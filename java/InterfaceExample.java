package interfaceexample;

class Phone
{
    public void call(){
        System.out.println("Phone call");
    }
    
    public void sms(){
        System.out.println("Phone sending sms");
    }
}

interface IMusicPlayer{
    void play();
    void stop();
}

interface ICamera{
    void click();
    void record();
}

class SmartPhone extends Phone implements ICamera, IMusicPlayer{
    public void videoCall(){
        System.out.println("Smart Phone video calling.");
    }
    
    @Override
    public void click(){
        System.out.println("Smart Phone Clicking photo.");
    }
    
    @Override
    public void record(){
        System.out.println("Smart Phone recording video.");
    }
    
    @Override
    public void play(){
        System.out.println("Smart phone playing music.");
    }
    
    @Override
    public void stop(){
        System.out.println("Smart phone stopped playing music.");
    }
    
}

public class InterfaceExample{
    public static void main(String[] args){
        
    }
}