import java.util.*;

public class Run {
    static Scanner sc = new Scanner(System.in);
    private static List<Cat> cats = new ArrayList<>();
    static Action actions = new Action();


    public  static void fillList(){
        for (int i = 0; i < 4; i++) {
            cats.add(new Cat(i));
        }
    }

    public static Cat turnOff(Cat cat){
        cat.setAction(false);
        return cat;
    }

    public static void print(){
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
                print();
            }
        } catch (Exception e) {
            System.out.println("ERROR - enter right name and age");
        }
    }

    public static void action() {
        System.out.println("What action do you want to do?\n" + "(1)-feed the cat");
        System.out.println("(2)-play with cat");
        System.out.println("(3)-treat a cat");
        int action = sc.nextInt();
        switch (action) {
            case 1:
                System.out.println("With cat do you want to feed, enter the index?");
                int i = sc.nextInt();
                    System.out.printf("You fed %s, %s years old\n", cats.get(i - 1).getName(), cats.get(i - 1).getAge());
                    turnOff(actions.feed(cats.get(i - 1)));
                break;
            case 2:
                System.out.println("With cat do you want to play, enter the index?");
                int in = sc.nextInt();
                System.out.printf("You played with %s, %s years old\n", cats.get(in - 1).getName(), cats.get(in - 1).getAge());
                turnOff(actions.play(cats.get(in - 1)));

                break;
            case 3:
                System.out.println("With cat do you want to treat, enter the index?");
                int ind = sc.nextInt();
                System.out.printf("You treated %s, %s years old\n", cats.get(ind - 1).getName(), cats.get(ind - 1).getAge());
                turnOff(actions.treat(cats.get(ind - 1)));
                break;
            default:
                System.out.println("enter right action");
                action();
        }
        print();
        }



    public static void nextDay(){
        System.out.println("if you want to make next day press 1 if no press any button: ");
        int nextday = sc.nextInt();
        if(nextday == 1){
            for (int i = 0; i < cats.size(); i++) {
                actions.nextDay(cats.get(i));
            }
            System.out.println("----------------Next Day-----------------");
            print();
        } else {
            System.out.println("----------------Same Day-----------------");
            print();
        }
    }}


