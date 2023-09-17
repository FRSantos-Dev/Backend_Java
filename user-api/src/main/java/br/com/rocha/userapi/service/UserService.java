package br.com.rocha.userapi.service;

import br.com.rocha.shoppingclient.dto.UserDTO;
import br.com.rocha.shoppingclient.exception.UserNotFoundException;
import br.com.rocha.userapi.converter.DTOConverter;

import br.com.rocha.userapi.model.User;
import br.com.rocha.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return DTOConverter.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        userDTO.setRegistryDate(new Date());
        userDTO.setKey(UUID.randomUUID().toString());
        User user = userRepository.save(User.convert(userDTO));
        return DTOConverter.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf, String key) {
        User user = userRepository.findByCpfAndKey(cpf, key);
        if (user != null) {
            return DTOConverter.convert(user);
        }
        throw new UserNotFoundException();
    }

    public List<UserDTO> queryByName(String name) {
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

}