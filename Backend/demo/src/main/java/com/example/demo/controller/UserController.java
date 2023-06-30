package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    private ObjectMapper objectMapper;


    @PostMapping("/signup")
    public HttpStatus create(@RequestBody @Validated UserDTO newUser){

        User createdUser = userService.createUser(newUser);

        if(createdUser == null){
            return HttpStatus.NOT_ACCEPTABLE;
        }


        return HttpStatus.CREATED;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {

        return this.userService.findAll();
    }

    @PostMapping("/SaveDName")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public User userad(Principal user,@RequestBody @Validated SaveDTO dto) {
        User nesto = this.userService.findByUsername(user.getName());
        nesto.setDisplayName(dto.getName());
        nesto.setDescription(dto.getDesc());
        userService.Save(nesto);
        return nesto;
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }
    @PostMapping("/changepass")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus user(Principal user,@RequestBody  String dto ) throws JsonProcessingException {
        User nesto = this.userService.findByUsername(user.getName());
        ObjectMapper mapper = new ObjectMapper();
        PasswordDTO usera = mapper.readValue(dto, PasswordDTO.class);

        if(passwordEncoder.matches(usera.getOldPassword(),nesto.getPassword())  )
        {


            this.userService.ChangePassword(user.getName(),usera.getNewPassword());
            return HttpStatus.ACCEPTED;
        }
        else return HttpStatus.NOT_ACCEPTABLE;

    }
}