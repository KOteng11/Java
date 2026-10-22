package multithreading;

class My implements Runnable{
    @Override
    public void run(){
        int i = 1;
        while(true){
            System.out.println(i + " Hello");
            i++;
        }
    }
}


class MyThread extends Thread{
    @Override
    public void run(){
        int i = 1;
        while(true){
            System.out.println(i + " Hello");
            i++;
        }
    }
}


public class Multithreading{
    public static void main(String[] args){
        My m = new My();
        Thread t = new Thread(m);
        //MyThread t = new MyThread();
        t.start();
        
        int i = 0;
        
        while (true){
            System.out.println(++i + " World");
        }
    }
}