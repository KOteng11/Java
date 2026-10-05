package overriding;

class Super{
    public void display(){
        System.out.println("Super Class Display.");
    }
}

class Sub extends Super{
    @Override
    public void display(){
        System.out.println("Sub Class Display.");
    }
}

public class Overriding{
    public static void main(String[] args){
        Super s = new Sub();
        s.display();
    }
}