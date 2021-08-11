package com.dio.projeto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
// ou
// @Data
public class JornadaTrabalho {
    @Id
    @GeneratedValue
    private Long id;
    //@Audited - só para o campo
    private String descricao;
}
