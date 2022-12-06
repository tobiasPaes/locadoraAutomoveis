package persistencia;
import dominio.Automovel;
import java.util.*;
import java.sql.*;

public class AutomovelDAO {
	private Conexao conec = new Conexao();
	private final String INSERT = "insert into automoveis(ano, cor, placa, marcamodelo, tipoautomovel, quilometragem, nportas, tipocombustivel, arcondicionado, valoraluguel, tipodirecao, id_aluguel) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "update automoveis set ano = ?, cor = ?, marcamodelo = ?, tipoautomovel=?, quilometragem=?, nportas=?, tipocombustivel=?, arcondicionado=?,  valoraluguel=?,  tipodirecao=?, id_aluguel = ?  where placa = ?";
	private final String DELETE = "delete from automoveis where placa = ?";
	private final String BUSCAR = "select * from automoveis where placa = ?";
	private final String RELATORIO_GERAL =	"select * from automoveis";
	

	
	
	public ArrayList<Automovel> relatGeral(){
		ArrayList<Automovel> lista = new ArrayList<>();
		
		try {
			conec.conectar();
			Statement instrucao = conec.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);
			
			while(rs.next()) {
				Automovel am = new Automovel(rs.getInt("ano"), rs.getString("cor"), rs.getString("placa"), rs.getString("marcaModelo"), rs.getString("tipoAutomovel"), rs.getInt("quilometragem"), rs.getInt("nPortas"), rs.getString("tipoCombustivel"), rs.getBoolean("arCondicionado"), rs.getFloat("valorAluguel"), rs.getString("tipoDirecao"));
				lista.add(am);
			}
			conec.desconectar();
			
		}catch(SQLException e) {
			System.out.println("erro no relatorio" + e.getMessage());
		}
			
		return lista;
	
	}
	
	public Automovel buscar(String placa) {
		Automovel am = null;
		
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
			instrucao.setString(1, placa);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				am = new Automovel(rs.getInt("ano"), rs.getString("cor"), rs.getString("placa"), rs.getString("marcaModelo"), rs.getString("tipoAutomovel"), rs.getInt("quilometragem"), rs.getInt("nPortas"), rs.getString("tipoCombustivel"), rs.getBoolean("arCondicionado"), rs.getFloat("valorAluguel"), rs.getString("tipoDirecao"));
			}
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na busca " +e.getMessage());
		}
		return am;	
	}
	
	public void inserir(Automovel am, int id) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
			instrucao.setInt(1, am.getAno());
			instrucao.setString(2, am.getCor());
			instrucao.setString(3, am.getPlaca());
			instrucao.setString(4, am.getMarcaModelo());
			instrucao.setString(5, am.getTipoAutomovel());
			instrucao.setInt(6, am.getQuilometragem());
			instrucao.setInt(7, am.getnPortas());
			instrucao.setString(8, am.getTipoCombustivel());
			instrucao.setBoolean(9, am.isArCondicionado());
			instrucao.setFloat(10, am.getValorAluguel());
			instrucao.setString(11, am.getTipoDirecao());
			instrucao.setInt(12, id);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na inclusao " + e.getMessage());
		}
	}
	
	public void delete(String placa) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
			instrucao.setString(1, placa);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na exclusao "+e.getMessage());
		}
		
		
	}
	
	public void alterar(Automovel am, int id) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
			instrucao.setInt(1, am.getAno());
			instrucao.setString(2, am.getCor());
			instrucao.setString(3, am.getMarcaModelo());
			instrucao.setString(4, am.getTipoAutomovel());
			instrucao.setInt(5, am.getQuilometragem());
			instrucao.setInt(6, am.getnPortas());
			instrucao.setString(7, am.getTipoCombustivel());
			instrucao.setBoolean(8, am.isArCondicionado());
			instrucao.setFloat(9, am.getValorAluguel());
			instrucao.setString(10, am.getTipoDirecao());
			instrucao.setInt(11, id);
			instrucao.setString(12, am.getPlaca());
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na alteracao "+e.getMessage());
		}
	}		
}