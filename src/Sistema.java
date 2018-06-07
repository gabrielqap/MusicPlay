import java.util.LinkedList;

public class Sistema {
	private LinkedList<Usuario> listaUsuarios;
	
	
	public Sistema() {
		listaUsuarios = new LinkedList<Usuario>();
		UsuarioVip admin = new UsuarioVip("admin", "senha");
		addUsuario(admin);
	}
	
	public void addUsuario(Usuario u) s{
		try {
			for (Usuario x : listaUsuarios) {
				if(x.getLogin().equals(u.getLogin())) {
					throw new Exception("Ja existe esse login")
				}
			}
			listaUsuarios.add(u);
			
		}
	}
}
