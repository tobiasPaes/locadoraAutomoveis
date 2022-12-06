package persistencia;
import dominio.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClienteDAO {
	private Conexao conec = new Conexao();
	private final String INSERT = "insert into clientes (cpf, nome, datanascimento, rua, bairro, cep, cidade, carteiramotorista) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "update clientes set nome = ?, datanascimento=?, rua = ?, bairro = ?, cep=?, cidade = ?, carteiramotorista = ? where cpf = ?";
	private final String DELETE = "delete from clientes where cpf = ?";
	private final String BUSCAR = "select * from clientes where cpf = ?";
	private final String RELATORIO_GERAL =	"select * from clientes";
	
	
	public ArrayList<Cliente> relatGeral(){
		ArrayList<Cliente> lista = new ArrayList<>();
		
		try {
			conec.conectar();
			Statement instrucao = conec.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);
			
			while(rs.next()) {
				Cliente c = new Cliente(rs.getInt("cpf"), rs.getString("nome"), rs.getString("datanascimento"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("carteiramotorista"));
				lista.add(c);
			}
			conec.desconectar();
			
		}catch(SQLException e) {
			System.out.println("erro no relatorio" + e.getMessage());
		}
			
		return lista;
	
	}
	
	public Cliente buscar(int cpf) {
		Cliente c = null;
		
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
			instrucao.setInt(1, cpf);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				c = new Cliente(rs.getInt("cpf"), rs.getString("nome"), rs.getString("datanascimento"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("carteiramotorista"));
			}
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na busca " +e.getMessage());
		}
		return c;	
	}
	
	public void inserir(Cliente c) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
			instrucao.setInt(1, c.getCpf());
			instrucao.setString(2, c.getNome());
			instrucao.setString(3, c.getDataNascimento());
			instrucao.setString(4, c.getRua());
			instrucao.setString(5, c.getBairro());
			instrucao.setString(6, c.getCEP());
			instrucao.setString(7, c.getCidade());
			instrucao.setString(8, c.getCarteiraMotorista());
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na inclusao " + e.getMessage());
		}
	}
	
	public void delete(int cpf) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
			instrucao.setInt(1, cpf);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na exclusao "+e.getMessage());
		}
		
		
	}
	
	public void alterar(Cliente c, int cpf) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
			instrucao.setString(1, c.getNome());
			instrucao.setString(2, c.getDataNascimento());
			instrucao.setString(3, c.getRua());
			instrucao.setString(4, c.getBairro());
			instrucao.setString(5, c.getCEP());
			instrucao.setString(6, c.getCidade());
			instrucao.setString(7, c.getCarteiraMotorista());
			instrucao.setInt(8, cpf);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na alteracao "+e.getMessage());
		}
	}

}
