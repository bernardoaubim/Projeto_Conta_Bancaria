public class ContaCorrente extends ContaBancaria {
    
    private double credito;

    public ContaCorrente(Cliente cliente, double saldo, double credito) {
        super(cliente, saldo);
        this.credito = credito;
    }

    @Override
    public void aplicarJuros(double taxa) {
        System.out.println("Não é permitido para Conta Corrente");
        return;
    }
    @Override
    protected boolean autorizaSaque(double valor) {
        return valor <= (getSaldo() + this.credito);
    }
    @Override 
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Corrente");
        System.out.println("  Crédito: " + this.credito);
    }
    public double getCredito() {
        return credito;
    }
    public void setLimiteCredito(double credito) {
        this.credito = credito;
    }
}
