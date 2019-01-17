package VM;

import model.Coin;
import model.CurrencyType;
import model.Product;
import service.IOService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<Product, Integer> productStock;
    private Map<Coin, Integer> coinStock;
    private IOService service;
    private CurrencyType currency = CurrencyType.RON;

    public VendingMachine(Map<Product, Integer> productStock, Map<Coin, Integer> coinStock, IOService service, CurrencyType currency) {
        this.productStock = productStock;
        this.coinStock = coinStock;
        this.service = service;
        this.currency = currency;
    }

    public Map<Product, Integer> getProductStock() {
        return productStock;
    }

    public void setProductStock(Map<Product, Integer> productStock) {
        this.productStock = productStock;
    }

    public Map<Coin, Integer> getcoinStock() {
        return coinStock;
    }

    public void setcoinStock(Map<Coin, Integer> coinStock) {
        this.coinStock = coinStock;
    }

    public IOService getService() {
        return service;
    }

    public void setService(IOService service) {
        this.service = service;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public void run() {
        System.out.println("Produse");
        service.displayProductMenu(productStock);
        service.displayMessage("Selectati un produs: ");
        int option = service.readInput();
        boolean validOption = false;
        Product chosenProduct = null;
        while (!validOption) {
            for (Product p : productStock.keySet()) {
                if (p.getCode() == option) {
                    validOption = true;
                    chosenProduct = p;
                    break;
                }
            }
            if (!validOption) {
                service.displayMessage("Cod incorect. Incercati din nou: ");
                option = service.readInput();
            }
        }
        System.out.println();

        System.out.println("Bani");
        service.displayCoinMenu(coinStock);
        int sum = 0;
        while (sum < chosenProduct.getPrice()) {
            service.displayMessage("Introduceti suma: ");
            option = service.readInput();
            validOption = false;
            Coin chosenCoin = null;
            while (!validOption) {
                for (Coin c : coinStock.keySet()) {
                    if (c.getCode() == option) {
                        validOption = true;
                        chosenCoin = c;
                    }
                }
                if (!validOption) {
                    service.displayMessage("Cod incorect. Incercati din nou: ");
                    option = service.readInput();
                }
            }
            sum += chosenCoin.getValue();
        }
        System.out.println();
    }
}
