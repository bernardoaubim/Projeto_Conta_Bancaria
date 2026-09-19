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
        double valor = op.getValor();

        if (tipo == 'D') {
            if (valor <= 0) {
                System.out.println("Erro: O valor do depósito deve ser maior que zero.");
                return;
            }
            setSaldoAtual(getSaldoAtual() + valor);
            getDepositos().registrar(valor);
        } else if (tipo == 'S') {
            if (valor <= 0) {
                System.out.println("Erro: O valor do saque deve ser maior que zero.");
                return;
            }
            if (getSaldoAtual() < valor) {
                System.out.println("Erro: Saldo insuficiente para realizar o saque na Conta Poupança.");
                return;
            }
            setSaldoAtual(getSaldoAtual() - valor);
            getSaques().registrar(valor);
        } else if (tipo == 'J') {
            if (valor <= 0) {
                System.out.println("Erro: A taxa de juros deve ser maior que zero.");
                return;
            }
            double rendimento = getSaldoAtual() * (valor / 100.0);
            setSaldoAtual(getSaldoAtual() + rendimento);
            getJuros().registrar(rendimento);
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
