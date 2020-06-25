public class Deadlock {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();
    private static final Object object3 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (object1) {
                System.out.println("Thread 1: locked object 1");

                try {
                    Thread.sleep(420);
                } catch (Exception e) {
                    System.out.println("ignore exception");
                }

                synchronized (object2) {
                    System.out.println("Thread 1: locked object 2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object2) {
                System.out.println("Thread 2: locked object 2");

                try {
                    Thread.sleep(420);
                } catch (Exception e) {
                    System.out.println("ignore exception");
                }

                synchronized (object3) {
                    System.out.println("Thread 2: locked object 3");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object3) {
                System.out.println("Thread 3: locked object 3");

                try {
                    Thread.sleep(420);
                } catch (Exception e) {
                    System.out.println("ignore exception");
                }

                synchronized (object1) {
                    System.out.println("Thread 3: locked object 1");
                }
            }
        }).start();
    }
}
