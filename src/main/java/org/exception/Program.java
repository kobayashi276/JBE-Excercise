package org.exception;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        try {
            pm.addProduct(new Product(101, "Laptop", 999.99, 10));
            pm.addProduct(new Product(102, "Smartphone", 799.99, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product = pm.getProductByID(101);
            product.displayProductInfo();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            pm.updateProductQuantity(102, 15);
        } catch (ProductNotFoundException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        byte choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Add product");
            System.out.println("2. Receive product by ID");
            System.out.println("3. Update product quantity");
            System.out.println("4. Exit program");
            choice = sc.nextByte();
            sc.nextLine();

            switch (choice) {
                case 1:
                    double productPrice;
                    int productQuantity;
                    int productID;
                    String productName;
                    try {
                        System.out.println("Enter product ID:");
                        productID = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter product name:");
                        productName = sc.nextLine();
                        System.out.println("Enter product price:");
                        productPrice = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter product quantity:");
                        productQuantity = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        break;
                    }

                    Product newProduct = new Product(productID, productName, productPrice, productQuantity);
                    pm.addProduct(newProduct);
                    break;
                case 2:
                    int pID;
                    try{
                        System.out.println("Enter product ID:");
                        pID = sc.nextInt();
                        sc.nextLine();
                        Product p = pm.getProductByID(pID);
                        p.displayProductInfo();
                    }
                    catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    int pID_2;
                    int pQuantity;
                    try{
                        System.out.println("Enter product ID:");
                        pID_2 = sc.nextInt();
                        sc.nextLine();
                        Product p = pm.getProductByID(pID_2);
                        System.out.println("Enter product quantity:");
                        pQuantity = sc.nextInt();
                        sc.nextLine();
                        p.setQuantityInStock(pQuantity);
                    }
                    catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        while (choice != 4);

    }
}
