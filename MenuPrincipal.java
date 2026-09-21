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
                        realizarSaque();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 4:
                    if (conta != null) {
                        aplicarJuros();
                    } else {
                        System.out.println("É necessário abrir uma conta primeiro.");
                    }
                    break;

                case 5:
                    if (conta != null) {
                        conta.exibirExtrato(); 
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

        
        String nome;
        do {
            nome = Teclado.leString("Nome: ");

            if (nome.trim().isEmpty()) {
                System.out.println("Nome não pode ser vazio.");
            }

        } while (nome.trim().isEmpty());


        String cpf;

        do {
            cpf = Teclado.leString("CPF: ");

            if (cpf.trim().isEmpty()) {
                System.out.println("CPF não pode ser vazio.");
            }

        } while (cpf.trim().isEmpty());

        int dia;
        int mes;
        int ano;

        do {
            dia = Teclado.leInt("Dia de nascimento: ");

            if (dia < 1 || dia > 31) {
                System.out.println("Dia inválido.");
            }

        } while (dia < 1 || dia > 31);

        do {
            mes = Teclado.leInt("Mês de nascimento: ");

            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido.");
            }

        } while (mes < 1 || mes > 12);

        do {
            ano = Teclado.leInt("Ano de nascimento: ");

            int idade = 2026 - ano;

            if (ano > 2026) {
                System.out.println("Ano de nascimento inválido.");
            } else if (idade < 16) {
                System.out.println("É necessário ter pelo menos 16 anos.");
            }

        } while (ano > 2026 || 2026 - ano < 16);
        Data nascimento = new Data(dia, mes, ano);

        Cliente cliente = new Cliente(nome, cpf, nascimento);

        char tipo;

        do {
            tipo = Character.toUpperCase(Teclado.leChar("Tipo de conta (C - Corrente, P - Poupança, I - Investimento): "));

            if (tipo != 'C' && tipo != 'P' && tipo != 'I') {
                System.out.println("Tipo de conta inválido.");
            }

        } while (tipo != 'C' && tipo != 'P' && tipo != 'I');


        double saldoInicial;
        
            saldoInicial = pedirSaldo("Saldo inicial: ");

        // criação da conta específica
        switch (tipo) {

            case 'C':
                double limite;

                do {
                    limite = Teclado.leDouble("Limite de crédito: ");

                    if (limite < 0) {
                        System.out.println("O limite de crédito não pode ser negativo.");
                    }

                } while (limite < 0);

                conta = new ContaCorrente(cliente, saldoInicial, limite);
                break;

            case 'P':
                int diaAniversario;

                do {
                    diaAniversario = Teclado.leInt("Dia de aniversário da conta: ");

                    if (diaAniversario < 1 || diaAniversario > 31) {
                        System.out.println("Dia inválido.");
                    }

                } while (diaAniversario < 1 || diaAniversario > 31);

                conta = new ContaPoupanca(cliente, saldoInicial, diaAniversario);
                break;

            case 'I':
                int diaVencimento;
                int mesVencimento;
                int anoVencimento;

                do {
                    diaVencimento = Teclado.leInt("Dia do vencimento: ");

                    if (diaVencimento < 1 || diaVencimento > 31) {
                        System.out.println("Dia inválido.");
                    }

                } while (diaVencimento < 1 || diaVencimento > 31);

                do {
                    mesVencimento = Teclado.leInt("Mês do vencimento: ");

                    if (mesVencimento < 1 || mesVencimento > 12) {
                        System.out.println("Mês inválido.");
                    }

                } while (mesVencimento < 1 || mesVencimento > 12);

                do {
                    anoVencimento = Teclado.leInt("Ano do vencimento: ");

                    if (anoVencimento < 2026) {
                        System.out.println("Ano inválido.");
                    }

                } while (anoVencimento < 2026);

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
        Operacao operacao = new Operacao('D', valor);
        conta.movimenta(operacao);
    }

    public static void aplicarJuros() {
        double taxa = Teclado.leDouble("Digite a taxa de juros: ");
        Operacao operacao = new Operacao('J', taxa);
        conta.movimenta(operacao);
    }

    public static void realizarSaque() {
    double valor = Teclado.leDouble("Digite o valor do saque: ");
    conta.movimenta(new Operacao('S', valor));
    }

    //teclado.leDouble() permitia um bug onde entrada invalida passava por 0 
    //isso vlaia para outros parâmetros, mas no SaldoInicial contaminava mtds importantes 
    private static double pedirSaldo(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valorStr = Teclado.leString();

            if (verificarNumero(valorStr)) {
                return Double.parseDouble(valorStr.trim());
            }

            System.out.println("Valor inválido.");
        }
    }    private static boolean verificarNumero(String valorStr) {
        try {
            double valor = Double.parseDouble(valorStr.trim());
            return valor > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
