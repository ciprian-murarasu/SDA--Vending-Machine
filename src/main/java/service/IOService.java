package service;

import model.Coin;
import model.CurrencyType;
import model.Product;
import java.util.Map;
import java.util.Scanner;

public class IOService {
    public void displayProductMenu(Map<Product, Integer> products) {
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
        System.out.println();
    }

    public void displayCoinMenu(Map<Coin, Integer> coins) {
        System.out.println("Bani");
        System.out.println(" Cod|\tValoare|\tStoc");
        for (int i = 0; i < 24; i++) {
            System.out.print('-');
        }
        System.out.println();
        for (Coin c : coins.keySet()) {
            if (coins.get(c) > 0)
                System.out.printf("%4s|%10s|\t%4s\n", c.getCode(), c.getValue(), coins.get(c));

        }
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }

    public int readInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
//        while(input == null) {
        while (!input.matches("[0-9]{3}")) {
            System.out.print("Cod incorect. Incercati din nou: ");
            input = scan.nextLine();
        }
        return Integer.parseInt(input);
//        return scan.nextInt();
    }
}
