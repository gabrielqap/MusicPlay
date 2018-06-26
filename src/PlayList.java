import java.util.LinkedList;

public class PlayList {
	private String nome;
	public LinkedList<Musica> musicas;
	
	/**
	 * Construtor da classe.
	 * @param n nome da playlist.
	 */
	public PlayList(String n) {
		nome = n;
		musicas = new LinkedList<Musica>();
	}
	/**
	 * Metodo que adiciona uma musica na playlist.
	 * @param m musica a ser adicionada.
	 */
	public void addMusica(Musica m) {
		musicas.add(m);
	}
	/**
	 * Metodo que remove uma musica na playlist.
	 * @param m musica a ser removida.
	 */
	public void RemoveMusica(Musica m) {
		if(musicas.contains(m)) {
			musicas.remove(m);
		}
	}
	/**
	 * Get nome
	 * @return nome da playlist.
	 */
	public String getNome() {
		return nome;
	}
}
