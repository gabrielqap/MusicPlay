import java.util.LinkedList;

public class PlayList {
	private String nome;
	public LinkedList<Musica> musicas;
	
	
	public PlayList(String n) {
		nome = n;
		musicas = new LinkedList<Musica>();
	}
	
	public void addMusica(Musica m) {
		musicas.add(m);
	}
	
	public void RemoveMusica(Musica m) {
		musicas.remove(m);
	}
	
	public String getNome() {
		return nome;
	}
}
