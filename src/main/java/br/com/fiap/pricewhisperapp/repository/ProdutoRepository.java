package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
