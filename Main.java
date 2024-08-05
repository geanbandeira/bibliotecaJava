import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in, "UTF-8");

        DatabaseManager.createTables();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Adicionar Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolter Livro");
            System.out.println("7. Salvar Data");
            System.out.println("8. Load Data");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Insira o Título do Livro: ");
                    String title = scanner.nextLine();
                    System.out.print("Insira o Autor do Livro: ");
                    String author = scanner.nextLine();
                    Livro livro = new Livro(title, author);
                    library.addLivro(livro);
                    DatabaseManager.addLivroToDatabase(livro);
                    break;
                case 2:
                    library.listLivros();
                    DatabaseManager.listLivrosFromDatabase();
                    break;
                case 3:
                    System.out.print("Inserir nome do usuário: ");
                    String name = scanner.nextLine();
                    System.out.print("Inserir email do usuário: ");
                    String email = scanner.nextLine();
                    Usuario usuario = new Usuario(name, email);
                    library.addUsuario(usuario);
                    DatabaseManager.addUsuarioToDatabase(usuario);
                    break;
                case 4:
                    library.listUsuarios();
                    DatabaseManager.listUsuariosFromDatabase();
                    break;
                case 5:
                    System.out.print("Inserir o título do livro emprestado: ");
                    String tituloEmprestado = scanner.nextLine();
                    System.out.print("Insira o seu nome: ");
                    String nomeEmprestado = scanner.nextLine();
                    library.livroEmprestado(tituloEmprestado, nomeEmprestado);
                    break;
                case 6:
                    System.out.print("Insira o títudo do livro para devolução: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Insira o seu nome: ");
                    String returnName = scanner.nextLine();
                    library.returnLivro(returnTitle, returnName);
                    break;
                case 7:
                    FileManager.saveLibrary(library, "library.dat");
                    break;
                case 8:
                    library = FileManager.loadLibrary("library.dat");
                    break;
                case 9:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida. Por favor, tente novamente");
            }
        }
    }
}
