public class Cliente {

    private String nome;
    private String cpf;
    private Data nascimento;
    
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Data getNascimento() {
        return nascimento;
    }
    public Cliente(String nome, String cpf, Data nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

}
