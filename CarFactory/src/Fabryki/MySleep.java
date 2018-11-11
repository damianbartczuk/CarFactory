package Fabryki;

public class MySleep {
    public static void sleep() {
        try {
            Thread.sleep((int) (Math.random() * 100) + 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
