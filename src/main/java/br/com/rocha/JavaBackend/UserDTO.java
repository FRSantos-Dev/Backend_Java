package br.com.rocha.JavaBackend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;

public class UserDTO {

    private String name;
    private String cpf;
    private String adress;
    private String email;
    private String telephone;
    private Date dateRegistry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telefone) {
        this.telephone = telefone;
    }

    public Date getDateRegistry() {
        return dateRegistry;
    }

    public void setDateRegistry(Date dateRegistry) {
        this.dateRegistry = dateRegistry;
    }

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
}
