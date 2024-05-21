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
@Table(name="TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MARCA")
    @SequenceGenerator(sequenceName = "SQ_MARCA", name = "SQ_MARCA", allocationSize = 1, initialValue = 1)
    @Column(name="ID_MARCA")
    private Long id;

    @Column(name="NM_MARCA")
    private String nome;

    @Column(name="DS_MARCA")
    private String descricao;
}
