package lesson_5;

import java.util.Arrays;

public class MainApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        oneThread();
        twoThreads();
    }

    public static void oneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Работа в один поток занимает: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void twoThreads() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();
        float[] leftPart = new float[HALF];
        float[] rightPart = new float[HALF];
        System.arraycopy(arr, 0, leftPart, 0, HALF);
        System.arraycopy(arr, HALF, rightPart, 0, HALF);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < leftPart.length; i++) {
                leftPart[i] = (float) (leftPart[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < rightPart.length; i++) {
                rightPart[i] = (float) (rightPart[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftPart, 0, arr, 0, HALF);
        System.arraycopy(rightPart, 0, arr, HALF, HALF);
        System.out.println("Работа в два потока занимает: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
