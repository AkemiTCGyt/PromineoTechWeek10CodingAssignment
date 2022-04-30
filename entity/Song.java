package entity;

public class Song {

	private int id;
	private String songname;
		
	public Song(int id, String songname) {
		this.setId(id);
		this.setSongName(songname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songname;
	}

	public void setSongName(String songname) {
		this.songname = songname;
	}

}
