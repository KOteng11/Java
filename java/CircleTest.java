import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import circle.Circle;

public class CircleTest{
    protected Circle c1;
    
    @Before
    public void initCircle(){
        c1 = new Circle();
    }
    
    @Test
    public void testGetRadius(){
        c1.setRadius(10);
        assertEquals(10.0, c1.getRadius(), 0.0);
    }
    
    @Test
    public void testSetRadius_InvalidRadius(){
        assertThrows(IllegalArgumentException.class, ()->{
            c1.setRadius(0);
        });
    }
    
    @Test
    public void testSetRadius(){
        c1.setRadius(10);
        assertEquals(10.0, c1.getRadius(), 0.0);
    }
    
    @Test
    public void testArea(){
        c1.setRadius(10);
        assertEquals(314.1592653589793, c1.area(), 0.01);
    }
    
    @Test
    public void testPerimeter(){
        c1.setRadius(10);
        assertEquals(62.83185307179586, c1.perimeter(), 0.01);
    }
    
    @Test
    public void testCircumference(){
        c1.setRadius(10);
        assertEquals(62.83185307179586, c1.circumference(), 0.01);
    }
}