package visao;
import persistencia.*;
import dominio.*;
import java.util.*;
public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		AutomovelDAO amdao = new AutomovelDAO();
		AluguelDAO aldao = new AluguelDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		ClienteDAO cdao = new ClienteDAO();

		int opc, opc2, opc3, i;
		
		do {			
		
			System.out.println("--Menu Principal--");
			System.out.println("------------------");
			System.out.println("1- Cliente");
			System.out.println("2- Automovel");
			System.out.println("3- Funcionario");
			System.out.println("4- Aluguel");	
			System.out.println("5- Sair do programa");	
			opc = teclado.nextInt();
			
			switch(opc) {
			case 1:
				
				do {
						
					System.out.println("--Menu Secundario--");
					System.out.println("------------------");
					System.out.println("1- Inserir cliente");
					System.out.println("2- Alterar cliente");
					System.out.println("3- Mostrar clientes");
					System.out.println("4- Excluir cliente");	
					System.out.println("5- Voltar para o menu Principal");	
					opc2 = teclado.nextInt();
					
					switch(opc2) {
					
					case 1:
						Cliente c = new Cliente();
						System.out.println("cadastrando cliente");
						System.out.println("digite o cpf do cliente");
						c.setCpf(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite o nome do cliente");
						c.setNome(teclado.nextLine());
						System.out.println("digite a data de nascimento do cliente");
						c.setDataNascimento(teclado.nextLine());
						System.out.println("digite a rua do cliente");
						c.setRua(teclado.nextLine());
						System.out.println("digite o bairro do cliente");
						c.setBairro(teclado.nextLine());
						System.out.println("digite o CEP do cliente");
						c.setCEP(teclado.nextLine());
						System.out.println("digite a cidade do cliente");
						c.setCidade(teclado.nextLine());
						System.out.println("digite a carteira de motorista do cliente");
						c.setCarteiraMotorista(teclado.nextLine());
						
						cdao.inserir(c);
						
						break;
					case 2:
						int aux;
						Cliente cAUX = new Cliente();
						System.out.println("alterando cliente");
						System.out.println("digite o cpf do cliente que quer alterar");
						aux = teclado.nextInt();
						teclado.nextLine();
						System.out.println("digite o novo nome do cliente");
						cAUX.setNome(teclado.nextLine());
						System.out.println("digite a nova data de nascimento do cliente");
						cAUX.setDataNascimento(teclado.nextLine());
						System.out.println("digite a nova rua onde mora o cliente");
						cAUX.setRua(teclado.nextLine());
						System.out.println("digite o novo bairro onde o cliente");
						cAUX.setBairro(teclado.nextLine());
						System.out.println("digite a nova cidade onde mora o cliente");
						cAUX.setCidade(teclado.nextLine());
						System.out.println("digite o novo CEP do cliente");
						cAUX.setCEP(teclado.nextLine());
						System.out.println("digite a nova carteira de motorista do cliente");
						cAUX.setCarteiraMotorista(teclado.nextLine());
						
	
						cdao.alterar(cAUX, aux);
						break;
					case 3:
						System.out.println("mostrando cliente");
						System.out.println("o que deseja ver?");
						System.out.println("1 - relatorio geral");
						System.out.println("2 - buscar funcionario especifico");
						opc3 = teclado.nextInt();
						
						ArrayList<Cliente> relatorio;
						
						switch(opc3) {
						case 1:
							relatorio = cdao.relatGeral();
							System.out.println("mostrando relatorio geral");
							for(i=0; i<relatorio.size();i++) {
								System.out.println(
									relatorio.get(i).getNome() +", "+
									relatorio.get(i).getDataNascimento() +", "+ 
									relatorio.get(i).getRua() +", "+ relatorio.get(i).getBairro() +", "+
									relatorio.get(i).getCidade() +", "+ relatorio.get(i).getCEP() +", "+
									relatorio.get(i).getCpf() +", "+ relatorio.get(i).getCarteiraMotorista());
									
							}
							
							break;
						case 2:
							int auxCPF;
							Cliente busca;
							System.out.println("buscando cliente");
							System.out.println("digite o cpf que quer encontrar");
							auxCPF = teclado.nextInt();
							busca = cdao.buscar(auxCPF);
							
							System.out.println(
									busca.getNome() +", "+
									busca.getDataNascimento() +", "+ 
									busca.getRua() +", "+ busca.getBairro() +", "+
									busca.getCidade() +", "+ busca.getCEP() +", "+
									busca.getCpf() +", "+ busca.getCarteiraMotorista());
	
					
							break;
						}
						
						break;
					case 4:
						int cpf;
						System.out.println("Excluindo cliente");
						System.out.println("digite o cpf do cliente que deseja excluir");
						cpf = teclado.nextInt();
						cdao.delete(cpf);
						
						break;
					}
				
				}while(opc2 != 5);
				break;
			case 2:
				do {	
					System.out.println("--Menu Secundario--");
					System.out.println("------------------");
					System.out.println("1- Inserir automovel");
					System.out.println("2- Alterar automovel");
					System.out.println("3- Mostrar automoveis");
					System.out.println("4- Excluir automovel");	
					System.out.println("5- Voltar para o menu Principal");
					opc2 = teclado.nextInt();
					
					switch(opc2) {
					case 1:
	
						Automovel automovel = new Automovel();
						int auxId;
						System.out.println("cadastrando automovel");
						System.out.println("digite o ano do automovel");
						automovel.setAno(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite a cor do automovel");
						automovel.setCor(teclado.nextLine());
						System.out.println("digite a placa do automovel");
						automovel.setPlaca(teclado.nextLine());
						System.out.println("digite a marca e modelo do automovel - Ex.: Marca/Modelo");
						automovel.setMarcaModelo(teclado.nextLine());
						System.out.println("digite o tipo do automovel - Ex.: Carro, Moto...");
						automovel.setTipoAutomovel(teclado.nextLine());
						System.out.println("digite a quilometragem do automovel");
						automovel.setQuilometragem(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite o numero de portas do automovel");
						automovel.setnPortas(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite o tipo de combustivel do automovel - Ex.: Gasolina, Alcool");
						automovel.setTipoCombustivel(teclado.nextLine());
						System.out.println("digite se o automovel tem ar-condicionado");
						automovel.setArCondicionado(teclado.nextBoolean());
						teclado.nextLine();
						System.out.println("digite o valor do aluguel do automovel");
						automovel.setValorAluguel(teclado.nextFloat());
						teclado.nextLine();
						System.out.println("digite o tipo de direcao do automovel - Ex.: Hidraulica, Eletrica");
						automovel.setTipoCombustivel(teclado.nextLine());
						System.out.println("digite o id do aluguel que esse carro ta cadastrado");
						auxId = teclado.nextInt();
						
						amdao.inserir(automovel, auxId);			
						
						break;
					case 2:
						String aux;
						
						ArrayList<Automovel> listBuscar;
						System.out.println("alterando automovel");
						System.out.println("digite a placa do automovel que deseja alterar");
						aux = teclado.next();
						listBuscar = amdao.relatGeral();
						
						for(i=0; i<listBuscar.size(); i++) {
							if(listBuscar.get(i).getPlaca() == aux) {
								System.out.println("digite o ano do automovel");
								listBuscar.get(i).setAno(teclado.nextInt());
								teclado.nextLine();
								System.out.println("digite a cor do automovel");
								listBuscar.get(i).setCor(teclado.nextLine());
								System.out.println("digite a marca e modelo do automovel - Ex.: Marca/Modelo");
								listBuscar.get(i).setMarcaModelo(teclado.nextLine());
								System.out.println("digite o tipo do automovel - Ex.: Carro, Moto...");
								listBuscar.get(i).setTipoAutomovel(teclado.nextLine());
								System.out.println("digite a quilometragem do automovel");
								listBuscar.get(i).setQuilometragem(teclado.nextInt());
								teclado.nextLine();
								System.out.println("digite o numero de portas do automovel");
								listBuscar.get(i).setnPortas(teclado.nextInt());
								teclado.nextLine();
								System.out.println("digite o tipo de combustivel do automovel - Ex.: Gasolina, Alcool");
								listBuscar.get(i).setTipoCombustivel(teclado.nextLine());
								System.out.println("digite se o automovel tem ar-condicionado");
								listBuscar.get(i).setArCondicionado(teclado.nextBoolean());
								teclado.nextLine();
								System.out.println("digite o valor do aluguel do automovel");
								listBuscar.get(i).setValorAluguel(teclado.nextFloat());
								teclado.nextLine();
								System.out.println("digite o tipo de direcao do automovel - Ex.: Hidraulica, Eletrica");
								listBuscar.get(i).setTipoCombustivel(teclado.nextLine());
								System.out.println("digite o id do aluguel cadastrado");
								auxId = teclado.nextInt();
								
								amdao.alterar(listBuscar.get(i), auxId);
							}
						}
						break;
					case 3:
						System.out.println("mostrando automovel");
						System.out.println("o que deseja ver?");
						System.out.println("1 - relatorio geral");
						System.out.println("2 - buscar automovel especifico");
						opc3 = teclado.nextInt();
						
						ArrayList<Automovel> relatorio;
						
						switch(opc3) {
						case 1:
							relatorio = amdao.relatGeral();
							System.out.println("mostrando relatorio geral");
							for(i=0; i<relatorio.size();i++) {
								System.out.println(relatorio.get(i).getPlaca() + ", " + relatorio.get(i).getAno() + ", "  + relatorio.get(i).getCor() + ", "  + relatorio.get(i).isArCondicionado()+" ," + 
										relatorio.get(i).getMarcaModelo() + ", " + relatorio.get(i).getnPortas() + ", "  + relatorio.get(i).getTipoAutomovel() + ", "  +
										relatorio.get(i).getQuilometragem() + ", " + relatorio.get(i).getTipoCombustivel() + ", "  + relatorio.get(i).getValorAluguel() + ", " + 
										relatorio.get(i).getTipoDirecao());
							}
							
							break;
						case 2:
							String auxPlaca;
							Automovel busca;
							System.out.println("buscando automovel");
							System.out.println("digite a placa que quer encontrar");
							auxPlaca = teclado.next();
							busca = amdao.buscar(auxPlaca);
							
							System.out.println(busca.getPlaca()+" ," + busca.getCor()+" ," + busca.isArCondicionado()+" ," + 
									busca.getMarcaModelo()+" ," + busca.getnPortas()+" ," + busca.getTipoAutomovel()+" ," +
									busca.getQuilometragem()+" ," + busca.getTipoCombustivel()+" ," + busca.getValorAluguel( )+" ,"+ 
									busca.getTipoDirecao()+" ," + busca.getAno());
							
							break;
						}
						
						
						break;
					case 4:
						String placa;
						System.out.println("Excluindo automovel");
						System.out.println("digite a placa do automovel que deseja excluir");
						placa = teclado.next();
						amdao.delete(placa);
						
						
						
						break;
					}
				
				}while(opc2 != 5);

				
				break;
			case 3:
				do {
					System.out.println("--Menu Secundario--");
					System.out.println("------------------");
					System.out.println("1- Inserir funcionario");
					System.out.println("2- Alterar funcionario");
					System.out.println("3- Mostrar funcionarios");
					System.out.println("4- Excluir funcionario");	
					System.out.println("5- Voltar para o menu Principal");
					opc2 = teclado.nextInt();
					
					switch(opc2) {
					case 1:
						Funcionario f = new Funcionario();
						System.out.println("cadastrando funcionario");
						System.out.println("digite o cpf do funcionario");
						f.setCpf(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite o nome do funcionario");
						f.setNome(teclado.nextLine());
						System.out.println("digite a data de nascimento do funcionario");
						f.setDataNascimento(teclado.nextLine());
						System.out.println("digite o tipo do contrato do funcionario");
						f.setTipoContrato(teclado.nextLine());
						System.out.println("digite a rua do funcionario");
						f.setRua(teclado.nextLine());
						System.out.println("digite o bairro do funcionario");
						f.setBairro(teclado.nextLine());
						System.out.println("digite o CEP do funcionario");
						f.setCEP(teclado.nextLine());
						System.out.println("digite a cidade do funcionario");
						f.setCidade(teclado.nextLine());
						System.out.println("digite a carteira de trabalho do funcionario");
						f.setCarteiraTrabalho(teclado.nextLine());
						
						fdao.inserir(f);
						
						break;
					case 2:
						int aux;
						Funcionario fAUX = new Funcionario();
						System.out.println("alterando funcionario");
						System.out.println("digite o id do funcionario que quer alterar");
						aux = teclado.nextInt();
						teclado.nextLine();
						System.out.println("digite o novo nome do funcionario");
						fAUX.setNome(teclado.nextLine());
						System.out.println("digite a nova data de nascimento do funcionario");
						fAUX.setDataNascimento(teclado.nextLine());
						System.out.println("digite o novo cpf do funcionario");
						fAUX.setCpf(teclado.nextInt());
						teclado.nextLine();
						System.out.println("digite a nova rua onde mora o funcionario");
						fAUX.setRua(teclado.nextLine());
						System.out.println("digite o novo bairro onde o funcionario");
						fAUX.setBairro(teclado.nextLine());
						System.out.println("digite a nova cidade onde mora o funcionario");
						fAUX.setCidade(teclado.nextLine());
						System.out.println("digite o novo CEP do funcionario");
						fAUX.setCEP(teclado.nextLine());
						System.out.println("digite a nova carteira de trabalho do funcionario");
						fAUX.setCarteiraTrabalho(teclado.nextLine());
						System.out.println("digite o novo tipo de contrato do funcionario");
						fAUX.setTipoContrato(teclado.nextLine());
	
						fdao.alterar(fAUX, aux);
						break;
					case 3:
						System.out.println("mostrando funcionarios");
						System.out.println("o que deseja ver?");
						System.out.println("1 - relatorio geral");
						System.out.println("2 - buscar funcionario especifico");
						opc3 = teclado.nextInt();
						
						ArrayList<Funcionario> relatorio;
						
						switch(opc3) {
						case 1:
							relatorio = fdao.relatGeral();
							System.out.println("mostrando relatorio geral");
							for(i=0; i<relatorio.size();i++) {
								System.out.println(
									relatorio.get(i).getId() +", "+ relatorio.get(i).getNome() +", "+
									relatorio.get(i).getDataNascimento() +", "+ 
									relatorio.get(i).getRua() +", "+ relatorio.get(i).getBairro() +", "+
									relatorio.get(i).getCidade() +", "+ relatorio.get(i).getCEP() +", "+
									relatorio.get(i).getCpf() +", "+ relatorio.get(i).getCarteiraTrabalho() +", "+
									relatorio.get(i).getTipoContrato());
							}
							
							break;
						case 2:
							int auxID;
							Funcionario busca;
							System.out.println("buscando funcionario");
							System.out.println("digite o id que quer encontrar");
							auxID = teclado.nextInt();
							busca = fdao.buscar(auxID);
							
							System.out.println(
									busca.getId() +", "+ busca.getNome() +", "+
									busca.getDataNascimento() +", "+ 
									busca.getRua() +", "+ busca.getBairro() +", "+
									busca.getCidade() +", "+ busca.getCEP() +", "+
									busca.getCpf() +", "+ busca.getCarteiraTrabalho() +", "+
									busca.getTipoContrato());
					
							break;
						}
						
						break;
					case 4:
						int id;
						System.out.println("Excluindo funcionario");
						System.out.println("digite o id do funcionario que deseja excluir");
						id = teclado.nextInt();
						fdao.delete(id);
						
						break;
					}
				}while(opc2 != 5);

				
				break;			
			case 4:
				do {
					System.out.println("--Menu Secundario--");
					System.out.println("------------------");
					System.out.println("1- Inserir aluguel");
					System.out.println("2- Alterar aluguel");
					System.out.println("3- Mostrar alugueis");
					System.out.println("4- Excluir aluguel");						
					System.out.println("5- Voltar para o menu Principal");
					opc2 = teclado.nextInt();
					
					switch(opc2) {
					case 1:
						Aluguel al = new Aluguel();
						System.out.println("cadastrando aluguel");
						System.out.println("digite a data que comecou o aluguel");
						al.setDataInicio(teclado.nextLine());					
						System.out.println("digite a data que termina o aluguel");
						al.setDataFim(teclado.nextLine());
						System.out.println("digite o valor do aluguel");
						al.setValorTotal(teclado.nextInt());
						
						aldao.inserir(al);
						break;
					case 2:
						int aux;
						Aluguel alAUX = new Aluguel();
						System.out.println("alterando aluguel");
						System.out.println("digite o id do aluguel que voce quer alterar");
						aux = teclado.nextInt();
						teclado.nextLine();
						System.out.println("digite a nova data que comecou o aluguel");
						alAUX.setDataInicio(teclado.nextLine());					
						System.out.println("digite a nova data que termina o aluguel");
						alAUX.setDataFim(teclado.nextLine());
						System.out.println("digite o novo valor do aluguel");
						alAUX.setValorTotal(teclado.nextInt());
						
						aldao.alterar(alAUX, aux);
						
						break;
					case 3:
						System.out.println("mostrando alugueis");
						System.out.println("o que deseja ver?");
						System.out.println("1 - relatorio geral");
						System.out.println("2 - buscar aluguel especifico");
						opc3 = teclado.nextInt();
						
						ArrayList<Aluguel> relatorio;
						
						switch(opc3) {
						case 1:
							relatorio = aldao.relatGeral();
							System.out.println("mostrando relatorio geral");
							for(i=0; i<relatorio.size();i++) {
								System.out.println(relatorio.get(i).getId() + ", " + relatorio.get(i).getDataInicio() + ", "  + relatorio.get(i).getDataFim() + ", "  + relatorio.get(i).getValorTotal());
							}
							
							break;
						case 2:
							int auxID;
							Aluguel busca;
							System.out.println("buscando aluguel");
							System.out.println("digite o id que quer encontrar");
							auxID = teclado.nextInt();
							busca = aldao.buscar(auxID);
							
							System.out.println(busca.getId() + ", " + busca.getDataInicio() + ", "  + busca.getDataFim() + ", "  + busca.getValorTotal());
	
							break;
						}
						
						break;
					case 4:
						int id;
						System.out.println("Excluindo aluguel");
						System.out.println("digite o id do aluguel que deseja excluir");
						id = teclado.nextInt();
						aldao.delete(id);
						
						break;
					}
				}while(opc2 != 5);

				break;
			}	
		}while(opc !=5);
	}
}
