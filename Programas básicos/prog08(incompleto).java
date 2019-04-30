import java.io.*;

public interface CalcIntf{
	public int soma(int a,int b)throws ErrParEx;
	public int sub(int a, int b)throws ErrParEx;
	public double mult(double a, double b);
	public double div(double a, double b)throws Div0Ex;
}
public class ErrParEx extends Exception{
	ErrParEx(){
		super("Algum paramemetro esta incorreto");
	}
}
public class Div0Ex extends Exception{
	Div0Ex(){
		super("Nao eh possivel dividir por 0!");
	}
}
public class GelinhoCalculoso implements CalcIntf{
	
	public int soma(int a, int b)throws ErrParEx{
			if (a>100 || b>100){
				throw new ErrParEx();
			}
			return a+b;
	}
	public int sub(int a, int b)throws ErrParEx{
			if(b>a){
				throw new ErrParEx();
			}
			return a-b;
	}
	public double div(double a,double b)throws Div0Ex{
			if(b==0){
				throw new Div0Ex();
			}
			return a/b;
	}
	public double mult(double a,double b){
		return a*b;
	}
}
public class Calculadora{
	public static void main(String[] args){
		GelinhoCalculoso a= new GelinhoCalculoso();
		try{
			System.out.printf("%d\n", a.soma(3,0));
			System.out.printf("%d\n", a.soma(3,120));
		}catch(ErrParEx e){
			System.out.println(e);
		}
	}
}
