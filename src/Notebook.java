import java.util.Objects;

public class Notebook {
    private String operatingSystem;
    private int ram; // ОЗУ в ГБ
    private int hardDisk; // Объем ЖД в ГБ
    private String color; // Цвет

    public Notebook(String operatingSystem, int ram, int hardDisk, String color) {
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.color = color;
    }

    // Геттеры
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", ram=" + ram +
                ", hardDisk=" + hardDisk +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook)) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram &&
                hardDisk == notebook.hardDisk &&
                Objects.equals(operatingSystem, notebook.operatingSystem) &&
                Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatingSystem, ram, hardDisk, color);
    }
}