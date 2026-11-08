package routeplanner.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import routeplanner.modelo.Rota;

public class MemoriaRotaRepository implements RotaRepository {
    private final List<Rota> rotas = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void salvar(Rota rota) {
        rota.setId(proximoId++);
        rotas.add(rota);
    }

    @Override
    public List<Rota> listar() {
        return Collections.unmodifiableList(rotas);
    }
}
