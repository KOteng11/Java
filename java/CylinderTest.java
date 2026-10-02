import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import cylinder.Cylinder;

public class CylinderTest extends CircleTest
{
    Cylinder cy;
    
    @Before
    @Override
    public void initCircle(){
        c1 = new Cylinder();
    }
    
    @Before
    public void initCylinder(){
        cy = new Cylinder();
    }
    
    @Test
    public void testGetHeight(){
        c1.setRadius(10);
        assertEquals(10.0, c1.getRadius(), 0.0);
    }
    
    @Test
    public void testSetHeight_InvalidHeight(){
        assertThrows(IllegalArgumentException.class, ()->{
            c1.setRadius(0);
        });
    }
    
    @Test
    public void testSetHeight(){
        c1.setRadius(10);
        assertEquals(10.0, c1.getRadius(), 0.0);
    }    
}