package multithreading;


class MyThread extends Thread{
    public void run(){
        int i = 1;
        while(true){
            System.out.println(i+ " Hello");
            i++;
        }
    }
}

class My implements Runnable{
    public void run(){
        int i = 1;
        while(true){
            System.out.println(i + "Hello");
            i++;
        }
    }
}

public class MultiThreading{
    public static void main(String[] args){
        My m = new My();
        Thread t = new Thread(m);
        t.start();
        int i = 1;
        while(true){
            System.out.println(i + " world");
            i++;
        }
    }
}