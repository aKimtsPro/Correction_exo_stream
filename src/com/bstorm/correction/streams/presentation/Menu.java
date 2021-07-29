package com.bstorm.correction.streams.presentation;

import com.bstorm.correction.streams.ProductNotFoundException;
import com.bstorm.correction.streams.StockException;
import com.bstorm.correction.streams.service.Magasin;
import com.bstorm.correction.streams.service.Produit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Magasin magasin;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Magasin magasin) {
        this.magasin = magasin;
    }

    public void start(){

        welcome();
        int choice = 0;
        do {
            showMenu();
            choice = getChoice(8);
            mapChoice(choice);
        } while (choice != 8);

    }

    private void welcome(){
        System.out.println("--------------------------------------------");
        System.out.println("---- Bienvenue dans le magasin "+ magasin.getNom() +"! ----");
        System.out.println("--------------------------------------------\n\n");
    }
    private void showMenu(){
        System.out.println("Veuillez choisir l'action à réaliser : ");
        System.out.println("\t1 - Ajouter un produit");
        System.out.println("\t2 - Supprimer un produit");
        System.out.println("\t3 - Ajouter du stock à un produit");
        System.out.println("\t4 - Afficher tous les produits");
        System.out.println("\t5 - Faire une recherche");
        System.out.println("\t6 - Afficher les produits d'une marque");
        System.out.println("\t7 - Verifier les stocks");
        System.out.println("\t8 - Quitter\n");
    }
    private int getChoice(int nbrChoices){

        if(nbrChoices <= 0)
            throw new IllegalArgumentException("nbrChoices invalide: doit être positif et non null");

        int choice = 0;
        do {
            System.out.println("----> votre choix (entre 1 et "+nbrChoices+") : ");
            try{
               choice = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("valeur invalide, veuillez recommencer");
            }
            finally {
                scanner.nextLine();
            }

        } while(choice < 1 || choice > nbrChoices);

        return choice;
    }
    private void mapChoice(int choice){
        switch (choice){
            case 1:
                addProduct();
                break;
            case 2:
                deleteProduct();
                break;
            case 3:
                modifyStock();
                break;
            case 4:
                displayAll();
                break;
            case 5:
                searchProduct();
                break;
            case 6:
                displayByBrand();
                break;
            case 7:
                checkStock();
                break;
            case 8:
                exit();
                break;
        }
    }
    private void pause(){
        System.out.println(" --- appuyez sur 'entrer' pour continuer --- ");
        scanner.nextLine();
    }

    private void addProduct(){

        String nom;
        double prix;
        String marque;
        int typeChoice;
        int stock;

        try{
            System.out.println("Quelles sont les caractèristiques du produit?");
            System.out.println("---> nom: ");
            nom = scanner.nextLine();

            System.out.println("---> prix: ");
            prix = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("---> marque: ");
            marque = scanner.nextLine();

            System.out.println("---> type: ");
            for (Produit.Type value : Produit.Type.values()) {
                System.out.println("\t" + (value.ordinal()+1) + " - " + value.name() );
            }
            typeChoice = getChoice(Produit.Type.values().length);

            System.out.println("---> stock: ");
            stock = scanner.nextInt();
            scanner.nextLine();

            magasin.addProduct( new Produit(
                    nom,
                    prix,
                    marque,
                    Produit.Type.values()[typeChoice-1],
                    stock
            ) );

        }
        catch (InputMismatchException e){
            System.out.println("entrée invalide, retour au menu principal");
            scanner.nextLine();
        }
        catch (StockException e){
            System.out.println("Impossible de rajouter au stock, cela depasserait la limite");
            System.out.println("\ttaille du stock actuelle: " + e.getCurrentStock());
            System.out.println("\ttaille du stock après ajout: " + (e.getCurrentStock() + e.getAddedStock()) );
            System.out.println("\ttaille du stock limite: " + e.getLimit());
        }
    }
    private void deleteProduct(){
        System.out.println("Quel est le nom du produit à supprimer ? ");
        System.out.println("---> nom du produit: ");
        try{
            magasin.deleteProduct( magasin.getProductByName(scanner.nextLine()) );
        }
        catch (ProductNotFoundException e){
            System.out.println("Ce produit n'a pas été trouvé");
        }
    }
    private void modifyStock(){
        try{
            System.out.println("Quel est le nom du produit à modifier ? ");
            System.out.println("---> nom du produit: ");
            Produit p = magasin.getProductByName(scanner.nextLine());

            System.out.println("Quelle quantité à ajouter");
            System.out.println("---> qtt(nombre entier positif): ");
            magasin.addStock(p, scanner.nextInt());
            scanner.nextLine();
        }
        catch (ProductNotFoundException e){
            System.out.println("Ce produit n'a pas été trouvé");
        }
        catch (IllegalArgumentException e){
            System.out.println("La valeur doit être positive");
        }
        catch (InputMismatchException e){
            System.out.println("entrée invalide, retour au menu principal");
            scanner.nextLine();
        }
        catch (StockException e){
            System.out.println("Impossible de rajouter au stock, cela depasserait la limite");
            System.out.println("\ttaille du stock actuelle: " + e.getCurrentStock());
            System.out.println("\ttaille du stock après ajout: " + (e.getCurrentStock() + e.getAddedStock()) );
            System.out.println("\ttaille du stock limite: " + e.getLimit());
        }
    }
    private void displayAll(){

        boolean desc = false;
        List<Produit> toDisplay = null;

        System.out.println("Voulez-vous trier la liste?");
        System.out.println("1 - non");
        System.out.println("2 - oui, par prix");
        System.out.println("3 - oui, par type");
        System.out.println("4 - oui, par qtt");

        int choice = getChoice(4);
        if(choice != 1) {
            System.out.println("Trier de manière descendante? (O/N)");
            String responce = scanner.nextLine();
            desc = responce.equals("O") || responce.equals("o");
        }

        switch (choice){
            default:
            case 1:
                toDisplay = magasin.getProduits();
                break;
            case 2:
                toDisplay = magasin.getStockSortedByPrice(desc);
                break;
            case 3:
                toDisplay = magasin.getStockSortedByType(desc);
                break;
            case 4:
                toDisplay = magasin.getStockSortedByQtt(desc);
                break;
        }

        toDisplay.forEach(System.out::println);
        pause();
    }
    private void searchProduct(){

        Double min = null, max = null;
        String nom = null;
        Produit.Type type = null;
        int choice = 0;

        try{
            do {
                System.out.println("Choisissez le critères(les critères non défini ne seront pas pri en compte) " +
                        "ou lancez la recherche");
                System.out.println("1 - prix minimum");
                System.out.println("2 - prix maximum");
                System.out.println("3 - type");
                System.out.println("4 - nom");
                System.out.println("5 - lancer la recherche");

                choice = getChoice(5);

                switch (choice){
                    case 1:
                        System.out.println("entrez le prix minimum: ");
                        System.out.println("---> prix minimum(nombre positif): ");
                        min = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("entrez le prix maximum: ");
                        System.out.println("---> prix maximum(nombre positif): ");
                        max = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("entrez le type de produit souhaité: ");
                        System.out.println("---> type: ");
                        for (Produit.Type value : Produit.Type.values()) {
                            System.out.println("\t" + (value.ordinal()+1) + " - " + value.name() );
                        }
                        type = Produit.Type.values()[getChoice(Produit.Type.values().length)-1];
                        break;
                    case 4:
                        System.out.println("entrez un nom ou une partie de nom: ");
                        System.out.println("---> nom: ");
                        scanner.reset();
                        nom = scanner.nextLine();
                        break;
                    default:
                    case 5:
                        magasin.search(min,max,type,nom)
                                .forEach(System.out::println);
                        pause();
                }
            }while (choice != 5);
        }
        catch (InputMismatchException e){
            System.out.println("Valeur entrée invalide, retour au menu principal");
            scanner.nextLine();
        }

    }
    private void displayByBrand(){
        List<String> brands = magasin.getBrands();

        System.out.println("Faites votre choix parmi les marques disponibles: ");
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i+1) + " - " + brands.get(i));
        }
        String choice = brands.get( getChoice(brands.size())-1 );

        magasin.getByBrand(choice)
                .forEach(System.out::println);
        pause();
    }
    private void checkStock(){
        if(magasin.lowStockPresent()){
            System.out.println("Certaine marchandise sont en stock faible:");
            magasin.getByLowStock().forEach(System.out::println);
        }
        else
            System.out.println("Il n'y a pas de marchandise en stock faible");
        pause();
    }
    private void exit(){
        System.out.println("Merci pour votre visite !");
    }
}
