package br.com.rocha.shoppingclient.dto;

import java.util.Date;

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
}
