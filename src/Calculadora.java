import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora extends CalculadoraView {
    private double saldo;
    public Calculadora(double saldo) {
        this.saldo = saldo;
    }
    private BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN);

        }catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }
    @Override
    protected void btnVoltarClick(ActionEvent ev) {
        txtSaldo.setText(String.valueOf(saldo));
    }

    @Override
    protected void btnFecharClick(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();

    }
    @Override
    protected void btnCalcularClick(ActionEvent ev) {
        BigDecimal saldo = toBigDecimal(txtSaldo.getText());
        BigDecimal taxaJuros = toBigDecimal(txtTaxaJuros.getText());
        BigDecimal periodo = toBigDecimal(txtPeriodo.getText());

        BigDecimal resultado = taxaJuros.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
        resultado = resultado.add(BigDecimal.ONE);
        resultado = resultado.pow(periodo.intValue());
        resultado = resultado.multiply(saldo);
        resultado = resultado.setScale(2,RoundingMode.HALF_EVEN);
        txtResultado.setText(resultado.toPlainString());

    }

    @Override
    protected void btnLimparClick(ActionEvent ev) {
        txtTaxaJuros.setText("");
        txtPeriodo.setText("");
        txtResultado.setText("");
    }
}
