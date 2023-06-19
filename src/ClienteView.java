import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class ClienteView extends JFrame{
    private static final int TAMANHO_TXT = 15;
    protected JPanel pnlRodape;
    protected JPanel pnlForm;
    protected JButton btnCadastrarCliente;
    protected JButton btnVerConta;
    protected JButton btnFechar;
    protected JLabel lblNome;
    protected JTextField txtNome;
    protected JLabel lblConsulta;
    protected JTextField txtConsulta;
    public ClienteView(){
        this.inicializar();
        this.eventos();
    }
    private void inicializar(){
        this.setTitle("Cliente");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlForm(),BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.pack();
    }
    protected abstract void btnFecharClick(ActionEvent ev);
    protected abstract void btnCadastrarClick(ActionEvent ev);
    protected abstract void btnverContaClick(ActionEvent ev);
    private void eventos() {
        btnFechar.addActionListener(this::btnFecharClick);
        btnCadastrarCliente.addActionListener(this::btnCadastrarClick);
        btnVerConta.addActionListener(this::btnverContaClick);
    }
    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel();

            lblNome = new JLabel("Nome cadastro");
            txtNome = new JTextField(TAMANHO_TXT);

            lblConsulta = new JLabel("Nome a consultar");
            txtConsulta = new JTextField(TAMANHO_TXT);

            pnlForm.add(lblConsulta);
            pnlForm.add(txtConsulta);

            pnlForm.add(lblNome);
            pnlForm.add(txtNome);

        }
        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCadastrarCliente = new JButton("Cadastrar");
            btnVerConta = new JButton("Consultar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnCadastrarCliente);
            pnlRodape.add(btnVerConta);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }


}
