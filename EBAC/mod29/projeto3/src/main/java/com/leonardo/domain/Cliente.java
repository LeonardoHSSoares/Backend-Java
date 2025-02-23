package com.leonardo.domain;

public class Cliente {

    private Long id_cliente;
    private String codigo;
    private String nome;

    public Cliente(String nome,String codigo) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public Cliente() {

    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente { ID = " +getId_cliente()+ ", Nome =" +getNome()+ " , Codigo = " +getCodigo()+ " }";
    }

}
