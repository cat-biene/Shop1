package Shop;
// найти компьютеры со скидкой на BlackFriday

import Shop.model.Computer;

public interface Shop {

    boolean addProduct(Computer product);
    Computer removeProduct(long barCode);
    Computer findProduct(long barCode);
    int quantity();
    void printProducts();
    double calcBlackFridayDiscount(double price);
    Computer[] blackFridayDiscount(double price);



}
