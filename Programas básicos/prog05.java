import java.lang.String;

class Automovel{
	public String modelo;
	public int ano;
	private boolean ligado;
	
	public Automovel(String m, int a){
		modelo = m;
		ano = a;
		ligado = false;
	}
	
	public void liga(){
		ligado = true;
	}
	
	public void desliga(){
		ligado = false;
	}
}

class Motorista{
	private String nome;
	private Automovel carro;
	
	public Motorista(String n, Automovel a){
		nome = n;
		carro = a;
	}
	
	public String obterNome(){
		return nome;
	}
	
	public Automovel obterCarro(){
		return carro;
	}
}
class MeuPrograma{
	public static void main(String args[]){
		Automovel carro1;
		Motorista motorista1, motorista2;
		carro1 = new Automovel("Chevette", 87);
		motorista1= new Motorista("Joao", carro1);
		motorista2 = new Motorista("Pedro", carro1);
		
		System.out.println(motorista1.obterNome());
		System.out.println(motorista2.obterNome());
	}
}
