package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dominio.Aluguel;
import dominio.Automovel;

public class AluguelDAO {
	private Conexao conec = new Conexao();
	private final String INSERT = "insert into alugueis(datainicio, datafim, valortotal) values (?, ?, ?)";
	private final String UPDATE = "update alugueis set datainicio = ?, datafim = ?, valortotal=? where id = ?";
	private final String DELETE = "delete from alugueis where id = ?";
	private final String BUSCAR = "select * from alugueis where id = ?";
	private final String RELATORIO_GERAL =	"select * from alugueis";
	private final String RELATORIO_AUTOMOVEL = "select ano, cor, placa, marcamodelo, tipoautomovel, quilometragem, nportas, tipocombustivel, arcondicionado, valoraluguel, tipodirecao from alugueis, automoveis where id = id_aluguel and id = ?";
	
	
	public ArrayList<Aluguel> relatGeral(){
		ArrayList<Aluguel> lista = new ArrayList<>();
		
		try {
			conec.conectar();
			Statement instrucao = conec.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);
			
			while(rs.next()) {
				Aluguel al = new Aluguel(rs.getInt("id"), rs.getString("dataInicio"), rs.getString("dataFim"), rs.getInt("valorTotal"));
				lista.add(al);
			}
			conec.desconectar();
			
		}catch(SQLException e) {
			System.out.println("erro no relatorio" + e.getMessage());
		}
			
		return lista;
	
	}
	
	public Aluguel buscar(int id) {
		Aluguel al = null;
		
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				al = new Aluguel(rs.getInt("id"), rs.getString("dataInicio"), rs.getString("dataFim"), rs.getInt("valorTotal"));
			}
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na busca " +e.getMessage());
		}
		return al;	
	}
	
	public void inserir(Aluguel al) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
			instrucao.setString(1, al.getDataInicio());
			instrucao.setString(2, al.getDataFim());
			instrucao.setInt(3, al.getValorTotal());
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
	
	public void alterar(Aluguel al, int id) {
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
			instrucao.setString(1, al.getDataInicio());
			instrucao.setString(2, al.getDataFim());
			instrucao.setInt(3, al.getValorTotal());
			instrucao.setInt(4, id);
			instrucao.execute();
			conec.desconectar();
		}catch(SQLException e) {
			System.out.println("erro na alteracao "+e.getMessage());
		}
	}
	
	public ArrayList<Automovel> relatAuto(int id){
		ArrayList<Automovel> list = new ArrayList<>();
		try {
			conec.conectar();
			PreparedStatement instrucao = conec.getConexao().prepareStatement(RELATORIO_AUTOMOVEL);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			
			while(rs.next()) {
				Automovel am = new Automovel(rs.getInt("ano"), rs.getString("cor"), rs.getString("placa"), rs.getString("marcaModelo"), rs.getString("tipoAutomovel"), rs.getInt("quilometragem"), rs.getInt("nPortas"), rs.getString("tipoCombustivel"), rs.getBoolean("arCondicionado"), rs.getFloat("valorAluguel"), rs.getString("tipoDirecao"));
				list.add(am);
			}
			conec.desconectar();
			
		}catch(SQLException e) {
			System.out.println("erro no relatorio " + e.getMessage());
		}
		
		return list;
	}

}