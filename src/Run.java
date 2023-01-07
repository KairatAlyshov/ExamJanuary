import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
    static Scanner sc = new Scanner(System.in);
    private static List<Cat> cats = new ArrayList<>();


    public  static void fillList(){
        for (int i = 0; i < 4; i++) {
            cats.add(new Cat(i));
        }
    }

    public static void catDetails(){
        System.out.println("---+---------+---------+---------+---------+---------+---------+\n"+
                " # |   name  |   Age   |  Health |   Mood  | Satiety | Average |");
        int number = 0;

        cats.sort((e1, e2) -> e2.getAverage() - e1.getAverage());
        for (Cat cat : cats) {
        number++;
        System.out.printf(" %s | %-7s | %-7s | %-7s | %-7s | %-7s | %-7s |%n", number, cat.getName(),
                cat.getAge(),cat.getHealth(),cat.getMood(), cat.getSatiety(), cat.getAverage());
    }
        System.out.println("---+---------+---------+---------+---------+---------+---------+");

}

public static void addCat() {
    Cat cat = new Cat();
    Random rnd = new Random();
        try {
            System.out.print("Enter the new Cat, type the name and age up to 18\n" + "name: ");
            String name = sc.nextLine();
            System.out.print("age: ");
            int age = sc.nextInt();
            if (age > 0 && age < 19) {
                cat.setName(name);
                cat.setAge(age);
                cat.setMood(rnd.nextInt(60) + 20);
                cat.setHealth(rnd.nextInt(60) + 20);
                cat.setSatiety(rnd.nextInt(60) + 20);
                cat.setAverage((cat.getMood() + cat.getSatiety() + cat.getHealth()) / 3);
                cats.add(cat);
                catDetails();
            }
        } catch (Exception e) {
            System.out.println("ERROR - enter right name and age");
        }
    }

    public static void action(){
        System.out.println("What action do you want to do?\n"+"(1)-feed the cat");
        System.out.println("(2)-play with cat");
        System.out.println("(3)-treat a cat");
        int action = sc.nextInt();
        switch (action){
            case 1:
                System.out.println("With cat do you want to feed, enter the index?");
                int i = sc.nextInt();
                cats.get(i-1);
                System.out.printf("You fed %s", cats.get(i-1).getName());

                break;
            case 2:
                System.out.println("With cat do you want to play, enter the index?");
                int in = sc.nextInt();
                cats.get(in-1);
                System.out.printf("You played with %s", cats.get(in-1).getName());
                break;
            case 3:
                System.out.println("With cat do you want to treat, enter the index?");
                int ind = sc.nextInt();
                System.out.printf("You treated %s", cats.get(ind-1).getName());
                break;
            default:
                System.out.println("enter right action");
                action();
        }
    }
}