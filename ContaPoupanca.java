public class ContaPoupanca extends ContaBancaria{
    
    private int aniversario;

    public ContaPoupanca(Cliente cliente, double saldo, int aniversario) {
        super(cliente, saldo);
        this.aniversario = aniversario;
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Poupança");
        System.out.println("  Aniversário: " + this.aniversario);
    }
    public int getAniversario() {
        return aniversario;
    }
}
