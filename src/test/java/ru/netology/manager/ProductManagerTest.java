package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Граф Монте Кристо", 700, "Александр Дюма");
    Product product2 = new Book(2, "Белый клык", 500, "Джек Лондон");
    Product product3 = new Book(3, "Гарри поттер", 1100, "Джоан Роулинг");
    Product product4 = new Smartphone(4, "Iphone 13", 82_000, "Apple");
    Product product5 = new Smartphone(5, "Samsung S21", 69_000, "Samsung");
    Product product6 = new Smartphone(6, "Honor 50", 21_000, "Honor");

    @BeforeEach
    public void setup(){
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
    }

    @Test
    public void SearchByBookName(){
        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy("Белый клык");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchByInvalidSmartphoneName(){
        Product [] expected = new Product[]{};
        Product [] actual = manager.searchBy("Iphone 6S");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void SearchBySmartphoneName() {
        Product[] expected = new Product[]{product4};
        Product[] actual = manager.searchBy("Iphone 13");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchByAuthor(){
        Product[] expected = new  Product[] {product1};
        Product[] actual = manager.searchBy("Александр Дюма");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void SearchByInvalidAuthor(){
        Product[] expected = {};
        Product[] actual = manager.searchBy("Михаил Лермонтов");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void SearchByManufacturer(){
        Product[] expected = new  Product[] {product6};
        Product[] actual = manager.searchBy("Honor");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void SearchByInvalidManufacturer(){
        Product[] expected = {};
        Product[] actual = manager.searchBy("Ксяоми");
        Assertions.assertArrayEquals(expected, actual);

    }
}
