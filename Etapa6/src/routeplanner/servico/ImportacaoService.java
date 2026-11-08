package routeplanner.servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import routeplanner.modelo.ArquivoImportado;

public class ImportacaoService {
    public ArquivoImportado importar(String nomeArquivo, String dataTexto) {
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do arquivo.");
        }
        String nome = nomeArquivo.trim().toLowerCase();
        if (!(nome.endsWith(".csv") || nome.endsWith(".xls") || nome.endsWith(".xlsx"))) {
            throw new IllegalArgumentException("O arquivo deve ser CSV ou Excel.");
        }
        return new ArquivoImportado(nomeArquivo.trim(), converterData(dataTexto));
    }

    public String processar(ArquivoImportado arquivo) {
        if (arquivo == null) {
            throw new IllegalArgumentException("Importe um arquivo antes de processar.");
        }
        return "Arquivo " + arquivo.getNomeArquivo() + " processado com sucesso.";
    }

    private LocalDate converterData(String texto) {
        if (texto == null || texto.trim().isEmpty()) return LocalDate.now();
        DateTimeFormatter[] formatos = {
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ISO_LOCAL_DATE
        };
        for (DateTimeFormatter formato : formatos) {
            try {
                return LocalDate.parse(texto.trim(), formato);
            } catch (DateTimeParseException e) {
                // tenta o proximo formato
            }
        }
        throw new IllegalArgumentException("Data invalida. Use dd/MM/aaaa.");
    }
}
