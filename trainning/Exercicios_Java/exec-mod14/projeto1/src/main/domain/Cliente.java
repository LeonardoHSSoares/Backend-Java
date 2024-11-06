package main.domain;

public class Cliente {
    
    private String nome;
    private Long cpf;
    private Long tel;
    private String endereco;
    private Integer numCasa;
    private String cidade;
    private String estado;
    
    @Override
    public String toString() {
        return "Cliente [Nome = " + nome + ", CPF = " + cpf + ", Tel = " + tel + ", Endereco = " + endereco + ", NumeroCasa = "
                + numCasa + ", Cidade = " + cidade + ", Estado = " + estado + "]";
    }

    public Cliente(String nome, Long cpf, Long tel, String endereco, Integer numCasa, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.endereco = endereco;
        this.numCasa = numCasa;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        if (cpf == null) {
            if (other.cpf != null)
                return false;

        } else if (!cpf.equals(other.cpf))
            return false;
            
        return true;
    }
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Integer getNumCasa() {
        return numCasa;
    }
    public void setNumCasa(Integer numCasa) {
        this.numCasa = numCasa;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }


}
