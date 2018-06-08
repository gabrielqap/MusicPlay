import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JPasswordField;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Sistema A = new Sistema ();
		A.LerArquivos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(272, 26, 57, 41);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(272, 79, 147, 31);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JList list = new JList();
		list.setBounds(0, 0, 1, 1);
		contentPane.add(list);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(272, 142, 45, 15);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String l = textField.getText();
				String s = textField.getText();
				System.out.println(l);
				
			}
		});

		btnEntrar.setBounds(173, 228, 117, 25);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("Music Play");
		lblNewLabel.setBounds(51, 114, 105, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(308, 228, 117, 25);
		contentPane.add(btnCadastrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 169, 147, 31);
		contentPane.add(passwordField);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
