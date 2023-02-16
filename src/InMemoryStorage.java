import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class InMemoryStorage {
    HashMap<Integer, ArrayList<Item>> monthReports = new LinkedHashMap<>();
    public void saveMonthReport(int year, int month, ArrayList<Item> items) {
        monthReports.put(month,items);
    }

    public Item getMaxEarning(int i) {
        ArrayList<Item> items = monthReports.get(i+1);
        Item max = null;
        int total = 0;
        for (Item item : items) {
            if(item.expense) {
                continue;
            }
            if(item.getTotal() > total) {
                total = item.getTotal();
                max = item;
            }
        }
        return max;
    }

    public Item getMaxExpense(int i) {
        ArrayList<Item> items = monthReports.get(i+1);
        Item max = null;
        int total = 0;
        for (Item item : items) {
            if(!item.expense) {
                continue;
            }
            if(item.getTotal() > total) {
                total = item.getTotal();
                max = item;
            }
        }

        return max;
    }
}
