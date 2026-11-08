package routeplanner.modelo;

public class Doca {
    private int id;
    private final String nome;
    private final int capacidade;

    public Doca(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public int getCapacidade() { return capacidade; }

    @Override
    public String toString() {
        return nome + " (capacidade: " + capacidade + ")";
    }
}
