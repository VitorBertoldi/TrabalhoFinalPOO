import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class ContaView extends JFrame{
    public ContaView(Cliente cliente) {
        this.inicializar();
        this.eventos();
    }
    private static final int TAMANHO_TXT = 15;
    protected JPanel pnlRodape;
    protected JPanel pnlForm;
    protected JButton btnSacar;
    protected JButton btnDepositar;
    protected JButton btnTransferir;
    protected JButton btnCalcularJuros;
    protected JButton btnVoltar;
    protected JLabel lblConta;
    protected JTextField txtConta;
    protected JLabel lblSaldo;
    protected JTextField txtSaldo;
    protected JLabel lblValor;
    protected JTextField txtValor;
    protected JLabel lblDestino;
    protected JTextField txtDestino;
    private void inicializar(){
        this.setTitle("Conta");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlForm(),BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        txtSaldo.setText(String.valueOf(Conta.getSaldo()));
        txtConta.setText(String.valueOf(Conta.getNumero()));
        this.pack();
    }
    public String contaInfos(Cliente cliente) {
        String infos = ("Titular: " + cliente.getNome()
                + "Agencia" +
                cliente.getConta())+ "";
        return infos;
    }
    protected abstract void btnSacarClick(ActionEvent ev);
    protected abstract void btnDepositarClick(ActionEvent ev);
    protected abstract void btnTransferirClick(ActionEvent ev);
    protected abstract void btnVoltarClick(ActionEvent ev);
    protected abstract void btnCalcularJurosClick(ActionEvent ev);

    private void eventos() {
        btnSacar.addActionListener(this::btnSacarClick);
        btnDepositar.addActionListener(this::btnDepositarClick);
        btnTransferir.addActionListener(this::btnTransferirClick);
        btnVoltar.addActionListener(this::btnVoltarClick);
        btnCalcularJuros.addActionListener(this::btnCalcularJurosClick);
    }

    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel();

            pnlForm = new JPanel(new GridLayout(4,2));

            lblConta = new JLabel("Conta" );
            txtConta = new JTextField(TAMANHO_TXT);
            txtConta.setEditable(false);

            lblSaldo = new JLabel("Saldo");
            txtSaldo = new JTextField(TAMANHO_TXT);
            txtSaldo.setEditable(false);

            lblValor = new JLabel("Valor");
            txtValor = new JTextField(TAMANHO_TXT);

            lblDestino = new JLabel("Conta de Destino");
            txtDestino = new JTextField(TAMANHO_TXT);

            pnlForm.add(lblConta);
            pnlForm.add(txtConta);

            pnlForm.add(lblSaldo);
            pnlForm.add(txtSaldo);

            pnlForm.add(lblValor);
            pnlForm.add(txtValor);
            pnlForm.add(lblDestino);
            pnlForm.add(txtDestino);

        }
        return pnlForm;
    }
    public JPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnSacar = new JButton("Sacar");
            btnDepositar = new JButton("Depositar");
            btnTransferir = new JButton("Transferir");
            btnVoltar = new JButton("Voltar");
            btnCalcularJuros = new JButton("Calcular Juros Compostos");

            pnlRodape.add(btnSacar);
            pnlRodape.add(btnDepositar);
            pnlRodape.add(btnTransferir);
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnCalcularJuros);
        }
        return pnlRodape;
    }
}
