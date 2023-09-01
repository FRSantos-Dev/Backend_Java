package br.com.rocha.userapi.converter;

import br.com.rocha.backend.java.model.User;

public class DTOConverter {

    public static UserDTO convert(User user){

        public static UserDTO convert(User user) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getname());
            userDTO.setAdress(user.getAdress());
            userDTO.setCpf(user.getCpf());
            userDTO.setEmail(user.getEmail());
            userDTO.setTelephone(user.getTelephone());
            userDTO.setDateRegistry(user.getDateRegistry());
            userDTO.setKey(user.getKey());
            return userDTO;
        }
    }
}
