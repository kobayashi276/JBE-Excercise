package org.encap_and_inher;

public class ItemList {
    Item[] list;
    int numOfItems;
    final int MAX = 100;
    public ItemList() {
        list = new Item[MAX];
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItems >= MAX) return false;

        list[numOfItems] = item;
        numOfItems++;

        return true;
    }

    public void displayAll(){
        for (int i = 0; i<numOfItems; i++){
            System.out.println(list[i].toString());
        }
    }

    public Item findItem(String creator){
        for (int i = 0; i<numOfItems; i++){
            if (list[i].getCreator().equals(creator)){
                return list[i];
            }
        }
        return null;
    }

    public boolean updateItem(String id){
        for (int i = 0; i<numOfItems; i++){
            if (list[i].getId().equals(id)){
                list[i].input();
                return true;
            }
        }
        return false;
    }

    public void displayItemsByType(String type) {
        if (type.equals("VASE")) {
            for (int i = 0; i < numOfItems; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equals("STATUE")) {
            for (int i = 0; i < numOfItems; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                }
            }
        } else {
            for (int i = 0; i < numOfItems; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                }
            }
        }
    }

}
