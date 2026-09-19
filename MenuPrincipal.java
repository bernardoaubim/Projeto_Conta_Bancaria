public class MenuPrincipal {

    private static ContaBancaria conta;

    public static void main(String[] args) {

        abrirMenu();

    }

    public static void abrirMenu() {

        int opcao = 0;

        while (opcao != 7) {

            System.out.println("+---------------------------------+");
            System.out.println("|        Menu de opções           |");
            System.out.println("+---------------------------------+");

            if (conta == null) {
                System.out.println("| Opção 1 - Abrir conta           |");
            }

            if (conta != null) {
                System.out.println("| Opção 2 - Realizar depósito     |");
                System.out.println("| Opção 3 - Realizar Saque        |");
                System.out.println("| Opção 4 - Aplicar Juros         |");
                System.out.println("| Opção 5 - Extrato               |");
            }

            System.out.println("| Opção 6 - Integrantes           |");
            System.out.println("| Opção 7 - Sair                  |");
            System.out.println("+---------------------------------+");

            opcao = Teclado.leInt("Digite uma opção: ");

            switch (opcao) {
                case 1:
                    if (conta == null) {
                        abrirConta();
                    } else {
                        System.out.println("Uma conta já foi aberta.");
                    }
                    break;

                case 2:
                    if (conta != null) {
                        realizarDeposito();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 3:
                    if (conta != null) {
                        // futuramente realizarSaque();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 4:
                    if (conta != null) {
                        // futuramente aplicarJuros();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 5:
                    if (conta != null) {
                        // futuramente extrato();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 6:
                    integrantes();
                    break;

                case 7:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inexistente.");
            }
        }

    }

    public static void abrirConta() {

        System.out.println("\n--- ABERTURA DE CONTA ---");

        String nome = Teclado.leString("Nome: ");
        String cpf = Teclado.leString("CPF: ");

        int dia = Teclado.leInt("Dia de nascimento: ");
        int mes = Teclado.leInt("Mês de nascimento: ");
        int ano = Teclado.leInt("Ano de nascimento: ");

        Data nascimento = new Data(dia, mes, ano);

        Cliente cliente = new Cliente(nome, cpf, nascimento);

        char tipo = Teclado.leChar("Tipo de conta (C - Corrente, P - Poupança, I - Investimento): ");

        double saldoInicial = Teclado.leDouble("Saldo inicial: ");

        // criação da conta específica
        switch (Character.toUpperCase(tipo)) {

            case 'C':
                double limite = Teclado.leDouble("Limite de crédito: ");
                conta = new ContaCorrente(cliente, saldoInicial, limite);
                break;

            case 'P':
                int diaAniversario = Teclado.leInt("Dia de aniversário da conta: ");
                conta = new ContaPoupanca(cliente, saldoInicial, diaAniversario);
                break;

            case 'I':
                int diaVencimento = Teclado.leInt("Dia do vencimento: ");
                int mesVencimento = Teclado.leInt("Mês do vencimento: ");
                int anoVencimento = Teclado.leInt("Ano do vencimento: ");

                Data vencimento = new Data(
                        diaVencimento,
                        mesVencimento,
                        anoVencimento);

                conta = new ContaInvestimento(cliente, saldoInicial, vencimento);
                break;

            default:
                System.out.println("Tipo de conta inválido.");
                return;
        }

        System.out.println("\nConta aberta com sucesso!");
    }

    public static void integrantes() {
        System.out.print("\033\143");
        int opcao = 99;

        while (opcao != 0) {

            System.out.println("+---------------------------------+");
            System.out.println("|           Integrantes           |");
            System.out.println("+---------------------------------+");
            System.out.println("|      Bernardo Aubim Barbosa     |");
            System.out.println("|      Davi Fronza Caillava       |");
            System.out.println("|      Enzo Bueno                 |");
            System.out.println("|      Lorenzo Penna de Moraes    |");
            System.out.println("|      Yasmin Soares Peña         |");
            System.out.println("+---------------------------------+");
            opcao = Teclado.leInt("Digite 0 para sair da tela de integrantes.");
            System.out.print("\033\143");
        }
    }

    public static void realizarDeposito() {
        double valor = Teclado.leDouble("Digite o valor do depósito: ");

        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        Operacao operacao = new Operacao('D', valor);
        conta.movimenta(operacao);


    }
}
