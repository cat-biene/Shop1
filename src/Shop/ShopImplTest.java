package Shop;

import Shop.model.Computer;
import Shop.model.SmartPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {

    Shop shop;
    Computer[] product;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(10);
        product = new Computer[5];
        product[0] = new Computer(101l, "2.7", "Acer", 800);
        product[1] = new Computer(102l, "2.2", "HP", 650);
        product[2] = new SmartPhone(103l, "2.1", "Samsung", 320);
        product[3] = new SmartPhone(104l, "2.8", "Redmi", 250);

        for (int i = 0; i < product.length; i++) {
            shop.addProduct(product[i]);
        }
    }

    @Test
    void addProduct() {
        shop.printProducts();
        assertFalse(shop.addProduct(product[1]));
        assertFalse(shop.addProduct(null));
        System.out.println("***     ***     ***     ***     ***");
        Computer product = new Computer(105, "2.7", "Acer", 800);
        assertTrue(shop.addProduct(product));
        assertEquals(5, shop.quantity());
        shop.printProducts();

    }

    @Test
    void removeProduct() {
        shop.printProducts();
        assertEquals(product[1], shop.removeProduct(102l));
        assertEquals(3, shop.quantity());
        System.out.println("***     ***     ***     ***     ***");
        shop.printProducts();
    }

    @Test
    void findProduct() {
        shop.printProducts();
        assertEquals(product[1], shop.findProduct(102l));
        assertNull(shop.findProduct(105l));
    }

    @Test
    void quantity() {
        shop.printProducts();
        assertEquals(4, shop.quantity());
    }

    @Test
    void printProducts() {
        shop.printProducts();
    }

    @Test
    void calcBlackFridayDiscount() {
        assertEquals(400, shop.calcBlackFridayDiscount(800), 0.001);
    }

    }
