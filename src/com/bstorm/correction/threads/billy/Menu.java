package com.bstorm.correction.threads.billy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Tirelire tirelire;

    public Menu(Tirelire tirelire) {
        this.tirelire = tirelire;
    }

    public void start(){

        int choice = 0;
        do{
            showMenu();
            choice = getChoice(6);
            mapChoice(choice);
        }while (choice >= 1 && choice <= 5);

    }

    public void showMenu(){
        System.out.println("------- MENU -------");
        System.out.println("1) voir solde");
        System.out.println("2) ajouter etrennes");
        System.out.println("3) voir etrennes");
        System.out.println("4) interrompre etrennes");
        System.out.println("5) interrompre une etrenne");
        System.out.println("6) quitter");
    }
    public int getChoice(int nbrChoice){
        int choice = -1;
        do {
            System.out.println("Veuillez entrer votre choix:");
            try{
                choice = scanner.nextInt();
            }
            catch (InputMismatchException ignored){}
            finally {
                if(choice < 1 || choice > nbrChoice)
                    System.out.println("choix invalide, veuillez recommencer.");
            }
        }while ( choice < 1 || choice > nbrChoice);
        return choice;
    }

    public void mapChoice(int choice){
        switch (choice){
            case 1:
                System.out.println("SOLDE : " + tirelire.getSolde());
                break;

            case 2:
                System.out.println("Veuillez entrer une somme:");
                int somme = scanner.nextInt();
                System.out.println("Veuillez entrer un timing:");
                int timing = scanner.nextInt();
                tirelire.startEtrenne(new Etrenne(somme,timing,tirelire));
                break;
            case 3:
                System.out.println("--- Etrenne ---");
                tirelire.showEtrenne();
                break;
            case 4:
                System.out.println("Interruption des Threads");
                tirelire.interruptAll();
                break;
            case 5:
                System.out.println("Quel id?");
                tirelire.interruptOne(scanner.nextLong());
                break;
            default:
            case 6:
                System.out.println("Au revoir!");
                break;

        }
    }

}
