public class Produto {
    private String nome;
    private float[] vendas; // vendas por mês
    private int tempoReposicao;
    private float loteReposicao;
    private float estoqueAtual;

    public Produto(String nome, float[] vendas, int tempoReposicao, float loteReposicao, float estoqueAtual) {
        this.nome = nome;
        this.vendas = vendas;
        this.tempoReposicao = tempoReposicao;
        this.loteReposicao = loteReposicao;
        this.estoqueAtual = estoqueAtual;
    }

    public float calcularVMD() {
        float soma = 0;
        for (float v : vendas) {
            soma += v;
        }
        return (soma / vendas.length) / 25; // considerando 25 dias úteis
    }

    public float calcularEstoqueMinimo() {
        return tempoReposicao * calcularVMD();
    }

    public float calcularEstoqueMaximo() {
        return calcularEstoqueMinimo() + loteReposicao;
    }

    public String tomarDecisao() {
        if (estoqueAtual > calcularEstoqueMinimo()) {
            return "Não comprar";
        } else {
            return "Comprar";
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public float getEstoqueAtual() { return estoqueAtual; }
    public void setEstoqueAtual(float estoqueAtual) { this.estoqueAtual = estoqueAtual; }
}
