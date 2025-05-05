package com.leonardo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Veiculo {

    public Veiculo() {

    }

    public Veiculo(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "veiculo_seq")
    @SequenceGenerator(name = "veiculo_seq", sequenceName = "sq_veiculo", allocationSize = 1,initialValue = 1)
    private Long id;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", modelo=" + modelo + ", ano=" + ano + "]";
    }



}
