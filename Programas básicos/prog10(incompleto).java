import java.io.*;
import java.lang.Math;

class ErroParametro extends Exception{
	public ErroParametro(){
		super("Numero de  parametros e' excessivo!");
	}
}
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
			return "Arco: "+ String.format("%.2f", arcoRad) + "\nSeno: " + String.format("%.2f", sen) + "\nCosseno: " + String.format("%.2f", cos) + "\nTangente: INEXISTENTE\nCotangente: INEXISTENTE\n";
		}
		else if((ang==0)||(ang%180 == 0)){
			return "Arco: " + String.format("%.2f", arcoRad) + "\nSeno: " + String.format("%.2f", sen) + "\nCosseno: " + String.format("%.2f", cos) + "\nTangente: " + String.format("%.2f", tan) + "\nCotangente: INEXISTENTE\n";
		}
		else{
			return "Arco: " + String.format("%.2f", arcoRad) + "\nSeno: " + String.format("%.2f", sen) + "\nCosseno: " + String.format("%.2f", cos) + "\nTangente: " + String.format("%.2f", tan) + "\nCotangente: " + String.format("%.2f", cotan) + "\n";
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
			int contador = 0;
			System.out.print("Digite o numero de angulos: ");
			num = inData.readLine();
			max = Integer.parseInt(num);
			for(i = 0; i < num.length(); i++){
				if(num.charAt(i) == ' '){
					contador++;
				}
			}
			if(contador == 0){
				for(i=0; i<max; i++){
					int cont = 0;
					System.out.printf("Digite o angulo [%d]: ",i+1);
					angs = inData.readLine();
					for(i = 0; i < num.length(); i++){
						if(num.charAt(i) == ' '){
							cont++;
						}
					}
					if(cont == 0){
						angulo = Double.parseDouble(angs);
						AnguloObj ang = new AnguloObj(angulo);
						radiano = ang.converteAngulo();
						seno = ang.funcaoSeno();
						cosseno = ang.funcaoCosseno();
						tangente = ang.funcaoTangente();
						cotangente = ang.funcaoCotangente();
						System.out.print(ang.toString());
					}
					else{
						throw new ErroParametro();
					}
				}
			}
			else{
				throw new ErroParametro();
			}
		}
		catch(ErroParametro e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println("Caracter nao numerico detectado");
		}
	}
}
