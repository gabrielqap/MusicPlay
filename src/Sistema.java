
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Sistema {
	public LinkedList<Usuario> listaUsuarios;
	public LinkedList<Musica> musicas;
	public LinkedList<PlayList> playlist;
	//FileReader User;
	BufferedReader Users;
	BufferedReader playlists;
	BufferedWriter Escrita;
	FileWriter writer;
	PrintWriter escrever;
	
	/**
	 * Construtor do sistema MusicPlayer.
	 */
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		musicas = new LinkedList<Musica>();
		playlist = new LinkedList<PlayList>();
		LerArquivos();
	}
	
	/**
	 * Funcao que remove uma playlist do sistema.
	 * @param play_ playlist a ser removida.
	 */
	public void RemovePlaylist(PlayList play_) {
		playlist.remove(play_);
	}
	
	/**
	 * Funcao que procura um usuario pelo login no sistema
	 * @param login_ login do usuario a ser procurado
	 * @return true se login estiver no sistema, false se o login nao estiver no sistema.
	 */
	public boolean ProcuraUsuario(String login_) {
		for(Usuario x : listaUsuarios) {
			if (x.getLogin() == login_) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *  Funcao que verifica o tipo de usuario.
	 * @param login do usuario,
	 * @param senha do usuario.
	 * @return tipo do usuario.
	 */
	public String VerificaUsuario(String login, String senha) {
			
		for (Usuario x : listaUsuarios) {
			if(x.getLogin().equals(login)) {
				if(x.getSenha().equals(senha)) {
					if(x instanceof UsuarioComum) {
						return "Comum";
					}
					else if (x instanceof UsuarioVip){
						return "Vip";
					}
				}
				else {
					//throw new Exception("Senha incorreta!");
					return "Senha incorreta";
				}
			}
		}
		return "Login nao econtrado";
	}
	
	/*
	 *  Funcao que adiciona o usuario no sistema.
	 */
	public void addUsuario(String login_, String senha_, String email_, String tipo) {
		try {
			Usuario x;
			if(ProcuraUsuario(login_)) {
				throw new Exception("Usuario jÃ¡ existente!");
			}
			else {
				if(tipo.equals("Vip")) {
					x = new UsuarioVip (login_, senha_ ,email_, tipo);
				} 
				else {
					x = new UsuarioComum(login_, senha_ , email_, tipo);
				}
				listaUsuarios.add(x);
			}
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Funcao que adiciona uma musica no sistema.
	 * @param artista 
	 * @param nome
	 * @param diretorio onde a musica esta localizada.
	 */
	public void addMusica(String artista, String nome, String diretorio) {
		Musica x = new Musica(artista, nome, diretorio);
		musicas.add(x);
	}
	/**
	 * funcao que adiciona uma playlist ao sistema.
	 * @param A playlist a ser adicionada.
	 */
	public void addPlayList(PlayList A) {
		playlist.add(A);
	}
	/**
	 * Funcao que adiciona uma musica na playlist
	 * @param nome
	 */
	public void addMusicaPlayList(String nome) {
		for (PlayList x : playlist) {
			if(x.getNome().equals(nome)) {
				//implementar a adiÃ§Ã£o da musica
			}
		}
		
	}
	/**
	 * Funcao que carrega os dados quando o sistema é iniciado.
	 */
	public void LerArquivos(){
				// Ler usuários
		try {
			//Users = new BufferedReader(new FileReader("/home/talles/bti/lp2/MusicPlay/arquivos/Usuarios.txt"));
			Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt"));			
			//Users = new BufferedReader(new FileReader("/home/gabriel/area de Trabalho/MusicPlay/arquivos/Usuarios.txt"));			
			String line = Users.readLine();
			String[] dados; 
			while (line != null) {
				dados = line.split(":");
				addUsuario(dados[0], dados[1], dados[2], dados[3]);
				line = Users.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} finally {
			try {
				if (Users != null) {
					Users.close();
				}
			} catch (IOException e) {
				
			}
		}
		try {
				// Ler músicas
			//Users = new BufferedReader(new FileReader("/home/talles/bti/lp2/MusicPlay/arquivos/musicas.txt"));
			Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/musicas.txt"));
			//Users = new BufferedReader(new FileReader("/home/gabriel/area de Trabalho/MusicPlay/arquivos/musicas.txt"));
			if (Users != null) {
				String line = Users.readLine();
				String[] dados; 
				while (line != null) {
					dados = line.split(":");
					addMusica(dados[1], dados[0], dados[2]);
					line = Users.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} finally {
			try {
				if (Users != null) {
					Users.close();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		try {
				// LER PLAYLISTS
			
			//File f = new File("/home/talles/bti/lp2/MusicPlay/arquivos/");
				//File f = new File("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos");
				//String caminho = "/home/gabriel/area de Trabalho/MusicPlay/playlists";
				String caminho = "/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/playlists";
				File f = new File(caminho);
				String[] StringDir = f.list();
				String[] dados;
				for (String j : StringDir) {
					playlists = new BufferedReader(new FileReader(caminho + "/" + j));
					String line = playlists.readLine();
					String[] partes = null;
					partes  = j.split("\\.");
					System.out.println(partes[0]);
					
					PlayList nova = new PlayList(partes[0]);
					while (line != null) {
						dados = line.split(":");
						Musica MusicaNova = new Musica(dados[1], dados[0], dados[2]);
						nova.addMusica(MusicaNova);
						line = playlists.readLine();
						
					}
					addPlayList(nova);
				}
			
				
			
		
		}catch (FileNotFoundException e) {
			System.out.println("Erro na leitura da playlist!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} finally { 			
			
		}
	}
	/**
	 * Funcao que guarda os dados quando o sistema é finalizado.
	 */
	public void SalvarArquivos() {
		try {
			//writer = new FileWriter("/home/talles/bti/lp2/MusicPlay/arquivos/Usuarios.txt");
			writer = new FileWriter("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt", false);
			//writer = new FileWriter("/home/gabriel/area de Trabalho/MusicPlay/arquivos/Usuarios.txt", false);
			escrever = new PrintWriter(writer);
			for (Usuario B : listaUsuarios) {
				writer.write(B.getLogin() + ":" + B.getSenha() + ":" + B.getEmail() + ":" + B.getTipo());
				writer.write(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
				System.out.println("Erro na abertura do arquivo!\n");
				e.printStackTrace();
		} catch (IOException e) {
				System.out.println("Erro na abertura do arquivo!\n");
				e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		try {
			//writer = new FileWriter("/home/talles/bti/lp2/MusicPlay/arquivos/musicas.txt");
			writer = new FileWriter("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/musicas.txt");
			//writer = new FileWriter("/home/gabriel/area de Trabalho/MusicPlay/arquivos/musicas.txt", false);
			escrever = new PrintWriter(writer);
			for (Musica B : musicas) {
				writer.write(B.getArtista() + ":" + B.getNome()  + ":" + B.getLocalizacao());
				writer.write(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro na abertura do arquivooo!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivoooo!\n");
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		try {
			//File f = new File("/home/talles/bti/lp2/MusicPlay/arquivos/");
			//	File f = new File("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos");
				//String caminho = "/home/gabriel/area de Trabalho/MusicPlay/playlists";
				String caminho = "/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/playlists";
				File f = new File(caminho);
				String[] StringDir = f.list();
				for(String j : StringDir) {
					writer = new FileWriter(caminho + "/" + j, false);
					escrever = new PrintWriter(writer);
					String[] partes = j.split("\\.");
					String nome_playlist = partes[0];
					for(PlayList pl : playlist) {
						System.out.println(pl.getNome() + "\n");
						if(pl.getNome().equals(nome_playlist)) {
							for(Musica a : pl.musicas) {
								writer.write(a.getArtista() + ":" + a.getNome() + ":" + a.getLocalizacao());
								writer.write(System.lineSeparator());
							}
						}	
					}
				}
		} catch (FileNotFoundException e) {
			System.out.println("Erro na abertura do arquivooo!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivoooo!\n");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Erro na abertura do arquivooo!\n");
			e.printStackTrace();
		}finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				
			}
		}
	}
}

