package farmacia;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;
import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;


import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private static final ProdutoRepository produtoRepository = new ProdutoController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Visualizar Produto por ID");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    visualizarProdutoPorId();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do produto (1 para Medicamento, 2 para Cosmético): ");
        int tipo = scanner.nextInt();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto novoProduto;
        
        int novoId = produtoRepository.listarTodos().size() + 1;

        if (tipo == 1) {
            scanner.nextLine();
            System.out.print("Digite o nome genérico do medicamento: ");
            String generico = scanner.nextLine();
            novoProduto = new Medicamento(novoId, nome, tipo, preco, generico);
        } else if (tipo == 2) {
            scanner.nextLine();
            System.out.print("Digite a fragrância do cosmético: ");
            String fragrancia = scanner.nextLine();
            novoProduto = new Cosmetico(novoId, nome, tipo, preco, fragrancia);
        } else {
            System.out.println("Tipo de produto inválido.");
            return;
        }

        produtoRepository.salvar(novoProduto);
        System.out.println("Produto cadastrado com sucesso! ID: " + novoId);
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoRepository.listarTodos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                produto.visualizar();
                System.out.println("--------------------");
            }
        }
    }

    private static void visualizarProdutoPorId() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        Produto produto = produtoRepository.encontrarPorId(id);

        if (produto != null) {
            produto.visualizar();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void atualizarProduto() {
        System.out.print("Digite o ID do produto que deseja atualizar: ");
        int id = scanner.nextInt();
        Produto produtoExistente = produtoRepository.encontrarPorId(id);

        if (produtoExistente != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo tipo do produto (1 para Medicamento, 2 para Cosmético): ");
            int novoTipo = scanner.nextInt();
            System.out.print("Digite o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();

            Produto produtoAtualizado;

            if (novoTipo == 1) {
                scanner.nextLine();
                System.out.print("Digite o novo nome genérico do medicamento: ");
                String novoGenerico = scanner.nextLine();
                produtoAtualizado = new Medicamento(id, novoNome, novoTipo, novoPreco, novoGenerico);
            } else if (novoTipo == 2) {
                scanner.nextLine();
                System.out.print("Digite a nova fragrância do cosmético: ");
                String novaFragrancia = scanner.nextLine();
                produtoAtualizado = new Cosmetico(id, novoNome, novoTipo, novoPreco, novaFragrancia);
            } else {
                System.out.println("Tipo de produto inválido.");
                return;
            }

            produtoRepository.atualizar(produtoAtualizado);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void excluirProduto() {
        System.out.print("Digite o ID do produto que deseja excluir: ");
        int id = scanner.nextInt();
        produtoRepository.excluir(id);
        System.out.println("Produto excluído com sucesso!");
    }
}
