package lesson_1;

public class Treadmill implements Obstacle {
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public void tryToDo(Competitor c) {
        c.run(dist);
    }
}
