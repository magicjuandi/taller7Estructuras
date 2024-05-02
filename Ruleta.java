package CircularList;

import java.util.Scanner;
import java.util.Random;

class Nodo {
    int numero;
    Nodo siguiente;

    //Constructor
    public Nodo(int numero) {
        this.numero = numero;
        this.siguiente = null;
    }
}

class ListaCircular {
    Nodo cabeza;

    // Constructor
    public ListaCircular() {
        this.cabeza = null;
    }

    // Agregar un nodo al final de la lista circular
    public void agregar(int numero) {
        Nodo nuevoNodo = new Nodo(numero);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza; // Hacer que apunte a sí mismo en una lista circular
            //Si la lista no está vacía, recorre hasta el final
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            // Hacer que el nuevo nodo apunte a la cabeza para mantener la circularidad
            nuevoNodo.siguiente = cabeza;
        }
    }

    // Método para imprimir la lista circular
    public void imprimir() {
        if (cabeza == null) { // Si no hay nada, la lista está vacía
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo temp = cabeza;
        do {
            System.out.print(temp.numero + " ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println();
    }

    // Método para realizar el giro de la ruleta y verificar si el número del usuario coincide
    public boolean girarRuleta(int numeroUsuario) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return false;
        }
        Random rand = new Random(); //Genera un número aleatorio.
        int pasos = rand.nextInt(20); // Escoger un número aleatorio de pasos para girar la ruleta (max 20)
        System.out.println("Girando la ruleta...");
        Nodo temp = cabeza;
        for (int i = 0; i < pasos; i++) { //Se recorren los pasos de la lista aleatoria
            temp = temp.siguiente;
        }
        System.out.println("El número ganador es: " + temp.numero);
        return temp.numero == numeroUsuario;
    }
}

// Clase principal para ejecutar el juego
public class Ruleta {
    public static void main(String[] args) {
        //Scanner para los inputs del usuario
        Scanner scanner = new Scanner(System.in);
        ListaCircular ruleta = new ListaCircular();
        int puntos = 0;

        // Agregar números a la ruleta (del 1 al 20)
        for (int i = 1; i <= 20; i++) {
            ruleta.agregar(i);
        }

        // Mostrar la ruleta en pantalla
        System.out.println("Números en la ruleta:");
        ruleta.imprimir();

        // Jugar
        while (true) {
            System.out.println("Ingrese un número (1-20) o presione cualquier tecla para salir:");
            //Si no se introduce un número, termina el juego
            if (!scanner.hasNextInt()) {
                System.out.println("Saliendo del juego...");
                break;
            }
            int numeroUsuario = scanner.nextInt();
            if (numeroUsuario < 1 || numeroUsuario > 20) {
                System.out.println("Número inválido. Debe ser entre 1 y 20.");
                continue;
            }
            //Si acierta el número
            if (ruleta.girarRuleta(numeroUsuario)) {
                System.out.println("¡Felicidades! Has ganado.");
                //Se suma uno a la lista de puntos
                puntos++;
            } else {
                System.out.println("Lo siento, no has ganado esta vez.");
            }
        }

        //Fuera del ciclo, se muestran los puntos obtenidos
        System.out.println("Tu puntaje final es: " + puntos);
    }
}