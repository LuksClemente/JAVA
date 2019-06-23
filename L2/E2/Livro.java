class Livro{
	String codigoLivro;
	String tituloLivro;
	String categoria;
	int qtd;
	int emprestados;
	
	public Livro(String codliv, String titliv, String catg, int quant, int emp){
		this.codigoLivro = codliv;
		this.tituloLivro = titliv;
		this.categoria = catg;
		this.qtd = quant;
		this.emprestados = emp;
	}
	class EmprestadoPara{
		GregorianCalendar dataEmp;
		GregorianCalendar dataDev;
		String codigoLivro;
		
		public EmprestadoPara(GregorianCalendar demp, GregorianCalendar ddev, String codliv){
			this.dataEmp = demp;
			this.dataDev = ddev;
			this.codigoLivro = codliv;
		}
		public String toString(){
			return "\nData de Emprestimo: " + dataEmp + "\nData de devolucao: " + dataDev + "\nCodigo do livro: " + codigoLivro;
		}
	}
	public void empresta(){
		if (qtd == emprestados){
			throw new CopiaNaoDisponivelEx();
		}
	}
	public void devolve(){
		throw new NenhumaCopiaEmprestadaEx();
	}
	Collection <EmprestadoPara> Historico = new ArrayList <EmprestadoPara> ();
	
	public void addUsuarioHist(GregorianCalendar demp, GregorianCalendar ddev, String codliv){
		EmprestadoPara user = new EmprestadoPara(demp, ddev, codliv);
		Historico.add(user);
	}
	public String toString(){
		return "\nCodigo do Livro: " + codigoLivro + "\nTitulo do Livro: " + tituloLivro + "\nCategoria: " + categoria + "\nQuantidade: " + qtd + "\nEmprestados: " + emprestados + "\nHistorico:\n\n" + Historico;		
	}
	public String getBookCode(){
		return codigoLivro;
	}
	public String getBookTitle(){
		return tituloLivro;
	}
	public String getCategorie(){
		return categoria;
	}
	public int getQtd(){
		return qtd;
	}
	public int getEmprestados(){
		return emprestados;
	}
}
