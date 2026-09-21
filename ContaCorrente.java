public class ContaCorrente extends ContaBancaria {
    private double limiteCredito;

    public ContaCorrente(Cliente cliente, double saldoInicial, double limiteCredito) {
        super(cliente, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void movimenta(Operacao op) {
        if (op == null) {
            System.out.println("Erro: Operação inválida.");
            return;
        }

        char tipo = op.getTipo();

        if (tipo == 'D' || tipo == 'S') {
            super.movimenta(op);
        } else if (tipo == 'J') {
            // Juros indisponíveis para conta corrente
            System.out.println("Erro: Operação de juros indisponível para Conta Corrente.");
        } else {
            System.out.println("Erro: Tipo de operação inválido.");
        }
    }

    @Override
    protected boolean autorizaSaque(double valor) {
        return valor <= getSaldoAtual() + limiteCredito;
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Corrente");
        System.out.printf("  Limite de Crédito: R$ %.2f\n", limiteCredito);
    }
}
