package metodoTrapecio;
import java.text.DecimalFormat;
import java.util.Scanner;
public class metodoTrapecios {
	

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		//encabezado
		System.out.println("\t\t Instituto Tecnológico de Culiacán");
		System.out.println("\t\t Ing. En Sistemas Computacionales\n");
		System.out.println("Trujillo Acosta Bryant");
		System.out.println("Integracion Numerica");
		System.out.println("Metodo de los Trapecios");
		System.out.println("De 13:00 a 14:00 horas.");
		System.out.println("Este proceso realiza el cálculo de una integral definidad\n"
				+ "utilizando el método de los trapecios con la siguiente\n"
				+ "información");
		//captura de datos del problema
		System.out.println("Cual es la pregunta del problema");
		String pregunta = entrada.nextLine();
		System.out.println("¿Cual es el valor real?");
		double vr = entrada.nextDouble();
		System.out.println("¿Cual es la unidad de medida?");
		String unidad = entrada.next();
		System.out.println("Punto inicial del intervalo");
		double a = entrada.nextDouble();
		System.out.println("Punto final del intervalo");
		double b = entrada.nextDouble();
		System.out.println("Numero de trapecio inicial");
		int n = entrada.nextInt();
		System.out.println("error");
		double error = entrada.nextDouble();
		System.out.println("Total de procesos");
		int tp = entrada.nextInt();
		int Np=0;
		double ca=a;
		//impresion del ecabezado del informe
		Np = Np+1;
		double Vcalc = 0;
		double h =(b-a)/n;
		DecimalFormat df = new DecimalFormat("0.000000");
		Encabezado();
        System.out.println("Pregunta: "+ pregunta);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Trapecio  a"+"\t\ta+h"+"\t\tf(a)"+"\t\tf(a+h)"+"\t\tArea");
		System.out.println("------------------------------------------------------------------------------------------");
	   for(int x=1; x<=n; x++) {
		   double ah = a+h;
		   double fa = (2+(Math.sin(2*Math.sqrt(a))));
		   double fah=(2+(Math.sin(2*Math.sqrt(ah))));
		   double Area =((h/2)*(fa+fah));
		   Vcalc = Vcalc + Area;
		   System.out.println(x+"\t"+(df.format(a))+"\t"+(df.format(ah))+"\t"+(df.format(fa))+"\t"+(df.format(fah))+"\t"+(df.format(Area)));
		   a=ah;
	   }
	   
	   double ErrorP = Math.abs(vr-Vcalc);
	   if(ErrorP<=error) {
		   System.out.println("-----------------------------");
		   System.out.println("Resultados:");
		   System.out.println("-----------------------------");
		   System.out.println("No.De Procesos = "+tp);
		   System.out.println("Valor Real de la integral = "+(df.format(vr))+" "+ unidad);
		   System.out.println("valor calculado por trapecios = "+(df.format(Vcalc))+" "+unidad);
		   System.out.println("Error del problema = "+error +" "+unidad);
		   System.out.println("Error del metodo = "+(df.format(ErrorP))+" "+ unidad);
	   }if(Np == tp) {
		   System.out.println("-----------------------------");
		   System.out.println("Resultados:");
		   System.out.println("-----------------------------");
		   System.out.println("La mejor aprox. no se ha encontrado en "+tp+" Procesos");
		   
	   }else
		   a=ca;
	       n=n*2;
	}
	public static void Encabezado() {
		System.out.println("\t\t Instituto Tecnológico de Culiacán");
		System.out.println("\t\t Ing. En Sistemas Computacionales\n");
		System.out.println("Trujillo Acosta Bryant");
		System.out.println("Integracion Numerica");
		System.out.println("Metodo de los Trapecios");
		System.out.println("De 13:00 a 14:00 horas.");
		}
}
