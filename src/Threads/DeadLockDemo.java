package Threads;

public class DeadLockDemo {
    public static void main(String[] args) {

    //hangi durumlarda DeadLock oluşur??
    final String lock1 = "lock1";
    final String lock2 = "lock2";

    //thread1
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread1, lock1 değişkenini kitledi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Thread1 lock2 değişkenini kitledi");
                }
            }
        }
    });
    thread1.start();

    //thread2
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread2 lock2 değişkenini kitledi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Thread2 lock1 değişkenini kitledi");
                }
            }
        }
    });
    }
}

