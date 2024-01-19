package domain;

import java.util.List;

public class Cliente {

    private Long[] id;

    private String nome;

    private String endereco;

    private String sobrenome;

    public Cliente(Long[] id, String nome, String endereco, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.sobrenome = sobrenome;
    }
    public Long[] getId() {
        return id;
    }

    public void setId(Long[] id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco; 
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Cliente [id = " + id + ", nome = " + nome + " "+ sobrenome +", Endereço = " + endereco + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}
