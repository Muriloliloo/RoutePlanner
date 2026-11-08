package routeplanner.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import routeplanner.infra.Conexao;
import routeplanner.modelo.Rota;

public class JdbcRotaRepository implements RotaRepository {
    private final Conexao conexao;

    public JdbcRotaRepository(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public void salvar(Rota rota) {
        String sql = "INSERT INTO rota (nome, destino, doca) VALUES (?, ?, ?)";
        try (Connection conn = conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rota.getNome());
            ps.setString(2, rota.getDestino());
            ps.setString(3, rota.getDoca());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel salvar a rota.", e);
        }
    }

    @Override
    public List<Rota> listar() {
        List<Rota> rotas = new ArrayList<>();
        String sql = "SELECT id, nome, destino, doca FROM rota ORDER BY id";
        try (Connection conn = conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Rota rota = new Rota(rs.getString("nome"), rs.getString("destino"), rs.getString("doca"));
                rota.setId(rs.getInt("id"));
                rotas.add(rota);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel listar as rotas.", e);
        }
        return rotas;
    }
}
