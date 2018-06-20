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
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.AbstractAction;
import javax.swing.Action;

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
		cadastro = new JanelaCadastro(sistema);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		DefaultListModel<String> listMusicaPL = new DefaultListModel<String>();
		DefaultListModel<String> listPlaylists = new DefaultListModel<String>();
		
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
		btnCadastrar.setBounds(989, 84, 126, 25);
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
				if(musica.charAt(musica.length()-1) != '3') {
					JOptionPane.showMessageDialog(new JFrame(), "O arquivo selecionado "
							+ "deve ser do tipo '.mp3'.", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String dados[] = musica.split("-");
					listModel.addElement(dados[0] + "-" + dados[1]);
					String a = f.getPath();
					sistema.addMusica(dados[0], dados[1], f.getPath());
					System.out.print(musica);
				}
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
		btnNovaPlaylist.setBounds(1027, 591, 117, 25);
		contentPane.add(btnNovaPlaylist);
		
		//LABEL DAS PLAYLISTS
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(1048, 299, 70, 15);
		contentPane.add(lblPlaylists);
			
		JLabel lblMsicas = new JLabel("Músicas");
		lblMsicas.setBounds(109, 125, 70, 15);
		contentPane.add(lblMsicas);
		
		JLabel lblPlaylistX = new JLabel("Playlist x");
		lblPlaylistX.setBounds(658, 139, 70, 15);
		contentPane.add(lblPlaylistX);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(279, 180, 17, 176);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(767, 180, 17, 48);
		contentPane.add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(1153, 354, 17, 48);
		contentPane.add(scrollBar_2);
		
		JButton btnAdicionarNaPlaylist = new JButton("Adicionar na playlist");
		btnAdicionarNaPlaylist.setBounds(367, 205, 147, 23);
		contentPane.add(btnAdicionarNaPlaylist);
		btnAdicionarNaPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//implementar add playlist
				//System.out.println(list_1.getSelectedValue());
				listMusicaPL.addElement(list_1.getSelectedValue());
			}
		});
		JList list = new JList(listMusicaPL);
		list.setBounds(588, 180, 196, 224);
		contentPane.add(list);
		
		JButton btnSelecionarPlaylist = new JButton("Selecionar Playlist");
		btnSelecionarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelecionarPlaylist.setBounds(1027, 543, 117, 23);
		contentPane.add(btnSelecionarPlaylist);
		
	}
	
}
