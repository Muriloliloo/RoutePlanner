package routeplanner.repositorio;

import java.util.List;
import routeplanner.modelo.Rota;

public interface RotaRepository {
    void salvar(Rota rota);
    List<Rota> listar();
}
