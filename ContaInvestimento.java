public class ContaInvestimento extends ContaBancaria {

    private Data vencimento;

    public ContaInvestimento(Cliente cliente, double saldo, Data vencimento) {
        super(cliente, saldo);
        this.vencimento = vencimento;
    }

    @Override 
    public void movimenta(Operacao operacao){
        if (operacao.getTipo() == 'S') {
            System.out.println("Esse tipo de conta não permite saques.");
            return;
        }
        super.movimenta(operacao);
    }
    @Override
    public void realizarSaque(double valor) {
        System.out.println("Esse tipo de conta não permite saques");
        return;
    }
    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Investimento");
        System.out.println("  Vencimento: " + this.vencimento);
    }
    public Data getVencimento() {
        return vencimento;
    }

    
    /*@override

    public void movimenta(){}
    
    public void realizarSaque(){}

    public void exibirDadosEspecificos(){}

    getter vencimento
    */
}
