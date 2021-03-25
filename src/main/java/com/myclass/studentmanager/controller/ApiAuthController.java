package com.myclass.studentmanager.controller;

import com.myclass.studentmanager.dto.AuthenticatedUserDto;
import com.myclass.studentmanager.dto.LoginDto;
import com.myclass.studentmanager.entity.CustomUserDetails;
import com.myclass.studentmanager.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("api/auth")
public class ApiAuthController {
    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public ApiAuthController(AuthenticationManager authenticationManager, UserService userService){
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginDto dto) {
        try {
            //Gọi hàm thực hiện đăng nhập
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            AuthenticatedUserDto user = userService.findByEmailForAuthentication(dto.getEmail());
            user.setToken(generateToken(authentication));
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (BadCredentialsException e) {
            return new ResponseEntity<>("Sai tên đăng nhập hoặc mật khẩu",HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private String generateToken(Authentication authentication) {
        // Đoạn JWT_SECRET bí mật
        final String JWT_SECRET = "secret";
        //Thời gian có hiệu lực của chuỗi jwt(10 ngày)
        final long JWT_EXPIRATION = 864000000L;
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + JWT_EXPIRATION);

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }
}
