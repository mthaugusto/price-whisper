package br.com.fiap.pricewhisperapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="TB_HISTORICO_DE_VENDAS")
public class HistoricoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VENDA")
    private Long id;

    @Column(name="DATA_VENDA")
    private LocalDate dataVenda;

    @Column(name="PRECO_VENDA")
    private BigDecimal precoVenda;

    @Column(name="QTD_VENDIDA")
    private int quantidadeVendida;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PRODUTO",
            referencedColumnName = "ID_PRODUTO"
            , foreignKey = @ForeignKey(name = "FK_VENDAS_PRODUTO")
    )
    private Produto produto;
}
