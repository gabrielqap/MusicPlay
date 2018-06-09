
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Sistema {
	private LinkedList<Usuario> listaUsuarios;
	//FileReader User;
	BufferedReader Users;
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		//addUsuario("admim", "senha", "Vip");
		
		//LerArquivos();
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
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
	
	public void addUsuario(String login_, String senha_, String tipo) {
		try {
			Usuario x;
			if(ProcuraUsuario(login_)) {
				throw new Exception("Usuario já existente!");
			}
			else {
				if(tipo == "Vip") {
					x = new UsuarioVip (login_, senha_);
				}
				else {
					x = new UsuarioComum(login_, senha_);
				}
				listaUsuarios.add(x);
			}
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void LerArquivos(){
		try {
			Users = new BufferedReader(new FileReader("/home/gabriel/Área de Trabalho/MusicPlay/arquivos/Usuarios.txt"));
			String line = Users.readLine();
			String[] dados; 
			while (line != null) {
				dados = line.split(":");
				addUsuario(dados[0], dados[1], dados[2]);
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
}

