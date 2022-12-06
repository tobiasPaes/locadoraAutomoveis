package dominio;

public class Funcionario {
	private int Id;
	private String nome;
	private String dataNascimento;
	private String tipoContrato;
	private	String rua;
	private String bairro;
	private String CEP;
	private String cidade;
	private int cpf;
	private String carteiraTrabalho;
	
	public Funcionario() {
		
	}
	
	
	public Funcionario(int id, String nome, String datanascimento, String contrato, String rua, String bairro, String cep, String cidade, int cpf, String carteira) {
		this.Id = id;
		this.nome = nome;
		this.dataNascimento = datanascimento;
		this.tipoContrato = contrato;
		this.rua = rua;
		this.bairro = bairro;
		this.CEP = cep;
		this.cidade = cidade;
		this.cpf = cpf;
		this.carteiraTrabalho = carteira;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
	
}
