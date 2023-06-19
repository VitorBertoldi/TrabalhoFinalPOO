public class Cliente {
    private String nome;
    private Conta conta;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ContaView getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
