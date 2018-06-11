
public abstract class Usuario {
	private String login;
	private String senha;
	private String email;
	private String tipo;
	
	public Usuario(String l, String s, String e, String t) {
		this.login = l;
		this.tipo = t;
		this.senha = s;
		this.email = e;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha_) {
		this.senha = senha_;
	}
	
	public void setLogin(String login_) {
		this.login = login_;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
