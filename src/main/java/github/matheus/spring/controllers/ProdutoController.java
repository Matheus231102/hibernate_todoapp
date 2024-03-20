package github.matheus.spring.controllers;

import github.matheus.spring.model.entities.Produto;
import github.matheus.spring.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @PostMapping
    public @ResponseBody Produto novoProduto(Produto produto) {
        produto.setNome(produto.getNome());
        produto.setDesconto(produto.getDesconto());
        produto.setPreco(produto.getPreco());

        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping
    public @ResponseBody Produto removerProduto(@RequestParam(name = "idproduto") int id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.delete(produto.get());
        return produto.get();
    }

    @PostMapping(path = "/adddesc")
    public Produto adicionarDescontoProduto(
            @RequestParam(name = "idproduto") int id, @RequestParam(name = "valordesc") double desconto
    ) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produto.get().setDesconto(desconto);
        produtoRepository.save(produto.get());
        return produto.get();
    }

    @PostMapping(path = "/addpreco")
    public Produto adicionarPrecoProduto(
            @RequestParam(name = "idproduto") int id, @RequestParam(name = "preco") double precoProduto
    ) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produto.get().setPreco(precoProduto);
        produtoRepository.save(produto.get());
        return produto.get();
    }

    @GetMapping(path = "/get")
    public Produto vizualizarProduto(@RequestParam(name = "idproduto") int id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    @GetMapping(path = "/getvlliq")
    public Produto vizualizarProdutoComDesconto(@RequestParam(name = "idproduto") int id) {
        Optional<Produto> pr = produtoRepository.findById(id);
        Produto produto = pr.get();
        produto.setPreco(produto.getPreco() - produto.getPreco() * produto.getDesconto());
        return produto;
    }

}
