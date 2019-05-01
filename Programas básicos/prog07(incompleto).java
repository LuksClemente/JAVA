import java.io.*;
import java.lang.Math;

class ErroTriangulo extends Exception{
	public ErroTriangulo(){
		super("Nao foi possivel formar um triangulo! =(");
	}
}
class ErroNegativoNulo extends Exception{
	public ErroNegativoNulo(){
		super("Nao e' possivel utilizar parametros negativos/nulos! =(");
	}
}
public class Ex1{
	private static float calcula(float r){
		double s = Math.pow(r,2)*3.14159265359;
		float area = (float)s;
		return area;
	}
	private static float calcula(float b, float a){
		float area = b*a;
		return area;
	}
	private static float calcula(float l1,float l2, float l3) throws ErroTriangulo{
		if ((Math.abs(l2-l3)<l1) && (l1<l2+l3) && (Math.abs(l1-l3)<l2) && (l2<l3+l1) && (Math.abs(l1-l2)<l3) && (l3<l1+l2)){
			float p = (l1+l2+l3)/2;
			double s = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
			float area = (float)s;
			return area;
		}
		else{
			throw new ErroTriangulo();
		}
	}
	private static void triangulo(float l1, float l2, float l3){
		if((l1 == l2)&&(l2 == l3)){
			System.out.println("O triangulo e' equilatero!");
		}
		else if((l1 == l2)||(l2 == l3)||(l3 == l1)){
			System.out.println("O triangulo e' isosceles");
		}
		else{
			System.out.println("O triangulo e' escaleno");
		}
	}		
	public static void main(String[] args){
		Ex1 c = new Ex1();
		float raio,altura,base,lado1,lado2,lado3,areas;
		try{
			if(args.length == 1){
				raio = Float.parseFloat(args[0]);
				if (raio > 0){
					areas = c.calcula(raio);
					System.out.printf("Area do circulo: %.2f unidades de area\n", areas);
				}
				else{
					throw new ErroNegativoNulo();
				}
			}
			else if(args.length == 2){
				altura = Float.parseFloat(args[0]);
				base = Float.parseFloat(args[1]);
				if((base > 0) && (altura > 0)){
					areas = c.calcula(base, altura);
					System.out.printf("Area do retangulo: %.2f unidades de area\n", areas);
				}
				else{
					throw new ErroNegativoNulo();
				}
			}
			else if(args.length == 3){
				lado1 = Float.parseFloat(args[0]);
				lado2 = Float.parseFloat(args[1]);
				lado3 = Float.parseFloat(args[2]);
				if((lado1 > 0) && (lado2 >0) && (lado3 > 0)){
					areas = c.calcula(lado1, lado2, lado3);
					System.out.printf("Area do triangulo: %.2f unidades de area\n", areas);
					c.triangulo(lado1, lado2, lado3);
				}
				else{
					throw new ErroNegativoNulo();
				}
			}
			else if(args.length < 1){
				System.out.println("Numero de argumentos insuficiente! =(");
			}
			else{
				System.out.println("Numero de argumentos excessivo! =(");
			}
		}
		catch(ErroTriangulo e){
			System.out.println(e);
		}
		catch(ErroNegativoNulo e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println("Detectado parametro que nao e' numero");
		}
	}
}
