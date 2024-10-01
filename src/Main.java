import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        // Добавляем ноутбуки
        notebooks.add(new Notebook("Windows", 8, 512, "Black"));
        notebooks.add(new Notebook("Linux", 16, 256, "Silver"));
        notebooks.add(new Notebook("Windows", 16, 1024, "White"));
        notebooks.add(new Notebook("macOS", 8, 512, "Space Gray"));

        // Пользовательская фильтрация
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> criteria = new HashMap<>();

        System.out.println("Выберите критерии фильтрации (введите цифры через пробел):");
        System.out.println("1 - ОЗУ (Введите минимальное значение в ГБ)");
        System.out.println("2 - Объем ЖД (Введите минимальное значение в ГБ)");
        System.out.println("3 - Операционная система (Введите название)");
        System.out.println("4 - Цвет (Введите цвет)");

        String input = scanner.nextLine();
        String[] choices = input.split(" ");

        for (String choice : choices) {
            int criterion = Integer.parseInt(choice);
            System.out.println("Введите значение для критерия " + criterion + ":");
            String value = scanner.nextLine();
            criteria.put(criterion, value);
        }

        // Фильтрация
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, criteria);
        System.out.println("Найденные ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }

        scanner.close();
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<Integer, String> criteria) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean matches = true;

            if (criteria.containsKey(1)) {
                int requiredRam = Integer.parseInt(criteria.get(1));
                if (notebook.getRam() < requiredRam) {
                    matches = false;
                }
            }

            if (criteria.containsKey(2)) {
                int requiredHardDisk = Integer.parseInt(criteria.get(2));
                if (notebook.getHardDisk() < requiredHardDisk) {
                    matches = false;
                }
            }

            if (criteria.containsKey(3)) {
                String requiredOS = criteria.get(3);
                if (!notebook.getOperatingSystem().equalsIgnoreCase(requiredOS)) {
                    matches = false;
                }
            }

            if (criteria.containsKey(4)) {
                String requiredColor = criteria.get(4);
                if (!notebook.getColor().equalsIgnoreCase(requiredColor)) {
                    matches = false;
                }
            }

            if (matches) {
                result.add(notebook);
            }
        }

        return result;
    }
}