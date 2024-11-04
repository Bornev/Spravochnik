import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
        addInitialEmployees();
    }

    private void addInitialEmployees() {
        addEmployee(new Employee(1, "+7-911-111-11-11", "Ivanov Ivan", 5));
        addEmployee(new Employee(2, "+7-922-222-22-22", "Petrov Petr", 3));
        addEmployee(new Employee(3, "+7-933-333-33-33", "Sidorova Anna", 7));
        addEmployee(new Employee(4, "+7-944-444-44-44", "Kozlov Mikhail", 2));
        addEmployee(new Employee(5, "+7-955-555-55-55", "Morozova Elena", 4));
        addEmployee(new Employee(6, "+7-966-666-66-66", "Volkov Andrey", 6));
        addEmployee(new Employee(7, "+7-977-777-77-77", "Sokolova Mariya", 3));
        addEmployee(new Employee(8, "+7-988-888-88-88", "Lebedev Dmitriy", 8));
        addEmployee(new Employee(9, "+7-999-999-99-99", "Novikova Olga", 1));
        addEmployee(new Employee(10, "+7-900-000-00-00", "Komarov Sergey", 5));
        addEmployee(new Employee(11, "+7-901-111-11-11", "Popova Tatyana", 4));
        addEmployee(new Employee(12, "+7-902-222-22-22", "Solovyov Aleksandr", 9));
        addEmployee(new Employee(13, "+7-902-222-11-22", "Solovyeva Tatyana", 7));
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findByExperience(int experience) {
        return employees.stream()
                .filter(emp -> emp.getExperience() == experience)
                .collect(Collectors.toList());
    }

    public List<Employee> findByName(String searchName) {
        String searchLower = searchName.toLowerCase().trim();
        return employees.stream()
                .filter(emp -> emp.getName().toLowerCase().contains(searchLower))
                .collect(Collectors.toList());
    }

    
    public Employee findById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}