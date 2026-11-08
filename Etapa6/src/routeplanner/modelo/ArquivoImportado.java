package routeplanner.modelo;

import java.time.LocalDate;

public class ArquivoImportado {
    private final String nomeArquivo;
    private final LocalDate dataImportacao;

    public ArquivoImportado(String nomeArquivo, LocalDate dataImportacao) {
        this.nomeArquivo = nomeArquivo;
        this.dataImportacao = dataImportacao;
    }

    public String getNomeArquivo() { return nomeArquivo; }
    public LocalDate getDataImportacao() { return dataImportacao; }
}
