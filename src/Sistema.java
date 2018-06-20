
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
	BufferedWriter Escrita;
	FileWriter writer;
	PrintWriter escrever;
	
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		musicas = new LinkedList<Musica>();
		playlist = new LinkedList<PlayList>();
		LerArquivos();
	}
	
	// mudei pra boleano, pq a antiga nao tava funcionando no VerificaUsuario	
	public boolean ProcuraUsuario(String login_) {
		for(Usuario x : listaUsuarios) {
			if (x.getLogin() == login_) {
				return true;
			}
		}
		return false;
	}
	
	
	//@SuppressWarnings("finally")
	//tirei o try pra dar uma modificada, acho que da pra colocar dps ainda
	public String VerificaUsuario(String login, String senha) {
			
		for (Usuario x : listaUsuarios) {
			if(x.getLogin().equals(login)) {
				if(x.getSenha().equals(senha)) {
					if(x instanceof UsuarioComum) {
						return "Comum";
					}
					else {
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
	
	public void addUsuario(String login_, String senha_, String email_, String tipo) {
		try {
			Usuario x;
			if(ProcuraUsuario(login_)) {
				throw new Exception("Usuario jÃ¡ existente!");
			}
			else {
				if(tipo == "Vip") {
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
	
	public void addMusica(String artista, String nome, String diretorio) {
		Musica x = new Musica(artista, nome, diretorio);
		musicas.add(x);
	}
	
	public void addPlayList(String nome) {
		PlayList pl = new PlayList(nome);
		playlist.add(pl);
	}
	
	public void addMusicaPlayList(String nome) {
		for (PlayList x : playlist) {
			if(x.getNome().equals(nome)) {
				//implementar a adiÃ§Ã£o da musica
			}
		}
		
	}
	
	public void LerArquivos(){
		try {
			Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt"));			
			//Users = new BufferedReader(new FileReader("/home/gabriel/Ã�rea de Trabalho/MusicPlay/arquivos/Usuarios.txt"));			
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
			Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/musicas.txt"));
			//Users = new BufferedReader(new FileReader("/home/gabriel/Ã�rea de Trabalho/MusicPlay/arquivos/musicas.txt"));
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
				
			}
		}
		try {
			File f = new File("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos");
			FilenameFilter textFilter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					String lowercaseName = name.toLowerCase();
					if (lowercaseName.endsWith(".txt")) {
						return true;
					} else {
						return false;
					}
				}
			}; 
			File[] files = f.listFiles(textFilter);
			String dados[];
			String nomePL;
			PlayList pl;
			Musica m;
			for (File file : files) {
				dados = file.getName().split("_");
				if(dados[0].equals("playlist")) {
					//System.out.println(file.getName());
					nomePL = dados[1].split("\\.")[0];
					System.out.println(nomePL);
					pl = new PlayList(nomePL);
					Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/playlist_" + playlist + ".txt"));
					//Users = new BufferedReader(new FileReader("/home/gabriel/Ã�rea de Trabalho/MusicPlay/arquivos/musicas.txt"));
					if (Users != null) {
						String line = Users.readLine();
						String[] dados_2; 
						while (line != null) {
							dados = line.split(":");
							m = new Musica(dados[1], dados[0], dados[2]);
							pl.addMusica(m);
							line = Users.readLine();
						}		
					}
					playlist.add(pl);	
				}
				
			}
		
		}catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!\n");
			e.printStackTrace();
		} finally { 			
			
		}
	}
	
	public void SalvarArquivos() {
		try {
			writer = new FileWriter("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt");
			//writer = new FileWriter("/home/gabriel/Ã�rea de Trabalho/MusicPlay/arquivos/Usuarios.txt");
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
			writer = new FileWriter("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/musicas.txt");
			//writer = new FileWriter("/home/gabriel/rea de Trabalho/MusicPlay/arquivos/musicas.txt");
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
	}
}

