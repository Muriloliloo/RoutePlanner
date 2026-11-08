package routeplanner.modelo;

public class Rota {
    private int id;
    private final String nome;
    private final String destino;
    private final String doca;

    public Rota(String nome, String destino, String doca) {
        this.nome = nome;
        this.destino = destino;
        this.doca = doca;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getDestino() { return destino; }
    public String getDoca() { return doca; }

    @Override
    public String toString() {
        return nome + " - " + destino + " - Doca " + doca;
    }
}
