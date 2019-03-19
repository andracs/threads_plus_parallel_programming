import java.lang.management.ThreadInfo;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        ScreenWriter screenWriterA = new ScreenWriter("Hest");
        ScreenWriter screenWriterB = new ScreenWriter("Hund");

        Thread threadA = new Thread(screenWriterA);
        Thread threadB = new Thread(screenWriterB);

        //System.out.println(threadA.getId());
        threadA.start();
        threadB.start();
        threadB.join();
    }


    static class ScreenWriter implements Runnable {

        String s;
        int counter;
        public static final int ITERATIONS = 3000;
        public static final int LINEBREAK = 200;
        public static final boolean INFINITE = true;



        public ScreenWriter(String a) {
            s = a;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
            for (int i = 1; i <= ITERATIONS; i++) {
                if (INFINITE) { i--; }
                counter++;
                String output = String.format("%1$" + 10 + "s", counter).replace(' ', ' ');
                System.out.print("\r" + this.s + " " + Thread.currentThread().getId() + output);
                Thread.currentThread().yield();
            }
        }
    }
}
