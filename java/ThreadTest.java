package multithreading;

class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    
    public void run(){
        int count = 1;
        
        while(true){
            System.out.println(count++);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

public class ThreadTest
{
    public static void main(String[] args){
        MyThread t = new MyThread("Thread 1");
        System.out.println(t.threadId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        //t.start();
    }
}