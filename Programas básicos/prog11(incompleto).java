import java.io.*;

class Funcionario{
	String nome, codigo;
	float salario, salarioliq;
	
	public Funcionario(String n, String cod, float sal){
		this.nome = n;
		this.codigo = cod;
		this.salario = sal;
		this.salarioliq = sal;
	}
	public double calculaSalario(double desconto){
		salarioliq = salario - (salario*desconto);
		return salarioliq;
	}
	public String toString(){
		return "Nome: " + nome + "\nCodigo: " + codigo "\nSalario-base: " + salario + "\n";
	}
}
class FuncionarioContratado extends Funcionario{
	int dependentes;
	float valorPorDep = 9.58;
	float aliquotaIR = 0.15;
	
	public FuncionarioContratado(String n, String cod, float sal, int dep){
		this.nome = n;
		this.codigo = cod;
		this.salario = sal;
		this.dependentes = dep;
	}
	public void calculaSalario(){
		salarioliq = calculaSalario(aliquotaIR);
	}
	public void calculaSalario(int numeroDependentes){
		salario = salario + (numeroDependentes*valorPorDep);
		salarioliq = calculaSalario();
	}
	public String toString(){
		return "Nome: " + nome + "\nCodigo: " + codigo "\nSalario-base: " + salario + "\nSalario-liquido: " + salarioliq + "\n";
	}
}
public class Ex4{
	public static void main(String[] args){
		String nome, codigo, num, salariostr, dependentestr;
		float salario, salarioliquido;
		int dependentes, numero, i, j;
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		try{
			system.out.print("Quantos funcionarios deseja cadastrar?: ");
			num = inData.readLine();
			numero = Integer.parseInt(num);
			public Ex4(int n);
			for(i = 0; i < numero; i++){
				Ex4 instancia = new Ex4(numero);
				System.out.print("Nome do empregado: ");
				nome = inData.readLine();
				System.out.print("Codigo: ");
				codigo = inData.readLine();
				System.out.print("Salario: ");
				salariostr = inData.readLine();
				System.out.print("Numero de dependentes: ");
				dependentestr = inData.readLine();
				dependentes = Integer.parseInt(dependentestr);
				salario = Float.parseFloat(salariostr);
				FuncionarioContratado funcionario = new FuncionarioContratado(nome, codigo, salario, dependentes);
				salarioliq = funcionario.calculaSalario(dependentes);
			}
			for(j = 0, j < numero; j++){
				System.out.print(funcionario);
			}
		}
		catch(Exception e){
			System.out.println("Parametro passado e' invalido! =(");
		}
	}
}
