package github.matheus.spring.model.repositories;

import github.matheus.spring.model.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {



}
