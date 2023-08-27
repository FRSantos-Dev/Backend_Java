package br.com.rocha.JavaBackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocha.JavaBackend.dto.UserDTO;
import br.com.rocha.JavaBackend.model.User;
import br.com.rocha.JavaBackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired//injeção de dependencias
    private UserRepository userRepository;

    //
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();//retorna lista de ususarios, instancias da entidade user
        return users
                .stream()//transforma lista em stream
                .map(UserDTO::convert)//transforma a lista d eentidade em lista DTOs
                .collect(Collectors.toList());//retorna a lista de DTOs
    }

    public UserDTO findById(long userId){//achar usuario por id
        
        Optional<User>user = userRepository.findById(userId);

        if(user.isPresent()){
            return UserDTO.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO){//salva usuario no BD
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public UserDTO delete(long userId){//exclui usuario do BD
        Optional<User>user = userRepository.findById(userId);

        if(user.isPresent()){
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf){//busca ususario por CPF

        User user = userRepository.findByCpf(cpf);
        if(user != null){
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryBYName(String Name){//busca por nome, mesmo sem ser escrita exata
        List<User> users = userRepository.queryByNameLike(Name);
        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
