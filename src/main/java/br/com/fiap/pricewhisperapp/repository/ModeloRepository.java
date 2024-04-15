package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
