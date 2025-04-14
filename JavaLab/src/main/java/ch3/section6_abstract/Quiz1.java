package ch3.section6_abstract;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void makeSound();
}

interface Printable {
    void print();
}

class Dog extends Animal implements Printable {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog makeSound");
    }

    public void fetch() {System.out.println("Dog fetch");}

    @Override
    public void print() {
        System.out.println("Dog print");
        System.out.println("이름: " + getName());
        System.out.println("나이: " + getAge());
        System.out.println("품종: " + breed);
    }
}

class Cat extends Animal implements Printable {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {System.out.println("Cat makeSound");}

    public void climb() {System.out.println("Cat climb");}

    @Override
    public void print() {
        System.out.println("Cat print");
        System.out.println("이름: " + getName());
        System.out.println("나이: " + getAge());
        System.out.println("색상: " + color);
    }
}

class Document implements Printable {
    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void print() {
        System.out.println("Document print");
        System.out.println("제목: " + getTitle());
        System.out.println("내용: " + getContent());
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        Dog dog = new Dog("강아지", 1, "푸들");
        dog.makeSound();
        dog.fetch();
        dog.print();

        Cat cat = new Cat("고양이", 2, "흰색");
        cat.makeSound();
        cat.climb();
        cat.print();

        Document doc = new Document("제목", "내용");
        doc.print();
    }
}
