package com.dio.projeto.util;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MovimentacaoId implements Serializable {
    private Long idMovimento;
    private Long idUsuario;
}
