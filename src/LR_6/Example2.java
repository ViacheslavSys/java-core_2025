package LR_6;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t1.join();
    }
}
