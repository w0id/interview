package hw1;

public class Shape {

    public String draw() {
        return "Это просто неизвестная фигура";
    }

    public String draw(Double radius) {
        return "Площадь окружности = " + Double.valueOf(3.14 * radius * radius);
    }

    public String draw(Double base, Double height) {
        return "Площадь треугольника = " + Double.valueOf(0.5 * base * height);
    }

    public String draw(Integer side) {
        return "Площадь квадрата = " + Integer.valueOf(side  *  side);
    }



}
