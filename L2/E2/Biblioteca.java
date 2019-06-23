class Biblioteca implements Serializable{
	Hashtable <Integer, Usuario> cadastroUsuarios = new Hashtable <Integer, Usuario>();
	Hashtable <String, Livro> cadastroLivros = new Hashtable <String, Livro>();
	public Biblioteca(Hashtable cadastroU, Hashtable cadastroL){
		this.cadastroUsuarios = cadastroU;
		this.cadastroLivros = cadastroL;
	}
	public Biblioteca(File cadU, File cadL){
		try{
			ObjectInputStream objU = new ObjectInputStream(new FileInputStream (cadU));
			ObjectInputStream objL = new ObjectInputStream(new FileInputStream(cadL));
			cadastroUsuarios = (Hashtable <Integer, Usuario>) objU.readObject();
			cadastroLivros = (Hashtable <String, Livro>) objL.readObject();
			objU.close();
			objL.close();
		}
		catch (OptionalDataException e) {
			System.out.println("Argumento invalido! =(");
		}
		catch (StreamCorruptedException e) {
			System.out.println("Fluxo corrompido! =(");
		}
		catch(ClassNotFoundException e){
			System.out.println("Classe nao encontrada! =(");
		}
		catch (FileNotFoundException e) {
			System.out.println("Nao foi possivel encontrar o arquivo! =(");
		} 
		catch (InvalidClassException e) {
			System.out.println("Classe nao valida! =(");
		}
		catch(IOException e){
			System.out.println("Algo de errado nao esta' certo! =(");
		}
	}
	public void cadastraUsuario(Usuario u){
		cadastroUsuarios.put(u.getUserCode(), u);
	}
	public void cadastraLivro(Livro l){
		cadastroLivros.put(l.getBookTitle(), l);
	}
	
}
