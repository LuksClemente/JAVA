import java.io.*;
import java.lang.Math;

class MuitosParametros extends Exception{
	public MuitosParametros(){
		super("Numero de parametros excessivo! =(");
	}
}
class NenhumParametro extends Exception{
	public NenhumParametro(){
		super("Nenhum parametro informado! =(");
	}
}
class NumberFormatException extends Exception{
	public NumberFormatException(){
		super("Erro formatacao de parametro! =(");
	}
}
class AnguloObj{
	private double arcoRad;
	double sen, cos, tan, cotan, ang;
	
	public AnguloObj(double a) throws NumberFormatException{
		this.arcoRad = Math.toRadians(a);
		this.ang = a;
	}
	public double converteAngulo(){
		return arcoRad;
	}
	public double funcaoSeno(){
		return Math.sin(arcoRad);
		
	}
	public double funcaoCosseno(){
		return Math.cos(arcoRad);
	}
	public double funcaoTangente(){
		return Math.tan(arcoRad);
	}
	public double funcaoCotangente(){
		return 1/(Math.tan(arcoRad));
	}
	public String toString(){
		if((ang%90 == 0)&&(ang%180 != 0)){
			return "Arco: "+ String.format("%.2f", converteAngulo()) + "\nSeno: " + String.format("%.2f", funcaoSeno()) + "\nCosseno: " + String.format("%.2f", funcaoCosseno()) + "\nTangente: INEXISTENTE\nCotangente: INEXISTENTE\n";
		}
		else if((ang==0)||(ang%180 == 0)){
			return "Arco: " + String.format("%.2f", converteAngulo()) + "\nSeno: " + String.format("%.2f", funcaoSeno()) + "\nCosseno: " + String.format("%.2f", funcaoCosseno()) + "\nTangente: " + String.format("%.2f", funcaoTangente()) + "\nCotangente: INEXISTENTE\n";
		}
		else{
			return "Arco: " + String.format("%.2f", arcoRad) + "\nSeno: " + String.format("%.2f", funcaoSeno()) + "\nCosseno: " + String.format("%.2f", funcaoCosseno()) + "\nTangente: " + String.format("%.2f", funcaoTangente()) + "\nCotangente: " + String.format("%.2f", funcaoCotangente()) + "\n";
		}
	}
}
public class Ex3{
	public static void main(String[] args){
		int max, i, j, contador = 0;
		double angle;
		String input = new String();
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.print("Digite o numero de angulos: ");
			input = inData.readLine();
			for(i = 0; i < input.length(); i++){
				if(input.charAt(i) == ' '){
					contador++;
				}
			}
			if(contador > 0){
				throw new MuitosParametros();
			}
			else if(input.equals("") == true){
				throw new NenhumParametro();
			}
			max = Integer.parseInt(input);
			AnguloObj[] angulosvet = new AnguloObj[max];
			for (i = 0; i < max ; i++){
				System.out.printf("Digite o angulo[%d]: ", i+1);
				input = inData.readLine();
				for(j = 0; j < input.length(); j++){
					if(input.charAt(j) == ' '){
						contador++;
					}
				}
				if(contador > 0){
					throw new MuitosParametros();
				}
				else if(input.equals("") == true){
					throw new NenhumParametro();
				}
				angle = Double.parseDouble(input);
				angulosvet[i] = new AnguloObj(angle);
			}
			System.out.println("==========RESULTADO==========");
			for (i = 0 ; i < max; i++){
				System.out.println(angulosvet[i]);
			}
		}
		catch(MuitosParametros e){
			System.out.println(e);
		}
		catch(NenhumParametro e){
			System.out.println(e);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println("Parametro inserido nao e' numerico! =(");
		}
	}
}
