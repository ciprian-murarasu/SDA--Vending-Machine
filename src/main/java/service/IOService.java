package service;

import model.Coin;
import model.CurrencyType;
import model.Product;

import java.util.Map;
import java.util.Scanner;

public class IOService {
    public void displayMessage(String message) {
        System.out.print(message);
    }

    public void displayProductMenu(Map<Product, Integer> products) {
        System.out.println();
        System.out.println("Produse");
        System.out.println(" Cod|\t\t\t\t  Nume  \t\t\t\t|\tCantitate|\t Pret|\tStoc");
        for (int i = 0; i < 72; i++) {
            System.out.print('-');
        }
        System.out.println();
        for (Product p : products.keySet()) {
            if (products.get(p) > 0)
                System.out.printf("%4s|%39s|%12s|%7s|\t%4s\n", p.getCode(), p.getName(), p.getSize(), p.getPrice() + " " + CurrencyType.RON, products.get(p));
        }
    }

    public void displayExitProducts() {
        System.out.printf("%4s|%39s|\n", "0", "Iesire");
    }

//    public void displayServiceOption() {
//        System.out.printf("%4s|%39s|\n", "", "Meniu service");
//    }

    public void displayCoinMenu(Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("Bani");
        System.out.println(" Cod|\tValoare|\tStoc");
        for (int i = 0; i < 24; i++) {
            System.out.print('-');
        }
        System.out.println();
        for (Coin c : coins.keySet()) {
            if (coins.get(c) > 0)
                System.out.printf("%4s|%10s|\t%4s\n", c.getCode(), c.getValue() + " " + CurrencyType.RON, coins.get(c));
        }
        System.out.printf("%4s|%10s|\n", "0", "Anulare");
        System.out.println();
    }

    public int readInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.matches("[0-9]{1,3}")) {
            System.out.print("Cod incorect. Incercati din nou: ");
            input = scan.nextLine();
        }
        return Integer.parseInt(input);
    }

    public void displayServiceMenu() {
        System.out.println(" Cod|\t\t\tOptiune\t\t\t");
        for (int i = 0; i < 36; i++) {
            System.out.print('-');
        }
        System.out.println();
        System.out.printf("%4s|%30s|\n", "993", "Introduceti produs existent");
        System.out.printf("%4s|%30s|\n", "994", "Introduceti produs nou");
        System.out.printf("%4s|%30s|\n", "995", "Introduceti monezi");
        System.out.printf("%4s|%30s|\n", "996", "Retrageti produs");
        System.out.printf("%4s|%30s|\n", "997", "Modificati pret");
        System.out.printf("%4s|%30s|\n", "0", "Iesire");
    }

    public void displayGoBackOption() {
        System.out.printf("%4s|%39s|\n", "0", "Revenire");
    }
}
