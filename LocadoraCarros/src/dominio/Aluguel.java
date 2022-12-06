package dominio;
import dominio.Automovel;
import java.util.ArrayList;

import persistencia.AluguelDAO;
import persistencia.AutomovelDAO;

public class Aluguel {
	private int Id;
	private String dataInicio;
	private String dataFim;
	private int valorTotal;
	private ArrayList<Automovel> automoveis = new ArrayList<>();
	
	public Aluguel() {
		
	}

	public Aluguel(String dataI, String dataF, int valorTotal) {
		this.dataFim = dataF;
		this.dataInicio = dataI;
		this.valorTotal = valorTotal;
	}
	
	public Aluguel(int id, String dataI, String dataF, int valorTotal) {
		this.Id = id;
		this.dataFim = dataF;
		this.dataInicio = dataI;
		this.valorTotal = valorTotal;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void addAutomoveis(Automovel a) {
		automoveis.add(a);
	}
	
	public ArrayList<Automovel> listaAutomoveis(int id){
		AluguelDAO aldao = new AluguelDAO();
		ArrayList<Automovel> lista = new ArrayList<>();
		lista = aldao.relatAuto(id);
		return lista;
	}
	
}
