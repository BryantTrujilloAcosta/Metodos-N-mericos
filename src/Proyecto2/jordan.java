package Proyecto2;

import java.util.Scanner;

public class jordan {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Ingrese el número de ecuaciones: ");
		
		// Validar el orden de la matriz
        int n;
        do {
            System.out.print("Ingrese el orden de la matriz (entre 2 y 6): ");
            n = input.nextInt();
        } while (n < 2 || n > 6);

        // Capturar los conceptos y unidades de medida
        String[] conceptos = new String[n];
        String[] unidades = new String[n+1];
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese el concepto de la variable x%d: ", i+1);
            conceptos[i] = input.next();
            System.out.printf("Ingrese la unidad de medida del %s: ", conceptos[i]);
            unidades[i] = input.next();
        }
       // unidades[n] = "Solución";
        //conceptos[n]="solucion";

		double[][] a = new double[n][n+1];

		System.out.println("Ingrese los coeficientes y términos independientes de las ecuaciones: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n+1; j++) {
				System.out.println(conceptos[i]);
				a[i][j] = input.nextDouble();
			}
		}

		System.out.println("\nLa matriz de coeficientes y términos independientes es: ");
		imprimirMatriz(a);

		// Aplicar el método de Gauss-Jordan
		for (int i = 0; i < n; i++) {
			// Pivoteo parcial
			int max = i;
			for (int j = i+1; j < n; j++) {
				if (Math.abs(a[j][i]) > Math.abs(a[max][i])) {
					max = j;
				}
			}
			double[] temp = a[i];
			a[i] = a[max];
			a[max] = temp;

			// Hacer ceros debajo del pivote
			for (int j = i+1; j < n; j++) {
				double factor = a[j][i] / a[i][i];
				for (int k = i+1; k < n+1; k++) {
					a[j][k] -= factor * a[i][k];
				}
				a[j][i] = 0;
			}
		}
	
		// Aplicar el método de Gauss-Jordan para hacer unos encima de los pivotes
		for (int i = n-1; i >= 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				double factor = a[j][i] / a[i][i];
				for (int k = i+1; k < n+1; k++) {
					a[j][k] -= factor * a[i][k];
				}
				a[j][i] = 0;
			}
			double factor = 1 / a[i][i];
			for (int j = i; j < n+1; j++) {
				a[i][j] *= factor;
			}
		}
		System.out.println("\nLa matriz transformada es: ");
		imprimirMatriz(a);

		System.out.println("resultados ");
		for (int i = 0; i < n; i++) {
			System.out.println(conceptos[i]+"="+ a[i][n]+ unidades[i]);
		}
	}

	public static void imprimirMatriz(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%.2f\t", a[i][j]);
			}
			System.out.println();
		}
	}
}
