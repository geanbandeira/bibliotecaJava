import java.sql.*;

public class DatabaseManager{
    private static final String JDBC_URL = "jdmc:mysql://localhost:3306/library";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "password";
    
    public static Connection getConnection() throws SQLException{
        return DriveManager.getConnection(JDBC_URL, USUARIO, PASSWORD);
    }
    
    public static void createTables(){
        String createLivrosTrable = "CREATE TABLE IF NOT EXISTS livros (id INT AUTO_INCLEMENT PRIMARY KEY, titulo VARCHAR(255), autor VARCHAR(255), estaEmprestado BOOLEAN)";
        String createUsuariosTable = "CREATE TABLE IF NOT EXISTS usuarios (ID INT AUTO_INCLEMENT PRIMARY KEY, nome VARCHAR(255), email VARCHAR(255))";
        
        try(Connection conn = getConnection(); Statement stmt = conn.createStatement()){
            stmt.execute(createLivrosTrable);
            stmt.execute(createUsuariosTable);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void addLivroDatabase(Livro livro){
        String sql = "INSERT INTO livros (titulo, autor, estaEmprestado) VALUES(?, ?, ?)";
        
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setBoolean(3, livro.estaEmprestado());
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    

    
}
