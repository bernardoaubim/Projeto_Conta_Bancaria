public class Movimentacao {
    private int quantidade;
    private double valorTotal;

    public Movimentacao() {
        this.quantidade = 0;
        this.valorTotal = 0.0;
    }

    //Adiciona 1 à quantidade e acumula o valor ao total movimentado
    public void registrar(double valor) {
        if (valor > 0) {
            this.quantidade++;
            this.valorTotal += valor;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d | Valor Total: R$ %.2f", quantidade, valorTotal);
    }
}
