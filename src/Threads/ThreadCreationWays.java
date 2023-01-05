package Threads;

public class ThreadCreationWays {
    public static void main(String[] args) {
        //ilk çalışan thread main thread'dir, kontrol edelim
        System.out.println("Current Thread : " + Thread.currentThread().getName()); //main thread

        MyThread thread1 = new MyThread();
        thread1.start(); // thread sınıfında run() methodunda yazılanlar işlenmeye başlar
        //thread1.run();
        //run() diyerek de çağırdığımızda method yine çalışıyor, start() ile çağırmamız arasındaki fark ise:
            //run() ===> thread değişmez sadece method çalışır
            //start()==> önce thread ayağa kalkar daha sonra içindeki run() methodu çalışır

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // !!! isimsiz olarak thread oluşturma ==> anonymous(Interface)
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //5sn.uyu
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread: " + Thread.currentThread().getName());
                System.out.println("Bu isimsiz sınıf yoluyla oluşturulan iş parçacığıdır");
            }
        });

        thread3.setName("Thread3"); // thread 3'e isim verdik
        thread3.start();

        // !!! isimsiz olarak thread oluşturma 2.yol
        Thread thread4 = new Thread(()->{
            System.out.println("lambda ile yazıldı");
        });
        thread4.start();

        System.out.println("Main methodu bitti");//bu yazının çıktının neresinde gözükeceği ile ilgili kesin bir şey diyemeyiz

        Thread thread5 = new Thread(()->{
            System.out.println("thread5 çalıştı");
        });
        thread5.start();
    }

    }
    //1.way: Thread class'ını extend ederek
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread thread is running");
        }
    }

    //2.way: Runnable Interface'i implement ederek
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Runnable Interfaceden türetilen thread çalıştı");
        }
    }
