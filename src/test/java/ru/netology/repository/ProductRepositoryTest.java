package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Граф Монте Кристо", 700, "Александр Дюма");
    Product product2 = new Book(2, "Белый клык", 500, "Джек Лондон");
    Product product3 = new Book(3, "Гарри поттер", 1100, "Джоан Роулинг");
    Product product4 = new Smartphone(4, "Iphone 13", 82_000, "Apple");
    Product product5 = new Smartphone(5, "Samsung S21", 69_000, "Samsung");
    Product product6 = new Smartphone(6, "Honor 50", 21_000, "Honor");

    @BeforeEach
    public void setup(){
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }

    @Test
    public void ShouldSaveProducts(){
        Product[] expected  = new Product[] {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldRemoveById(){
        repo.RemoveById(4);

        Product[] expected = new Product[]{product1, product2, product3, product5, product6};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetNotFoundException () {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.RemoveById(20);
        });
    }
    @Test
    public void shouldGetAlreadyExistsException (){
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product5);
        });
    }
}
