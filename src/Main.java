import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cat> cat = new ArrayList<>();
        Action act = new Action();
        Run.fillList();
        Run.print();
        Run.addCat();
        Run.action();
        Run.nextDay();


    }

}