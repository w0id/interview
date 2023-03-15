import lombok.experimental.SuperBuilder;

@SuperBuilder //Необходимо использовать, чтобы пробросить билдер из класса-родителя
public class Lorry extends Car implements Moveable, Stopable{ //Moveable и Stopable - это интерфейсы. Их нужно имплементить.
    //    @Override необязательно
    public void move(){
        System.out.println("Lorry is moving");
    }

//    @Override необязательно
    public void stop(){
        System.out.println("Lorry is stop");
    }

    /**
     * Не был переопределен абстрактный метод open() класса Car
     */
    @Override
    void open() {
        System.out.println("Lorry is open");
    }

    /**
     * Можно так же сделать свою реализацию метода start() класса-родителя
     */
    @Override
    protected void start() {
        System.out.println("Lorry starting");
    }
}
