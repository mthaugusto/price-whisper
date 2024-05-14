package br.com.fiap.pricewhisperapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name="TB_CARRINHO")
public class Carrinho {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARRINHO")
    @SequenceGenerator(sequenceName = "SQ_CARRINHO", name = "SQ_CARRINHO", allocationSize = 1, initialValue = 1)
    @Column(name="ID_CARRINHO")
    private Long id;

    private int quantidadeProdutos;

    private Double sub_total;

    private Produto produto;

    private HistoricoVendas venda;
}
