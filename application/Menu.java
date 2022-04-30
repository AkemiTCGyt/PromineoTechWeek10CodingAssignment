package application;
	
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SongDao;
import entity.Song;

public class Menu {
		
	private SongDao songDao = new SongDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Show all Songs",
			"Display a Song",
			"Create Song",
			"Delete Song",
			"Update Song");
		
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
				
			try {
				if (selection.equals("1")) { //Displays all of the songs in the table
					displaySongs();
				} else if (selection.equals("2")) { //Displays a song given that you input the song id
					displaySong();
				} else if (selection.equals("3")) { //Creates a new song
					createSong();
				} else if (selection.equals("4")) { //Deletes a song
					deleteSong();
				} else if (selection.equals("5")) { //Updates a song
					updateSong();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to continue...\n");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
		
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
		
		
		
	private void displaySongs() throws SQLException {
		List<Song> songs = songDao.getSongs();
		for (Song song : songs) {
			System.out.println(song.getId() + ": " + song.getSongName());
		}
	}
		
	private void displaySong() throws SQLException {
		System.out.print("Enter song id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Song song = songDao.getSongById(id);
		System.out.println(song.getId() + ": " + song.getSongName());
	}
		
	private void createSong() throws SQLException {
		System.out.println("Enter new song name: ");
		String songName = scanner.nextLine();
		songDao.createNewSong(songName);
		System.out.println(songName + " has been created.");
	}
	
	public void deleteSong() throws SQLException {
		System.out.println("Enter song id you would like to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		songDao.deleteSongById(id);
		System.out.println("Song at id: " + id + " has been deleted.");
	}
	
	public void updateSong() throws SQLException {
		System.out.println("Enter song id you would like to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the song name you would like to use: ");
		String name = scanner.next();
		songDao.updateSongById(id, name);
		System.out.println("Song at id: " + id + " has been successfully updated!");
	}

}
