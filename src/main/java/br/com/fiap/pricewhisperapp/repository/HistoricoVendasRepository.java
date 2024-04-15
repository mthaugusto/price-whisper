package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.HistoricoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVendasRepository extends JpaRepository<HistoricoVendas, Long> {
}
