package hw1;

import lombok.experimental.SuperBuilder;

@SuperBuilder // Для удобства можно использовать билдер
public abstract class Car {
    public Engine engine; // Нет соответствующего класса
    private String color;
    private String name;
    protected void start() {
        System.out.println("hw1.Car starting");
    }
    abstract void open();

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
