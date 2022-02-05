package lesson_1;

public class Human implements Competitor{
    private String name;
    private int age;

    private int maxJumpHeight;
    private int maxRunDist;
    private boolean onDist;

    public Human(String name, int age, int maxJumpHeight, int maxRunDist) {
        this.name = name;
        this.age = age;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDist = maxRunDist;
        this.onDist = true;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.maxJumpHeight = 2;
        this.maxRunDist = 500;
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Human " + name + " is jumping over " + height + " m wall");
        } else {
            System.out.println("The wall is too high, Human " + name + " cannot jump over it");
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

    @Override
    public void run(int dist) {
        if (dist <= maxRunDist) {
            System.out.println("Human " + name + " is running " + dist + " m distance");
        }else
        {
            System.out.println("Human " + name + " cannot run this distance");
            onDist = false;
        }

    }
}
