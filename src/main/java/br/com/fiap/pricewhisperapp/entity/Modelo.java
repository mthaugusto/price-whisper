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
@Table(name="TB_MODELO")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MARCA")
    @SequenceGenerator(sequenceName = "SQ_MARCA", name = "SQ_MARCA", allocationSize = 1, initialValue = 1)
    @Column(name="ID_MODELO")
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "MARCA",
            referencedColumnName = "ID_MARCA"
            , foreignKey = @ForeignKey(name = "FK_MODELO_MARCA")
    )
    private Marca marca;

}
