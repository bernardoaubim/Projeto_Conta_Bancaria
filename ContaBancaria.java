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

    public void movimenta(Operacao operacao){

        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        if (valor <= 0 ) {
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

    public void aplicarJuros(double taxa){
        if (taxa <= 0) {
            System.out.println("Taxa inválida.");
            return;
        }
        double saldoAnterior = this.saldo; // guarda o saldo inicial
        double rendimento = this.saldo * (taxa / 100);
        this.saldo += rendimento;

        if (this.saldo > this.saldoMax) {
            this.saldoMax = this.saldo;
        }
        System.out.println("Saldo Inicial: R$ " + saldoAnterior);
        System.out.println("Rendimento: R$" + rendimento);
        System.out.println("Saldo atual: R$" + this.saldo);


        //pode precisar de metd do Moviementação para registrar e compor extrato
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
    public void realizarSaque(double valor){
        if (valor % 1 != 0) { //enunciado delimita apenas notas, presumo que centavos n são considerados
            System.out.println("Operação inválida: Este terminal não opera com moedas.");   
            return;         
        }
        
        int montante = (int) valor; //corta o decimal usando apenas notas(inteiros)

        int[] notas = {100, 50, 20, 10, 5, 2}; //testar se ordem será da maior p/menor conf enunciado
        String extratoNotas = "";

        for (int nota : notas) {
            int saqueNotas = montante / nota;

            if (saqueNotas > 0) {
                extratoNotas += saqueNotas + "nota(s) de R$ " + nota + "\n";
                montante %= nota;  // retorna o resto da divisão ao loop
            }
        }

        if (montante == 0) {
            this.saldo -= valor;

            //pd precisar de metd do Movimentação para registrar e compor extrato
            if (this.saldo < this.saldoMin) {
                this.saldoMin = this.saldo;
            }

            System.out.println("Saque de R$ " + valor + "realizado com sucesso!");
            System.out.print(extratoNotas);
            System.out.println("Saldo Atualizado: R$ " + this.saldo);
        }
        else{
            System.out.println("Notas indisponíveis para sacar R$ " + valor);
            //testar se o valor não-sacado afeta o saldo
        }
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
             //REQUER mtd no movimentação

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