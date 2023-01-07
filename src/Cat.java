import java.util.List;
import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int satiety;
    private int mood;
    private int health;
    private int average;
    private static List<String> names = List.of("Kiko", "Milky", "Donut", "Suso");

    Random rnd = new Random();

    public Cat(int i) {
        name = names.get(i);
        age = rnd.nextInt(17)+1;
        satiety = rnd.nextInt(100);
        mood = rnd.nextInt(100);
        health = rnd.nextInt(100);
        average = (health + mood + satiety) / 3;
    }

    public Cat() {

    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
