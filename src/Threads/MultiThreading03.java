package Threads;

public class MultiThreading03 {
    public static void main(String[] args) {
        Brackets brackets = new Brackets();

        //1.thread
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<8; i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();

        //2.thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<8; i++){

                }
            }
        });
        thread2.start();
    }
}

class Brackets{
    //çıktının düzgün gözükebilmesi için generateBrackets() methoduna aynı anda sadece 1 thread'in
    //girebiliyor olması için "synchronized" kullanıldı
    public synchronized void generateBrackets(){
        for (int i=1; i<=10; i++){
            if (i<=5){
                System.out.print("[");
            }else {
                System.out.print("]");
            }
        }
        System.out.println("");
    }

}