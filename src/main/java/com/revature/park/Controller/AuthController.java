package com.revature.park.Controller;

import com.revature.park.Services.JwtTokenService;
import com.revature.park.Services.UserService;
import com.revature.park.Utils.custom_exception.ResourceConflictException;
import com.revature.park.Utils.custom_exception.UserNotFoundException;
import com.revature.park.dtos.requests.NewLoginRequest;
import com.revature.park.dtos.requests.NewUserRequest;
import com.revature.park.dtos.responses.Principal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

        private final UserService userService;
        private final JwtTokenService tokenService;

        /**
         * Registers a new user.
         *
         * @param req the NewUserRequest object containing user registration details
         * @return ResponseEntity with the HTTP status indicating the success or failure
         * of the registration
         */
        @PostMapping("/register")
        public ResponseEntity<?> registerUser(@RequestBody NewUserRequest req) {
            // if username is not valid, throw exception
            if (!userService.isValidUsername(req.getUsername())) {
                throw new ResourceConflictException(
                        "Username needs to be 8-20 characters long and can only contain letters, numbers, periods, and underscores");
            }

            // if username is not unique, throw exception
            if (!userService.isUniqueUsername(req.getUsername())) {
                throw new ResourceConflictException("Username is not unique");
            }

            // if password is not valid, throw exception
            if (!userService.isValidPassword(req.getPassword())) {
                throw new ResourceConflictException(
                        "Password needs to be at least 8 characters long and contain at least one letter and one number");
            }

            // if password and confirm password do not match, throw exception
            if (!userService.isSamePassword(req.getPassword(), req.getConfirmPassword())) {
                throw new ResourceConflictException("Passwords do not match");
            }

            // register user
            userService.registerUser(req);

            // return 201 - CREATED
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    @PostMapping("/login")
    public ResponseEntity<Principal> login(@RequestBody NewLoginRequest req) {
        // userservice to call login method
        Principal principal = userService.login(req);

        // create a jwt token
        String token = tokenService.generateToken(principal);

        principal.setToken(token);

        // return status ok and return principal object
        return ResponseEntity.status(HttpStatus.OK).body(principal);
    }


    /**
         * Exception handler for ResourceConflictException.
         *
         * @param e the ResourceConflictException to handle
         * @return ResponseEntity with the error message and status code indicating
         * resource conflict
         */
        @ExceptionHandler(ResourceConflictException.class)
        public ResponseEntity<Map<String, Object>> handleResourceConflictException(ResourceConflictException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("timestamp", new Date(System.currentTimeMillis()));
            map.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
        }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
    }
        @GetMapping("/hello")
        public String sayHello(){
            return "hello every one";
        }
    }