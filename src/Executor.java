import java.util.concurrent.*;

public class Executor {
    public static void main(String[] args) {
        // Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit runnable tasks to the executor
        executor.execute(new Main.ScreenWriter("a"));
        executor.execute(new Main.ScreenWriter("b"));

        // Shut down the executor
        executor.shutdown();
    }
}