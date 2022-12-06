package persistencia;

import java.sql.*;

public class Conexao {
	private String usuario;
	private String senha;
	private String caminho;
	private Connection con;
	
	public Conexao(){
		caminho = "jdbc:postgresql://localhost:5432/locadoraAutomoveis";
		usuario = "postgres";
		senha = "postegres";
	}
	
	public void conectar() {
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(caminho, usuario, senha);
		}catch(Exception e) {
			System.out.println("Erro na conexao "+e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			con.close();
		}catch(Exception e) {
			System.out.println("Erro na desconexao "+e.getMessage());

		}
	}
	public Connection getConexao() {
		return con;
	}

	
}
