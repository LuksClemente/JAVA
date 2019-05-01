import java.io.*;
import java.lang.Math;

class Calculadora{
	private static float Calcula(float r){
		double s = Math.pow(r,2)*3.14159265359;
		float area = (float)s;
		return area;
	}
	private static float Calcula(float b, float a){
		float area = b*a;
		return area;
	}
	private static float Calcula(float l1,float l2, float l3){
		float p = (l1+l2+l3)/2;
		double s = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
		float area = (float)s;
		return area;
	}
	public static void main(String[] args){
		Calculadora c = new Calculadora();
		float raio,altura,base,lado1,lado2,lado3,areas;
		if(args.length == 1){
			raio = Float.parseFloat(args[0]);
			areas = c.Calcula(raio);
			System.out.printf("Area do circulo: %.2f unidades de area\n", areas);
		}
		else if(args.length == 2){
			altura = Float.parseFloat(args[0]);
			base = Float.parseFloat(args[1]);
			areas = c.Calcula(base, altura);
			System.out.printf("Area do retangulo: %.2f unidades de area\n", areas);
		}
		else if(args.length == 3){
			lado1 = Float.parseFloat(args[0]);
			lado2 = Float.parseFloat(args[1]);
			lado3 = Float.parseFloat(args[2]);
			areas = c.Calcula(lado1, lado2, lado3);
			System.out.printf("Area do triangulo: %.2f unidades de area\n", areas);
			if((lado1 == lado2)&&(lado2 == lado3)){
				System.out.println("O triangulo e' equilatero!");
			}
			else if((lado1 == lado2)||(lado2 == lado3)||(lado3 == lado1)){
				System.out.println("O triangulo e' isosceles");
			}
			else{
				System.out.println("O triangulo e' escaleno");
			}
		}
	}
}
