# PromineoTechWeek10CodingAssignment

## Coded by Thomas Le

## Synopsis:
This is a menu driven application that implements the ddrsongs.sql file to
perform CRUD tasks (Create, Read, Update, Delete) while utilizing a
connection between Java and MySQL.

## Details of the ddrsongs database:
- Primary key id which is the songid for each song that is created. This is auto_incremented.
- songname which is the name of the song that is being referenced to.

## Details of the packages:

### application
- Application.java
	Creates a new instance of menu and uses the menu.start() method to run the code.
- Menu.java
	The physical menu in which the user can access the CRUD options.

### dao
- DBConnection.java
	Establishes a connection between java and the specified MySQL database which is in this case, ddrsongs.
- SongDao.java
	Contains the queries and methods that will actually be executed by the specified functions in menu.

### entity
- Song.java
	Identified the song object along with its getters and setters.
