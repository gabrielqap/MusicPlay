
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sistema {
	public LinkedList<Usuario> listaUsuarios;
	public LinkedList<Musica> musicas;
	public LinkedList<PlayList> playlist;
	//FileReader User;
	BufferedReader Users;
	BufferedWriter Escrita;
	FileWriter writer;
	
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
				throw new Exception("Usuario já existente!");
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
				//implementar a adição da musica
			}
		}
		
	}
	
	public void LerArquivos(){
		try {
			Users = new BufferedReader(new FileReader("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt"));
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
			String line = Users.readLine();
			String[] dados; 
			while (line != null) {
				dados = line.split(":");
				addMusica(dados[1], dados[0], dados[2]);
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
	}
	
	public void SalvarArquivos() {
		try {
			writer = new FileWriter(new File("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/Usuarios.txt"), true);
			Escrita = new BufferedWriter(writer);
			for (Usuario B : listaUsuarios) {
				Escrita.write(B.getLogin() + ":" + B.getSenha() + ":" + B.getEmail() + ":" + B.getTipo());
			}
		}
			catch (FileNotFoundException e) {
				System.out.println("Erro na abertura do arquivo!\n");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Erro na abertura do arquivo!\n");
				e.printStackTrace();
		}
		
		try {
			writer = new FileWriter(new File("/Users/Talle/Desktop/bti/6/lp2/MusicPlayer/arquivos/musicas.txt"), true);
			Escrita = new BufferedWriter(writer);
			for (Musica B : musicas) {
				Escrita.write(B.getArtista() + ":" + B.getNome()  + ":" + B.getLocalizacao());
			}
		}
			catch (FileNotFoundException e) {
				System.out.println("Erro na abertura do arquivooo!\n");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Erro na abertura do arquivoooo!\n");
				e.printStackTrace();
		}
	}
}

