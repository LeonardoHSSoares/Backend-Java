@Tabela(nomeTabela = "clientes")
public class Cliente {
    
    Long id = gerarId(0);
    String nome = null;

    public Long gerarId(Long id) { return id += 1; }
}
