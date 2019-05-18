import java.io.*;
import java.lang.Math;

class AnguloObj{
	private double arcoRad;
	double sen, cos, tan, cotan, ang;
	
	public AnguloObj(double a){
		this.arcoRad = Math.toRadians(a);
		this.ang = a;
	}
	public double converteAngulo(){
		return arcoRad;
	}
	public double funcaoSeno(){
		this.sen = Math.sin(arcoRad);
		return sen;
	}
	public double funcaoCosseno(){
		this.cos = Math.cos(arcoRad);
		return cos;
	}
	public double funcaoTangente(){
		this.tan = Math.tan(arcoRad);
		return tan;
	}
	public double funcaoCotangente(){
		this.cotan = 1/(Math.tan(arcoRad));
		return cotan;
	}
	public String toString(){
		if((ang%90 == 0)&&(ang%180 != 0)){
			return "Arco: "+ this.arcoRad+ "\nSeno: " + this.sen + "\nCosseno: " + this.cos + "\nTangente: INEXISTENTE\nCotangente: INEXISTENTE";
		}
		else if((ang==0)||(ang%180 == 0)){
			return "Arco: " + this.arcoRad + "\nSeno: " + this.sen + "\nCosseno: " + this.cos + "\nTangente: " + this.tan + "\nCotangente: INEXISTENTE";
		}
		else{
			return "Arco: " + this.arcoRad + "\nSeno: " + this.sen + "\nCosseno: " + this.cos + "\nTangente: " + this.tan + "\nCotangente: " + this.cotan;
		}
	}
}
public class Ex3{
	public static void main(String[] args){
		double angulo,seno,cosseno,tangente,cotangente,radiano;
		int i, max;
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		String angs, num;
		try{
			System.out.print("Digite o numero de angulos: ");
			num = inData.readLine();
			max = Integer.parseInt(num);
			for(i=0; i<max; i++){
				System.out.printf("Digite o angulo [%d]: ");
				angs = inData.readLine();
				angulo = Double.parseDouble(angs);
				AnguloObj ang = new AnguloObj(angulo);
				radiano = ang.converteAngulo();
				seno = ang.funcaoSeno();
				cosseno = ang.funcaoCosseno();
				tangente = ang.funcaoTangente();
				cotangente = ang.funcaoCotangente();
				System.out.print(ang.toString());
			}
		}
		catch(Exception e){
			System.out.println("O caracter digitado e' invalido");
		}
	}
}
