package br.com.fiap.pricewhisperapp.repository;

import br.com.fiap.pricewhisperapp.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
