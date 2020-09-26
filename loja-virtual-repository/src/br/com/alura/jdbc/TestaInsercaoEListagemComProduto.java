package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection con = new ConnectionFactory().getConnection()){
			
			ProdutoDAO persistenciaProduto = new ProdutoDAO(con);
			persistenciaProduto.salvar(comoda);
			List<Produto> listaDeProdutos = persistenciaProduto.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
