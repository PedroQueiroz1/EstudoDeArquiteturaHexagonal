package com.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private String cpf;
    private boolean isValidCpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(boolean validCpf) {
        isValidCpf = validCpf;
    }
}
