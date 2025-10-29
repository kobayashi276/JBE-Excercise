package org.exception;

public class ProductManagement {
    private Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) {
        try{
            products[productCount] = product;
            productCount++;
            System.out.println("Added product: " + product);
        }
        catch(Exception e) {
            System.out.println("Out of space. Can't add product.");
        }
    }

    public Product getProductByID(int id) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == id) {
                return products[i];
            }
        }
        throw new ProductNotFoundException("Product with id " + id + " not found.");
    }

    public void updateProductQuantity(int productId, int quantity) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == productId) {
                products[i].setQuantityInStock(quantity);
                System.out.println("Updated product quantity: " + products[i].getQuantityInStock());
                return;
            }
        }
        throw new ProductNotFoundException("Product with id " + productId + " not found.");
    }
}
