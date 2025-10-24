package org.encap_and_inher;

import java.util.Scanner;

public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        byte choice = 0;
        do{
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator ");
            System.out.println("6. Display the list of vase items ");
            System.out.println("7. Quit");
            System.out.print("Input your choice: ");
            choice = sc.nextByte();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Vase item = new Vase();
                    item.input();
                    if (itemList.addItem(item)) {
                        System.out.println("added");
                    }
                    break;
                case 2:
                    Statue item2 = new Statue();
                    item2.input();
                    if (itemList.addItem(item2)) {
                        System.out.println("added");
                    }
                    break;

                case 3:
                    Painting item3 = new Painting();
                    item3.input();
                    if (itemList.addItem(item3)) {
                        System.out.println("added");
                    }
                    break;
                case 4:
                    itemList.displayAll();
                    break;
                case 5:
                    System.out.println("Creator you want to find: ");
                    String creator = sc.nextLine();
                    System.out.println(itemList.findItem(creator));
                    break;
                case 6:
                    itemList.displayItemsByType("VASE");
                    break;
                case 7:
                    return;
            }

        } while (choice <= 6);

    }
}
