package br.com.rocha.JavaBackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage(){
        return "Spring boot is working!";
    }
}
