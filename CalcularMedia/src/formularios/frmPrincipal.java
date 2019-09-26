package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;

	JDesktopPane dpPrincipal = null;
	
	public frmPrincipal() {
		setTitle("Calcular M\u00E9dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 645, 21);
		contentPane.add(menuBar);
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);
		
		JMenuItem mniCalcularMdia = new JMenuItem("Calcular M\u00E9dia");
		mniCalcularMdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadCalcularMedia();
			}
		});
		mnFerramentas.add(mniCalcularMdia);
		
		dpPrincipal = new JDesktopPane();
		dpPrincipal.setBounds(0, 0, 645, 643);
		contentPane.add(dpPrincipal);
	}
	public void CadCalcularMedia(){
		frmCalcularMedia frmcalcularmedia = new frmCalcularMedia();
		dpPrincipal.add(frmcalcularmedia);
		frmcalcularmedia.setVisible(true);
	}
}
