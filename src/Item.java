public class Item {
    String name;
    boolean expense;
    int quantity;
    int sum;

    public Item(String name, boolean expense, int quantity, int sum) {
        this.name = name;
        this.expense = expense;
        this.quantity = quantity;
        this.sum = sum;
    }

    int getTotal(){
        return quantity * sum;
    }

   /* @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", expense=" + expense +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }*/
}
