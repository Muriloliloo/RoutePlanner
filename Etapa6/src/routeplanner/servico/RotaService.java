package routeplanner.servico;

import java.util.List;
import routeplanner.modelo.Rota;
import routeplanner.repositorio.RotaRepository;

public class RotaService {
    private final RotaRepository repositorio;

    public RotaService(RotaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Rota cadastrar(String nome, String destino, String doca) {
        validar(nome, "nome");
        validar(destino, "destino");
        validar(doca, "doca");
        Rota rota = new Rota(nome.trim(), destino.trim(), doca.trim());
        repositorio.salvar(rota);
        return rota;
    }

    public List<Rota> listar() {
        return repositorio.listar();
    }

    private void validar(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo " + campo + " deve ser preenchido.");
        }
    }
}
