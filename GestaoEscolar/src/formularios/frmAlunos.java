package formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAlunos extends JInternalFrame {
	private JTextField textnome;
	private JTextField textra;
	private JTextField textemail;
	private JTextField textcelular;

	private DefaultListModel dlmAlunos = new DefaultListModel();
	JList lstalunos = new JList();
	public frmAlunos() 
	{
	
		setTitle("Cadastro de Alunos");
		setBounds(100, 100, 343, 391);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Alunos");
		lblCadastroDeAlunos.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastroDeAlunos.setBounds(84, 11, 146, 24);
		getContentPane().add(lblCadastroDeAlunos);
		
		JLabel lblnome = new JLabel("Nome:");
		lblnome.setBounds(20, 73, 46, 14);
		getContentPane().add(lblnome);
		
		JLabel lblra = new JLabel("RA:");
		lblra.setBounds(20, 98, 46, 14);
		getContentPane().add(lblra);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(20, 123, 46, 14);
		getContentPane().add(lblemail);
		
		JLabel lblcelular = new JLabel("Celular:");
		lblcelular.setBounds(20, 148, 46, 14);
		getContentPane().add(lblcelular);
		
		textnome = new JTextField();
		textnome.setBounds(59, 70, 180, 20);
		getContentPane().add(textnome);
		textnome.setColumns(10);
		
		textra = new JTextField();
		textra.setBounds(59, 95, 114, 20);
		getContentPane().add(textra);
		textra.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(59, 123, 180, 20);
		getContentPane().add(textemail);
		textemail.setColumns(10);
		
		textcelular = new JTextField();
		textcelular.setText("");
		textcelular.setBounds(59, 148, 114, 20);
		getContentPane().add(textcelular);
		textcelular.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar();
				
			}
		});
		btnCadastrar.setBounds(10, 197, 97, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alterar();
			}
		});
		btnAlterar.setBounds(117, 197, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExcluir.setBounds(228, 197, 89, 23);
		getContentPane().add(btnExcluir);
		
		
		lstalunos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstalunos.setModel (dlmAlunos);
		lstalunos.setBounds(10, 231, 307, 85);
		getContentPane().add(lstalunos);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sair();
			}
		});
		btnSair.setBounds(117, 327, 89, 23);
		getContentPane().add(btnSair);

	}
	public void Cadastrar(){
		if (!textnome.getText().equals("") && !textra.getText().equals(""))
		dlmAlunos.addElement(textnome.getText() + " - "+ textra.getText() + " - " + textemail.getText() + " - " + textcelular.getText() );
		LimparTXT();
	}
	public void Sair(){
		this.dispose();
	}
	public void LimparTXT(){
		textnome.setText("");
		textra.setText("");
		textemail.setText("");
		textcelular.setText("");
	}
	
	public void Alterar(){ 
		dlmAlunos.setElementAt(textnome.getText() + " - " + textra.getText()+ " - "+ textemail.getText()+ " - "+ textcelular.getText(), lstalunos.getSelectedIndex());
	}
}
