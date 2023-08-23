package tup.coincontrol.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tup.coincontrol.model.User;
import tup.coincontrol.service.UserService;

@CrossOrigin(origins = {"http://localhost:4200" , "http://localhost:8080"})

@RestController
@RequestMapping("/api")
/*Respuesta de http */
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    /*Inyectamos el service */

    @PostMapping("/create")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }
}
