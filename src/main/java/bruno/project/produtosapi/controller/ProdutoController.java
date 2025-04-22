package bruno.project.produtosapi.controller;

import bruno.project.produtosapi.model.Produto;
import bruno.project.produtosapi.reporsitory.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping()
    public Produto save(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") String id){
        // Outra forma de fazer a requisição do id do produto
        // Optional<Produto> produto = produtoRepository.findById(id);
        // return produto.isPresent() ? produto.get() : null;

        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletePorId(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Produto update(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public List<Produto> buscaProdutos(@RequestParam("name") String name){
        return produtoRepository.findByName(name);
    }
}
