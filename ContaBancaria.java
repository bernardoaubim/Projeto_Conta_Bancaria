public class ContaBancaria {
    
    private Cliente cliente;
    private double saldo;
    private double saldoInicial;

    private double saldoMin;
    private double saldoMax;

    /*private Movimentacao deposito;
    private Movimentacao saque;
    private Movimentacao juros;*/

    public ContaBancaria (Cliente cliente, double saldo){
        this.cliente = cliente;
        this.saldoInicial = saldo;
        this.saldo = saldo;

        this.saldoMin = saldo;
        this.saldoMax = saldo;

        /* this.deposito = new Movimentacao();
        this.saque = new Movimentacao();
        this.juros = new MOviemntacao(); */
    }
    // public void movimenta(){}

    //public void aplicarJuros(){}

    //public void realizarDeposito(){}

    //public void realizarSaque(){}

    //public void exibirExtrato(){}

    //protected boolean autorizaSaque(){}

    //protected void exibirDadosEspecificos(){}

    //public double getSaldo(){}
    


}
