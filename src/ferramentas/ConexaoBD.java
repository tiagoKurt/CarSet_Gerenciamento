package ferramentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static Connection conexao = null;

    private ConexaoBD() {
    }

    public static Connection getConexao() throws Exception {
        try {
            if (conexao == null) {
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/CadastroDeProjetos";
                String user = "postgres";
                String password = "lezzadogamer";
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException erro) {
            //Erro de não encontrar o drive do banco no projeto
            throw new Exception("Drive: " + erro.getMessage());
        } catch (SQLException erro) {
            //Erro no banco de dados: usuario, senha ou banco de dados 
            throw new Exception("Banco: " + erro.getMessage());
        }
        return conexao;
    }

}
