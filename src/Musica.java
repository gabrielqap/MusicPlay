import java.awt.Component;

public class Musica {
		private String Nome;
		private String artista;
		private String Localizacao;
		
		public Musica(String n, String a, String l) {
			Nome = n;
			artista = a;
			Localizacao = l;
		}
		
		public String getNome() {
			return Nome;
		}

		public void setNome(String Nome_) {
			Nome = Nome_;
		}

		public String getLocalizacao() {
			return Localizacao;
		}

		public void setLocalizacao(String localizacao) {
			Localizacao = localizacao;
		}
		
		public String getArtista() {
			return artista;
		}
		
		public void setArtista(String artista) {
			this.artista = artista;
		}
		
		public String info() {
			return getArtista() + " - " + getNome(); 
		}
		
}
