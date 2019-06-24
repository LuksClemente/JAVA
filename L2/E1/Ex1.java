import java.io.*;
import java.util.*;
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
	public String getName(){
		return nome;
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
	public double getIMC(){
		return calculaIMC(peso, altura);
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
class MinhaListaOrdenavel{
	ArrayList <PessoaIMC> pessoas = new ArrayList <PessoaIMC> ();
	public MinhaListaOrdenavel(){
		this.pessoas = pessoas;
	}
	public void addP(PessoaIMC p){
		pessoas.add(p);
	}
	public Comparator pesoC = new Comparator (){
		public int compare (Object p1, Object p2){
			double pf1, pf2;
			pf2 = ((PessoaIMC)p2).getPeso();
			pf1 = ((PessoaIMC)p1).getPeso();
			return (int)Math.round(pf2 - pf1);
		}
	};
	public Comparator alturaC = new Comparator (){
		public int compare(Object p1, Object p2){
			double alt1, alt2;
			alt2 = ((PessoaIMC)p2).getAltura();
			alt1 = ((PessoaIMC)p1).getAltura();
			return (int)Math.round(alt2 - alt1);
		}
	};
	public Comparator imcC = new Comparator (){
		public int compare(Object p1, Object p2){
			double imc1, imc2;
			imc2 = ((PessoaIMC)p2).getIMC();
			imc1 = ((PessoaIMC)p1).getIMC();
			return (int)Math.round(imc2 - imc1);
		}
	};
	public Comparator nomeC = new Comparator(){
		public int compare(Object p1, Object p2){
			String nome1, nome2;
			nome2 = ((PessoaIMC)p2).getName();
			nome1 = ((PessoaIMC)p1).getName();
			return nome1.compareTo(nome2);
		}
	};
	public ArrayList ordena(int criterio){
		switch(criterio){
			case 1:
				Collections.sort(pessoas, nomeC);
			case 2:
				Collections.sort(pessoas, nomeC.reversed());
			case 3:
				Collections.sort(pessoas, pesoC);
			case 4: 
				Collections.sort(pessoas, alturaC.reversed());
			case 5:
				Collections.sort(pessoas, imcC);
			default:
		}
		return pessoas;
	}
}
public class Ex1{
	public static void main(String[] args){
		String opcao1, opcao2;
		int escolha1, escolha2;
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		MinhaListaOrdenavel lista = new MinhaListaOrdenavel();
		ArrayList <PessoaIMC> pessoas = new ArrayList <PessoaIMC>();
		Homem p1 = new Homem("Lucas", "22/11/1999", 74.0, 1.78);
		lista.addP(p1);
		Mulher p2 = new Mulher("Ana", "19/01/2012", 30.0, 1.31);
		lista.addP(p2);
		Homem p3 = new Homem("Marcello", "01/08/1972", 115.0, 1.83);
		lista.addP(p3);
		Mulher p4 = new Mulher("Elaine", "22/02/1976", 85.0, 1.61);
		lista.addP(p4);
		Homem p5 = new Homem("Celso", "03/06/1942", 60.0, 1.65);
		lista.addP(p5);
		Homem p6 = new Homem("Fabio", "21/01/1981", 100.0, 1.80);
		lista.addP(p6);
		Mulher p7 = new Mulher("Andrea", "18/10/1978", 74.0, 1.63);
		lista.addP(p7);
		Homem p8 = new Homem("Henrique", "01/01/2012", 23.0, 1.20);
		lista.addP(p8);
		Mulher p9 = new Mulher("Solange", "10/05/1950", 80.0, 1.55);
		lista.addP(p9);
		Mulher p10 = new Mulher("Adriana", "06/11/1974", 55.0, 1.65);
		lista.addP(p10);
		System.out.println("--------------------------MENU------------------------\n");
		System.out.println("                 1. Imprimir Lista");
		System.out.println("                 2. Sair");
		try{
			System.out.print("\nDigite sua opcao: ");
			opcao1 = inData.readLine();
			escolha1 = Integer.parseInt(opcao1);
			if(escolha1 == 1){
				System.out.println("----------ESCOLHA SEU MODO DE ORDENACAO----------\n");
				System.out.println("               1. Alfabetica (A - Z)");
				System.out.println("               2. Alfabetica (Z - A)");
				System.out.println("               3. Menor Peso");
				System.out.println("               4. Maior Altura");
				System.out.println("               5. Menor IMC");
				System.out.print("\nDigite sua opcao: ");
				opcao2 = inData.readLine();
				escolha2 = Integer.parseInt(opcao2);
				pessoas = lista.ordena(escolha2);
				System.out.println(pessoas);
			}
		}
		catch(IOException e){
			System.out.println("Algo de errado nao esta' certo! =(");
		}
	}
}
