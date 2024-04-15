package br.com.fiap.pricewhisperapp.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table(name="TB_HISTORICO_DE_VENDAS")
public class HistoricoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VENDA")
    private Long id;

    private LocalDate dataVenda;
    private BigDecimal precoVenda;
    private int quantidadeVendida;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PRODUTO",
            referencedColumnName = "ID_PRODUTO"
            , foreignKey = @ForeignKey(name = "FK_VENDAS_PRODUTO")
    )
    private Produto produto;
}
