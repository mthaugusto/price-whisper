package br.com.fiap.pricewhisperapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(sequenceName = "SQ_PRODUTO", name = "SQ_PRODUTO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "DS_PRODUTO")
    private String descricao;

    @Column(name="PRECO_CUSTO")
    private BigDecimal precoCusto;

    @Column(name="PRECO_VENDA")
    private BigDecimal precoVenda;

    @Column(name="PRECO_MINIMO")
    private BigDecimal precoMinimo;

    @Column(name="ESTOQUE")
    private Integer estoque;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CATEGORIA",
            referencedColumnName = "ID_CATEGORIA"
            , foreignKey = @ForeignKey(name = "FK_PRODUTO_CATEGORIA")
    )
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "MODELO",
            referencedColumnName = "ID_MODELO"
            , foreignKey = @ForeignKey(name = "FK_PRODUTO_MODELO")
    )
    private Modelo modelo;
}
