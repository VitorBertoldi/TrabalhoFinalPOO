import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CalculadoraView extends JFrame {

    private static final int TAMANHO_TXT = 15;
    protected JPanel pnlRodape;
    protected JPanel pnlForm;

    protected JButton btnCalcular;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    protected JButton btnVoltar;

    protected JLabel lblSaldo;
    protected JTextField txtSaldo;

    protected JLabel lblTaxaJuros;
    protected JTextField txtTaxaJuros;

    protected JLabel lblPeriodo;
    protected JTextField txtPeriodo;

    protected JLabel lblResultado;
    protected JTextField txtResultado;


    public CalculadoraView(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar(){
        this.setTitle("Calculadora Juros Compostos");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        this.getContentPane().add(getPnlForm(),BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        //txtSaldo.setText(String.valueOf(saldo);
        this.pack();
    }

    protected abstract void btnFecharClick(ActionEvent ev);
    protected abstract void btnCalcularClick(ActionEvent ev);
    protected abstract void btnLimparClick(ActionEvent ev);
    protected abstract void btnVoltarClick(ActionEvent ev);

    private void eventos() {
        btnFechar.addActionListener(this::btnFecharClick);
        btnLimpar.addActionListener(this::btnLimparClick);
        btnCalcular.addActionListener(this::btnCalcularClick);
        btnVoltar.addActionListener(this::btnVoltarClick);
    }

    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel(new GridLayout(4,2));

            lblSaldo = new JLabel("Saldo");
            txtSaldo = new JTextField(TAMANHO_TXT);

            lblTaxaJuros = new JLabel("Taxa de Juros");
            txtTaxaJuros = new JTextField(TAMANHO_TXT);

            lblPeriodo = new JLabel("Periodo");
            txtPeriodo = new JTextField(TAMANHO_TXT);

            lblResultado = new JLabel("Resultado");
            txtResultado = new JTextField(TAMANHO_TXT);
            txtResultado.setEditable(false);

            pnlForm.add(lblSaldo);
            pnlForm.add(txtSaldo);

            pnlForm.add(lblTaxaJuros);
            pnlForm.add(txtTaxaJuros);
            pnlForm.add(lblPeriodo);
            pnlForm.add(txtPeriodo);
            pnlForm.add(lblResultado);
            pnlForm.add(txtResultado);

        }
        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if (pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCalcular = new JButton("Calcular");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");
            btnVoltar = new JButton("Ver Saldo");

            pnlRodape.add(btnCalcular);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);
            pnlRodape.add(btnVoltar);
        }
        return pnlRodape;
    }
}
