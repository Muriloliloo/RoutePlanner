package routeplanner.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import routeplanner.modelo.Doca;

public class MemoriaDocaRepository implements DocaRepository {
    private final List<Doca> docas = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void salvar(Doca doca) {
        doca.setId(proximoId++);
        docas.add(doca);
    }

    @Override
    public List<Doca> listar() {
        return Collections.unmodifiableList(docas);
    }
}
