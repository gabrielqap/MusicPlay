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
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class JanelaCadastro extends JFrame{
	private JPasswordField pwdS;
	private JTextField textField;
	private JPasswordField pwdLkzjdlj;
	private JTextField textField_1;
	private static Sistema B;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		B = new Sistema();
		B.LerArquivos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
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
	
	public JanelaCadastro() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(22, 23, 70, 15);
		getContentPane().add(lblCadastro);
		
		pwdS = new JPasswordField();
		pwdS.setBounds(219, 76, 92, 30);
		getContentPane().add(pwdS);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(150, 42, 70, 15);
		getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(219, 34, 136, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(150, 83, 70, 15);
		getContentPane().add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(96, 163, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setBounds(80, 121, 117, 15);
		getContentPane().add(lblConfirmarSenha);
		
		pwdLkzjdlj = new JPasswordField();
		pwdLkzjdlj.setBounds(219, 118, 109, 30);
		getContentPane().add(pwdLkzjdlj);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 156, 202, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Vip");
		chckbxNewCheckBox.setBounds(156, 194, 129, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String usuario = textField.getText();
					String senha;
					if(pwdS.getPassword() == pwdLkzjdlj.getPassword()) {
						senha = pwdS.getText();
					}
					else {
						throw new Exception("Senhas diferentes");
					}
					String email = textField_1.getText();
					if(chckbxNewCheckBox.isSelected())
						B.addUsuario(usuario, senha, email, "Vip");
					else 
						B.addUsuario(usuario, senha, email, "Comum");
				}
				catch (Exception a) {
					System.out.println(a);
				}
			}
		});
		
		
		
		
		
		
		
		btnCadastrar.setBounds(120, 227, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(249, 227, 117, 25);
		getContentPane().add(btnCancelar);
		
	}
}
