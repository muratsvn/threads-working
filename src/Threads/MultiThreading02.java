package Threads;

import javax.swing.plaf.TableHeaderUI;

// thread'ler aynı kaynağa erişmek isterlerse ne olur??
public class MultiThreading02 {

    public static int counter=0;
    public static void main(String[] args) {
            //ayrı 2 thread oluşturup aynı kaynağa erişmesini sağlayalım
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 çalıştı");
            }
        });
        thread1.start();

       /* try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //2.thread oluşturuyoruz
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 çalıştı");
            }
        });
        thread2.start();
    }
}

class Counter{
    public synchronized static void count(){ //synchronized ile bu methoda giren threadleri sıraya koyduk
                                             //method içine aynı anda sadece 1 thread girebilecek
        for (int i=1; i<=1000; i++){
            MultiThreading02.counter++; //1000
        }
        System.out.println("Counter : " + MultiThreading02.counter);//1000
    }
}