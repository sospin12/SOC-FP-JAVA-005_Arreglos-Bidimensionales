import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        // System.out.println("Ingresa la cantidad de filas: ");
        // int n = scan.nextInt(); 
        // int[][] array = new int[][];
        menu(scan);
    }public static void ejercicio1(Scanner scan) {
        int cont = 1;
        System.out.println("\nMatriz de 3 x 3 con los números del 1 al 3x3 (9) ");
        int[][] matriz3x3 = new int[3][3];
        for (int i = 0; i < matriz3x3.length; i++) {
            for (int j = 0; j < matriz3x3[0].length; j++) {
                matriz3x3[i][j] = cont;
                cont++;
            }
        }
        imprimeMatriz(matriz3x3);
    }
    public static void ejercicio2(Scanner scan) {
        System.out.println("\nmatriz de n x n con los números del 1 al n x n.");
        System.out.println("ingrese el valor n del tamaño de la matriz: ");
        int n = scan.nextInt();
        int cont=1;
        int[][] arreglo = new int[n][n];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j]=cont;
                cont++;
            }
        }
        imprimeMatriz(arreglo); 
    }
    public static void ejercicio3(Scanner scan) {
        System.out.println("\nmatriz de m filas y n columnas (valores pedidos al usuario) y llenarlos con números \r\n" + //
                        "aleatorios del 0 al 10. ");
        System.out.println("Ingresa el numero m de filas: ");
        int m = scan.nextInt();
        System.out.println("Ingresa el numero n de columnas: ");
        int n = scan.nextInt();
        int[][] arreglo = new int[m][n];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j] =(int) (Math.random()*100+1);                
            }
        }
        imprimeMatriz(arreglo);

        System.out.println("\nCrear una segunda matriz de tamaño n (unidimensional) con el valor de \r\n" + //
                        "la sumatoria de cada fila en la matriz de m x n. ");
        int[] suma = new int[arreglo.length];
        int sum = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                sum += arreglo[i][j];
            }
            suma[i] = sum;
            sum = 0;
        }
        for (int i : suma) {
            System.out.println(i);
        }


    }
    public static void ejercicio4(Scanner scan) {
        System.out.println("matriz1 de n x n (n pedido al usuario y llena con valor aleatorios de 0 al 99). Hacer: ");
        int[][] matriz1 = creaMatriznxn(scan);
        imprimeMatriz(matriz1);
        int[][] matriz2 = new int[matriz1[0].length][matriz1.length];

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                matriz2[i][j] = matriz1[j][i];
            }
        }
        System.out.println("\n matriz transpuesta: ");
        imprimeMatriz(matriz2); 

        System.out.println("\n Diagonal de la matriz transpuesta");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                if (i==j){
                    System.out.println(matriz2[i][j]);
                }
                System.out.print("  ");
            }
            System.out.println("");
        }

        int[][] numevaMatriz= new int[matriz2.length+5][matriz2.length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                numevaMatriz[i][j]=matriz1[i][j];                
            }
        }
        System.out.println("\n Este es un ensayo: ");
        System.err.println(numevaMatriz.length + " " + numevaMatriz[0].length);
        // numevaMatriz[5][0]=1;
        // numevaMatriz[5][1]=1;
        // numevaMatriz[5][2]=1;
        // numevaMatriz[5][3]=1;
        // numevaMatriz[5][4]=1;
        imprimeMatriz(numevaMatriz);  

        
    }
    public static void menu(Scanner scan) {

        System.out.println("\nSelecciona el ejercicio que deseas ejecutar: ");
        System.out.println("1. Ejercicio1 ");
        System.out.println("2. Ejercicio2 ");
        System.out.println("3. Ejercicio3 ");
        System.out.println("4. Ejercicio4 ");
        System.out.println("5. Ejercicio5 ");
        System.out.println("6. Ejercicio6 ");
        System.out.println("7. Salir del programa");
        System.out.print("Ingresa tu opcion: ");
        int c = scan.nextInt();
        scan.nextLine(); //CLEAN BUFFER.

        switch (c) {
            case 1:
            ejercicio1(scan);
            menu(scan);
            case 2:
            ejercicio2(scan);
            menu(scan);
            case 3:
            ejercicio3(scan);
            menu(scan);
            case 4:
            ejercicio4(scan);
            menu(scan);
            // case 5:
            // ejercicio5(scan);
            // menu(scan);
            // case 6:
            // ejercicio6(scan);
            // menu(scan);
            case 7: 
            System.out.println("Terminando programa...");
            break;
        
            default:
                System.out.println("Número incorrecto");
                menu(scan);
        }

        
    }
    public static void imprimeMatriz(int[][] matriz) {
        for (int[] is : matriz) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println("");
        }
        
    }
    public static int[][] creaMatriznxn(Scanner scan) {
        System.out.print("ingresa el tamaño n de la matriz nxn: ");
        int n = scan.nextInt();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int)(Math.random()*100);
            }
        }
        return matriz;
        
    }
}
