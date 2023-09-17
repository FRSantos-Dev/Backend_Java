package br.com.rocha.shoppingclient.dto;

import java.util.Date;

public class UserDTO {

    private String name;
    private String cpf;
    private String adress;
    private String email;
    private String telephone;
    private Date registryDate;
    private String key;

    public UserDTO() {
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

    public void setTelefone(final String telephone) {
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