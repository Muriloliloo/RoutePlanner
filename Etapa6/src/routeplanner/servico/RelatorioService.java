package routeplanner.servico;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import routeplanner.modelo.Rota;

public class RelatorioService {
    public Map<String, Integer> totalRotasPorDoca(List<Rota> rotas) {
        Map<String, Integer> resumo = new LinkedHashMap<>();
        for (Rota rota : rotas) {
            String doca = rota.getDoca();
            resumo.put(doca, resumo.getOrDefault(doca, 0) + 1);
        }
        return resumo;
    }
}
