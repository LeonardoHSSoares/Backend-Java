package tarefaReflection;

/*
 * Criar uma annotation chamada tabela, que recebera um valor contendo o nome da tabela
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tabela {
    
    /**
     *  Define o nome da tabela associada a Classe
     *  @return o nome da tabela
     */
   
     String nomeTabela();
}
