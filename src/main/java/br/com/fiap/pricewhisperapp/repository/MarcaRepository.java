package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
