import java.sql.*;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USUARIO, PASSWORD);
    }

    public static void createTables() {
        String createLivrosTable = "CREATE TABLE IF NOT EXISTS livros (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), estaEmprestado BOOLEAN)";
        String createUsuariosTable = "CREATE TABLE IF NOT EXISTS usuarios (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createLivrosTable);
            stmt.execute(createUsuariosTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addLivroToDatabase(Livro livro) {
        String sql = "INSERT INTO livros (title, author, estaEmprestado) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitle());
            pstmt.setString(2, livro.getAuthor());
            pstmt.setBoolean(3, livro.estaEmprestado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUsuarioToDatabase(Usuario usuario) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getName());
            pstmt.setString(2, usuario.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listLivrosFromDatabase() {
        String sql = "SELECT * FROM livros";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                boolean estaEmprestado = rs.getBoolean("Esta Emprestado");
                System.out.println("Title: " + title + ", Author: " + author + ", Emprestado: " + estaEmprestado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listUsuariosFromDatabase() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
