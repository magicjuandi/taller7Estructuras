package org.example.taller7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Taller7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique el numero de soldados a saltar");
        int n = scanner.nextInt(); // Número de soldados a saltar
        List<String> soldiers = new ArrayList<>(); // Lista de nombres de soldados
        int opt;
        do{
            System.out.println("Ingrese el nombre del soldado: ");//Ingresa el nombre
            String name = scanner.next();
            soldiers.add(name);//Se guarda un soldado
            System.out.println("Desea agregar otro soldado?, Si(1), No(0)");//Se da la decision
            opt = scanner.nextInt();
        }while(opt != 0);//Ciclo para repetir el proceso
        List<String> eliminatedSoldiers = josephus(n, soldiers);//llamado metodo para la eliminacion de soldados
        System.out.println("Soldados eliminados en orden:");
        for (String soldier : eliminatedSoldiers) {//Se da la secuencia de soldados eliminados en orden
            System.out.println(soldier);
        }
        System.out.println("Soldado que escapa: " + soldiers.get(0));//Se imprime cual es el soldado que escapa
    }

    public static List<String> josephus(int n, List<String> soldiers) {
        List<String> eliminatedSoldiers = new ArrayList<>();//Se crea una lista de los soldados a eliminar
        int index = 0;
        while (soldiers.size() > 1) {
            index = (index + n - 1) % soldiers.size(); // Calcula el índice del soldado a eliminar
            eliminatedSoldiers.add(soldiers.remove(index)); // Elimina al soldado y lo agrega a la lista de eliminados
        }
        return eliminatedSoldiers;//Retorna la lista de los eliminados
    }
}
