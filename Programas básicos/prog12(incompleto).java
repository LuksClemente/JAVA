import java.io.*;
import java.util.Vector;
import java.lang.Math;

class Pessoa{
	private String nome, dataNascimento;
	
	public Pessoa(String name, String data){
		this.nome = name;
		this.dataNascimento = data;
	}
	public String toString(){
		return "\nNome: " + nome + "\nData de Nascimento: " + dataNascimento;
	}
}
class PessoaIMC extends Pessoa{
	private double peso, altura;
	
	public PessoaIMC(String name, String data, double pes, double alt){
		super(name, data);
		this.peso = pes;
		this.altura = alt;
	}
	public double getPeso(){
		return peso;
	}
	public double getAltura(){
		return altura;
	}
	public double calculaIMC(double pes, double alt){
		return (pes/Math.pow(alt, 2));
	}
	public String toString(){
		return super.toString() + "\nPeso: " + String.format("%.2f", peso) + " Kg" + "\nAltura: " + altura + " metros" + "\nIMC: " + String.format("%.2f", calculaIMC(peso, altura));
	}
}
class Homem extends PessoaIMC{
	public Homem(String name, String data, double pes, double alt){
		super(name, data, pes, alt);
	}
	public String toString(){
		if(calculaIMC(getPeso(), getAltura()) < 20.7){
			return super.toString() + " Abaixo do Peso\n";
		}
		else if(calculaIMC(getPeso(), getAltura()) > 26.4){
			return super.toString() + " Acima do Peso\n";
		}
		else{
			return super.toString() + " Peso Ideal\n";
		}
	}
}
class Mulher extends PessoaIMC{
	public Mulher(String name, String data, double pes, double alt){
		super(name, data, pes, alt);
	}
	public String toString(){
		if(calculaIMC(getPeso(), getAltura()) < 19){
			return super.toString() + " Abaixo do peso\n";
		}
		else if(calculaIMC(getPeso(), getAltura()) > 25.8){
			return super.toString() + " Acima do peso\n";
		}
		else{
			return super.toString() + " Peso ideal\n";
		}
	}
}
public class Ex5{
	public static void main(String[] args){
		int numero, i;
		double peso, altura;
		String num, sexo, pesostr, alturastr, data, nome;
		Vector <PessoaIMC> pessoas = new Vector <PessoaIMC> ();
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.print("Digite o numero de pessoas: ");
			num = inData.readLine();
			numero = Integer.parseInt(num);
			for(i = 0; i < numero; i++){
				System.out.print("\nInserir Homem[h] ou Mulher[m]?: ");
				sexo = inData.readLine();
				if(sexo.equals("h") == true){
					System.out.print("\nDigite o nome: ");
					nome = inData.readLine();
					System.out.print("Digite a data de nascimento: ");
					data = inData.readLine();
					System.out.print("Digite a altura(em metros): ");
					alturastr = inData.readLine();
					altura = Double.parseDouble(alturastr);
					System.out.print("Digite o peso: ");
					pesostr = inData.readLine();
					peso = Double.parseDouble(pesostr);
					Homem homem = new Homem(nome, data, peso, altura);
					pessoas.add(homem);
				}
				else if(sexo.equals("m") == true){
					System.out.print("\nDigite o nome: ");
					nome = inData.readLine();
					System.out.print("Digite a data de nascimento: ");
					data = inData.readLine();
					System.out.print("Digite a altura(em metros): ");
					alturastr = inData.readLine();
					altura = Double.parseDouble(alturastr);
					System.out.print("Digite o peso: ");
					pesostr = inData.readLine();
					peso = Double.parseDouble(pesostr);
					Mulher mulher= new Mulher(nome, data, peso, altura);
					pessoas.add(mulher);
				}
			}
			System.out.println(" - - - - - - - - - - - - - ");
			System.out.println("\n" + pessoas);
		}
		catch(Exception e){
			System.out.println("Parametro informado e' invalido! =(");
		}
	}
}
