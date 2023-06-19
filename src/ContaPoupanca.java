public class ContaPoupanca extends Conta{
    String tipo = "Poupança";
      public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    public String contaInfos(Cliente cliente) {
        String infos = ("Titular: " + cliente.getNome()
                + "Agencia" + cliente.getConta()
                + "Tipo" + tipo);
        return infos;
    }
    public void imprimirExtrato() {
        System.out.println("---- Extrato Conta Poupança ----");
        super.contaInfos(cliente);
    }
}
