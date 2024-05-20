package br.com.edu.infnet.cadastroprodutos.repository;

import br.com.edu.infnet.cadastroprodutos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
