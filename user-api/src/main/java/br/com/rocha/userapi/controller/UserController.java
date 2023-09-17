package br.com.rocha.userapi.controller;



import br.com.rocha.shoppingclient.dto.UserDTO;
import br.com.rocha.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/cpf/{cpf}")
    UserDTO findByCpf(@RequestParam(name = "key", required = true) String key, @PathVariable String cpf) {
        return userService.findByCpf(cpf, key);
    }

    @PostMapping("/users")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/users/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/users/search")
    public List<UserDTO> queryByName(@RequestParam(name = "name", required = true) String name) {
        return userService.queryByName(name);
    }

}