package routeplanner.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final String url;
    private final String usuario;
    private final String senha;

    public Conexao(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static Conexao padrao() {
        String url = System.getProperty("routeplanner.db.url", "jdbc:mysql://localhost:3306/routeplanner");
        String usuario = System.getProperty("routeplanner.db.usuario", "root");
        String senha = System.getProperty("routeplanner.db.senha", "");
        return new Conexao(url, usuario, senha);
    }
}
