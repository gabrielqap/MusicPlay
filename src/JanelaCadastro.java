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

public class JanelaCadastro extends JFrame{
	private JPasswordField pwdS;
	private JTextField textField;
	private JPasswordField pwdLkzjdlj;
	private JTextField textField_1;
	public JanelaCadastro() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(22, 23, 70, 15);
		getContentPane().add(lblCadastro);
		
		pwdS = new JPasswordField();
		pwdS.setText("S");
		pwdS.setBounds(219, 76, 92, 30);
		getContentPane().add(pwdS);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(150, 42, 70, 15);
		getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(219, 35, 136, 30);
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
		pwdLkzjdlj.setText("lkzjdlj");
		pwdLkzjdlj.setBounds(219, 118, 109, 30);
		getContentPane().add(pwdLkzjdlj);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 156, 202, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 212, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(249, 212, 117, 25);
		getContentPane().add(btnCancelar);
	}
}
