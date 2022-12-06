package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioDAO {
	private Conexao conec = new Conexao();
	private final String INSERT = "insert into funcionarios (cpf, nome, datanascimento, rua, bairro, cep, cidade, carteiratrabalho, tipocontrato) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "update funcionarios set cpf = ?, nome = ?, datanascimento=?, rua = ?, bairro = ?, cep=?, cidade = ?, carteiratrabalho = ?, tipocontrato=? where id = ?";
	private final String DELETE = "delete from funcionarios where id = ?";
	private final String BUSCAR = "select * from funcionarios where id = ?";
	private final String RELATORIO_GERAL =	"select * from funcionarios";
	
	
	public ArrayList<Funcionario> relatGeral(){
		ArrayList<Funcionario> lista = new ArrayList<>();
		
		try {
			conec.conectar();
			Statement instrucao = conec.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);
			
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("datanascimento"), rs.getString("tipocontrato"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getInt("cpf"), rs.getString("carteiratrabalho"));
				lista.add(f);
			}
			conec.desconectar();
			
		}catch(SQLException e) {
			System.out.println("erro no relatorio" + e.getMessage());
		}
			
		return lista;
	
	}
	
	public Funcionario buscar(int id) {
		Funcionario f = null;
		
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("datanascimento"), rs.getString("tipocontrato"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getInt("cpf"), rs.getString("carteiratrabalho"));
			}
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na busca " +e.getMessage());
		}
		return f;	
	}
	
	public void inserir(Funcionario f) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
			instrucao.setInt(1, f.getCpf());
			instrucao.setString(2, f.getNome());
			instrucao.setString(3, f.getDataNascimento());
			instrucao.setString(4, f.getRua());
			instrucao.setString(5, f.getBairro());
			instrucao.setString(6, f.getCEP());
			instrucao.setString(7, f.getCidade());
			instrucao.setString(8, f.getCarteiraTrabalho());
			instrucao.setString(9, f.getTipoContrato());
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na inclusao " + e.getMessage());
		}
	}
	
	public void delete(int id) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
			instrucao.setInt(1, id);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na exclusao "+e.getMessage());
		}
		
		
	}
	
	public void alterar(Funcionario f, int id) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
			instrucao.setInt(1, f.getCpf());
			instrucao.setString(2, f.getNome());
			instrucao.setString(3, f.getDataNascimento());
			instrucao.setString(4, f.getRua());
			instrucao.setString(5, f.getBairro());
			instrucao.setString(6, f.getCEP());
			instrucao.setString(7, f.getCidade());
			instrucao.setString(8, f.getCarteiraTrabalho());
			instrucao.setString(9, f.getTipoContrato());
			instrucao.setInt(10, id);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na alteracao "+e.getMessage());
		}
	}
}
