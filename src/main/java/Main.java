import VM.VendingMachine;
import model.Coin;
import model.CurrencyType;
import model.Product;
import service.IOService;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Product, Integer> productStock = new LinkedHashMap<Product, Integer>();
        Map<Coin, Integer> coinStock = new LinkedHashMap<Coin, Integer>();
        productStock.put(new Product(101, "Cola", 3, "0.5 L"), 50);
        productStock.put(new Product(102, "Coca Cola", 5, "1 L"), 30);
        productStock.put(new Product(103, "Snickers", 2, "75 g"), 20);
        coinStock.put(new Coin(201, 10), 20);
        coinStock.put(new Coin(202, 5), 25);
        coinStock.put(new Coin(203, 1), 50);

        VendingMachine vm = new VendingMachine(productStock, coinStock, new IOService(), CurrencyType.RON);
        vm.run();
    }
}
