import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportService {
    InMemoryStorage storage = new InMemoryStorage(); //создаем объект класса InMemoryStorage, где будем хранить items
    String[] monthName = {"Январь", "Февраль", "Март"};
    // , "Апрель", "Май", "Июнь", "Август", "Сентябрь", "Октабрь",
    //            "Ноябрь", "Декабрь"
    public void loadMothReports() {
        for(int i = 1; i <=3; i++) { // 2. Каждый список с объектами item по циклу записывается в объект storage
            ArrayList<Item> items = loadMonthReport("./resources/m.20210" + i + ".csv"); // загрузиди в список
            storage.saveMonthReport(2021, i, items); // сохраняем в объект storage на позицию i список items
            // год по заданию хранить не обязательно - дополнительная опция
        }
    }
    // 1. каждая строка из файла станет объектом, объекты с полями записываются в список ндля 1-ого месяца.
    ArrayList<Item> loadMonthReport(String path) { // функция по преобразованию строки в список с объектами
        List<String> lines = readFileContents(path); // считали из файла список со строками в переменную lines
        ArrayList<Item> items = new ArrayList<>(); // объявили новый список items, где будем хранить разбитые строки
        for (int i = 1; i < lines.size(); i++) { // проходим по списку ines
            String line = lines.get(i); // вынимаем по очереди из списка строку в новую переменную line
            String[] rows = line.split(","); // разбиваем сроку line на элементы по (,)
            Item item = new Item(rows[0], // создаем объект item класса Item, в поля которого будем записывать элементы из line
                    Boolean.parseBoolean(rows[1]),
                    Integer.parseInt(rows[2]),
                    Integer.parseInt(rows[3]));
            items.add(item); // в список items записываем объект item класса Item
        }
        return items; // возвращаем список items из объектов
    }

    public void printMothReportsInfo() {
        System.out.println(storage.monthReports);
        for(int i = 0; i < monthName.length; i++) {
            System.out.println("Месяц: " + getMonthName(i));
            Item maxEarning = storage.getMaxEarning(i);
            System.out.println("Максимальный доход. Товар " + maxEarning.name + ". Сумма: " + maxEarning.getTotal());
            Item maxExpense = storage.getMaxExpense(i);
            System.out.println("Максимальная трата. Товар " + maxExpense.name + ". Сумма: " + maxExpense.getTotal());
        }
    }

    private String getMonthName(int month) {
        String nameOfMonth = monthName[month];
        return nameOfMonth;
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}