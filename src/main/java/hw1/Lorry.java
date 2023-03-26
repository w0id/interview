package hw1;

import lombok.experimental.SuperBuilder;

@SuperBuilder //Необходимо использовать, чтобы пробросить билдер из класса-родителя
public class Lorry extends Car implements Moveable, Stopable{ //hw1.Moveable и hw1.Stopable - это интерфейсы. Их нужно имплементить.
    //    @Override необязательно
    public void move(){
        System.out.println("hw1.Lorry is moving");
    }

//    @Override необязательно
    public void stop(){
        System.out.println("hw1.Lorry is stop");
    }

    /**
     * Не был переопределен абстрактный метод open() класса hw1.Car
     */
    @Override
    void open() {
        System.out.println("hw1.Lorry is open");
    }

    /**
     * Можно так же сделать свою реализацию метода start() класса-родителя
     */
    @Override
    protected void start() {
        System.out.println("hw1.Lorry starting");
    }
}
