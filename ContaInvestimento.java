public class ContaInvestimento extends ContaBancaria {

    private Data vencimento;

    public ContaInvestimento(Cliente cliente, double saldo, Data vencimento) {
        super(cliente, saldo);
        this.vencimento = vencimento;
    }

    /*@override

    public void movimenta(){}
    
    public void realizarSaque(){}

    public void exibirDadosEspecificos(){}

    getter vencimento
    */
}
