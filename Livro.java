public class Livro{
    private String titulo;
    private String author;
    private boolean estaEmprestado;
    
    public Livro(String titulo, String author){
        this.titulo = titulo;
        this.author = author;
        this.estaEmprestado = false;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public boolean estaEmprestado(){
        return estaEmprestado;
    }
    
    public void emprestado(){
        estaEmprestado = true;
    }
    
    public void returnEmprestado(){
        estaEmprestado = false;
    }
    
    public String toString(){
        return "\nTitulo: " + titulo + "\nAuthor: " + author + "\nEmprestado: " + estaEmprestado;
    }
    
}
