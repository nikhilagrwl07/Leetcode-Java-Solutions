package java8;

public class LambdaThreadExample {
    public static void main(String[] args) {

        //old way
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread with old way has started");
            }
        }).start();

        // new way
        new Thread(() -> System.out.println("thread with new way has started")).start();
    }
}
