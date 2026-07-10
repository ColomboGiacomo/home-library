package backend.database;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import backend.entities.Author;

public class AuthorDao {
	private Connection connection;

	//ritorna tutta la tabella autori
	//la connessione si chiuderà nel main, così che la chiudo una volta alla fine di tutto. (non mi fa impazzire ma proviamo così)
	public ArrayList<Author> getAuthors() throws SQLException, IOException {
		final String query = "SELECT * FROM authors"; 
		ArrayList<Author> authorsList = new ArrayList<Author>();
		
		connection = DBConnect.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			authorsList.add(new Author(
					resultSet.getInt("author_id"),
					resultSet.getString("full_name"),
					resultSet.getDate("birth_date").toLocalDate(),
					resultSet.getString("nationality")
					));
		}
		
		return authorsList;
	}
	
	public void updateAuthor(int id, String fullName, LocalDate birthDate, String nationality ) throws SQLException, IOException {
		final String query = "UPDATE authors SET full_name = ?, birth_date = ?, nationality = ? WHERE author_id = ?";
		
		connection = DBConnect.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, fullName);
		statement.setObject(2, birthDate);
		statement.setString(3, nationality);
		statement.setInt(4, id);
		
		statement.executeUpdate();
	}
	
	public void insertAuthor(String fullName, LocalDate birthDate, String nationality) throws SQLException, IOException {
		final String query = "INSERT INTO authors (full_Name, birth_date, nationality) VALUES (?, ?, ?)";
		
		connection = DBConnect.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, fullName);
		statement.setObject(2, birthDate);
		statement.setString(3, nationality);
		
		statement.executeUpdate();
	}
	
	public void deleteAuthor(int id) throws SQLException, IOException {
		final String query = "DELETE FROM authors WHERE author_id = ?";
		
		connection = DBConnect.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, id);
		
		statement.executeUpdate();
	}
	
}
