package Simpson;
import java.util.Scanner;

public class Metodo_Simpson {

	public static void main(String[] args) {
		Scanner lee=new Scanner(System.in);
		double errorCalc=0, h , valorReal=0, valorCalc=0, limInf=0, limSup=0, n=0, x1=0, x2=0;
		String problema="", unidad="";
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Este Software aplica la Regla de Simpson de la siguiente funcion:f(x)=100+((8*sqrt(x)*1.0955");
		System.out.println("---------------------------------------------------------------------------------------------");
		// captura de datos
		System.out.print("Ingrese la pregunta del problema: ");
		problema=lee.nextLine();
		System.out.print("Valor Real: ");
		valorReal=lee.nextDouble();
		System.out.print("Limite Inferior: ");
		limInf=lee.nextDouble();
		System.out.print("Limite Superior: ");
		limSup=lee.nextDouble();
		System.out.print("Unidad de medida: ");
		unidad=lee.nextLine();
		unidad=lee.nextLine();
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("				      Metodo Reglas de Simpson");
		System.out.println("*Regla 1: n=2");
		System.out.println("*Regla 2: n=3");
		System.out.println("*Regla 3: n>2, n=par");
		System.out.println("*Regla 4: n>3, n=impar, n=*3");
		System.out.println("*FIN: n=0");
		do {
			System.out.print("¿Cuál es el número de divisiones? ");
			n=lee.nextDouble();
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------");	
			System.out.println("\nInstituto Tecnologico de Culiacán.");
			System.out.println("\nIng. en Sistemas.");
			System.out.println("Bryant Trujillo Acosta");
			System.out.println("Integracion Numerica - Metodo de Simpson.");
			System.out.println("De 13:00 - 14:00 horas.");
			System.out.println();
			System.out.println("Pregunta: "+problema);
			System.out.println("---------------------------------------------------------------------------------------------");	
			System.out.printf("%1s %15s %20s %15s %20s","pxy","x","Factor","f(x)","Area");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------");
			if(n==0) {
				System.out.println("Programa Finalizado");
				return;
			//la regla de Simpson de 1/3 con la formula sencilla.
			}
			if(n==2) {
				double fa, fb, fx1;
				h=(limSup-limInf)/n;
				x1=limInf+h;
				fa=Math.abs(100+(8*Math.sqrt(limInf)*1.0955));
				fb=Math.abs(100+(8*Math.sqrt(limSup)*1.0955));
				fx1=Math.abs(100+(8*Math.sqrt(x1)*1.0955));
				valorCalc=(h/3)*(fa+4*fx1+fb);
				errorCalc=Math.abs(valorReal-valorCalc);		
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",1,limInf,1,fa,fa);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",2,x1,4,fx1,4*fx1);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",3,limSup,1,fb,fb);	
			}
            //la regla de Simpson de 1/8 con la formula sencilla.
			if(n==3) {
				double fa, fb, fx1, fx2;
				h=(limSup-limInf)/n;
				x1=limInf+h;
				x2=limInf+2*h;
				fa=Math.abs(100+(8*Math.sqrt(limInf)*1.0955));
				fb=Math.abs(100+(8*Math.sqrt(limSup)*1.0955));
				fx1=Math.abs(100+(8*Math.sqrt(x1)*1.0955));
				fx2=Math.abs(100+(8*Math.sqrt(x2)*1.0955));
				valorCalc=(3*h/8)*(fa+3*fx1+3*fx2+fb);
				errorCalc=Math.abs(valorReal-valorCalc);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",1,limInf,1,fa,fa);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",2,x1,3,fx1,3*fx1);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",3,x2,3,fx2,3*fx2);
				System.out.printf("%1s %20.5f %15s %20.5f %20.5f\n",4,limSup,1,fb,fb);

			}
            //la regla de Simpson de 1/3 con la formula compleja.
			if(n>2 && n%2==0) {
				double x[]= new double[(int)n+1];
				double fx[]= new double[(int)n+1];
				x[0]=limInf;
				h=(limSup-limInf)/n;

				for(int i=1; i<x.length; i++) {
					x[i]=x[i-1]+(h);
				}
				for(int i=0; i<fx.length; i++) {
					if(i==0 || i==fx.length-1) {
						fx[i]=Math.abs(100+(8*Math.sqrt(x[i])*1.0955));
						valorCalc+=fx[i];
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],1,fx[i],fx[i]);
						continue;
					}
					if(i%2==1) {
						fx[i]=4*(Math.abs(100+(8*Math.sqrt(x[i])*1.0955)));
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],4,fx[i]/4,fx[i]);
					}else {
						fx[i]=2*(Math.abs(100+(8*Math.sqrt(x[i])*1.0955)));
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],2,fx[i]/2,fx[i]);
					}
					valorCalc+=fx[i];		
				}
				valorCalc=(1*h/3)*(valorCalc);
				errorCalc=Math.abs(valorReal-valorCalc);
			}
            //la regla de Simpson de 3/8 con la formula compleja.
			if(n>3 && n%2==1 && n%3==0) {
				double x[]= new double[(int)n+1];
				double fx[]= new double[(int)n+1];
				x[0]=limInf;
				h=(limSup-limInf)/n;

				for(int i=1; i<x.length; i++) {
					x[i]=x[i-1]+(h);
				}

				for(int i=0; i<fx.length; i++) {
					if(i==0 || i==fx.length-1) {
						fx[i]=Math.abs(100+(8*Math.sqrt(x[i])*1.0955));
						valorCalc+=fx[i];
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],1,fx[i],fx[i]);
						continue;
					}
					if(i<=(n-2) && ((i-1)%3==0 || i==1) ) {
						fx[i]=3*(Math.abs(100+(8*Math.sqrt(x[i])*1.0955)));
						valorCalc+=fx[i];
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],3,fx[i]/3,fx[i]);
						continue;
					}
					if(i<=(n-1) && ((i-2)%3==0 || i==2) ) {
						fx[i]=3*(Math.abs(100+(8*Math.sqrt(x[i])*1.0955)));
						valorCalc+=fx[i];
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],3,fx[i]/3,fx[i]);
						continue;
					}
					if(i<=(n-3) && i%3==0) {
						fx[i]=2*(Math.abs(100+(8*Math.sqrt(x[i])*1.0955)));
						valorCalc+=fx[i];
						System.out.printf("%s %20.5f %15s %20.5f %20.5f\n",i+1,x[i],2,fx[i]/2,fx[i]);
						continue;
					}
				}
				valorCalc=(3*(h/8))*(valorCalc);
				errorCalc=Math.abs(valorReal-valorCalc);
			}
			if(n%2!=0 && n%3!=0) {
				System.out.println("Simpson no aplica para este numero de divisiones.");
			}
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Numero de Divisiones: "+(int)n);
			System.out.printf("Valor Real de la Integral: %.5f %1s\n",valorReal,unidad);
			System.out.printf("Valor por el Metodo: %.5f %1s\n",valorCalc,unidad);
			System.out.printf("Error del Metodo: %.5f %1s\n",errorCalc,unidad);
		}while(n!=0);
	}
}

