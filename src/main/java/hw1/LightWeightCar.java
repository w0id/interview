package hw1;

import lombok.experimental.SuperBuilder;

@SuperBuilder //Необходимо использовать, чтобы пробросить билдер из класса-родителя
public class LightWeightCar extends Car implements Moveable {
//    @Override необязательно
    void open() {
        System.out.println("hw1.Car is open");
    }

//    @Override необязательно
    public void move() {
        System.out.println("hw1.Car is moving");
    }
}
