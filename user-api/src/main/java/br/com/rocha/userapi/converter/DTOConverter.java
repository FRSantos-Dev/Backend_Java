package br.com.rocha.userapi.converter;


import br.com.rocha.shoppingclient.dto.UserDTO;
import br.com.rocha.userapi.model.User;

public class DTOConverter {

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setAdress(user.getAdress());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelephone(user.getTelephone());
        userDTO.setRegistryDate(user.getRegistryDate());
        userDTO.setKey(user.getKey());
        return userDTO;
    }

}