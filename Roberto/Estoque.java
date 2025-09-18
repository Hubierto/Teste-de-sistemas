import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorDeProdutos gerenciador = new GerenciadorDeProdutos();

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Atualizar Estoque");
            System.out.println("5 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    float[] vendas = new float[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Vendas mês " + (i+1) + ": ");
                        vendas[i] = sc.nextFloat();
                    }

                    System.out.print("Tempo de reposição (dias): ");
                    int tr = sc.nextInt();

                    System.out.print("Lote de reposição: ");
                    float lr = sc.nextFloat();

                    System.out.print("Estoque atual: ");
                    float ea = sc.nextFloat();

                    Produto novo = new Produto(nome, vendas, tr, lr, ea);
                    gerenciador.adicionarProduto(novo);
                    break;

                case 2:
                    for (Produto p : gerenciador.listarProdutos()) {
                        System.out.println("Produto: " + p.getNome() +
                            " | VMD: " + p.calcularVMD() +
                            " | Min: " + p.calcularEstoqueMinimo() +
                            " | Max: " + p.calcularEstoqueMaximo() +
                            " | Decisão: " + p.tomarDecisao());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do produto: ");
                    String busca = sc.nextLine();
                    Produto encontrado = gerenciador.buscarProduto(busca);
                    if (encontrado != null) {
                        System.out.println("Produto: " + encontrado.getNome() +
                            " | Min: " + encontrado.calcularEstoqueMinimo() +
                            " | Max: " + encontrado.calcularEstoqueMaximo() +
                            " | Decisão: " + encontrado.tomarDecisao());
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Produto: ");
                    String atualizar = sc.nextLine();
                    System.out.print("Novo estoque: ");
                    float novoEstoque = sc.nextFloat();
                    gerenciador.atualizarEstoque(atualizar, novoEstoque);
                    break;

                case 5:
                    System.out.print("Produto: ");
                    String remover = sc.nextLine();
                    gerenciador.removerProduto(remover);
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    
        
    
}
