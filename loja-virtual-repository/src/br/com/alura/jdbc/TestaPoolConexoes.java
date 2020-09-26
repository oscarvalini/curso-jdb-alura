package br.com.alura.jdbc;
import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
			
		ConnectionFactory factory = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			factory.getConnection();
			System.out.println("Conexão de número " + i);
		}
		
	}

}
