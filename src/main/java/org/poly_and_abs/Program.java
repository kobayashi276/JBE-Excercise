package org.poly_and_abs;

import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProducts = 0;
    private static final int MAX = 100;

    public Program() {
        products = new Product[MAX];
    }

    public void addProduct(Product product) {
        if (numOfProducts < MAX) {
            products[numOfProducts] = product;
            numOfProducts++;
            System.out.println("Product added successfully.");
        }
        else{
            System.out.println("Maximum product reached.");
        }
    }

    public void displayProducts() {
        for (int i = 0; i < numOfProducts; i++) {
            System.out.println(products[i].toString());
        }
    }

    public Product findProduct(int id){
        for (int i = 0; i < numOfProducts; i++) {
            if (products[i].id == id){
                return products[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Program program = new Program();
        Scanner scanner = new Scanner(System.in);
        final int ADD = 1;
        final int DISPLAY = 2;
        final int FIND = 3;
        final int EXIT = 4;
        final int ELECTRONICS = 1;
        final int CLOTHING = 2;
        final int RETURN = 3;
        byte choice;

        do {

            System.out.println("1. Add Product");

            System.out.println("2. Display Products");

            System.out.println("3. Find Product");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case ADD:
                    byte subchoice;
                    System.out.println("1. Electronics");
                    System.out.println("2. Clothing");
                    System.out.println("3. Return");

                    subchoice = scanner.nextByte();
                    scanner.nextLine();

                    if (subchoice == RETURN) {
                        break;
                    }
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter product price: ");
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    int id = program.numOfProducts + 1;
                    switch (subchoice) {
                        case ELECTRONICS:
                            System.out.println("Enter product brand: ");
                            String brand = scanner.nextLine();

                            Electronics newElectronic = new Electronics(id, name, price, brand);

                            program.addProduct(newElectronic);
                            break;
                        case CLOTHING:
                            System.out.println("Enter product size: ");
                            String size = scanner.nextLine();

                            Clothing newClothing = new Clothing(id, name, price, size);

                            program.addProduct(newClothing);
                            break;
                    }

                    break;

                case DISPLAY:
                    program.displayProducts();
                    break;

                case FIND:
                    System.out.println("Enter product id: ");
                    int idFind = scanner.nextInt();
                    scanner.nextLine();

                    Product foundProduct = program.findProduct(idFind);
                    if (foundProduct != null) {
                        System.out.println(foundProduct.toString());
                    }
                    else{
                        System.out.println("Product not found.");
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}
