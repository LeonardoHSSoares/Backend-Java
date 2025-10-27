package com.leonardo.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "Cliente", description = "Representa um cliente no sistema")
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @Schema(description = "Identificador único do cliente")
    private String id;

    @NotNull
    @Size(min = 2, max = 100)
    @Schema(description = "Nome", minLength = 2, maxLength = 100, nullable = false)
    private String nome;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description = "CPF", nullable = false)
    private Long cpf;

    @NotNull
    @Schema(name = "TEL", nullable = false)
    private Long tel;

    @Schema(name = "EMAIL", nullable = false, maxLength = 100)
    private String email;

    @Schema(name = "ENDERECO", nullable = false, maxLength = 100)
    private String end;

    @Schema(name = "NUMERO", nullable = false)
    private Integer numero;

    @Schema(name = "CIDADE", nullable = false, maxLength = 50)
    private String cidade;
    
    @Schema(name = "ESTADO", nullable = false, minLength = 2, maxLength = 2)
    private String estado;

}
