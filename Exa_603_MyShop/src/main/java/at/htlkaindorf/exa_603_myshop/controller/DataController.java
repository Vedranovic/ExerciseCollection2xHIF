package at.htlkaindorf.exa_603_myshop.controller;

import at.htlkaindorf.exa_603_myshop.pojos.IOAccess;
import at.htlkaindorf.exa_603_myshop.pojos.Order;
import at.htlkaindorf.exa_603_myshop.pojos.OrderLine;
import at.htlkaindorf.exa_603_myshop.pojos.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataController {
    private ObservableList<Order> orders;
    private List<Product> products;

    public DataController() {
        orders = FXCollections.observableArrayList();
        products = new ArrayList<>();
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();

        for (Product product : products) {
            String category = product.getCategory();

            if (!categories.contains(category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    public void loadProducts() throws IOException {
        products = IOAccess.loadProducts();
        Collections.sort(products);
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteOrder(int index) {
        orders.remove(index);
    }

    public void addToCart(Product product, int orderIndex) {

    }

    public void printOrder(Path path, int index) {
        IOAccess.writeInvoice(path, orders.get(index));
    }

    public void deleteProduct(OrderLine line, int orderIndex) {

    }
}
