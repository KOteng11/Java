package genericdemo;


interface A{}
class B implements A{}
class C implements A{}

@SuppressWarnings("unchecked")
class MyArray<T extends A>{
    private int length = 0;
    private T[] data;
    
    public MyArray(){
        data = (T[]) new B[10];
        length = 0;
    }
    
    
    public void append(T value){
        data[length++] = value;
    }
    
    public void display(){
        for (int i = 0; i < length; i++){
            System.out.println(data[i]);
        }
    }
    
}


public class GenericDemo{
    public static void main(String[] args){
        MyArray<A> ma = new MyArray<>();

    }
}