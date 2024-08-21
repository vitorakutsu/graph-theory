package Menu;

import DataStructure.List.ArrayList;
import DataStructure.Matrix.Matrix;

import java.util.Scanner;

public class Menu {
    private final Matrix m;
    private final ArrayList arrayList;
    public Menu(Matrix m, ArrayList arrayList) {
        this.m = m;
        this.arrayList = arrayList;
    }
    public void showMenu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Deseja iniciar mostrando a Matriz ou a Lista de Adjacência?");
        System.out.println("M - Matriz");
        System.out.println("L - Lista de Adjacência");
        System.out.println("C - Acessar conversor");

        System.out.println();

        String resp = s.nextLine();

        while(!resp.equalsIgnoreCase("M") && !resp.equalsIgnoreCase("L") && !resp.equalsIgnoreCase("C")) {
            System.out.println("Opção inválida, tente novamente.");
            System.out.println("Deseja iniciar mostrando a Matriz ou a Lista de Adjacência?");
            System.out.println("M - Matriz");
            System.out.println("L - Lista de Adjacência");
            System.out.println("C - Acessar conversor");
            System.out.println();

            resp = s.nextLine();
        }

        if(resp.equalsIgnoreCase("M")) {
            m.showMatrix();
        }
        else if(resp.equalsIgnoreCase("L")) {
            arrayList.insertOnArrayList(m);
            arrayList.showArrayList();
        }
        else{
            showMenuConverter();
        }
    }

    public void showMenuConverter(){
        Scanner s = new Scanner(System.in);
        System.out.println("Deseja converter a Matriz em Lista de Adjacência ou a Lista de Adjacência em Matriz?");
        System.out.println("M - Matriz -> Lista de Adjacência");
        System.out.println("L - Lista de Adjacência -> Matriz");

        System.out.println();

        String resp = s.nextLine();

        while(!resp.equalsIgnoreCase("M") && !resp.equalsIgnoreCase("L")) {
            System.out.println("Opção inválida, tente novamente.");
            System.out.println("Deseja converter a Matriz em Lista de Adjacência ou a Lista de Adjacência em Matriz?");
            System.out.println("M - Matriz -> Lista de Adjacência");
            System.out.println("L - Lista de Adjacência -> Matriz");
            System.out.println();

            resp = s.nextLine();
        }

        if(resp.equalsIgnoreCase("M")) {
            m.showMatrix();
        } else if(resp.equalsIgnoreCase("L")) {
            arrayList.insertOnArrayList(m);
            Matrix matrix = arrayList.convertListToMatrix();
            matrix.showMatrix();
        }
    }
}
