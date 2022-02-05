package lesson_1;

public class Main {
    public static void main(String[] args) {


        Competitor[] competitors = new Competitor[]{
                new Cat("Barsik"),
                new Robot("Spot"),
                new Human("Mark", 20),
                new Cat("Leo", 3, 500),
                new Human("Alex", 25, 3, 1000)
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Wall(2),
                new Treadmill(100),
                new Wall(3)
        };

        for (Competitor value : competitors) {
            for (Obstacle obstacle : obstacles) {
                obstacle.tryToDo(value);
                if (value.isOnDist()) {
                    break;
                }
            }

        }

        for (Competitor competitor : competitors) {
            competitor.info();
        }

    }
}
