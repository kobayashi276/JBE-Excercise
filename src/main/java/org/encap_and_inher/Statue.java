package org.encap_and_inher;

import java.util.Scanner;

public class Statue extends Item{
    private int weight;
    private String color;

    public Statue() {

    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight of the statue: ");
        this.setWeight(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the color of the statue: ");
        this.setColor(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Statue{" +
                "creator='" + creator + '\'' +
                ", value=" + value +
                ", id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

