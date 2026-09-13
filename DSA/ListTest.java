package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import interfaces.ListInterface;
import interfaces.Collection;
import datastructures.*;
import java.util.NoSuchElementException;

public class ListTest
{
    ListInterface<Integer> ll;
    
    @Before
    public void init(){
        ll = new LinkedList<>();
    }
    
    @Test
    public void testLengthEqualsZero(){
        assertEquals(0, ll.length());
        assertThrows(IndexOutOfBoundsException.class, ()->{
            ll.get(0);
        });
    }
    
    @Test
    public void testLengthEqualsOne(){
        ll.addLast(5);
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testLengthEqualsTwenty(){
        for(int i = 0; i < 20; i++){
            ll.addLast(i + 10);
        }
        assertEquals(20, ll.length());
    }
    
    @Test
    public void testClear(){
        ll.addLast(2);
        ll.addLast(10);
        ll.clear();
        assertEquals(0, ll.length());
        assertThrows(IndexOutOfBoundsException.class, ()->{
            ll.get(0);
        });
    }
    
    @Test
    public void testGet_NegativeIndex(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
             ll.get(-1);
         });
    }
    
    @Test
    public void testGet_IndexGreaterThanOrEqualLength(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
             ll.get(1);
         });
    }
    
    @Test
    public void testGet(){
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(15);
        assertEquals(Integer.valueOf(3), ll.get(1));
    }
    
    @Test
    public void testAddLast(){
        ll.addLast(2);
        ll.addLast(9);
        ll.addLast(15);
        assertEquals(Integer.valueOf(15), ll.get(ll.length() - 1));
    }
    
    @Test
    public void testAddFirst(){
        ll.addFirst(2);
        ll.addFirst(9);
        ll.addFirst(15);
        assertEquals(Integer.valueOf(9), ll.get(1));
    }
    
    @Test
    public void testRemoveFirst_ListIsEmpty(){
        assertThrows(NoSuchElementException.class, ()->{
            ll.removeFirst();
        });
    }
    
    @Test
    public void testRemoveFirst_OneElement(){
        ll.addFirst(5);
        assertEquals(Integer.valueOf(5), ll.removeFirst());
        assertEquals(0, ll.length());
    }
    
    @Test
    public void testRemoveFirst_TwoElements(){
        ll.addFirst(2);
        ll.addLast(5);
        assertEquals(Integer.valueOf(2), ll.removeFirst());
        assertEquals(1, ll.length());
        assertEquals(Integer.valueOf(0), ll.get(0));
    }
    
}