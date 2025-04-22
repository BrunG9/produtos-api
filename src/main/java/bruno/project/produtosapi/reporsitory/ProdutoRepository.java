package bruno.project.produtosapi.reporsitory;

import bruno.project.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
