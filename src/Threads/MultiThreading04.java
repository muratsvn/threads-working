package Threads;

public class MultiThreading04 {
    public static void main(String[] args) throws InterruptedException {

        Brackets2 brackets2 = new Brackets2();
        long startTime = System.currentTimeMillis();

        //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<8; i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();

        //thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<8; i++){

                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();
        long endTime = System.currentTimeMillis();

        System.out.println("Toplam geçen süre : " + (endTime-startTime)); //2197
    }
}

class Brackets2 {
    public void generateBrackets() {
        synchronized (this) {
            for (int i = 1; i < 11; i++) {
                if (i < 6) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }//endOf for
            System.out.println(" ");
        }
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
