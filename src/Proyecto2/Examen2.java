package Proyecto2;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Examen2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		boolean salir = false;
		int orden;
		String opcion;
		while (!salir) {
			System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
					+ "En sistemas computacionales");
			System.out.println();
			System.out.println("Trujillo Acosta Bryant\nSolución de sistemas de Ecuaciones\nDe 13:00 a 14:00 horas");
			System.out.println();
			System.out.println("Este programa ejecuta el proceso de cálculo de raices de una ecuacion\nutilizando el metodo Gauss jordan "
					+ "y Gauss Seidel");
			System.out.println();
			System.out.println("Una empresa juguetera cuya matriz se encuentra en Culiacán, tiene \n"
					+ "cuatro sucursales en ventas al público en general. \n"
					+ "Estas sucursales están ubicadas en Culiacán, Mazatlán, Guasave y los Mochis. \n"
					+ "Cada tienda vende los mismos tipos de juguetes; Carrito Tipo1, \n"
					+ "Carrito Tipo2, Carrito Tipo 3 y Carrito Tipo 4.\n"
					+ "La contabilidad registrada el día 30 de abril de este año\n"
					+ "cuantifica un monto de ventas de $40,050 por la sucursal ubicada en Culiacán,\n"
					+ "ventas de $25,625 en la sucursal ubicada en Mazatlán,\nventas de $43,100 en la sucursal de la ciudad de Guasave \n"
					+ "y ventas de $43,150 de la sucursal ubicada en la ciudad de los mochis.");
			System.out.println("La cantidad de carritos vendidos durante el mes de abril de acuerdo al inventario registrado fue el siguiente.\n"
					+ "1.- En la sucursal de Culiacán se vendieron 80 carrito tipo1, 30 carritos tipo2, 220 carritos tipo3 y 80 carritos tipo4\n"
					+ "2.- En la sucursal de Mazatlán se vendieron 20 carrito tipo1, 135 carritos tipo2, 50 carritos tipo3 y 50 carritos tipo4.\n"
					+ "3.- En la sucursal de Guasave se vendieron 210 carrito tipo1, 50 carritos tipo2, 80 carritos tipo3 y 60 carritos tipo4.\n"
					+ "4.- En la sucursal de Mochis se vendieron 40 carrito tipo1, 90 carritos tipo2, 50 carritos tipo3 y 200 carritos tipo4.");
			System.out.println("¿Cuál es el precio estimado en que cada sucursal debió haber vendido\n"
					+ "cada carrito el día del niño, suponiendo los montos de ventas registrado?");

			System.out.println();
			System.out.println("a) Metodo Gauss Jordan");
			System.out.println("b) Metodo Gauss Seidel");
			System.out.println("c) finalizar el programa");
			try {
				System.out.println("Elige una de las opciones");
				opcion = entrada.next();

				switch (opcion) {
				case "a":
					System.out.println("Cual es el orden ?");
					orden = entrada.nextInt();
					System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
							+ "En sistemas computacionales");
					System.out.println();
					System.out.println("Bryant Trujillo Acosta\nSolución de Sistemas de Ecuaciones\nMétodo Gauss Jordan\nDe 13:00 a 14:00 horas");
					System.out.println("Pregunta:¿Cuál es el precio estimado en que cada sucursal "
							+ "\ndebió haber vendido cada carrito el día del niño,\n"
							+ "suponiendo los montos de ventas registrado?");
					
					while (!(orden==2) && !(orden<=6)){
						System.out.println("El orden debe ser del 2 al 6");
						orden = entrada.nextInt();
					}
					DecimalFormat df = new DecimalFormat("#0.000000");
					double matriz [][] ={
							{80,30,220,80,40050},
							{20,135,50,50,25625},
							{210,50,80,60,43100},
							{40,90,50,200,43150},
					};
					System.out.println("Matriz de Datos");
					System.out.println("__________________________________________");
					int i=0;
					while (i<orden) 
					{
						for(int j=0;j<orden+1; j++)
						{
							System.out.print(matriz[i][j]+"\t");
						}
						System.out.println();
						i++;
					}
					System.out.println("___________________________________________");
					System.out.println("Matriz Transformada");
					System.out.println("__________________________________________________________________________");
					gauss_jordan(matriz,orden);
					for(int i2=0;i2<orden;i2++){
						for(int j=0;j<orden+1;j++){
							System.out.print(df.format(matriz[i2][j])+"\t");
						}
						System.out.println();
					}
					System.out.println("__________________________________________________________________________");
					System.out.println("Resultado");
					System.out.println();
					for(int i3=0;i3<orden;i3++){
						System.out.println("Carrito Tipo "+(i3+1)+"="+df.format(matriz[i3][orden])+"$"+"\t");//"X"<<i+1<<"="<<M[i][n]<<"\t";
					}
					System.out.println();



					break;
				case "b":
					System.out.println("\tInstituto Tecnologico de culiacán\n\tIng."
							+ "En sistemas computacionales");
					System.out.println();
					System.out.println("Bryant Trujillo Acosta\nSolución de Sistemas de Ecuaciones\nMétodo Gauss Seidel\nDe 13:00 a 14:00 horas");
					System.out.println("Pregunta:¿Cuál es el precio estimado en que cada sucursal debió haber vendido cada carrito el día del niño,\n"
							+ "suponiendo los montos de ventas registrado?");
					System.out.println("Cual es el orden ?");
					orden = entrada.nextInt();
					DecimalFormat df2 = new DecimalFormat("#0.000000");
					 Double e = 0.0001;
				        Integer n = orden;
				        Integer a = n+1;
				        Double[][] M = new Double[10][10];
				        Double[][] Iter = new Double[999][999];
				        Double [] V = new Double[100];
				        
				        for (int f = 1; f <= n; f++) {
				            for (int c = 1; c <= a; c++) {
				                if (c == a) {
				                	System.out.println("Introduce el termino independiente de la ecuacion");
				                    M[f][c] = entrada.nextDouble();
				                    /*JOptionPane.showMessageDialog(null,"variable de la matriz "+f+" "+c+" : "+ M[f][c]);*/
				                }else {
				                	System.out.println("Introduce los coeficientes de la "+ f +" ecuacion (uno en uno)");
				                    M[f][c] = entrada.nextDouble();
				                    /*JOptionPane.showMessageDialog(null,"variable de la matriz "+f+" "+c+" : "+ M[f][c]);*/
				                }
				            }
				        }
				        
				        Double may;
				        Integer ban=0;
				        for (int f = 1; f <= n; f++) {
				            may = M[f][f];
				            for (int c = 1; c < n+1; c++) {
				                if ((Math.abs(may))<(Math.abs(M[f][c]))) {
				                    ban = 1;
				                }
				            }
				        }
				        
				        if (ban == 1) {
				            System.out.println("EL SISTEMA NO CONVERGE");
				        }else {
				            
				            for (int f = 1; f <= n; f++) {
				            	System.out.println("Introduce los valores iniciales");
				                V[f] = entrada.nextDouble();
				            }
				        
				            Integer inter = 0, c = 1;
				            Double mayor, suma, res, er;
				            do {
				                mayor = 0.0;
				                for (int i3 = 1; i3 <= n; i3++) {
				                    suma = 0.0;
				                    for (int j = 1; j <= n; j++) {
				                        if (j!=i3 ) {
				                            suma += M[i3][j] * V[j];
				                        }
				                    }
				                    res = (M[i3][a] - suma) / M[i3][i3];
				                    er = Math.abs(V[i3]-res);
				                    if (er > mayor) {
				                        mayor = er;
				                    }
				                    V[i3] = res;
				                    Iter[i3][c] = res;
				                }
				                c++;
				                inter ++;
				            } while (mayor >= e);
				        
				            System.out.println("Solucion Aproximada");
				            System.out.println("Realizo "+inter+" iteraciones");
				        
				           // DefaultTableModel modelo = (DefaultTableModel) tblResultado.getModel();
				           // modelo.setRowCount(n);
				           // modelo.setColumnCount(1);
				            for (int i4 = 0; i4 < n; i4++) {
				                System.out.println(V[i4+1]+i4);
				            }
				           // DefaultTableModel model = (DefaultTableModel) tblIteraciones.getModel();
				           // model.setRowCount(n);
				            //model.setColumnCount(inter);
				            for (int i5 = 0; i5 < n; i5++) {
				                for (int j = 0; j < inter; j++) {
				                    System.out.println(Iter[i5+1][j+1]+ i5+ j);
				                }
				            }
				        }
				        
				        
					

					break;
				case "c":
					salir = true;
					break;	
				default:
					System.out.println("Solo letras entre a y c");

				}
			}catch (Exception e) {
				System.out.println("Debes insertar una letra");
				entrada.next();
			}
		}

	}
	private static void gauss_jordan(double M[][],int n){
		double may;//variable para almacenar el mayor de la columna k
		int ind;//indice del mayor-->indice de may
		double aux;
		double pivote;

		for(int k=0;k<n;k++){//recorrer columnas de la matriz reducida
			may=(M[k][k]);
			ind=k;
			//recorrer filas de la columna k para buscar el indice del mayor
			for(int l=k+1;l<n;l++){
				if(may<(M[l][k])){
					may=(M[l][k]);
					ind=l;
				}

			}

			//cambiar filas
			if(k!=ind){
				for(int i=0;i<n+1;i++){
					aux=M[k][i];
					M[k][i]=M[ind][i];
					M[ind][i]=aux;
				}

			}
			if(M[k][k]==0){
				break;
			}
			else{

				for(int i=0;i<n;i++){//recorrer fila
					if(i!=k){
						pivote=-M[i][k];
						for(int j=k;j<n+1;j++){//recorrer elementos de una fila

							M[i][j]=M[i][j]+pivote*M[k][j]/M[k][k];
						}
					}
					else{
						pivote=M[k][k];
						for(int j=k;j<n+1;j++){
							M[i][j]=M[i][j]/pivote;
						}
					}
				}
			}


		}
	} 
}



