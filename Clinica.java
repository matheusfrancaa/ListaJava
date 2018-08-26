import java.util.Scanner;
import java.util.ArrayList;
public class Clinica {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		ArrayList<Pacientes> listPac = new ArrayList<Pacientes>();  //Criando um array de objetos tipo Pacientes
		Pacientes pac = new Pacientes();   //Instanciando o objeto na memória
		String pacName = "";
		int mIdHomem = 0, qtdHomens = 0, qtdMulheresIdPeso = 0, pessIdDzVtcc = 0;
		
		
		
		System.out.print("********************************************\n");
		System.out.println("           CADASTRO DE PACIENTES");
		System.out.print("********************************************\n");
		
		
		
		while(!pac.getNome().toLowerCase().equals("fim")) { 
			
			System.out.print("NOME DO PACIENTE: "); pacName = ler.nextLine();
			
			if(pacName.toLowerCase().equals("fim")) {
				
				break;
			
			}else {
			
				pac.setNome(pacName);			
			
				System.out.print("SEXO: "); pac.setSexo(ler.next().charAt(0));
				System.out.print("PESO: "); pac.setPeso(ler.nextFloat());
				System.out.print("IDADE: "); pac.setIdade(ler.nextInt());
				System.out.print("ALTURA: "); pac.setAltura(ler.nextFloat());
				System.out.print("--------- PACIENTE CADASTRADO!\n\n");
				ler.nextLine();
				
				
				listPac.add(pac);
				pac = new Pacientes();
				
				
			}
		}
		for(int i = 0; i < listPac.size(); i++) {
			
			if((listPac.get(i).getSexo() == 'm') || (listPac.get(i).getSexo() == 'M')) {
				mIdHomem += listPac.get(i).getIdade();
				qtdHomens++;
			}		
			
			if(((listPac.get(i).getSexo() == 'f') || (listPac.get(i).getSexo() == 'F')) && ((listPac.get(i).getAltura() > 1.60) || (listPac.get(i).getAltura() < 1.70)) && ((listPac.get(i).getPeso() > 70.00))) {
				qtdMulheresIdPeso++;
			}
			if((listPac.get(i).getIdade() > 18) && (listPac.get(i).getIdade() < 25)){
				pessIdDzVtcc++;
			}		
			
		}
		if(qtdHomens == 0) {		
			
		}else {
		mIdHomem /= qtdHomens;
		}
		
		System.out.println("\n\n============================================");
		System.out.println("==================RELATÓRIO=================");
		System.out.println("============================================");
		System.out.println(listPac.size() + " PACIENTES CADASTRADOS.");
		System.out.println("MÉDIA DE IDADE DOS HOMENS: " + mIdHomem);
		System.out.println("MULHERES COM ALTURA ENTRE 1,60 E 1,70 E PESO ACIMA DE 70KG: " + qtdMulheresIdPeso);
		System.out.println("QUANTIDADE DE PESSOAS COM IDADE ENTRE 18 E 25: " + pessIdDzVtcc);
		
		int idPacMaisVelho = 0, qtdPacMaisVelho = 0;
		int qtdMulherMaisBaixa = 0;
		float altMulherMaisBaixa = 10.00f;
		
		for(int i = 0; i < listPac.size(); i++) {   
			
			if(listPac.get(i).getIdade() > idPacMaisVelho) {
				idPacMaisVelho = listPac.get(i).getIdade();
			}
			if(idPacMaisVelho == listPac.get(i).getIdade()) {
				qtdPacMaisVelho++;
			}
			
			if(((listPac.get(i).getSexo() == 'f') || (listPac.get(i).getSexo() == 'F')) && (listPac.get(i).getAltura() < altMulherMaisBaixa)) {
				qtdMulherMaisBaixa++;
				
				if(listPac.get(i).getAltura() < altMulherMaisBaixa) {
					altMulherMaisBaixa = listPac.get(i).getAltura();
				}
				
			}
		
		}
		
		System.out.println("\nPACIENTE(S) MAIS VELHO(S):");
		for(int i = 0; i < listPac.size(); i++) {
			if(listPac.get(i).getIdade() >= idPacMaisVelho) {
				System.out.println("*****NOME: " + listPac.get(i).getNome() + " | IDADE: " + listPac.get(i).getIdade());
			}
		}
		
		System.out.println("\nMULHER(RES) MAIS BAIXA(S):");
		for(int i = 0; i < listPac.size(); i++) {
			if(((listPac.get(i).getSexo() == 'f') || (listPac.get(i).getSexo() == 'F')) && (listPac.get(i).getAltura() == altMulherMaisBaixa)) {
				System.out.println("*****NOME: " + listPac.get(i).getNome() + " | ALTURA: " + listPac.get(i).getAltura());
			}
		}
		
	}
}