public class ContaCorrente extends ContaBancaria {
    
    private double credito;

    public ContaCorrente(Cliente cliente, double saldo, double credito) {
        super(cliente, saldo);
        this.credito = credito;
    }

    /* @Override

    public void aplicarJuros(){}

    protected boolean autorizaSaque(){}

    protected void exibirDadosEspecificos(){}

    getter/setter de credito
    
    */
}
