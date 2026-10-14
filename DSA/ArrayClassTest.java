package arrayclasstest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import arrayclass.ArrayClass;

public class ArrayClassTest{
    private ArrayClass t;
    
    @Before
    public void init(){
        t = new ArrayClass();
    }
    
    @Test
    public void testIsValidIndex_NegativeValues(){
        assertFalse(t.isValidIndex(-1));
    }
    
    @Test
    public void testIsValidIndex_GreaterThanLength(){
        assertFalse(t.isValidIndex(1));
    }
    
    @Test
    public void testisValidIndex(){
        assertTrue(t.isValidIndex(0));
    }
    
    @Test
    public void testInsert(){
        assertTrue(t.isValidIndex(0));
        t.insert(0, 10);
        assertEquals(10, t.get(0));
        assertEquals(1, t.size());
    }
    
}