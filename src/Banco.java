import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Banco extends BancoView {
    private ArrayList<ContaView> contas = new ArrayList<ContaView>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
    @Override
    protected void btnFecharClick(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
    }
    @Override
    protected void btnCadastrarClick(ActionEvent ev) {
        String nome = txtNome.getText();
        Arquivo.Write("C:\\Users\\suporte\\Documents\\ArquivosPOO" , txtNome.getText());
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        Conta conta = new ContaPoupanca(cliente);
        cliente.setConta(conta);
        clientes.add(cliente);
        contas.add(conta);
    }
    protected void btnverContaClick(ActionEvent ev) {
        String nomeconsulta = txtConsulta.getText();
        for (Cliente cliente : clientes) {
            String nome = cliente.getNome();
            if (nome.equals(nomeconsulta) ){
                Conta c = new Conta(cliente);
                c.setVisible(true);
            }
            else
                txtConsulta.setText("Digite um nome cadastrado");
        }
    }
}
