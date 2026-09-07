import java.io.*;
import java.nio.charset.Charset;

/**
 * Classe que permite fazer leitura de dados do teclado
 */
public class Teclado {

    private static String s;
    private static final InputStreamReader i;
    private static final BufferedReader d;
    
    static {
        // Detecta o charset apropriado
        Charset charset = detectarCharset();
        i = new InputStreamReader(System.in, charset);
        d = new BufferedReader(i);
        // System.out.println("Usando charset: " + charset.name());
    }
    
    private static Charset detectarCharset() {
        // Tenta obter do console primeiro
        Console console = System.console();
        if (console != null) {
            return console.charset();
        }
        
        // Fallback para charset padrão
        return Charset.defaultCharset();
    }

     /**
     * Lê um inteiro.
     *
     * @return int
     */
    public static int leInt() {
        int a = 0;
        try {
            s = d.readLine();
            a = Integer.parseInt(s);
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e);
        } catch (NumberFormatException e) {
            System.out.println("O valor digitado deve ser inteiro: " + e);
        }
        return a;
    }

    /**
     * Lê um inteiro, com mensagem.
     *
     * @return int
     */
    public static int leInt(String msg) {
        System.out.println(msg);
        return leInt();
    }

    /**
     * Lê um double.
     *
     * @return double
     */
    public static double leDouble() {
        double a = 0;
        try {
            s = d.readLine();
            a = Double.parseDouble(s);
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e);
        } catch (NumberFormatException e) {
            System.out.println("O valor digitado deve ser número: " + e);
        }
        return a;
    }

    /**
     * Lê um double, com mensagem.
     *
     * @return double
     */
    public static double leDouble(String msg) {
        System.out.println(msg);
        return leDouble();
    }

    /**
     * Lê um string.
     *
     * @return String
     */
    public static String leString() {
        s = "";
        try {
            s = d.readLine();
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e);
        }
        return s;
    }

    /**
     * Lê um string. com mensagem.
     *
     * @return String
     */
    public static String leString(String msg) {
        System.out.println(msg);
        return leString();
    }

    public static char leChar() {
        char a = ' ';
        try {
            s = d.readLine();
            a = s.charAt(0);
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e);
        } catch (NumberFormatException e) {
            System.out.println("o valor digitado deve ser char: " + e);
        }
        return a;
    }

    /**
     * Lê um char, com mensagem.
     *
     * @return char
     */
    public static char leChar(String msg) {
        System.out.println(msg);
        return leChar();
    }
}
