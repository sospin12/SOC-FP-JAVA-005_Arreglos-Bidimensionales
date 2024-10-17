import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = leerMatrizDesdeArchivo("matriz.txt");
        if (matriz == null) {
            System.out.println("No se encontró un archivo de datos existente. Inicializando una nueva matriz.");
            matriz = new int[0][4]; // Inicializa una matriz de ejemplo
        }
        
        menu(matriz,scan);
    }
    public static int[][] funcion1(int[][] matriz, Scanner scan) {
        int[][] matriz2 = new int[matriz.length+1][4];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz2[i][j]=matriz[i][j];
            }
        }
        System.out.print("ingresa el id del estudiante: ");
        matriz2[matriz.length][0]=scan.nextInt();
        System.out.print("ingresa la edad del estudiante: ");
        matriz2[matriz.length][1]=scan.nextInt();
        System.out.print("ingresa el año de nacimento del estudiante: ");
        matriz2[matriz.length][2]=scan.nextInt();
        System.out.print("ingresa el numero de materias del estudiante: ");
        matriz2[matriz.length][3]=scan.nextInt();

        matriz=matriz2;
        App.imprimeMatriz(matriz);
        return matriz;
    }
    public static void funcion2(int[][] matriz, Scanner scan) {
        System.out.println("Ingresa el id del usuario a buscar: ");
        int id = scan.nextInt();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0]==id){
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
                break;
            }
            System.out.println("No hay coincidencias ");
        }
    }
    public static void funcion3(int[][] matriz, Scanner scan) {
        System.out.println("Ingresa el rango de edad a buscar: ");
        int min = scan.nextInt();
        int max = scan.nextInt();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][1]>=min && matriz[i][1]<=max){
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
                break;
            }
            System.out.println("No hay coincidencias ");
        }
        
    }
    public static void funcion4(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void funcion5(int[][] matriz, Scanner scan) {
        System.out.println("Ingresa el año a buscar: ");
        int año = scan.nextInt();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][2]==año){
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
            }
        }
        
    }
    public static void funcion6(int[][] matriz) {
        int promedio = 0;
        for (int i = 0; i < matriz.length; i++) {
            promedio+=matriz[i][3];
        }
        promedio/=matriz.length;
        System.out.println("El promedio de materias es: "+promedio);
        
    }

    public static void menu(int[][] matriz, Scanner scan) {
        System.out.println("Escoge una opcion: ");
        System.out.println("1. Almacenar datos de estudiante. ");
        System.out.println("2. Buscar datos. ");
        System.out.println("3. Estudiantes en rango de edad. ");
        System.out.println("4. Todos los estudiantes. ");
        System.out.println("5. Estudiantes de año. ");
        System.out.println("6. Promedio de materias. ");
        System.out.print("Ingresa tu opción: ");
        int n = scan.nextInt();
        scan.nextLine();

        switch (n) {
            case 1:
            matriz = funcion1(matriz,scan);
            guardarMatrizEnArchivo(matriz, "matriz.txt");
            menu(matriz, scan);
            case 2:
            funcion2(matriz,scan);
            menu(matriz, scan);
            case 3:
            funcion3(matriz,scan);
            menu(matriz, scan);
            case 4:
            funcion4(matriz);
            menu(matriz, scan);
            case 5:
            funcion5(matriz,scan);
            menu(matriz, scan);
            case 6:
            funcion6(matriz);
            menu(matriz, scan);
            case 7:
            System.out.println("Terminando programa...");
            break;
        
            default:
            System.out.println("Opcion incorrecta.");
            menu(matriz, scan);
        }
    }
    public static void guardarMatrizEnArchivo(int[][] matriz, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int[] fila : matriz) {
                for (int elemento : fila) {
                    writer.write(elemento + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] leerMatrizDesdeArchivo(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int[][] matriz = new int[5][4]; // Ajustar tamaño según sea necesario
            int fila = 0;
            while ((linea = reader.readLine()) != null) {
                String[] elementos = linea.split(" ");
                for (int i = 0; i < elementos.length; i++) {
                    matriz[fila][i] = Integer.parseInt(elementos[i]);
                }
                fila++;
            }
            return matriz;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
