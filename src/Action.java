import java.util.Random;

public class Action implements Actionable{

    @Override
    public void nextDay(Cat cat) {
        Random rnd = new Random();

        cat.setSatiety(cat.getSatiety()- (rnd.nextInt(4)+1));
        cat.setMood(cat.getMood()+ (rnd.nextInt(7)-3));
        cat.setHealth(cat.getHealth()+(rnd.nextInt(7)-3));
        cat.setAction(true);
    }

    @Override
    public Cat feed(Cat cat) {
        if(cat.isAction()){
        if (cat.getAge()>0 && cat.getAge()<6){
            cat.setSatiety(cat.getSatiety()+7);
            cat.setMood(cat.getMood()+7);
        } else if(cat.getAge()>5 && cat.getAge()<11){
            cat.setSatiety(cat.getSatiety()+5);
            cat.setMood(cat.getMood()+5);
        }else {cat.setSatiety(cat.getSatiety()+4);
            cat.setMood(cat.getMood()+4);}
    }else {
            System.out.println("this action not available today");
        }
    return cat;
    }

    @Override
    public Cat treat(Cat cat) {
        if (cat.isAction()){
        if (cat.getAge()>0 && cat.getAge()<6){
            cat.setHealth(cat.getHealth()+7);
          cat.setSatiety(cat.getSatiety()-3);
          cat.setMood(cat.getMood()-3);
        } else if(cat.getAge()>5 && cat.getAge()<11){
            cat.setHealth(cat.getHealth()+5);
            cat.setSatiety(cat.getSatiety()-5);
            cat.setMood(cat.getMood()-5);
        }else {cat.setSatiety(cat.getSatiety()-6);
            cat.setHealth(cat.getHealth()+4);
            cat.setMood(cat.getMood()-6);
    }}else {
            System.out.println("this action not available today");
        }
        return cat;
    }

    @Override
    public Cat play(Cat cat) {
        if (cat.isAction()) {
            if (cat.getAge() > 0 && cat.getAge() < 6) {
                cat.setHealth(cat.getHealth() + 7);
                cat.setSatiety(cat.getSatiety() - 3);
                cat.setMood(cat.getMood() + 7);
            } else if (cat.getAge() > 5 && cat.getAge() < 11) {
                cat.setHealth(cat.getHealth() + 5);
                cat.setSatiety(cat.getSatiety() - 5);
                cat.setMood(cat.getMood() + 5);
            } else {
                cat.setSatiety(cat.getSatiety() - 6);
                cat.setHealth(cat.getHealth() + 4);
                cat.setMood(cat.getMood() + 4);
            }
        }else {
            System.out.println("this action not available today");
        }
        return cat;
    }

}
