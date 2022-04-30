package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Song;

public class SongDao {
	
	private Connection connection;
	private final String GET_SONGS_QUERY = "SELECT * FROM ddrsongs";
	private final String GET_SONGS_BY_ID_QUERY = "SELECT * FROM ddrsongs WHERE id = ?";
	private final String CREATE_NEW_SONG_QUERY = "INSERT INTO ddrsongs(songname) VALUES(?)";
	private final String DELETE_SONGS_BY_ID_QUERY = "DELETE FROM ddrsongs WHERE id = ?";
	private final String UPDATE_SONGS_BY_ID_QUERY = "UPDATE ddrsongs SET songname = ? WHERE id = ?";
	
	public SongDao() {
		connection = DBConnection.getConnection(); //connect to the database when SongDao is instantiated
	}
	
	public List<Song> getSongs() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SONGS_QUERY).executeQuery();
		List<Song> songs = new ArrayList<Song>();
		
		while (rs.next()) {
			songs.add((populateSong(rs.getInt(1), rs.getString(2)))); //populate the List of songs
		}
		
		return songs;
	}
	
	private Song populateSong(int id, String name) { //returns Song object when it's populated
		return new Song(id, name);
	}

	public Song getSongById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SONGS_BY_ID_QUERY);
		ps.setInt(1,  id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSong(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewSong(String songName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SONG_QUERY);
		ps.setString(1, songName);
		ps.executeUpdate(); //to update data
	}
	
	public void deleteSongById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SONGS_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateSongById(int id, String songname) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_SONGS_BY_ID_QUERY);
		ps.setString(1, songname);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

}
