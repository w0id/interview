package hw2;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        System.out.println("Первый элемент");
        stringLinkedList.add("Hello");
        stringLinkedList.print();
        System.out.println("\nВторой элемент");
        stringLinkedList.add("Codekru");
        stringLinkedList.print();
        System.out.println("\nТретий элемент");
        stringLinkedList.add("Codekru2");
        stringLinkedList.print();
        System.out.println("\nЭлемент по индексу 1: " + stringLinkedList.get(1));
        System.out.println("Индекс элемента Codekru2: " + stringLinkedList.indexOf("Codekru2"));
        System.out.println("\nУдаление последнего элемента");
        stringLinkedList.removeLast();
        stringLinkedList.print();
    }
}
