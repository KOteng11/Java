package enumdemo;

enum Dept{
    CS("John", "Block A"), IT("Smith", "Block B"), CIVIL("Srinavas", "Block C"), ECE("Dave", "Block D");
    String head;
    String location;
    
    private Dept(String head, String loc){
        this.head = head;
        this.location = loc;
    }
    
    public void display(){
        System.out.println(this.name() + " " + this.ordinal());
    }
    
    public String getHeadName(){
        return head;
    }
    
    public String getLocation(){
        return location;
    }
}

public class EnumDemo{
    public static void main(String[] args){
        Dept d = Dept.CIVIL;
        System.out.println(d.getHeadName());
        System.out.println(d.getLocation());
        /**
        switch(d){
            case CS: System.out.println("Head: John \nBlock: A");
                break;
            case IT: System.out.println("Head: Smith \nBlock: B");
                break;
            case CIVIL: System.out.println("Head: Srinavas \nBlock: C");
                break;
            case ECE: System.out.println("Head: Dave \nBlock: D");
                break;
        }
        
        */
    }
}