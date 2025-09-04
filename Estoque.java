import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int opcao;

         while (true) {
            System.out.println("1 - calcular o vmd de um item" );
            System.out.println("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    calcular(sc);
                    break;  
                default:
                    break;

            }
        }
    }

    public static void calcular(Scanner sc) {
        System.out.print("digite o número de itens vendidos no primeiro mês: ");
        Float m1 = sc.nextFloat();

        System.out.print("digite o número de itens vendidos no segundo mês: ");
        Float m2 = sc.nextFloat();

        System.out.print("digite o número de itens vendidos no terceiro mês: ");
        Float m3 = sc.nextFloat();

        Float vmd = ((m1+m2+m3)/3)/25;

        System.out.println("A média de produtos vendidos por mês é: "+vmd);

        System.out.println("Digite o número de dias necessário para a reposição dos produtos: ");
        int tempoDeReposicao = sc.nextInt();

        Float estoqueMinimo = tempoDeReposicao * vmd;

        System.out.println("O Estoque mínimo é: "+estoqueMinimo);

        System.out.println("Digite o lote de reposição: ");
        Float loteDeReposicao = sc.nextFloat();

        Float estoqueMaximo = loteDeReposicao + estoqueMinimo;

        System.out.println("O estoque máximo é: "+estoqueMaximo);

        System.out.println("Digite o estoque atual: ");
        Float estoqueAtual = sc.nextFloat();

        if (estoqueAtual > estoqueMinimo) {

            System.out.println("Não comprar!");
        } else {
            System.out.println("Compar!");
        }
    }

    
        
    
}
