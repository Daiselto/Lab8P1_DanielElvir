/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_danielelvir;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Lab8P1_DanielElvir {

    static Scanner num = new Scanner(System.in);
    static Scanner letra = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        Libro[][] librero = null;
        while (seguir) {
            System.out.println("--- Menu ---");
            System.out.println("BIENVENIDO A SU LIBRERO PERSONAL");
            System.out.println("1. Ingresar libro");
            System.out.println("2. Modificar libros");
            System.out.println("3. Para salir de su librero");
            System.out.println("Ingrese una opción");
            int opcion = num.nextInt();

            switch (opcion) {
                case 1: {
                    librero = llenarLibrero();

                    break;
                }

                case 2: {
                    if (librero != null) {
                    System.out.println("Ingrese el título del libro a modificar: ");
                    String nombre = letra.nextLine();
                    System.out.println("Ingrese el escritor del libro a modificar:");
                    String autor = letra.nextLine();
                    System.out.println("Ingrese el año de publicación del libro a modificar:");
                    int año = num.nextInt();
                    
                    modificarLibro(librero, nombre, autor, año);
                } else {
                    System.out.println("El librero está vacío. Por favor, primero llene el librero.");
                }
                break;
                }
                case 3: {
                    System.out.println("Gracias por usar el programa");
                    seguir = false;
                    break;
                }
            }
        }
    }

    public static Libro[][] llenarLibrero() {
        System.out.println("Ingrese la cantidad de filas para el librero");
        int filas = num.nextInt();
        System.out.println("Ingrese la cantidad de columnas para el librero");
        int columnas = num.nextInt();

        boolean mayor = true;
        while (mayor) {
            if (filas <= 0 || columnas <= 0) {
                System.out.println("¡¡ERROR!!");
                System.out.println("¡Su librero es inexistente!");
                System.out.println("");
                System.out.println("Ingrese la cantidad de filas para el librero");
                filas = num.nextInt();
                System.out.println("Ingrese la cantidad de columnas para el librero");
                columnas = num.nextInt();
            }else{
                mayor=false;
            }
        }

        Libro[][] librero = new Libro[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el titulo del libro");
                String nombre = letra.nextLine();
                System.out.println("Ingrese el autor del libro");
                String autor = letra.nextLine();
                System.out.println("Ingrese el año de publicacion");
                int año = num.nextInt();

                boolean antes = true;
                while (antes) {
                    if (año <= 0) {
                        System.out.println("¡¡ERROR!!");
                        System.out.println("Ingrese un año mayor que 0!!");
                        System.out.println("Ingrese el año de publicacion");
                        año = num.nextInt();
                    } else {
                        antes = false;
                    }
                }

                Libro NuevoLibro = new Libro(nombre, autor, año);
                librero[i][j] = NuevoLibro;

                System.out.println("El libro fue agregado exitosamente");
                System.out.println("");
            }
        }

        System.out.println("El librero completo se ve de la siguiente manera");
        mostrarLibrero(librero);
        return librero;
    }

    public static void modificarLibro(Libro[][] librero, String NombreBuscar, String AutorBuscar, int AñoBuscar) {
        int filaBusc = -1;
        int columnaBusc = -1;

        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[0].length; j++) {
                Libro libro = librero[i][j];
                if (libro.getNombre().equals(NombreBuscar) && libro.getAutor().equals(AutorBuscar) && libro.getAño() == AñoBuscar) {
                    filaBusc = i;
                    columnaBusc = j;
                    break;
                }
            }
        }

        if (filaBusc != -1 && columnaBusc != -1) {
            System.out.println("El libro fue encontrado en la fila " + (filaBusc + 1) + " columna " + (columnaBusc + 1));

            System.out.println("");

            System.out.println("Ingrese el nuevo título del libro: ");
            String nuevoNombre = letra.nextLine();
            System.out.println("Ingrese el nuevo escritor: ");
            String nuevoAutor = letra.nextLine();
            System.out.println("Ingrese el nuevo año de publicación: ");
            int nuevoAño = num.nextInt();

            librero[filaBusc][columnaBusc].setNombre(nuevoNombre);
            librero[filaBusc][columnaBusc].setAutor(nuevoAutor);
            librero[filaBusc][columnaBusc].setAño(nuevoAño);

            System.out.println("El libro fue modificado exitosamente");

            System.out.println("El librero modificado es:");
            mostrarLibrero(librero);
        } else {
            System.out.println("El libro no fue encontrado en el librero.");
        }
    }

    public static void mostrarLibrero(Libro[][] librero) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[0].length; j++) {
                System.out.print("[" + librero[i][j].getNombre() + "] " + "\t");
            }
            System.out.println("");
        }
    }
}
