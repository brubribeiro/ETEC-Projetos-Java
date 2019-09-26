package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;	
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtResultado;

	public Calculadora() {
		setTitle("Calculadora Gr\u00E1fica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 266); //tamanho da janela
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalculadora = new JLabel("Calculadora Gr\u00E1fica");
		lblCalculadora.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCalculadora.setBounds(66, 11, 152, 14);
		contentPane.add(lblCalculadora);
		
		JLabel lblNumero1 = new JLabel("N\u00FAmero 1:");
		lblNumero1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNumero1.setBounds(10, 52, 72, 14);
		contentPane.add(lblNumero1);
		
		JLabel lblNumero2 = new JLabel("N\u00FAmero 2:");
		lblNumero2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNumero2.setBounds(10, 88, 60, 14);
		contentPane.add(lblNumero2);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblResultado.setBounds(10, 165, 60, 14);
		contentPane.add(lblResultado);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(92, 49, 86, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		txtNumero2 = new JTextField();
		txtNumero2.setBounds(92, 85, 86, 20);
		contentPane.add(txtNumero2);
		txtNumero2.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setBounds(92, 162, 86, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		JButton btnSomar = new JButton("+");
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Somar();
			}
		});
		//Design Botão Somar
		btnSomar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSomar.setBounds(10, 126, 60, 25);
		contentPane.add(btnSomar);
		
		
		JButton btnSubtrair = new JButton("-");
		btnSubtrair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Subtrair();
			}
		});
		//Design Botão Subtrair
		btnSubtrair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubtrair.setBounds(77, 126, 60, 25);
		contentPane.add(btnSubtrair);
		
		
		JButton btnDividir = new JButton("/");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dividir();
			}
		});
		//Design Botão Dividir
		btnDividir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDividir.setBounds(147, 126, 60, 25);
		contentPane.add(btnDividir);
		
		
		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Multiplicar();
			}
		});
		
		//Design Botão Multiplicar
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMultiplicar.setBounds(213, 126, 59, 25);
		contentPane.add(btnMultiplicar);
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Limpar();
			}
		});
		//Design Botão Limpar
		btnLimpar.setBounds(116, 193, 86, 23);
		contentPane.add(btnLimpar);
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sair();
			}
		});
		//Design Botão Sair
		btnSair.setBounds(212, 193, 60, 23);
		contentPane.add(btnSair);
	}
	
	public void Somar(){
		float numero1, numero2, resultado;
		
		numero1 = Float.parseFloat(txtNumero1.getText());
		numero2 = Float.parseFloat(txtNumero2.getText());
		resultado = numero1 + numero2;
		txtResultado.setText(String.valueOf(resultado));	
		/* try { txtResultado.setText(String.valueOf(Float.parseFloat(txtNumero1.getText())+ 
		 * Float.parseFloat(txtNumero2.getText())));
		 * }
		 * catch (Exception errosomar) {
		 * JOptionPane.showMessageDialog(this/null,"número digitado inválido","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
		 * }
		 * 
		 *  */
	}
	
	public void Subtrair(){
		float numero1, numero2, resultado;
			
		numero1 = Float.parseFloat(txtNumero1.getText());
		numero2 = Float.parseFloat(txtNumero2.getText());
		resultado = numero1 - numero2;
		txtResultado.setText(String.valueOf(resultado));
	}
	
	public void Dividir(){
		float numero1, numero2, resultado;
			
		numero1 = Float.parseFloat(txtNumero1.getText());
		numero2 = Float.parseFloat(txtNumero2.getText());
		resultado = numero1 / numero2;
		txtResultado.setText(String.valueOf(resultado));
	}
	
	public void Multiplicar(){
		float numero1, numero2, resultado;
			
		numero1 = Float.parseFloat(txtNumero1.getText());
		numero2 = Float.parseFloat(txtNumero2.getText());
		resultado = numero1 * numero2;
		txtResultado.setText(String.valueOf(resultado));
	}
	public void Limpar(){
		txtNumero1.setText(null); // (null) ou ("")
		txtNumero2.setText(null);
		txtResultado.setText(null);
		txtNumero1.requestFocus();
	}
	public void Sair(){
		
	}
	
	
}
