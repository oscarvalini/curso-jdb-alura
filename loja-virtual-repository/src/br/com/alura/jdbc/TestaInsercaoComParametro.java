package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection con = factory.getConnection();) {
			con.setAutoCommit(false);
				
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";
			try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				adicionarVariavel("Smart Tv", "45 Polegadas", stm);
				adicionarVariavel("Radio", "Radio de Bateria", stm);
				adicionarVariavel("Notebook", "Notebook Acer", stm);
			
				con.commit();
			
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Executando ROLLBACK");
				con.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		/*if(nome.equals("Notebook")) {
			throw new RuntimeException("Não foi possível adicionar o produto");
		}*/
		
		stm.execute();
		
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O ID " + id + " foi criado!");
			}
		}
	}

}
