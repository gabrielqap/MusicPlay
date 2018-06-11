import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;

public class JanelaPlayer extends JFrame {
	private JanelaCadastro cadastro;
	private JPanel contentPane;
	
	
	private Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPlayer frame = new JanelaPlayer();
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
	public JanelaPlayer() {
		cadastro = new JanelaCadastro();
		
		try{
            FileInputStream stream = new FileInputStream("/home/gabriel/Área de Trabalho/MusicPlay/musicas/Bom-dia, Família (Parte 1) - Bom-dia, Família!.mp3");
            BufferedInputStream buffer = new BufferedInputStream(stream);
            this.player = new Player (buffer);
            System.out.println("Executando...");
           // this.player.play();
            System.out.println("Terminado");
        } catch (Exception e) {
            System.out.println("Erro!");
            e.printStackTrace();
        }
    	
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMusicPlayer = new JLabel("Music Player");
		lblMusicPlayer.setBackground(Color.BLACK);
		lblMusicPlayer.setForeground(Color.RED);
		lblMusicPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicPlayer.setBounds(29, 12, 358, 159);
		contentPane.add(lblMusicPlayer);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(91, 156, 126, 25);
		contentPane.add(btnCadastrar);
	
		
	}
}
