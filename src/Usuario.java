
public abstract class Usuario {
	private String login;
	private String senha;
	
	public Usuario(String l, String s) {
		this.login = l;
		this.senha = s;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
}
