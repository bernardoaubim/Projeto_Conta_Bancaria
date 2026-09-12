public class ContaPoupanca extends ContaBancaria{
    
    private int aniversario;

    public ContaPoupanca(Cliente cliente, double saldo, int aniversario) {
        super(cliente, saldo);
        this.aniversario = aniversario;
    }

    /* @override
    
    public void exibirDadosEspecificos(){}
    
    getter aniversario*/
}
