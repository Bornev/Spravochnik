// import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private static EmployeeDirectory directory = new EmployeeDirectory();

    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        while (true) {
            printMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1:
                    showAllEmployees();
                    break;
                case 2:
                    searchByExperience();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    addNewEmployee();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println("\nНажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Справочник сотрудников ===");
        System.out.println("1. Показать всех сотрудников");
        System.out.println("2. Поиск по стажу");
        System.out.println("3. Поиск телефона по имени");
        System.out.println("4. Поиск по табельному номеру");
        System.out.println("5. Добавить нового сотрудника");
        System.out.println("0. Выход");
    }

    private static void showAllEmployees() {
        System.out.println("\nСписок всех сотрудников:");
        directory.getAllEmployees().forEach(System.out::println);
    }

    private static void searchByExperience() {
        int experience = getIntInput("Введите стаж для поиска: ");
        List<Employee> found = directory.findByExperience(experience);
        if (found.isEmpty()) {
            System.out.println("Сотрудники с таким стажем не найдены.");
        } else {
            System.out.println("\nНайденные сотрудники:");
            found.forEach(System.out::println);
        }
    }

     private static void searchByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        System.out.println(name);
        List<Employee> foundEmployees = directory.findByName(name);
        
        if (foundEmployees.isEmpty()) {
            System.out.println("Сотрудники с таким именем не найдены.");
        } else {
            System.out.println("\nНайденные сотрудники:");
            for (Employee emp : foundEmployees) {
                System.out.println(emp);
            }
        }
    }


    private static void searchById() {
        int id = getIntInput("Введите табельный номер: ");
        Employee employee = directory.findById(id);
        if (employee == null) {
            System.out.println("Сотрудник с таким табельным номером не найден.");
        } else {
            System.out.println("\nНайденный сотрудник:");
            System.out.println(employee);
        }
    }

    private static void addNewEmployee() {
        int id = getIntInput("Введите табельный номер: ");
        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        int experience = getIntInput("Введите стаж: ");

        Employee newEmployee = new Employee(id, phone, name, experience);
        directory.addEmployee(newEmployee);
        System.out.println("Сотрудник успешно добавлен!");
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Пожалуйста, введите положительное число.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
    }
}