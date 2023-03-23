package hw1;

public class Main {

    public static void main(String[] args) {
        System.out.println(Person.builder()
                .firstName("Name")
                .lastName("Lastname")
                .middleName("Middlename")
                .age(20)
                .gender("М")
                .country("Россия")
                .address("Краснодар")
                .build());

        Lorry lorry = Lorry.builder()
                .self()
                .name("Volvo")
                .color("red")
                .engine(new Engine("Diesel", 8))
                .build();
        System.out.println("\nhw1.Lorry name is " + lorry.getName());
        System.out.println("hw1.Lorry color is " + lorry.getColor());
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();

        LightWeightCar lwCar = LightWeightCar.builder()
                .name("Kia")
                .color("grey")
                .engine(new Engine("Gasoline", 4))
                .build();
        System.out.println("\nhw1.Car name is " + lwCar.getName());
        System.out.println("hw1.Car color is " + lwCar.getColor());
        lwCar.open();
        lwCar.start();
        lwCar.move();

        Shape shape = new Shape();
        System.out.println("\n" + shape.draw());
        System.out.println(shape.draw(2d));
        System.out.println(shape.draw(4d,1.4d));
        System.out.println(shape.draw(5));

    }
}
