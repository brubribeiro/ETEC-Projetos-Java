package formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmCalcularMedia extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtMedia;
	private JTable tblCalcularMedia;
	
	private DefaultTableModel dtmCalcularMedia = new DefaultTableModel();
	
	public void CriarColunasTableCalcularMedia(){
		dtmCalcularMedia.addColumn("Nome");
		dtmCalcularMedia.addColumn("N1");
		dtmCalcularMedia.addColumn("N2");
		dtmCalcularMedia.addColumn("N3");
		dtmCalcularMedia.addColumn("Média");
		tblCalcularMedia.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblCalcularMedia.getColumnModel().getColumn(1).setPreferredWidth(40);
		tblCalcularMedia.getColumnModel().getColumn(2).setPreferredWidth(40);
		tblCalcularMedia.getColumnModel().getColumn(3).setPreferredWidth(40);
		tblCalcularMedia.getColumnModel().getColumn(4).setPreferredWidth(60);
	}
	
	public frmCalcularMedia() {
		setBounds(100, 100, 450, 471);
		getContentPane().setLayout(null);
		
		JLabel lblNotas = new JLabel("Calcular M\u00E9dia de Notas");
		lblNotas.setBounds(10, 11, 371, 14);
		getContentPane().add(lblNotas);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(41, 54, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(41, 77, 46, 14);
		getContentPane().add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(41, 102, 46, 14);
		getContentPane().add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(41, 127, 46, 14);
		getContentPane().add(lblNota3);
		
		JLabel lblMedia = new JLabel("M\u00E9dia:");
		lblMedia.setBounds(41, 152, 46, 14);
		getContentPane().add(lblMedia);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 51, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(97, 74, 86, 20);
		getContentPane().add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(97, 99, 86, 20);
		getContentPane().add(txtNota2);
		txtNota2.setColumns(10);
		
		txtNota3 = new JTextField();
		txtNota3.setBounds(97, 124, 86, 20);
		getContentPane().add(txtNota3);
		txtNota3.setColumns(10);
		
		txtMedia = new JTextField();
		txtMedia.setBounds(97, 149, 86, 20);
		getContentPane().add(txtMedia);
		txtMedia.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calcular();
			}
		});
		btnCalcular.setBounds(208, 98, 89, 23);
		getContentPane().add(btnCalcular);
		
		JList lstMedia = new JList();
		lstMedia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lstMedia.setBounds(10, 226, 414, 63);
		getContentPane().add(lstMedia);
		
		JPanel pbotoes = new JPanel();
		pbotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pbotoes.setBounds(0, 177, 434, 38);
		getContentPane().add(pbotoes);
		pbotoes.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excluir();
			}
		});
		btnExcluir.setBounds(275, 7, 63, 23);
		pbotoes.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alterar();
			}
		});
		btnAlterar.setBounds(175, 7, 65, 23);
		pbotoes.add(btnAlterar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar();
			}
		});
		btnCadastrar.setBounds(61, 7, 81, 23);
		pbotoes.add(btnCadastrar);
		
		JScrollPane spCalcularMedia = new JScrollPane();
		spCalcularMedia.setBounds(10, 300, 414, 130);
		getContentPane().add(spCalcularMedia);
		
		tblCalcularMedia = new JTable();
		tblCalcularMedia.setModel(dtmCalcularMedia);
		spCalcularMedia.setViewportView(tblCalcularMedia);
		CriarColunasTableCalcularMedia();

	}
	public void Cadastrar(){
		dtmCalcularMedia.addRow(new String[] {txtNome.getText(),txtNota1.getText(),txtNota2.getText(),
		txtNota3.getText(),txtMedia.getText()});
	}
	public void Alterar(){
		dtmCalcularMedia.setValueAt(txtNome.getText(), tblCalcularMedia.getSelectedRow(), 0);
		dtmCalcularMedia.setValueAt(txtNota1.getText(), tblCalcularMedia.getSelectedRow(), 1);
		dtmCalcularMedia.setValueAt(txtNota2.getText(), tblCalcularMedia.getSelectedRow(), 2);
		dtmCalcularMedia.setValueAt(txtNota3.getText(), tblCalcularMedia.getSelectedRow(), 3);
		dtmCalcularMedia.setValueAt(txtMedia.getText(), tblCalcularMedia.getSelectedRow(), 4);
	}
	public void Excluir(){
		dtmCalcularMedia.removeRow(tblCalcularMedia.getSelectedRow());
	}
	public void Calcular(){
		float media, n1, n2, n3;
		
		n1 = Float.parseFloat(txtNota1.getText());
		n2 = Float.parseFloat(txtNota2.getText());
		n3 = Float.parseFloat(txtNota3.getText());
		
		
		media=(n1+n2+n3)/3;
		
		txtMedia.setText(String.valueOf(media));
	}
}
