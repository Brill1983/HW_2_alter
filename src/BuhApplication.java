import java.util.Scanner;

public class BuhApplication {

    private Scanner scanner;
    private ReportService service;
    public void run() {
        scanner = new Scanner(System.in);
        service = new ReportService();

        while(true) {
            printMenu();
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                return;

            } else if(line.equals("1")){
                service.loadMothReports();

            } else if(line.equals("2")){
                System.out.println("2 - Считать годовой отчет.");
            } else if(line.equals("3")){
                System.out.println("3 - Сверить отчеты.");

            } else if(line.equals("4")){
                service.printMothReportsInfo();

            } else if(line.equals("5")){
                System.out.println("5 - Вывести информацию о годовом отчете.");
            } else if(line.equals("0")){
                break;
            } else {
                System.out.println("Неизвестный пункт меню");
            }
        }


    }

    private void printMenu() {
        System.out.println("Введите номер действия, которое хотите выполнить:");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчет.");
        System.out.println("3 - Сверить отчеты.");
        System.out.println("4 - Вывести информацию о всех месячных отчетах.");
        System.out.println("5 - Вывести информацию о годовом отчете.");
        System.out.println("0 - Выход.");
    }
}
