import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import datastructures.Stack;
import java.util.NoSuchElementException;

public class StackTest{
    Stack<Integer> st;
    
    @Before
    public void init(){
        st = new Stack<>();
    }
    
    @Test
    public void testSize_EmptyElement(){
        st.push(3);
        st.pollFirst();
        assertEquals(0, st.size());
    }
    
    @Test
    public void testSize_OneElement(){
        st.push(3);
        assertEquals(1, st.size());
    }
    
    @Test
    public void testSize_MultipleElements(){
        st.push(3);
        st.push(10);
        st.push(15);
        st.push(30);
        assertEquals(4, st.size());
    }
    
    @Test
    public void testPush_OneElement(){
        st.push(3);
        assertEquals(Integer.valueOf(3), st.peekFirst());
        assertEquals(1, st.size());
    }
    
    @Test
    public void testPush_MultipleElements(){
        st.push(3);
        st.push(15);
        st.push(30);
        st.push(18);
        assertEquals(4, st.size());
        st.push(19);
        assertEquals(5, st.size());
        assertEquals(Integer.valueOf(19), st.peekFirst());
    }
    
    @Test
    public void testPollFirst_EmptyStack(){
        st.push(3);
        st.pollFirst();
        assertNull(st.pollFirst());
        assertEquals(0, st.size());
    }
    
    @Test
    public void testPollFirst_OneElement(){
        st.push(3);
        assertEquals(Integer.valueOf(3), st.peekFirst());
        assertEquals(1, st.size());
        st.pollFirst();
        assertEquals(null, st.peekFirst());
        assertEquals(0, st.size());
    }
    
        @Test
    public void pop_EmptyStack(){
        st.push(3);
        st.pop();
        assertThrows(NoSuchElementException.class, ()->{
            st.pop();
        });
        assertEquals(0, st.size());
    }
    
    @Test
    public void pop_OneElement(){
        st.push(3);
        assertEquals(Integer.valueOf(3), st.peekFirst());
        assertEquals(1, st.size());
        st.pop();
        assertEquals(null, st.peekFirst());
        assertEquals(0, st.size());
    }
}