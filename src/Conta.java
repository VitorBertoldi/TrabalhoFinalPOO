import java.awt.event.ActionEvent;
public class Conta extends ContaView implements IConta{
    @Override
    public void sacar(double valor) {
        valor = Double.valueOf(txtValor.getText());
        double saldo = Double.valueOf(txtSaldo.getText());
        if (saldo == 0) {
            throw new ExceptionPRO("Saldo indisponivel");
        }
        else {
            saldo -= valor;
            txtSaldo.setText(String.valueOf(saldo));
        }
    }

    @Override
    public void depositar(double valor) {
        valor =  Double.valueOf(txtValor.getText());
        double saldo = Double.valueOf(txtSaldo.getText());
        saldo += valor;
        txtSaldo.setText(String.valueOf(saldo));

    }

    @Override
    public void transferir(double valor, String contaDestino) {
        valor = Double.valueOf(txtValor.getText());
        double saldo = Double.valueOf(txtSaldo.getText());
        saldo -= valor;
        txtSaldo.setText(String.valueOf(saldo));
        contaDestino = txtDestino.getText();
        for (Cliente cliente : Banco.getClientes()) {
            String nome = cliente.getNome();
            if (nome.equals(contaDestino) ){
                ContaView c = new Conta(cliente);
                c.setVisible(true);
                //saldo += valor;
                //txtSaldo.setText(String.valueOf(saldo));
            }
            else
                txtDestino.setText("Tente novamente");
        }

    }

    protected static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 0;
    protected int agencia;
    protected static int numero;
    protected static double saldo;
    protected static Cliente cliente;

    public static Cliente getCliente() {
        return cliente;
    }

    public Conta(Cliente cliente) {
        super(cliente);
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    public String contaInfos(Cliente cliente) {
        String infos = ("Titular: " + cliente.getNome() + "Agencia" + cliente.getConta());
        return infos;
    }

    protected static String saldoInfo(Cliente cliente) {
        String infoSaldo = "Saldo: " + cliente.getConta();
        return infoSaldo;
    }

    public static int getNumero() {
        return numero;
    }
    public static double getSaldo() {
        return saldo;
    }
    protected void btnVoltarClick(ActionEvent ev){
        Conta conta = new Conta(cliente);
        conta.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    @Override
    public void btnSacarClick(ActionEvent ev) {
        sacar(Double.valueOf(txtValor.getText()));
    }
    @Override
    public void btnDepositarClick(ActionEvent ev) {
        depositar(Double.valueOf(txtValor.getText()));
    }
    @Override
    public void btnTransferirClick(ActionEvent ev) {
        transferir(Double.valueOf(txtValor.getText()),txtDestino.getText());
    }
    protected void btnCalcularJurosClick(ActionEvent ev){
        Calculadora conta = new Calculadora(Double.valueOf(txtSaldo.getText()));
        conta.setVisible(true);
        //this.setVisible(false);
        //this.dispose();
    }
}
