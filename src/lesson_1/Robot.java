package lesson_1;

public class Robot implements Competitor {
    private String name;

    private int maxJumpHeight;
    private int maxRunDist;
    private boolean onDist;

    public Robot(String name, int maxJumpHeight, int maxRunDist) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDist = maxRunDist;
        this.onDist = true;
    }

    public Robot(String name) {
        this.name = name;
        this.maxJumpHeight = 0;
        this.maxRunDist = 10;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDist) {
            System.out.println("Robot " + name + " is running " + dist + " m distance");
        } else {
            System.out.println("Robot " + name + " cannot run this distance");
            onDist = false;
        }

    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Robot " + name + " is jumping over " + height + " m wall");
        } else {
            System.out.println("The wall is too high, Robot " + name + " cannot jump over it");
            onDist = false;
        }
    }

    @Override
    public boolean isOnDist() {
        return onDist;
    }

    @Override
    public void info() {
        System.out.printf("%s %b\n", name, onDist);
    }
}
