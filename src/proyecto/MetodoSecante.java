package proyecto;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MetodoSecante {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);


		System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
				+ "En sistemas computacionales");
		System.out.println();
		System.out.println("Trujillo Acosta Bryant\nMétodo de la Secante.Raices de una Ecuación\nDe 13:00 a 14:00 horas");
		System.out.println();
		System.out.println("Este programa ejecuta el proceso de cálculo de raices de una ecuacion metodo de la secante");
		System.out.println();
		System.out.println("Cuál es la pregunta del problema?");
		String problema = entrada.nextLine();
		System.out.println();


		System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
				+ "En sistemas computacionales");
		System.out.println();
		System.out.println("Trujillo Acosta Bryant\nRaices de una Ecuación.Método de la secante.\nDe 13:00 a 14:00 horas");
		System.out.println("Pregunta:"+problema);
		double X1=10; 
		double X2 = 20;
		double Error = 0.00001;
		int TC=50;
		DecimalFormat df1 = new DecimalFormat("#0.000000");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("Nc\tX1\t\tF(X1)\t\tX2\t\tF(X2)\t\tX3\t\tF(X3)");
		System.out.println("------------------------------------------------------------------------------------------------------");
		int NC=1;
		double Fx1= (Math.pow(X1, 4))-(6*Math.pow(X1, 3))+(12*Math.pow(X1, 2))-(10*X1)+3;
		double Fx2= (Math.pow(X2, 4))-(6*Math.pow(X2, 3))+(12*Math.pow(X2, 2))-(10*X2)+3;
		double X3;
		double Fx3;
		do {
			X3 =X1 -((X1-X2)*Fx1)/(Fx1-Fx2);
			Fx3= (Math.pow(X3, 4))-(6*Math.pow(X3, 3))+(12*Math.pow(X3, 2))-(10*X3)+3;
			System.out.println(NC+"\t"+df1.format(X1)+"\t"+df1.format(Fx1)+"\t"+df1.format (X2)+"\t"+df1.format(Fx2)+"\t"+df1.format(X3)+"\t"+df1.format(Fx3));
			NC+=1;
			X1=X2;
			X2=X3;
			Fx1=Fx2;
			Fx2=Fx3;

		}while(Math.abs(Fx3)>Error&&NC<TC);
		System.out.println("------------------------------------------------------------------------------------------------------");
		if(NC>TC) {
			System.out.println("No se encontró raiz");
		}
		else {
			System.out.println("La Raiz de la Ecuacion = "+df1.format(X3));
		}
		System.out.println();


	}

}

