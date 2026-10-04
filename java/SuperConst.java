package superconst;

class Rectangle{
    int length;
    int width;
    
    Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    
    Rectangle(){
        this(1, 1);
    }
}

class Cuboid extends Rectangle{
    int height;
    
    Cuboid(){
        height = 1;
    }
    
    Cuboid(int l, int w, int h){
        super(l, w);
        height = h;
    }
    
    int volume(){
        return length * width * height;
    }
}
public class SuperConst{
    public static void main(String[] args){
        Cuboid c = new Cuboid(5, 3, 10);
        
        System.out.println(c.volume());
    }
}