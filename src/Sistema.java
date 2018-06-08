
import java.awt.EventQueue;

import java.util.*;

public class Sistema {
	private LinkedList<Usuario> listaUsuarios;
	
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		UsuarioVip admin = new UsuarioVip("admin", "senha");
		listaUsuarios.add(admin);
		
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
}

