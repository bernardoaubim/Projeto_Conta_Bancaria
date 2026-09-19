public class ContaInvestimento extends ContaBancaria {
    private Data vencimento;

    public ContaInvestimento(Cliente cliente, double saldoInicial, Data vencimento) {
        super(cliente, saldoInicial);
        this.vencimento = vencimento;
    }

    public Data getVencimento() {
        return vencimento;
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
            super.movimenta(op);
        } else if (tipo == 'S') {
            //Saques bloqueados p conta investimento
            System.out.println("Erro: Operação de saque indisponível para Conta Investimento.");
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
        System.out.println("  Tipo: Conta Investimento");
        System.out.println("  Data de Vencimento: " + vencimento);
    }
}
