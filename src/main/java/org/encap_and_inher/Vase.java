package org.encap_and_inher;

import java.util.Scanner;

public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {

    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the vase: ");
        height = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the material: ");
        material = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Vase{" +
                "material='" + material + '\'' +
                ", id='" + id + '\'' +
                ", value=" + value +
                ", creator='" + creator + '\'' +
                ", height=" + height +
                '}';
    }
}
