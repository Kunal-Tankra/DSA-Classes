import java.util.Scanner;

public class OOPS {

    public static void main(String args[]) {

        Pen p1 = new Pen();

        // p1.setColor("blue");
        // System.out.println(p1.color);

        // p1.setTip(5);
        // System.out.println(p1.tip);

        // BankAccount acc = new BankAccount();
        // acc.setPassword("blah");

        // p1.setColor("blue");
        // System.out.println(p1.getColor());

        // Student s1 = new Student();
        // s1.name = "Kunal";
        // s1.roll = 123;
        // s1.password = "abcd";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;

        // Student s2 = new Student(s1); // copy s1 things in s2
        // s2.password = "xyz";

        // s1.marks[2] = 100; //change after copy but its still works because dono ek
        // arr ko hi show krte h ya ek ki trf hi point krte hai.. --for shallow copy

        for (int i = 0; i < 3; i++) {
            // System.out.println(s2.marks[i]);
        }

        Fish shark = new Fish();
        // shark.eat();

        Dog dobby = new Dog();
        // dobby.eat();
        dobby.legs = 4;
        // System.out.println(dobby.legs);

        Calculator calc = new Calculator();
        // System.out.println(calc.sum(1, 2));
        // System.out.println(calc.sum((float)1, (float)2.4));
        // System.out.println(calc.sum(1, 2, 4));

        Deer d = new Deer();
        // d.eat();

        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // h.changecolor();
        // System.out.println(h.color);

        // Chicken c = new Chicken();
        // System.out.println(c.color);

        // Mustang myHorse = new Mustang();
        // anima --> horse --> mustang

        Queen q = new Queen();
        // q.moves();

        Duck myDuck = new Duck();
        // myDuck.swim();

        Student1 s1 = new Student1();
        s1.schoolName = "happy";

        Student1 s2 = new Student1();
        // System.out.println(s2.schoolName); //static

        // Horse2 h4 = new Horse2();
        // System.out.println(h4.color);

        // practice questions ans
        Complex c1 = new Complex(-1, 1);
        Complex c2 = new Complex(-1, -2);

        Complex.product(c1, c2);
    }
}

// practice questions
// 1.
class Complex {
    int real, image;

    public Complex(int r, int i) {
        this.real = r;
        this.image = i;
    }

    public static void sum(Complex c1, Complex c2) {
        System.out.println((c1.real + c2.real) + ((c1.image + c2.image) >= 0 ? "+" : "") + (c1.image + c2.image) + "i");
    }

    public static void diff(Complex c1, Complex c2) {
        System.out.println((c1.real - c2.real) + ((c1.image - c2.image) >= 0 ? "+" : "") + (c1.image - c2.image) + "i");
    }

    public static void product(Complex c1, Complex c2) {
        System.out.println(((c1.real*c2.real) - (c1.image*c2.image)) + (((c1.real * c2.image)+ (c1.image*c2.real)) >= 0 ? "+" : "") + ((c1.real * c2.image)+ (c1.image*c2.real)) + "i");

    }
}

// super
class Animal4 {
    String color;

    Animal4() {
        System.out.println("animal constructor is called");
    }
}

class Horse2 extends Animal4 {
    Horse2() {
        super.color = "brown";
        System.out.println("horse constructor is called");
    }
}

// static
class Student1 {
    static int percentage(int phy, int chem, int math) {
        return (phy + chem + math) / 3;
    }

    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

// multiple inheritance by interfaces
interface Fly {
    void fly();
}

interface Swim {
    void swim();
}

class Duck implements Fly, Swim {
    public void fly() {
        System.out.println("can fly");
    }

    public void swim() {
        System.out.println("can swim");
    }
}

// interfaces
interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal (in all 4 directions)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down , left, right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down , left, right, diagonal (by 1 step)");
    }
}

// abstract class
abstract class Animal3 {
    String color;

    Animal3() {
        color = "brown";
        System.out.println("animal constructor called");
    }

    void eat() {
        System.out.println("animals eats");
    }

    abstract void walk();
}

class Horse extends Animal3 {
    Horse() {
        System.out.println("horse constructor called");

    }

    void changecolor() {
        color = "darkBrown";
    }

    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("mustang constructor called");
    }
}

class Chicken extends Animal3 {
    void changecolor() {
        color = "yellow";
    }

    void walk() {
        System.out.println("walks on 2 legs");
    }
}

// function overriding
class Animal2 {
    void eat() {
        System.out.println("eats anything");
    }
}

class Deer extends Animal2 {
    void eat() {
        System.out.println("eats grass");
    }
}

// function overloading
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

// base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breath() {
        System.out.println("breathes");
    }
}

// derived class /subclass
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("swims in water");
    }
}

class shark extends Fish {
    void danger() {
        System.out.println("danger");
    }
}

// derived class
class bird extends Animal {
    void fly() {
        System.out.println("fly in the sky");
    }
}

// derived class
class Mammal extends Animal {
    int legs;

    void walk() {
        System.out.println("walks ");
    }
}

// derived se bhi derived class
class Dog extends Mammal {
    String breed;
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // non parameterised constructor
    Student() {
        marks = new int[3];
        System.out.println("constructor is called...");
    }

    // parameterised consrtructor
    Student(String name) { // for name only
        marks = new int[3];
        this.name = name;
    }

    Student(int roll) { // for rollnumber only
        marks = new int[3];
        this.roll = roll;
    }

    // copy constructor
    // Student(Student s) { //shallow copy
    // marks = new int[3];
    // this.name = s.name;
    // this.roll = s.roll;

    // this.marks = s.marks;

    // }

    Student(Student s) { // deep copy
        marks = new int[3];
        this.name = s.name;
        this.roll = s.roll;

        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s.marks[i];
        }

    }
}

class BankAccount {
    public String userName;
    private String password;

    public void setPassword(String pass) {
        password = pass;
    }
}

class Pen {
    private String color;
    private int tip;

    // getters
    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    // setters
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}