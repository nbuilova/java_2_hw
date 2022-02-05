package lesson_1;

public class Cat implements Competitor {
    private String name;

    private int maxJumpHeight;
    private int maxRunDist;
    private boolean onDist;

    public Cat(String name, int maxJumpHeight, int maxRunDist) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDist = maxRunDist;
        this.onDist = true;
    }

    public Cat(String name) {
        this.name = name;
        this.maxJumpHeight = 3;
        this.maxRunDist = 200;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDist) {
            System.out.println("Cat " + name + " is running " + dist + " m distance");
        }else
        {
            System.out.println("Cat " + name + " cannot run this distance");
            onDist = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Cat " + name + " is jumping over " + height + " m wall");
        } else {
            System.out.println("The wall is too high, Cat " + name + " cannot jump over it");
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