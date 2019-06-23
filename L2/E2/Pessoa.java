class Pessoa{
	public String nome;
	public GregorianCalendar dataNasc;
	
	public Pessoa(String nome, GregorianCalendar dataNasc){
		this.nome = nome;
		this.dataNasc = dataNasc;
	}
	public String toString(){
		return "\nNome: " + nome + "\nData de Nascimento: " + dataNasc;
	}
	public String getName(){
		return nome;
	}
	public GregorianCalendar getDataNasc(){
		return dataNasc;
	}
}
