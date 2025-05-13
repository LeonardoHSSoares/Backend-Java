package com.leonardo.domain;


public interface ICliente {

    String getId();
    void setNome(String nome);
    String getNome();
    void setCpf(String cpf);
    String getCpf();
    void setEmail(String email);
    String getEmail();
    void setTelefone(Integer telefone);
    Integer getTelefone();
    void setEndereco(String endereco);
    String getEndereco();
    String imprimeCliente();

}
