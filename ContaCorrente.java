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
        double valor =  op.getValor();

        if (tipo == 'D') {
            super.movimenta(op);
        } else if (tipo == 'S') {
            if (valor <= 0) {
                System.out.println("Erro: O valor do saque deve ser maior que zero.");
                return;
            }
            //Valida se saldo + limite de crédito é suficiente
            if (getSaldoAtual() + limiteCredito < valor) {
                System.out.println("Erro: Saldo insuficiente e limite de crédito ultrapassado.");
                return;
            }
            setSaldoAtual(getSaldoAtual() - valor);
            getSaques().registrar(valor);
        } else if (tipo == 'J') {
            //Juros indisponíveis p conta corrente
            System.out.println("Erro: Operação de juros indisponível para Conta Corrente.");
        } else {
            System.out.println("Erro: Tipo de operação inválido.");
        }
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Corrente");
        System.out.printf("  Limite de Crédito: R$ %.2f\n", limiteCredito);
    }
}
