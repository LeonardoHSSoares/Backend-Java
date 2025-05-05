package com.leonardo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro extends Veiculo {

    public Carro() {
        super();
    }

    public Carro(String modelo, Integer ano, Marca marca) {
        super(modelo, ano);
        this.marca = marca;
        this.acessorios = new ArrayList<>();
    }

    @ManyToOne
    @JoinColumn(name = "marca", nullable = false)
    private Marca marca;

    @ManyToMany
    @JoinTable(
        name = "carro_acessorio",
        joinColumns = @JoinColumn(name = "carro_id"),
        inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;
  

    @Override
    public String toString() {
        return "Carro [id=" + getId() + ", modelo=" + getModelo() + ", ano=" + getAno() + "]";
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

}
