public class ContaBancaria {
    
    private Cliente cliente;
    private double saldo;

    private double saldoInicial;
    private double saldoMin;
    private double saldoMax;

    private Movimentacao deposito;
    private Movimentacao saque;
    private Movimentacao juros;

    public ContaBancaria (Cliente cliente, double saldo){
        this.cliente = cliente;
        this.saldoInicial = saldo;
        this.saldo = saldo;

        this.saldoMin = saldo;
        this.saldoMax = saldo;

        this.deposito = new Movimentacao();
        this.saque = new Movimentacao();
        this.juros = new Movimentacao();
    }

    public void movimenta(Operacao operacao) {

        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        switch (tipo) {
            case 'D':
                realizarDeposito(valor);
                break;
            case 'S':
                if (!autorizaSaque(valor)) {
                    System.out.println("Saldo insuficiente.");
                    return;
                }
                realizarSaque(valor);
                break;
            case 'J':
                aplicarJuros(valor);
                break;
            default:
                System.out.println("Informe uma operação válida.");
                break;
        }
    }

    public void aplicarJuros(double taxa) {
        if (taxa <= 0) {
            System.out.println("Taxa inválida.");
            return;
        }
        double saldoAnterior = this.saldo;
        double rendimento = this.saldo * (taxa / 100);
        this.saldo += rendimento;
        this.juros.registrar(rendimento);          // registra para o extrato

        if (this.saldo > this.saldoMax) {
            this.saldoMax = this.saldo;
        }
        System.out.println("Saldo Inicial: R$ " + saldoAnterior);
        System.out.println("Rendimento: R$ " + rendimento);
        System.out.println("Saldo atual: R$ " + this.saldo);
    }

    public void realizarDeposito(double valor){
        if (valor <= 0) {
            System.out.println("Valor inválido");
            return ;
        }

        this.saldo += valor; 
        this.deposito.registrar(valor);

        if (this.saldo > this.saldoMax) {
            this.saldoMax = this.saldo;
        }

        System.out.println("Depósito concluído. Saldo atualizado para: R$ " + this.saldo);
    }

    //lógica de caixa eletronico. Por alguma razão enunciado n menciona nota de 200
    public void realizarSaque(double valor) {
        if (valor % 1 != 0) {
            System.out.println("Operação inválida: Este terminal não opera com moedas.");
            return;
        }

        int montante = (int) valor;
        int n100 = 0, n50 = 0, n20 = 0, n10 = 0, n5 = 0, n2 = 0;

        // se for ímpar, precisa tirar uma nota de 5 para sobrar valor par
        if (montante % 2 != 0) {
            if (montante < 5) {
                System.out.println("Notas indisponíveis para sacar R$ " + valor);
                return;
            }
            n5 = 1;
            montante -= 5;
        }

        n100 = montante / 100;
        montante %= 100;

        n50 = montante / 50;
        montante %= 50;

        n20 = montante / 20;
        montante %= 20;

        n10 = montante / 10;
        montante %= 10;

        n2 = montante / 2;
        montante %= 2;

        if (montante != 0) {
            System.out.println("Notas indisponíveis para sacar R$ " + valor);
            return;
        }

        this.saldo -= valor;
        this.saque.registrar(valor);

        if (this.saldo < this.saldoMin) {
            this.saldoMin = this.saldo;
        }

        String extratoNotas = "";
        if (n100 > 0) extratoNotas += n100 + " nota(s) de R$ 100\n";
        if (n50 > 0)  extratoNotas += n50 + " nota(s) de R$ 50\n";
        if (n20 > 0)  extratoNotas += n20 + " nota(s) de R$ 20\n";
        if (n10 > 0)  extratoNotas += n10 + " nota(s) de R$ 10\n";
        if (n5 > 0)   extratoNotas += n5 + " nota(s) de R$ 5\n";
        if (n2 > 0)   extratoNotas += n2 + " nota(s) de R$ 2\n";

        System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        System.out.print(extratoNotas);
        System.out.printf("Saldo Atualizado: R$ %.2f\n", this.saldo);
    }

    
        public void exibirExtrato() {
            System.out.println("\nEXTRATO BANCÁRIO");

            System.out.println("Cliente:    " + this.cliente.getNome());
            System.out.println("CPF:        " + this.cliente.getCpf());
            System.out.println("Nascimento: " + this.cliente.getNascimento());

            System.out.println("\nDados Específicos da Conta:");
            this.exibirDadosEspecificos();

            System.out.println("\nSaldos:");
            System.out.println("  Inicial: R$ " + this.saldoInicial);
            System.out.println("  Atual:   R$ " + this.saldo);

            System.out.println("\nMovimentações (Qtd - Valor Total):");
            System.out.println("  Depósitos: " + this.deposito);
            System.out.println("  Saques:    " + this.saque);
            System.out.println("  Juros:     " + this.juros);

            System.out.println("\nPicos da Conta:");
            System.out.println("  Mínimo: R$ " + this.saldoMin);
            System.out.println("  Máximo: R$ " + this.saldoMax + "\n");
    }
    protected boolean autorizaSaque(double valor) {
        return valor <= this.saldo;
    }
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Superclasse Conta Bancária");
    }
    public double getSaldo() {
        return this.saldo;
    }

    public double getSaldoAtual() {
    return this.saldo;
    }

    public void setSaldoAtual(double saldo) {
        this.saldo = saldo;
    }

    public Movimentacao getDepositos() {
    return this.deposito;
    }

    public Movimentacao getSaques() {
        return this.saque;
    }

    public Movimentacao getJuros() {
        return this.juros;
    }
}