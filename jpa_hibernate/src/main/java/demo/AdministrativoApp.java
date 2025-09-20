package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto produto = new Produto();
        produto.setId(1);

        Produto byId = produtoModel.findById(produto);
        byId.setQuantidade(200);
        produtoModel.update(byId);

        produtoModel.delete(byId);

        // ------------------------------------------------------------------- //

        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setEmail("fulano@email.com");
        pessoa.setIdade(30);
        pessoa.setCpf("12345678912");
        pessoa.setDataNascimento(LocalDate.of(1995, 1, 20));

        pessoaModel.create(pessoa);

        List<Pessoa> all = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + all.size());

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1);

        Pessoa byId1 = pessoaModel.findById(pessoa1);
        byId1.setCpf("12345678911");
        pessoaModel.update(byId1);

        pessoaModel.delete(byId1);
    }
}
