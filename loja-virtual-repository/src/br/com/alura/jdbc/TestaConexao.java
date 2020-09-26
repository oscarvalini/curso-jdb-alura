package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.getConnection();
		con.close();

	}

}
