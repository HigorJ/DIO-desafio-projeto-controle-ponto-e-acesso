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
public class BancoHorasId implements Serializable {
    private Long bancoHorasId;
    private Long movimentacaoId;
    private Long usuarioId;
}
