package service;

import VM.VendingMachine;
import model.Coin;
import model.Product;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

public class IOService {
    public void displayProductMenu(Map<Product, Integer> products) {
        System.out.println("Cod\t\t" + "Nume\t\t" + "Cantitate\t" + "Pret\t" + "Stoc");
        for (Product p : products.keySet()) {
            System.out.println(p.getCode() + "\t\t" + p.getName() + "\t\t\t" + p.getSize() + "\t" + p.getPrice() + "\t\t" + products.get(p));
        }
        System.out.println();
    }

    public void displayCoinMenu(Map<Coin, Integer> coins) {
        System.out.println("Cod\t\t" + "Valoare\t\t" + "Stoc");
        for (Coin c : coins.keySet()) {
            System.out.println(c.getCode() + "\t\t\t" + c.getValue() + "\t\t" + coins.get(c));
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
