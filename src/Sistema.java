import java.awt.EventQueue;
import java.util.*;

public class Sistema {
	private LinkedList<Usuario> listaUsuarios;

	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		UsuarioVip admin = new UsuarioVip("admin", "senha");
		addUsuario(admin);
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

	public String procuraUsuario(String login, String senha) {
		for (Usuario x : listaUsuarios) {
			if(x instanceof UsuarioComum) {
				if (((UsuarioComum)x).getLogin().equals(login)){
					if(((UsuarioComum)x).getSenha() == senha){
						return "vip";
					}
					else {
						return "Senha errada";
					}
				}
				else if (((UsuarioVip)x).getLogin().equals(login)) {
					if(((UsuarioVip)x).getSenha().equals(senha)) {
						return "comum";
					}
					else {
						return "Senha errada";
					}
				}
				else {
					return "O login não existe";
				}
			}
		}
		return"";
	}
	
	public void addUsuario(Usuario u) {
		/*try {
			for (Usuario x : listaUsuarios) {
				if(x.getLogin().equals(u.getLogin())) {
					throw new Exception("Ja existe esse login")
				}
			}
			listaUsuarios.add(u);
			
		}*/
	}
}
