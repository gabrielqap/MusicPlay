import java.awt.Component;

public class Musica {
		private String Nome;
		private String artista;
		private String Localizacao;
		
		/**
		 * Construtor da classe.
		 * @param a nome do artista
		 * @param n nome da musica
		 * @param l diretorio da musica
		 */
		public Musica(String a, String n, String l) {
			Nome = n;
			artista = a;
			Localizacao = l;
		}
		
		/**
		 * Get nome
		 * @return nome da musica.
		 */
		public String getNome() {
			return Nome;
		}
		/**
		 * Set nome
		 * @param Nome_ nome da musica.
		 */
		public void setNome(String Nome_) {
			Nome = Nome_;
		}
		/**
		 * Get localizacao
		 * @return diretorio da musica
		 */
		public String getLocalizacao() {
			return Localizacao;
		}
		/**
		 * Set localizacao
		 * @param localizacao diretorio a ser mudado.
		 */
		public void setLocalizacao(String localizacao) {
			Localizacao = localizacao;
		}
		/**
		 * Get artista
		 * @return nome do artista;
		 */
		public String getArtista() {
			return artista;
		}
		/**
		 * Set artista
		 * @param artista nome do artista a ser mudado.
		 */
		public void setArtista(String artista) {
			this.artista = artista;
		}
		/**
		 * Metodo que retorna as informaçoes da musica.
		 * @return nome do artista e nome da musica.
		 */
		public String info() {
			return getArtista() + " - " + getNome(); 
		}
		
}
