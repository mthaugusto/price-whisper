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

    @Column(name="QT_PRODUTOS")
    private int quantidadeProdutos;

    @Column(name="VL_SUBTOTAL")
    private Double subTotal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "PRODUTO", referencedColumnName = "ID_PRODUTO", foreignKey = @ForeignKey(name = "FK_CARRINHO_PRODUTO"))
    private Produto produto;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "VENDA", referencedColumnName = "ID_VENDA", foreignKey = @ForeignKey(name = "FK_CARRINHO_HISTORICO_VENDA"))
    private HistoricoVendas historicoVenda;
}
