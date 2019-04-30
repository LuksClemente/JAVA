import java.io.*;
import java.lang.Math;

class Calculadora{
	private static float Calcula(float r){
		float area = (Math.pow(r,2))*3.14159265359;
		return area;
	}
	private static float Calcula(float b, float a){
		float area = b*a;
		return area;
	}
	private static float Calcula(float l1,float l2, float l3){
		float p = (l1+l2+l3)/2;
		float area = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
		return area;
	}
}
public class Areas{
	public static void main(String[] args){
		Calculadora c = new Calculadora();
		float r,a,b,l1,l2,l3,area;
		if(args.length == 1){
			r = Float.parseFloat(args[0]);
			area = c.Calcula(r);
			System.out.printf("Area do circulo: %f\n", area);
		}
		else if(args.length == 2){
			a = Float.parseFloat(args[0]);
			b = Float.parseFloat(args[1]);
			area = c.Calcula(b, a);
			System.out.printf("Area do retangulo: %f\n", area);
		}
		else if(args.length == 3){
			l1 = Float.parseFloat(args[0]);
			l2 = Float.parseFloat(args[1]);
			l3 = Float.parseFloat(args[2]);
			area = c.Calcula(l1, l2, l3);
			System.out.print("Area do triangulo: %f\n", area);
			if((l1 == l2)&&(l2 == l3)){
				System.out.println("O triangulo eh equilatero!");
			}
			else if((l1 == l2)||(l2 == l3)||(l3 == l1)){
				System.out.println("O triangulo eh isosceles");
			}
			else{
				System.out.println("O triangulo eh escaleno");
			}
		}
	}
}
