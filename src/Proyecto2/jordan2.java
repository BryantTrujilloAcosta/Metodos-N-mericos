package Proyecto2;

import java.util.Scanner;

public class jordan2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		   // Validar el orden de la matriz
        int n;
        do {
            System.out.print("Ingrese el orden de la matriz (entre 2 y 6): ");
            n = input.nextInt();
        } while (n < 2 || n > 6);

        // Capturar los coeficientes y términos independientes
        double[][] a = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese los coeficientes y término independiente de la ecuación %d: ", i+1);
            for (int j = 0; j < n+1; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        // Imprimir la matriz de datos
        System.out.println("\nLa matriz de datos es: ");
        imprimirMatriz(a);

        // Aplicar el método de Gauss-Jordan para hacer ceros debajo de la diagonal
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

        // Imprimir la matriz con ceros debajo de la diagonal
        System.out.println("\nLa matriz con ceros debajo de la diagonal es: ");
        imprimirMatriz(a);

        // Aplicar el método de Gauss-Jordan para hacer ceros arriba de la diagonal
        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                double factor = a[j][i] / a[i][i];
                for (int k = i+1; k < n+1; k++) {
                    a[j][k] -= factor * a[i][k];
                }
                a[j][i] = 0;
            }
        }

        // Imprimir la matriz con ceros arriba y abajo de la diagonal
        System.out.println("\nLa matriz con ceros arriba y abajo de la diagonal es: ");
        imprimirMatriz(a);

        // Aplicar el método de Gauss-Jordan para hacer unos encima de los pivotes
        for (int i = 0; i < n; i++) {
            double factor = 1 / a[i][i];
            for (int j = i; j < n+1; j++) {
                a[i][j] *= factor;
            }
        }

        // Imprimir la matriz identidad
        System.out.println("\nLa matriz identidad es: ");
        imprimirMatriz(a);

        //

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
