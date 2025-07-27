package com.leonardo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Leonardo Soares
 *
 * Anotação para identificar a tabela associada a um campo.
 *
 * Esta anotação pode ser usada em campos para especificar a tabela
 * associada a eles, permitindo uma melhor organização e identificação
 * das tabelas no código.
 *
 * O valor padrão é uma string vazia, mas pode ser alterado conforme necessário.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    String value();
}
