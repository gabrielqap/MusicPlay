
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Sistema {
	private LinkedList<Usuario> listaUsuarios;
	//FileReader User;
	BufferedReader Users;
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		LerArquivos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Usuario ProcuraUsuario(String login_) {
		for(Usuario x : listaUsuarios) {
			if (x.getLogin() == login_) {
				return x;
			}
		}
		return null;
	}
	
	
	@SuppressWarnings("finally")
	public String VerificaUsuario(String login, String senha) {
			try {
				Usuario x = ProcuraUsuario(login);
				if(x != null) {
					if(x.getSenha() == senha) {
						if(x instanceof UsuarioComum) {
							return "Comum";
						}
						else {
							return "Vip";
						}
					}
					else {
						throw new Exception("Senha incorreta!");
					}
				}
				else {
					throw new Exception("Login não encontrado!");
				}
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
			
			finally {
				return "";
			}
	}
	
	public void addUsuario(String login_, String senha_, String tipo) {
		try {
			Usuario x = ProcuraUsuario(login_);
			if(x != null) {
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
			Users = new BufferedReader(new FileReader("/arquivos/Usuarios.txt"));
			System.out.println("Aberto com sucesso!\n");
		}
		
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo!\n");
		}
	}
}

