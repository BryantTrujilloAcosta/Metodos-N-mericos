package proyecto;


import java.util.Scanner;
import java.text.DecimalFormat;


public class Examen1 {

	public static void main(String[] args) {
	Scanner entrada = new Scanner (System.in);
	boolean salir = false;
	String opcion;
	
		System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
				+ "En sistemas computacionales");
		System.out.println();
		System.out.println("Trujillo Acosta Bryant\nMétodo de Newton Raphson.Raices de una Ecuación\nDe 13:00 a 14:00 horas");
		System.out.println();
		System.out.println("Este programa ejecuta el proceso de cálculo de raices de una ecuacion\nutilizando el metodo de newton raphson "
				+ "y metodo de la secante");
		System.out.println();
		System.out.println("Cuál es la pregunta del problema?");
		String problema = entrada.nextLine();
		System.out.println();
		while (!salir) {
		try {
			System.out.println("a) Metodo Newton Raphson");
			System.out.println("b) Metodo de la secante");
			System.out.println("c) finalizar el programa");
			System.out.println("Elige una de las opciones");
			opcion = entrada.next();
			switch (opcion) {
			case "a":
				System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
						+ "En sistemas computacionales");
				System.out.println();
				System.out.println("Trujillo Acosta Bryant\nRaices de una Ecuación.Método de Newton Raphson\nDe 13:00 a 14:00 horas");
			    System.out.println("Pregunta:"+problema);
			    DecimalFormat df = new DecimalFormat("#0.000000");
			    double x1 = 200;
			    double error = 0.00001;
			    int tc = 100;
			    System.out.println("------------------------------------------------------------------------------------------------------");
			    System.out.println("N\tX1\t\tF(X1)\t\t\tF'(X1)\t\tX2\t\tF(X2)");
			    System.out.println("------------------------------------------------------------------------------------------------------");
			    
			    int nc=1;
			    double fx1 = (Math.pow(x1, 3))+(3.5*Math.pow(x1, 2))-40;
			    double derivada;
			    double x2 ;
			    double fx2 ;
			    do {
			    	 derivada = (3*Math.pow(x1, 2))+(7*x1);
				     x2 = x1-(fx1/derivada);
				     fx2 = (Math.pow(x2, 3))+(3.5*Math.pow(x2, 2))-40;
			    	System.out.println((nc)+"\t"+df.format(x1)+"\t"+df.format(fx1)+"\t\t"+df.format(derivada)+"\t"+df.format(x2)+"\t"+df.format(fx2));   
			    	nc+=1;
			    	x1=x2;
			    	fx1=fx2;
			    }while(Math.abs(fx2)>error&&nc<tc);
			    System.out.println("------------------------------------------------------------------------------------------------------");
		        if(nc>100) {
		        	System.out.println("No se encontró raiz");
		        }
		        else {
		        	System.out.println("La concentración del ion de hidrogeno para una solución saturada = "+df.format(x2));
			   
			}
			 System.out.println();
			    break;
			
			case "b":
				System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
						+ "En sistemas computacionales");
				System.out.println();
				System.out.println("Trujillo Acosta Bryant\nRaices de una Ecuación.Método de la secante.\nDe 13:00 a 14:00 horas");
				System.out.println("Pregunta:"+problema);
			    double X1=60; 
			    double X2 = 70;
			    double Error = 0.00001;
			    int TC=100;
			    DecimalFormat df1 = new DecimalFormat("#0.000000");
			    System.out.println("------------------------------------------------------------------------------------------------------");
			    System.out.println("Nc\tX1\t\tF(X1)\t\tX2\t\tF(X2)\t\tX3\t\tF(X3)");
			    System.out.println("------------------------------------------------------------------------------------------------------");
			    int NC=1;
			    double Fx1= (Math.pow(X1, 3))+(3.5*Math.pow(X1, 2))-40;
			    double Fx2= (Math.pow(X2, 3))+(3.5*Math.pow(X2, 2))-40;
			    double X3;
			    double Fx3;
			   do {
				    X3 =X1 -((X1-X2)*Fx1)/(Fx1-Fx2);
				    Fx3 =(Math.pow(X3, 3))+(3.5*Math.pow(X3, 2))-40;
				    System.out.println(NC+"\t"+df1.format(X1)+"\t"+df1.format(Fx1)+"\t"+df1.format (X2)+"\t"+df1.format(Fx2)+"\t"+df1.format(X3)+"\t"+df1.format(Fx3));
				    NC+=1;
				    X1=X2;
				    X2=X3;
				    Fx1=Fx2;
				    Fx2=Fx3;
				   
			   }while(Math.abs(Fx3)>Error&&NC<TC);
			   System.out.println("------------------------------------------------------------------------------------------------------");
			   if(NC>100) {
		        	System.out.println("No se encontró raiz");
		        }
		        else {
		        	System.out.println("La concentración del ion de hidrogeno para una solución saturada = "+df1.format(X3));
		        }
			   System.out.println();
				break;
			case "c":
				salir = true;
				System.out.println("FIN DEL PROGRAMA");
				break;	
				default:
					System.out.println("Solo letras entre a y c en minúsculas " );
			
		}
	}catch (Exception e) {
        System.out.println("Debes insertar una letra");
        entrada.next();
	}
	}

}
}
