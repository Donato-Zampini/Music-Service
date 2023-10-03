// Playlist.java by Donato Zampini SB ID 114849209
import java.util.ArrayList;

public class Playlist {
	private String title;
	private ArrayList<Song> list = new ArrayList<Song>();
	public Playlist() { }
	public Playlist(String title) { this.title = title; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public void addSong(Song song) {
		if(!list.contains(song))
			list.add(song);
	}
	public boolean removeSong(String songName) {
		for(Song s: list)
			if(s.getSongName().equals(songName)) {
				list.remove(s);
				return true;
			}
		return false;
	}
	public void swapSongs(Song song1, Song song2) {
		if(list.contains(song1) && list.contains(song2)) {
			int s1 = list.indexOf(song1); int s2 = list.indexOf(song2);
			list.set(s1, song2);
			list.set(s2, song1);
		}
	}
	public String totalDuration() {
		int mins = 0; int secs = 0;
		for(Song s: list) {
			mins += s.getMins();
			secs += s.getSecs();
		}
		int leftover = secs/60;
		mins += leftover;
		secs -= (leftover*60);
		return mins+" min, "+secs+" sec";
	}
	public void sortSongs() {
		for(int i = list.size()-1; i > 0; i--)
			for(int x = list.size()-1; x > 0; x--)
				if(list.get(x).compareTo(list.get(x-1)) < 0) {
					Song temp = list.get(x);
					list.set(x, list.get(x-1));
					list.set(x-1, temp);
			}
	}
	public String toString() {
		String print = title+" - "+this.totalDuration();
		for(int i = 1; i <= list.size(); i++)
			print += "\n"+i+". "+list.get(i-1).toString();
		return print;
	}
}
