package service;

import model.Product;

import java.util.Map;
import java.util.Scanner;

public class IOService {
    public void displayProductMenu(Map<Product, Integer> products) {
        System.out.println("Cod\t\t" + "Nume\t\t" + "Cantitate\t" + "Pret\t" + "Stoc");
        for (Product p : products.keySet()) {
            System.out.println(p.getCode() + "\t\t" + p.getName() + "\t\t" + p.getSize() + "\t" + p.getPrice() + "\t\t" + products.get(p));
        }
    }

    public void displayCoinMenu() {

    }

    public void displayMessage() {

    }

    public int readInput(Scanner scan) {
//        scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
