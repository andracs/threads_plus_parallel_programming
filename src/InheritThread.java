public class InheritThread {


    public static void main(String[] args) {

        Task t1 = new Task(".");
        Task t2 = new Task(":");


        t1.start();
        t2.start();

    }

    static class Task extends Thread {
            String s;
            long counter;

        public Task(String s) {
            this.s = s;
        }

        @Override
            public void run() {
                while (true) {
                    if (counter++%10==0) {
                        System.out.print("\r");
                    }
                    System.out.print (this.getId() + ".");
                    try {
                        this.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


    }
}
