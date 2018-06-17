import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.DefaultListModel;
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
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.JTextPane;

public class JanelaPlayer extends JFrame {
	private JanelaCadastro cadastro;
	private JPanel contentPane;
	private Player player;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public JanelaPlayer(Sistema sistema) {
		cadastro = new JanelaCadastro();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		/*try{
            FileInputStream stream = new FileInputStream("");
            BufferedInputStream buffer = new BufferedInputStream(stream);
            this.player = new Player (buffer);
            System.out.println("Executando...");
           // this.player.play();
            System.out.println("Terminado");
        } catch (Exception e) {
            System.out.println("Erro!");
            e.printStackTrace();
        }*/
    	
		
		this.setTitle("Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		//BOTAO CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(1048, 53, 126, 25);
		contentPane.add(btnCadastrar);
		
		//BOTAO ADICIONAR MUSICA
		JButton btnAdicionarMusica = new JButton("Adicionar Musica");
		btnAdicionarMusica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				
				String musica = f.getName();
				String dados[] = musica.split("-");
				listModel.addElement(dados[0] + "-" + dados[1]);
				sistema.addMusica(dados[0], dados[1], f.getPath());
				System.out.print(musica);
			}	
		});
		btnAdicionarMusica.setBounds(100, 441, 196, 25);
		contentPane.add(btnAdicionarMusica);
		
		//LISTA DE MUSICAS
		for(Musica a : sistema.musicas) {
			listModel.addElement(a.info());
		}
		JList<String> list_1 = new JList<String>(listModel);
		list_1.setBounds(100, 180, 196, 224);
		contentPane.add(list_1);
		
		//LISTA DE PLAYLISTS
		JList list_2 = new JList();
		list_2.setBounds(989, 354, 181, 170);
		contentPane.add(list_2);
		
		//BOTAO PRA ADICONAR PLAYLIST
		JButton btnNovaPlaylist = new JButton("Nova Playlist");
		btnNovaPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//implementar add playlist
			}
		});
		btnNovaPlaylist.setBounds(1022, 548, 117, 25);
		contentPane.add(btnNovaPlaylist);
		
		//LABEL DAS PLAYLISTS
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(1048, 299, 70, 15);
		contentPane.add(lblPlaylists);
		
	}
	
}
