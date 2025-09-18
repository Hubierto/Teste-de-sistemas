import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeProdutos {
    private List<Produto> produtos = new ArrayList<>();

    // CREATE
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // READ
    public Produto buscarProduto(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    // UPDATE
    public void atualizarEstoque(String nome, float novoEstoque) {
        Produto p = buscarProduto(nome);
        if (p != null) {
            p.setEstoqueAtual(novoEstoque);
        }
    }

    // DELETE
    public void removerProduto(String nome) {
        produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }
}
