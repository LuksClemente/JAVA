import java.io.*;
import java.util.*;

class MuitosParametros extends Exception{
	public MuitosParametros(){
		super("Numero de parametros excessivo! =(");
	}
}
class NenhumParametro extends Exception{
	public NenhumParametro(){
		super("Nenhum parametro informado! =(");
	}
}
class Funcionario{
	String nome, codigo;
	double salario, salarioliq;
	
	public Funcionario(String n, String cod, double sal){
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
		return "Nome: " + this.nome + "\nCodigo: " + this.codigo + "\nSalario-base: R$ " + String.format("%.2f", salario);
	}
	public String getNome(){
		return this.nome;
	}
	public String getCodigo(){
		return this.nome;
	}
	public double getSalario(){
		return this.salario;
	}
}
class FuncionarioContratado extends Funcionario{
	int dependentes;
	double valorPorDep = 9.58;
	double aliquotaIR = 0.15;
	
	public FuncionarioContratado(String n, String cod, double sal, int dep){
		super(n, cod, sal);
		this.dependentes = dep;
	}
	public void calculaSalario(){
		salarioliq = calculaSalario(aliquotaIR);
	}
	public void calculaSalario(int numeroDependentes){
		salario = salario + (numeroDependentes*valorPorDep);
		salarioliq = calculaSalario(aliquotaIR);
	}
	public String toString(){
		return "\n" + super.toString() + "\nSalario-liquido: R$ " + String.format("%.2f", salarioliq) + "\n";
	}
	public int getDependentes(){
		return this.dependentes;
	}
	public double getSalarioliq(){
		return this.salarioliq;
	}
}
public class Ex4{
	int numero;
	public Ex4(int n){
		numero = n;
	}
	public void calculaSalarios(){
		int i, dependentes;
		String nome, codigo, salariostr, dependentesstr;
		double salario;
		Collection <FuncionarioContratado> empregados = new ArrayList <FuncionarioContratado> (numero);
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("- - - Cadastro de Funcionarios - - -");
		System.out.print("\n");
		try{
			for(i = 0; i < numero; i++){
				System.out.print("Nome do empregado: ");
				nome = inData.readLine();
				System.out.print("Codigo do empregado: ");
				codigo = inData.readLine();
				System.out.print("Salario-base: ");
				salariostr = inData.readLine();
				System.out.print("Numero de dependentes: ");
				dependentesstr = inData.readLine();
				dependentes = Integer.parseInt(dependentesstr);
				salario = Double.parseDouble(salariostr);
				FuncionarioContratado funcionario = new FuncionarioContratado(nome, codigo, salario, dependentes);
				funcionario.calculaSalario(dependentes);
				empregados.add(funcionario);
				System.out.print("\n");
			}
			System.out.println("- - - Folha Salarial - - -");
			System.out.print("\n");
			System.out.println(empregados);
		}
		catch(Exception e){
			System.out.println("Parametro informado e' invalido! =(");
		}
	}
	public static void main(String[] args){
		int numero, i, contador = 0;
		String num;
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.print("Quantos funcionarios deseja cadastrar?: ");
			num = inData.readLine();
			for(i = 0; i < num.length(); i++){
				if(num.charAt(i) == ' '){
					contador++;
				}
			}
			if(contador > 0){
				throw new MuitosParametros();
			}
			else if(num.equals("") == true){
				throw new NenhumParametro();
			}
			numero = Integer.parseInt(num);
			Ex4 instancia = new Ex4(numero);
			instancia.calculaSalarios();
		}
		catch(MuitosParametros e){
			System.out.println(e);
		}
		catch(NenhumParametro e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println("Parametro passado e' invalido! =(");
		}
	}
}
