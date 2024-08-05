import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Library() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public boolean livroEmprestado(String title, String nomeUsuario) {
        for (Livro livro : livros) {
            if (livro.getTitle().equals(title) && !livro.estaEmprestado()) {
                livro.estaEmprestado();
                System.out.println(nomeUsuario + " emprestado " + title);
                return true;
            }
        }
        System.out.println("Livro nao disponivel.");
        return false;
    }

    public boolean returnLivro(String title, String nomeUsuario) {
        for (Livro livro : livros) {
            if (livro.getTitle().equals(title) && livro.estaEmprestado()) {
                livro.returnLivro();
                System.out.println(nomeUsuario + " returned " + title);
                return true;
            }
        }
        System.out.println("Livro nao encontrado.");
        return false;
    }

    // Adicionando os métodos get e set para books e users
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
