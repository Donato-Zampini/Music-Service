// User.java by Donato Zampini SB ID 114849209
import java.util.ArrayList;

public class User {
	private String username;
	private ArrayList<Playlist> list = new ArrayList<Playlist>();
	public User() { }
	public User(String username) { this.username = username; }
	public String getUsername() { return username; }
	public void addPlaylist(Playlist playlist) {
		if(!list.contains(playlist))
			list.add(playlist);
	}
	public boolean removePlaylist(String title) {
		for(Playlist p:list)
			if(p.getTitle().equals(title)) {
				list.remove(p);
				return true;
			}
		return false;
	}
	public ArrayList<Playlist> getAllPlaylists() { return list; }
	public Playlist getPlaylist(String title) {
		for(Playlist p: list)
			if(p.getTitle().equals(title))
				return p;
		return null;
	}
	public void makeCollaborativePlaylist(String playlistTitle, User friend) {
		friend.addPlaylist(this.getPlaylist(playlistTitle));
	}
	public boolean equals(Object o) {
		if(o instanceof User)
			if(((User)o).getUsername().equals(username))
				return true;
		return false;
	}
	public String toString() {
		String print = username+"'s playlists:";
		for(Playlist p: list)
			print += "\n"+p.getTitle();
		return print;
	}
}
