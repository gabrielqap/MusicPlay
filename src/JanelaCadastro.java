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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	BufferedWriter Escrita;
	FileWriter writer;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/
	
	/**
	 * Funcao que apaga todos os campos do cadastro.
	 */
	public void ApagaTudo() {
		textField.setText(null);
		textField_1.setText(null);
		pwdS.setText(null);
		pwdLkzjdlj.setText(null);
		setVisible(false);
	}
	/**
	 * Create the frame.
	 * param sistema classe sistema.
	 */
	
	public JanelaCadastro(Sistema sistema) {
		//B = new Sistema();
		//B.LerArquivos();
		getContentPane().setLayout(null);
		setSize(450, 300);
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
		
		JLabel erro = new JLabel("");
		erro.setBounds(121, 225, 228, 30);
		getContentPane().add(erro);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Vip");
		chckbxNewCheckBox.setBounds(156, 194, 129, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxComum = new JCheckBox("Comum");
		chckbxComum.setBounds(289, 194, 129, 23);
		getContentPane().add(chckbxComum);
		
		
		chckbxComum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxComum.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
				}
				
			}
		});
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					chckbxComum.setSelected(false);
				}
				
			}
		});
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					String usuario = textField.getText();
					String senha1 = pwdS.getText();
					String senha2 = pwdLkzjdlj.getText();
					String tipo = "";
					if(senha1.equals(senha2)) {
							String email = textField_1.getText();
							if(chckbxNewCheckBox.isSelected()) {
								tipo = "Vip";
								sistema.addUsuario(usuario, senha1, email, tipo);
							}
							else { 
								tipo = "Comum";
								sistema.addUsuario(usuario, senha1, email, tipo);
							}
							/*try {
								writer = new FileWriter("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt", true);
								writer.write(usuario + ":" + senha1 + ":" + email + ":" + tipo);
								writer.close(); 
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} */
							ApagaTudo();
					}
					else {
							System.out.println(pwdS.getPassword());
							System.out.println(pwdLkzjdlj.getPassword());
							erro.setText("Senhas diferentes");
						}
			}
		});
		
		
		
		
		
		
		
		btnCadastrar.setBounds(96, 225, 101, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ApagaTudo();
				
			}
		});
		btnCancelar.setBounds(265, 225, 117, 25);
		getContentPane().add(btnCancelar);
		
		
		
		
	}
}
