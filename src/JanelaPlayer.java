import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class JanelaPlayer extends JFrame {
	private JanelaCadastro cadastro;
	private JPanel contentPane;
	private Player player;
	String tipo_;
	public void Erro() {
			JOptionPane.showMessageDialog(rootPane, "Você não possui acesso!", "Erro!", JOptionPane.ERROR_MESSAGE, null);
	}

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
	public JanelaPlayer(Sistema sistema, String tipo) {
		cadastro = new JanelaCadastro(sistema);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		DefaultListModel<String> listMusicaPL = new DefaultListModel<String>();
		DefaultListModel<String> listPlaylists = new DefaultListModel<String>();
		
			
		
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
				if(tipo.equals("Comum")) {
					Erro();
				}
				else {
					cadastro.setVisible(true);
				}
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
					//System.out.print(musica);
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
		for(PlayList pl : sistema.playlist) {
			listPlaylists.addElement(pl.getNome());
		}
	
		JList list_2 = new JList(listPlaylists);
		list_2.setBounds(989, 354, 181, 170);
		contentPane.add(list_2);
		
		//BOTAO PRA ADICONAR PLAYLIST
		JButton btnNovaPlaylist = new JButton("Nova Playlist");
		btnNovaPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo.equals("Comum")) {
					Erro();
				}
				//implementar add playlist
			}
		});
		btnNovaPlaylist.setBounds(989, 591, 165, 25);
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
		
		//ADICIONA MUSICA NA PLAYLIST SELECIONADA
		JButton btnAdicionarNaPlaylist = new JButton("Adicionar na playlist");
		btnAdicionarNaPlaylist.setBounds(367, 203, 181, 25);
		contentPane.add(btnAdicionarNaPlaylist);
		btnAdicionarNaPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo.equals("Comum")) {
					Erro();
				}
				//implementar add playlist
				//System.out.println(list_1.getSelectedValue());
				else {
					listMusicaPL.addElement(list_1.getSelectedValue());
					for (Musica m : sistema.musicas) {
						if(m.info().equals((String) list_1.getSelectedValue())) {
							for(PlayList pl : sistema.playlist) {
								if(pl.getNome().equals(lblPlaylistX.getText())) {
									pl.addMusica(m);
								}
							}
						}
					}	
				}
			}
		});
		JList<String> list2 = new JList<String>(listMusicaPL);
		list2.setBounds(588, 180, 196, 224);
		contentPane.add(list2);
		
		//SELECIONA PLAYLIST
		JButton btnSelecionarPlaylist = new JButton("Selecionar Playlist");
		btnSelecionarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipo.equals("Comum")) {
					Erro();
				}
				else {
					lblPlaylistX.setText((String) list_2.getSelectedValue());
					listMusicaPL.clear();
					for(PlayList pl : sistema.playlist) {
						if(pl.getNome().equals(lblPlaylistX.getText())) {
							for(Musica m : pl.musicas) {
								//pl.addMusica(m);
								listMusicaPL.addElement(m.info());
							
							}
						}
						list2.setModel(listMusicaPL);
					}	
				}
			}
		});
		btnSelecionarPlaylist.setBounds(989, 543, 165, 23);
		contentPane.add(btnSelecionarPlaylist);
		
		JButton RemoverDaPlaylist = new JButton("Remover da playlist");
		RemoverDaPlaylist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tipo.equals("Comum")) {
					Erro();
				}
				else {
					String Music = ((String) list2.getSelectedValue());
					listMusicaPL.removeElement(Music);;
					for(PlayList pl : sistema.playlist) {
						if(pl.getNome().equals(lblPlaylistX.getText())) {									
							for(Musica M : pl.musicas) {							
								if(M.info().equals(Music)) {													
									pl.RemoveMusica(M);
								}
							}
						}
					}
					/*for (Musica m : sistema.musicas) {
						if(m.info().equals(Music)) {
							for(PlayList pl : sistema.playlist) {
								if(pl.getNome().equals(lblPlaylistX.getText())) {									
									for(Musica M : pl.musicas) {
										System.out.println(M.info()  + " e " + list2.getSelectedValue());
										if(M.info().equals(list2.getSelectedValue())) {											
											System.out.println("removeu: " + M.info());
											pl.RemoveMusica(M);
										}
									}
								}
							}
						}
					}*/	
					list2.setModel(listMusicaPL);
					
				}
				
				
			}
		});
		RemoverDaPlaylist.setBounds(588, 441, 193, 25);
		contentPane.add(RemoverDaPlaylist);
		
		JButton btnNewButton = new JButton("Remover Playlist");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo.equals("Comum")) {
					Erro();
				}
				else {
					String playlistRemov = (String) list_2.getSelectedValue();
					for(PlayList pl : sistema.playlist) {
						if(pl.getNome().equals(playlistRemov)){
							sistema.playlist.remove(pl);
							System.out.println(list_2.getSelectedIndex());
							listPlaylists.removeElement(list_2.getSelectedValue());
						}
					}
				}
			}
		});
		btnNewButton.setBounds(989, 628, 165, 25);
		contentPane.add(btnNewButton);
		
		JButton btnTocarMusica = new JButton("Tocar musica");
		btnTocarMusica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try{
				String musica = list_1.getSelectedValue();	
				Musica m = null;
				for(Musica x : sistema.musicas) {
					if(x.info().equals(musica)) {
						//m = new Musica(x.getNome(), x.getArtista(), x.getLocalizacao());
						m.setNome(x.getNome());
						m.setArtista(x.getArtista());
						m.setLocalizacao(x.getLocalizacao());
					}
				}
				System.out.println(m.getLocalizacao());
	            FileInputStream stream = new FileInputStream(m.getLocalizacao());
	            BufferedInputStream buffer = new BufferedInputStream(stream);
	            player = new Player (buffer);
	            System.out.println("Executando...");
	           // this.player.play();
	            System.out.println("Terminado");
	        } catch (Exception error) {
	            System.out.println("Erro!");
	            error.printStackTrace();
	        }
			}
		});
		btnTocarMusica.setBounds(367, 351, 181, 23);
		contentPane.add(btnTocarMusica);
		
	}
}
