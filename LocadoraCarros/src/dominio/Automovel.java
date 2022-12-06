package dominio;
//ano cor marcamodelo tipoautomovel quilometragem nportas tipocombustivel arcondicionado valoraluguel tipodirecao
public class Automovel {
	private int ano;
	private boolean arCondicionado;
	private String cor;
	private String marcaModelo;
	private int nPortas;
	private String placa;
	private String tipoAutomovel;
	private int quilometragem;
	private String tipoCombustivel;
	private float valorAluguel;
	private String tipoDirecao;
	
	public Automovel() {
		
	}
	
	public Automovel(int ano, String cor, String placa, String marcaModelo, String tipoAutomovel, int quilometragem, int nPortas, String tipoCombustivel, boolean arCondicionado, float valorAluguel, String tipoDirecao) {
		this.ano = ano;
		this.arCondicionado = arCondicionado;
		this.cor = cor;
		this.marcaModelo = marcaModelo;
		this.nPortas = nPortas;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.tipoCombustivel = tipoCombustivel;
		this.tipoAutomovel = tipoAutomovel;
		this.tipoDirecao = tipoDirecao;
		this.valorAluguel = valorAluguel;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getTipoAutomovel() {
		return tipoAutomovel;
	}

	public void setTipoAutomovel(String tipoAutomovel) {
		this.tipoAutomovel = tipoAutomovel;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public int getnPortas() {
		return nPortas;
	}

	public void setnPortas(int nPortas) {
		this.nPortas = nPortas;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public float getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public String getTipoDirecao() {
		return tipoDirecao;
	}

	public void setTipoDirecao(String tipoDirecao) {
		this.tipoDirecao = tipoDirecao;
	}
	
	
	
	
	
	
}
