import java.io.*;
import java.lang.Math;

class Angulo{
	public double converteAngulo(double a){
		double rad = Math.toRadians(a);
		return rad;
	}
	public double funcaoSeno(double rad){
		double sen = Math.sin(rad);
		return sen;
	}
	public double funcaoCosseno(double rad){
		double cos = Math.cos(rad);
		return cos;
	}
	public double funcaoTangente(double rad){
		double tan = Math.tan(rad);
		return tan;
	}
	public double funcaoCotangente(double rad){
		double cotan = 1/(Math.tan(rad));
		return cotan;
	}
}
public class Ex2{
	public static void main(String[] args){
		double angulo,seno,cosseno,tangente,cotangente,radiano;
		Angulo ang = new Angulo();
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		String angs;
		try{
			if(args.length == 1){
				angulo = Double.parseDouble(args[0]);
				radiano = ang.converteAngulo(angulo);
				seno = ang.funcaoSeno(radiano);
				cosseno = ang.funcaoCosseno(radiano);
				tangente = ang.funcaoTangente(radiano);
				cotangente = ang.funcaoCotangente(radiano);
				if((angulo%90 == 0)&&(angulo%180 != 0)){
					System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: INEXISTENTE\nCotangente: %.2f\n", seno, cosseno, cotangente);
				}
				else if((angulo == 0)||(angulo%180 ==0)){
					System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: %.2f\nCotangente: INEXISTENTE\n", seno, cosseno,tangente);
				}
				else{
					System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: %.2f\nCotangente: %.2f\n", seno, cosseno, tangente, cotangente);
				}
			}
			else if (args.length > 1){
				System.out.println("Voce so' pode passar um unico angulo! =(");
			}
			System.out.print("Digite um novo angulo(em graus): ");
			angs = inData.readLine();
			int contador = 0, i;
			while(/*!line.isEmpty()*/!angs.equals("")){
				for(i = 0; i < angs.length(); i++){
					if(angs.charAt(i) == ' '){
						contador++;
					}
				}
				if(contador == 0){
					angulo = Double.parseDouble(angs);
					radiano = ang.converteAngulo(angulo);
					seno = ang.funcaoSeno(radiano);
					cosseno = ang.funcaoCosseno(radiano);
					tangente = ang.funcaoTangente(radiano);
					cotangente = ang.funcaoCotangente(radiano);
					if((angulo%90 == 0)&&(angulo%180 != 0)){
						System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: INEXISTENTE\nCotangente: %.2f\n", seno, cosseno, cotangente);
					}
					else if((angulo == 0)||(angulo%180 ==0)){
						System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: %.2f\nCotangente: INEXISTENTE\n", seno, cosseno,tangente);
					}
					else{
						System.out.printf("Seno: %.2f\nCosseno: %.2f\nTangente: %.2f\nCotangente: %.2f\n", seno, cosseno, tangente, cotangente);
					}
				}
				else if(contador >= 1){
					System.out.println("Voce so' pode passar um unico angulo! =(");
				}
				System.out.print("Digite um novo angulo(em graus): ");
				angs = inData.readLine();
			}
		}
		catch(Exception e){
			System.out.println("O caracter digitado e' invalido! =(");
		}
	}
}
