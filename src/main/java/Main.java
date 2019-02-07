import VM.VendingMachine;
import model.Coin;
import model.CurrencyType;
import model.Product;
import service.IOService;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Product, Integer> productStock = new LinkedHashMap<>();
        Map<Coin, Integer> coinStock = new LinkedHashMap<>();
        productStock.put(new Product(101, "Coca Cola", 3, "0.5 L"), 50);
        productStock.put(new Product(102, "Coca Cola Zero", 5, "1 L"), 30);
        productStock.put(new Product(103, "Snickers", 2, "75 g"), 60);
        productStock.put(new Product(104, "7days", 3, "75 g"), 15);
        productStock.put(new Product(105, "Pepsi Twist Lemon", 3, "330 ml"), 25);
        productStock.put(new Product(106, "Chio Chips Intense meat & mustard", 4, "100 g"), 44);
        productStock.put(new Product(107, "Chio Chips Exxtra grilled steak", 4, "100 g"), 0);

        coinStock.put(new Coin(201, 10), 20);
        coinStock.put(new Coin(202, 5), 25);
        coinStock.put(new Coin(203, 1), 0);
        coinStock.put(new Coin(204, 2), 0);

        VendingMachine vm = new VendingMachine(productStock, coinStock, new IOService(), CurrencyType.RON);
        vm.run();
    }
}
