package lesson_1;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void tryToDo(Competitor c) {
        c.jump(height);
    }
}
