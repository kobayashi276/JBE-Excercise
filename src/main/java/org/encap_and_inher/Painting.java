package org.encap_and_inher;

import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {

    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }

    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the painting: ");
        this.setHeight(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the width of the painting: ");
        this.setWidth(Integer.parseInt(sc.nextLine()));
        System.out.println("Is water color? : ");
        this.setWaterColor(Boolean.parseBoolean(sc.nextLine()));
        System.out.println("Is framed? : ");
        this.setFramed(Boolean.parseBoolean(sc.nextLine()));
    }

    @Override
    public String toString() {
        return "Painting{" +
                "isFramed=" + isFramed +
                ", id='" + id + '\'' +
                ", value=" + value +
                ", creator='" + creator + '\'' +
                ", isWaterColor=" + isWaterColor +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
