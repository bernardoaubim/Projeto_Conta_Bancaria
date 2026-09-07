import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {

        abrirMenu();

        
    }

        public static void abrirMenu() {

            int opcao = 0;

            while (opcao != 7) {
                System.out.println("+---------------------------------+");
                System.out.println("|        Menu de opções           |");
                System.out.println("+---------------------------------+");
                System.out.println("| Opção 1 - Abrir conta           |");
                System.out.println("| Opção 2 - Realizar depósito     |");
                System.out.println("| Opção 3 - Realizar Saque        |");
                System.out.println("| Opção 4 - Aplicar Juros         |");
                System.out.println("| Opção 5 - Extrato               |");
                System.out.println("| Opção 6 - Integrantes           |");
                System.out.println("| Opção 7 - Sair                  |");
                System.out.println("+---------------------------------+");
                opcao = Teclado.leInt("Digite uma opção: ");

                switch (opcao) {
            //        case 1 -> 
            //        case 2 -> 
            //        case 3 -> 
            //        case 4 -> 
            //        case 5 ->
                case 6 -> integrantes();
                case 7 -> System.out.println("Sistema encerrado.");
                default -> System.out.println("Opção inexistente.");
                }
            }

        }

        public static void integrantes() {
        System.out.print("\033\143");
        int opcao = 99;

            while (opcao != 0) {

                System.out.println("+---------------------------------+");
                System.out.println("|           Integrantes           |");
                System.out.println("+---------------------------------+");
                System.out.println("|         Bernardo Aubim          |");
                System.out.println("|                                 |");
                System.out.println("|                                 |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                opcao = Teclado.leInt("Digite 0 para sair da tela de integrantes.");
                System.out.print("\033\143");
            }      
        }
}
