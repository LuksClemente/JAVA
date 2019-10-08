class Usuario extends Pessoa{
	String endereco;
	int codigoUsuario;
	
	public Usuario(String name, GregorianCalendar date, String end, int code){
		super(name, date);
		this.endereco = end;
		this.codigoUsuario = code;
	}
	class Emprestimo{
		GregorianCalendar dataEmp;
		GregorianCalendar dataDev;
		String codigoLivro;
		
		public Emprestimo(GregorianCalendar demp, GregorianCalendar ddev, String codliv){
			this.dataEmp = demp;
			this.dataDev = ddev;
			this.codigoLivro = codliv;
		}
		public String toString(){
			return "\nData de Emprestimo: " + dataEmp + "\nData de devolucao: " + dataDev + "\nCodigo do livro: " + codigoLivro;
		}
	}
	Collection <Emprestimo> Historico = new ArrayList <Emprestimo> ();
	
	public void addLivroHist(GregorianCalendar demp, GregorianCalendar ddev, String codliv){
		Emprestimo emprestimo = new Emprestimo(demp, ddev, codliv);
		Historico.add(emprestimo);
	}
	public String getEndereco(){
		return endereco;
	}
	public int getUserCode(){
		return codigoUsuario;
	}
	public String toString(){
		return super.toString() + "\nEndereco: " + endereco + "\nCodigo de Usuario: " + codigoUsuario + "Historico:\n\n" + Historico;
	}
}
