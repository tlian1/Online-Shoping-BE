package StreamAPI;

public class LiskovSubstitution {

}
class Bird {
    void fly() {}
}

class Penguin extends Bird {
    void fly() {throw new RuntimeException();}
}

interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {}
}

class Penguin2 {
    void swim() {}
}

