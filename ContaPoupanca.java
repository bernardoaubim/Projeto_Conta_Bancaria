public class ContaPoupanca extends ContaBancaria {
    private int diaAniversario;

    public ContaPoupanca(Cliente cliente, double saldoInicial, int diaAniversario) {
        super(cliente, saldoInicial);
        this.diaAniversario = diaAniversario;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    @Override
    public void movimenta(Operacao op) {
        if (op == null) {
            System.out.println("Erro: Operação inválida.");
            return;
        }

        char tipo = op.getTipo();

        if (tipo == 'D' || tipo == 'S' || tipo == 'J') {
            super.movimenta(op);
        } else {
            System.out.println("Erro: Tipo de operação inválido.");
        }
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Poupança");
        System.out.println("  Dia de Aniversário: " + diaAniversario);
    }
}
