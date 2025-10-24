package org.encap_and_inher;

import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.id = sc.nextLine();
        System.out.println("Enter Value: ");
        this.value = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Creator: ");
        this.creator = sc.nextLine();
    }

    public String toString() {
        return String.format("ID %s, Value: %d, Creator: %s", this.id, this.value, this.creator);
    }
}
