package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Leonardo Soares
 *
 *         Anotação para identificar o tipo de chave de um campo.
 *
 *         Esta anotação pode ser usada em campos para especificar o tipo de chave
 *         associada a eles, permitindo uma melhor organização e identificação
 *         dos tipos de chaves no código.
 *
 *         O valor padrão do id é 1L, mas pode ser alterado conforme necessário.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value(); // Método que retorna o id do objeto
}
