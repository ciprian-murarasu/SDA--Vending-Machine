package VM;

import model.Coin;
import model.CurrencyType;
import model.Product;
import service.IOService;

import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachine {
    private Map<Product, Integer> productStock;
    private Map<Coin, Integer> coinStock;
    private IOService service;
    private CurrencyType currency;

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

    public Product selectProduct(int code) {
        for (Product p : productStock.keySet()) {
            if (p.getCode() == code && productStock.get(p) > 0) {
                return p;
            }
        }
        return null;
    }

    public Coin selectCoin(int code) {
        for (Coin c : coinStock.keySet()) {
            if (c.getCode() == code && coinStock.get(c) > 0) {
                return c;
            }
        }
        return null;
    }

    public void payProduct(int sum, Product chosenProduct) {
//        int sum = 0;
        Map<Coin, Integer> tempCoins = new LinkedHashMap<>(coinStock);
        while (sum < chosenProduct.getPrice()) {
            service.displayMessage("Credit: " + sum + " " + currency + ". Introduceti suma: ");
            int option = service.readInput();
            if (option == 0) {
                service.displayProductMenu(productStock);
                service.displayExitProducts();
                break;
            }
            Coin chosenCoin = selectCoin(option);
            if (chosenCoin != null) {
//                boolean validOption = false;
//                while (!validOption) {
//                    for (Coin c : transactionCoins.keySet()) {
//                        if (c.getCode() == option && transactionCoins.get(c) > 0) {
//                            validOption = true;
//                            chosenCoin = c;
//                        }
//                    }

                sum += chosenCoin.getValue();
                tempCoins.replace(chosenCoin, tempCoins.get(chosenCoin) + 1);
//                }
            } else {
                service.displayMessage("Cod incorect. Incercati din nou: ");
                option = service.readInput();
            }
        }
        if (sum >= chosenProduct.getPrice()) {
            coinStock = tempCoins;
        }
        productStock.replace(chosenProduct, productStock.get(chosenProduct) - 1);
        int rest = sum - chosenProduct.getPrice();
        while (rest > 0) {
            boolean hasRest = false;
            for (Coin c : coinStock.keySet()) {
                if (coinStock.get(c) > 0 && rest >= c.getValue()) {
                    hasRest = true;
                    break;
                }
            }
            if (hasRest) {
                Coin maxCoin = new Coin(0, 0);
                for (Coin c : coinStock.keySet()) {
                    if (c.getValue() > maxCoin.getValue())
                        maxCoin = c;
                }
                rest -= maxCoin.getValue();
                coinStock.replace(maxCoin, coinStock.get(maxCoin) - 1);
            } else {
                System.out.println("Ne pare rau, nu avem suficient rest de dat. Mai puteti alege un alt produs.");
                service.displayMessage("Selectati o optiune: ");
                int option = service.readInput();
                chosenProduct = selectProduct(option);
                payProduct(rest, chosenProduct);
//                break;
            }
        }
//        return sum;
    }

    private void payRest() {

    }

    public void run() {
        boolean isVMEmpty = true;
        for (Product p : productStock.keySet()) {
            if (productStock.get(p) > 0) {
                isVMEmpty = false;
                break;
            }
        }
        if (isVMEmpty) {
            System.out.println("Aparatul este gol!");
        } else {
            service.displayProductMenu(productStock);
        }
        service.displayExitProducts();
//        service.displayServiceOption();
        service.displayMessage("Selectati o optiune: ");
        int option = service.readInput();

        if (option == 0) {
            System.exit(0);
        }
        boolean validOption = false;
        Product chosenProduct = selectProduct(option);
        while (!validOption) {
            if (chosenProduct != null) {
                validOption = true;
                service.displayCoinMenu(coinStock);
//                service.displayExitCoins();
//                service.displayMessage("Selectati o optiune: ");
//                option = service.readInput();
                payProduct(0,chosenProduct);
            } else if (option == 992) {
                validOption = true;
                boolean inServiceMenu = true;
                while (inServiceMenu) {
                    service.displayServiceMenu();
                    service.displayMessage("Selectati o optiune: ");
                    option = service.readInput();
                    if (option == 0) {
                        System.exit(0);
                    } else {
                        if ((option < 993 && option != 0) || option > 997)
                            validOption = false;
                        while (!validOption) {

                            if (option == 993 || option == 996 || option == 997) {
                                validOption = true;
                                service.displayProductMenu(productStock);
                                service.displayGoBackOption();
                                service.displayMessage("Selectati o optiune: ");
                                option = service.readInput();
                                if (option == 0) {
                                    service.displayServiceMenu();
                                    service.displayMessage("Selectati o optiune: ");
                                    option = service.readInput();
                                    if (option == 0) {
                                        inServiceMenu = false;
                                    }
                                }
                            }
                            if (!validOption) {
                                service.displayMessage("Cod incorect. Incercati din nou: ");
                                option = service.readInput();
                            }
                        }
                    }
                }
            } else {
                service.displayMessage("Cod incorect. Incercati din nou: ");
                option = service.readInput();
            }
//            System.out.println();
//            if (chosenProduct != null) {
//                service.displayCoinMenu(coinStock);
//                int sum = 0;
//                while (sum < chosenProduct.getPrice()) {
//                    service.displayMessage("Credit: " + sum + ". Introduceti suma: ");
//                    option = service.readInput();
//                    Map<Coin, Integer> transactionCoins = coinStock;
//                    validOption = false;
//                    Coin chosenCoin = null;
//                    while (!validOption) {
//                        if (option == 0) {
//                            validOption = true;
//                            service.displayProductMenu(productStock);
//                            break;
//                        } else {
//                            for (Coin c : transactionCoins.keySet()) {
//                                if (c.getCode() == option && transactionCoins.get(c) > 0) {
//                                    validOption = true;
//                                    chosenCoin = c;
//                                }
//                            }
//                            if (!validOption) {
//                                service.displayMessage("Cod incorect. Incercati din nou: ");
//                                option = service.readInput();
//                            }
//                        }
//                        sum += chosenCoin.getValue();
//                        coinStock.replace(chosenCoin, transactionCoins.get(chosenCoin) + 1);
//                    }
//                }
//                System.out.println();
//                productStock.replace(chosenProduct, productStock.get(chosenProduct) - 1);
//
            service.displayProductMenu(productStock);
            service.displayCoinMenu(coinStock);
//            }
        }
    }
}
