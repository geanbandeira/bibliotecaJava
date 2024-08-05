public class Livro {
    private String title;
    private String author;
    private boolean estaEmprestado;

    public Livro(String title, String author) {
        this.title = title;
        this.author = author;
        this.estaEmprestado = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean estaEmprestado() {
        return estaEmprestado;
    }

    public void emprestado() {
        estaEmprestado = true;
    }

    public void returnLivro() {
        estaEmprestado = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Emprestado: " + estaEmprestado;
    }
}
