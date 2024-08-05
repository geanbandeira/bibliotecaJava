
class Livro{
    private String autor;
    private String titulo;
    private boolean estaExprestado;
    
    public Livro(String autor, String titulo, boolean estaExprestado){
        this.autor = autor;
        this.titulo = titulo;
        this.estaExprestado = estaExprestado;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String toString(){
        return "\nAutor: " + autor + "\nTitulo: " + titulo + "\nEstá emprestado: " + estaExprestado;
    }
    
}

public class Main{
	public static void main(String[] args){
	    
	    
	    
	    
	    
	}
}










