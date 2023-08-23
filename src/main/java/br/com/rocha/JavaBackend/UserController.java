package br.com.rocha.JavaBackend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDTO>users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAdress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setDateRegistry(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAdress("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelephone("1234-3454");
        userDTO2.setDateRegistry(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAdress("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelephone("1234-3454");
        userDTO3.setDateRegistry(new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return users;
    }
}
