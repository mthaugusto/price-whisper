package br.com.fiap.pricewhisperapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
    @SequenceGenerator(sequenceName = "SQ_CATEGORIA", name = "SQ_CATEGORIA", allocationSize = 1, initialValue = 1)
    @Column(name="ID_CATEGORIA")
    private Long id;

    @Column(name="NM_CATEGORIA")
    private String nome;

    @Column(name="DS_CATEGORIA")
    private String descricao;

}
