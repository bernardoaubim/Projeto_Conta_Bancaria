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

        if (tipo == 'D' || tipo == 'J') {
            super.movimenta(op);
        } else if (tipo == 'S') {
            // Saques bloqueados para conta investimento
            System.out.println("Erro: Operação de saque indisponível para Conta Investimento.");
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
