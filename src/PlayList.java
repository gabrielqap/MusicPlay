import java.util.LinkedList;

public class PlayList {
	private String nome;
	private LinkedList<Musica> musicas;
	
	
	public PlayList(String n) {
		nome = n;
		musicas = new LinkedList<Musica>();
	}
	
	public void addMusica(Musica m) {
		musicas.add(m);
	}
	
	public String getNome() {
		return nome;
	}
}
