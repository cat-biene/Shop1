package Shop;

import Shop.model.Computer;

public class ShopImpl implements Shop {

    private Computer[] products; // создаем массив для хранения компьютеров и смартфонов
    private int size; // назначаем переменную для определенния текущего значеия компьютеров и смартфонов

    public ShopImpl(int capacity) {
        products = new Computer[capacity]; // создаем место для хранения компьютеров  и смартфонов в магазине
    }

    @Override
    public boolean addProduct(Computer product) {
        if (product == null || findProduct(product.getBarCode()) != null || size == products.length) {
            return false;
        }
        products[size] = product;
        size++;
        return true;
    }

    @Override
    public Computer removeProduct(long barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) {
                Computer removeProduct = products[i];
                products[i] = products[size - 1];
                products[size - 1] = null;
                size--;
                return removeProduct;
            }
        }
        return null;
    }

    @Override
    public Computer findProduct(long barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) {
                return products[i];
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printProducts() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    @Override
    public double calcBlackFridayDiscount(double price) {
        return price * 0.5;

    }


    @Override
    public Computer[] blackFridayDiscount(double price) {
        // поиск продуктов со скидкой на Black Friday в пределах заданной цены
        int count = 0;
        for (int i = 0; i < size; i++) { //считаем сколько элементов будет, которые соотетствуют заданым критериям
            if (products[i].getPrice() == price)
                count++;
        }
        Computer[] res = new Computer[count]; // создаем массив размером с count
        for (int i = 0, j = 0; j < res.length; i++) {
            if (products[i].getPrice() == price) {
                products[i].setPrice(calcBlackFridayDiscount(products[i].getPrice()));

                // products[i].setPrice(calcBlackFridayDiscount(products[i].getPrice()));
                res[j++] = products[i];
            }
        }
        return res;
    }
}
