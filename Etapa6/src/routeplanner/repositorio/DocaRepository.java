package routeplanner.repositorio;

import java.util.List;
import routeplanner.modelo.Doca;

public interface DocaRepository {
    void salvar(Doca doca);
    List<Doca> listar();
}
