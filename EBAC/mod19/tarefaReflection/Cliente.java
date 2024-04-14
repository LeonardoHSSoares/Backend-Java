package tarefaReflection;

@Tabela(nomeTabela = "clientes")
public class Cliente {
    
    Long id = 0L;
    String nome = null;

    public Long gerarId(Long id) { return id += 1; }
}
