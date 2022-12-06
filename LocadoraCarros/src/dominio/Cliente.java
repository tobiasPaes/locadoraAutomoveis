package dominio;

public class Cliente {
	private int cpf;
	private String nome;
	private String dataNascimento;
	private	String rua;
	private String bairro;
	private String CEP;
	private String cidade;
	private String carteiraMotorista;
	
	public Cliente() {
		
	}

	public Cliente(int cpf, String n, String dn, String r, String b, String Cep, String c, String cm) {
		this.cpf = cpf;
		nome = n;
		dataNascimento = dn;
		rua = r;
		bairro = b;
		CEP = Cep;
		cidade = c;
		carteiraMotorista = cm;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
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

	public String getCarteiraMotorista() {
		return carteiraMotorista;
	}

	public void setCarteiraMotorista(String carteiraMotorista) {
		this.carteiraMotorista = carteiraMotorista;
	}
	
	
}
