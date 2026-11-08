package routeplanner;

import java.util.Map;
import routeplanner.modelo.ArquivoImportado;
import routeplanner.modelo.Doca;
import routeplanner.modelo.Rota;
import routeplanner.repositorio.MemoriaDocaRepository;
import routeplanner.repositorio.MemoriaRotaRepository;
import routeplanner.servico.DocaService;
import routeplanner.servico.ImportacaoService;
import routeplanner.servico.RelatorioService;
import routeplanner.servico.RotaService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTES DO ROUTE PLANNER - ETAPA 6 ===");

        RotaService rotaService = new RotaService(new MemoriaRotaRepository());
        DocaService docaService = new DocaService(new MemoriaDocaRepository());
        ImportacaoService importacaoService = new ImportacaoService();
        RelatorioService relatorioService = new RelatorioService();

        Doca d1 = docaService.cadastrar("Doca 10", "120");
        Doca d2 = docaService.cadastrar("Doca 20", "100");
        System.out.println("[OK] Docas cadastradas: " + d1 + " / " + d2);

        Rota r1 = rotaService.cadastrar("A1", "Praia Grande", "10");
        Rota r2 = rotaService.cadastrar("A2", "Santos", "10");
        Rota r3 = rotaService.cadastrar("B1", "Sao Vicente", "20");
        System.out.println("[OK] Rotas cadastradas: " + r1 + ", " + r2 + ", " + r3);

        ArquivoImportado arquivo = importacaoService.importar("rotas_am1.csv", "08/11/2026");
        System.out.println("[OK] Importacao validada: " + arquivo.getNomeArquivo());
        System.out.println("[OK] " + importacaoService.processar(arquivo));

        Map<String, Integer> resumo = relatorioService.totalRotasPorDoca(rotaService.listar());
        System.out.println("[OK] Relatorio de rotas por doca: " + resumo);

        try {
            rotaService.cadastrar("", "Santos", "10");
            System.out.println("[FALHA] Validacao de nome vazio.");
        } catch (IllegalArgumentException e) {
            System.out.println("[OK] Validacao rejeitou rota sem nome.");
        }

        System.out.println("=== FIM DOS TESTES ===");
    }
}
