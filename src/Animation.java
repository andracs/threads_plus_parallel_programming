public class Animation {

    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            Thread a = new Thread(new FrameWriter());
            a.start();
        }
    }


    static class FrameWriter implements Runnable {

        String s = "............................................................\n" +
                   "............................................................";


        @Override
        public void run() {
            while (true) {
                StringBuilder output = new StringBuilder(s);
                long id = Thread.currentThread().getId() - 10;
                output.setCharAt((int) id, 'X');
                s = output.toString();
                System.out.print("\r\r" + s);
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
