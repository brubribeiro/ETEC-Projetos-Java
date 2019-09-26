package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	JDesktopPane dpPrincipal = null;

	public frmPrincipal() {
		setTitle("Gestão Escolar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(SystemColor.inactiveCaption);
		pPrincipal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pPrincipal.setBounds(0, 26, 61, 672);
		contentPane.add(pPrincipal);
		pPrincipal.setLayout(null);
		
		JButton btnAlunos = new JButton("");
		btnAlunos.setBounds(12, 99, 38, 38);
		pPrincipal.add(btnAlunos);
		
		JButton btnProfessor = new JButton("");
		btnProfessor.setBounds(12, 150, 38, 38);
		pPrincipal.add(btnProfessor);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1021, 26);
		contentPane.add(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mniAlunos = new JMenuItem("Alunos");
		mniAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadAlunos();
			}
		});
		mniAlunos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCadastros.add(mniAlunos);
		
		JMenuItem mniProfessores = new JMenuItem("Professores");
		mniProfessores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnCadastros.add(mniProfessores);
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);
		
		JMenu mnEncerrarSistema = new JMenu("Encerrar Sistema");
		menuBar.add(mnEncerrarSistema);
		
		JMenuItem mniSair = new JMenuItem("Sair");
		mniSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sair();
			}
		});
		mniSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEncerrarSistema.add(mniSair);
		
		dpPrincipal = new JDesktopPane();
		dpPrincipal.setBounds(60, 26, 961, 672);
		contentPane.add(dpPrincipal);
		setExtendedState(MAXIMIZED_BOTH);
	}
	public void Sair() {
		System.exit(0);
	}
	public void CadAlunos() {
		frmAlunos frmalunos = new frmAlunos();
		dpPrincipal.add(frmalunos);
		frmalunos.setVisible(true);
	}
}
