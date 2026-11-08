package routeplanner.servico;

import java.util.List;
import routeplanner.modelo.Doca;
import routeplanner.repositorio.DocaRepository;

public class DocaService {
    private final DocaRepository repositorio;

    public DocaService(DocaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Doca cadastrar(String nome, String capacidadeTexto) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da doca deve ser preenchido.");
        }
        int capacidade;
        try {
            capacidade = Integer.parseInt(capacidadeTexto.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("A capacidade deve ser um numero inteiro.");
        }
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        Doca doca = new Doca(nome.trim(), capacidade);
        repositorio.salvar(doca);
        return doca;
    }

    public List<Doca> listar() {
        return repositorio.listar();
    }
}
