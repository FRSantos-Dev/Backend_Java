package br.com.rocha.userapi.model;


import br.com.rocha.shoppingclient.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpf;
    private String adress;
    private String email;
    private String telephone;
    private Date registryDate;
    private String key;

    public User() {
    }

    public static User convert(final UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAdress(userDTO.getAdress());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setTelephone(userDTO.getTelephone());
        user.setRegistryDate(userDTO.getRegistryDate());
        user.setKey(userDTO.getKey());
        return user;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(final String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public Date getRegistryDate() {
        return this.registryDate;
    }

    public void setRegistryDate(final Date registryDate) {
        this.registryDate = registryDate;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }
    
}