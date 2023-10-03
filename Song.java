// Song.java by Donato Zampini SB ID 114849209
import java.lang.Integer;

public class Song implements Comparable<Song>{
	private String songName, artistName, duration;
	public Song() { }
	public Song(String songName, String artistName, String duration) {
		this.songName = songName; this.artistName = artistName;
		this.duration = duration;
	}
	public String getSongName() { return songName; }
	public String getArtistName() { return artistName; }
	public String getDuration() { return duration; }
	public int getMins() {
		String s = duration.substring(0,duration.indexOf(":"));
		return Integer.parseInt(s);
	}
	public int getSecs() {
		String s = duration.substring(duration.indexOf(":")+1);
		return Integer.parseInt(s);
	}
	public int compareTo(Song o) {
		if(songName.compareTo(((Song)o).getSongName()) < 0)
			return -1;
		else if(songName.compareTo(((Song)o).getSongName()) > 0)
			return 1;
		else {
			if(artistName.compareTo(((Song)o).getArtistName()) < 0)
				return -1;
			else if(artistName.compareTo(((Song)o).getArtistName()) > 0)
				return 1;
			else
				return 0;
		}
	}
	public boolean equals(Object o) {
		Song maybe = (Song)o;
		if(o instanceof Song)
			return ((songName).equals(maybe.getSongName())&&
					(artistName).equals(maybe.getArtistName())&&
					(duration).equals(maybe.getDuration()));
		else
			return false;
	}
	public String toString() {
		return songName+" by "+artistName+" ("+duration+")";
	}
}
