
public abstract class Usuario {
	private String login;
	private String senha;
	private String email;
	private String tipo;
	
	/**
	 * Construtor da classe
	 * @param l login 
	 * @param s senha
	 * @param e email
	 * @param t tipo de usuario
	 */
	public Usuario(String l, String s, String e, String t) {
		this.login = l;
		this.tipo = t;
		this.senha = s;
		this.email = e;
	}
	/**
	 * Get login
	 * @return login do usuario.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Get senha
	 * @return senha do usuario.
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Set senha
	 * @param senha_ senha do usuario
	 */
	public void setSenha(String senha_) {
		this.senha = senha_;
	}
	/**
	 * Set login
	 * @param login_ login do usuario
	 */
	public void setLogin(String login_) {
		this.login = login_;
	}
	/**
	 * Get email
	 * @return email do usuario.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Set email.
	 * @param email do usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Get tipo do usuario
	 * @return tipo do usuario.
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Set tipo do usuario
	 * @param tipo do usuario.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
