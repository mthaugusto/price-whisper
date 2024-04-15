package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
