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
             ll.get(0);
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
        assertEquals(Integer.valueOf(5), ll.get(0));
    }

    @Test 
    public void testPollFirst_ListISEmpty(){
        assertNull(ll.pollFirst());
    }
    
    @Test
    public void testPollFirst_OneElement(){
        ll.addFirst(5);
        assertEquals(Integer.valueOf(5), ll.get(0));
        assertEquals(1, ll.length());
        assertEquals(Integer.valueOf(5), ll.removeFirst());
        assertEquals(0, ll.length());
    }
    
    @Test
    public void testPollFirst_TwoElements(){
        ll.addFirst(2);
        ll.addLast(5);
        assertEquals(Integer.valueOf(2), ll.removeFirst());
        assertEquals(1, ll.length());
        assertEquals(Integer.valueOf(5), ll.get(0));
    }
    
    @Test
    public void testIsEmpty_AddOneElement(){
        ll.addLast(2);
        assertFalse(ll.isEmpty());
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testIsEmpty_NoElement(){
        assertTrue(ll.isEmpty());
    }
    
    @Test
    public void testIsEmpty_RemoveOneElement(){
        ll.addLast(3);
        assertEquals(1, ll.length());
        ll.removeFirst();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.length());
    }
    
    @Test
    public void testRemoveLast_ListIsEmpty(){
        assertThrows(NoSuchElementException.class, ()->{
            ll.removeLast();
        });
    }
    
    @Test
    public void testRemoveLast_OneElement(){
        ll.addFirst(2);
        assertEquals(Integer.valueOf(2), ll.get(0));
        assertEquals(1, ll.length());
        assertEquals(Integer.valueOf(2), ll.removeLast());
        assertEquals(0, ll.length());
    }
    
    @Test
    public void testRemoveLast_TwoElements(){
        ll.addFirst(3);
        ll.addLast(5);
        assertEquals(2, ll.length());
        assertEquals(Integer.valueOf(5), ll.removeLast());
        assertEquals(1, ll.length());
        assertEquals(Integer.valueOf(3), ll.get(0));
    }
    
    @Test
    public void testGetFirst_EmptyList(){
        assertThrows(NoSuchElementException.class, ()->{
            ll.getFirst();
        });
    }
    
    @Test
    public void testGetFirst_OneElement(){
        ll.addFirst(3);
        assertEquals(Integer.valueOf(3), ll.getFirst());
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testGetFirst_TwoElements(){
        ll.addFirst(3);
        ll.addLast(5);
        assertEquals(Integer.valueOf(3), ll.getFirst());
        assertEquals(2, ll.length());
    }
    
    @Test
    public void testGetLast_EmptyList(){
        assertThrows(NoSuchElementException.class, ()->{
            ll.getLast();
        });
    }
    
    @Test
    public void testGetLast_OneElement(){
        ll.addLast(3);
        assertEquals(Integer.valueOf(3), ll.getLast());
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testGetLast_TwoElements(){
        ll.addLast(10);
        ll.addFirst(7);
        assertEquals(Integer.valueOf(10), ll.getLast());
        assertEquals(2, ll.length());
    }
    
    @Test
    public void testSet_NegativeIndex(){
        assertFalse(ll.set(-1, 10));
    }
    
    @Test
    public void testSet_IndexGreaterThanOrEqualLength(){
        assertFalse(ll.set(0, 10));
    }
    
    @Test
    public void testSet(){
        ll.addFirst(3);
        ll.addLast(8);
        ll.addLast(9);
        assertEquals(Integer.valueOf(8), ll.get(1));
        assertTrue(ll.set(1, 50));
        assertEquals(Integer.valueOf(50), ll.get(1));
        assertTrue(ll.set(1, 50));
    }
    
    @Test
    public void testAdd_NegativeIndex(){
        assertThrows(IndexOutOfBoundsException.class, ()->{
            ll.add(-1, 10);
        });
    }
    
    @Test
    public void testAdd_IndexGreaterThanLength(){
        assertThrows(IndexOutOfBoundsException.class, ()->{
            ll.add(1, 10);
        });
    }
    
    @Test
    public void testAdd_AddToFirstOnEmptyList(){
        ll.add(0, 5);
        assertEquals(Integer.valueOf(5), ll.get(0));
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testAdd_AddToFirstWithTwoElements(){
        ll.addFirst(8);
        ll.addLast(15);
        assertEquals(2, ll.length());
        ll.add(0, 6);
        assertEquals(3, ll.length());
        assertEquals(Integer.valueOf(6), ll.get(0));
    }
    
    @Test
    public void testAdd_AddToLastOnEmptyList(){
        ll.add(0, 5);
        assertEquals(Integer.valueOf(5), ll.get(0));
        assertEquals(1, ll.length());
    }
    
    @Test
    public void testAdd_AddToLastWithTwoElements(){
        ll.addFirst(8);
        ll.addFirst(10);
        assertEquals(2, ll.length());
        ll.add(ll.length(), 9);
        assertEquals(3, ll.length());
        assertEquals(Integer.valueOf(9), ll.get(2));
    }

    
    @Test
    public void testAdd_AddToMiddle(){
        ll.addFirst(10);
        ll.addLast(6);
        ll.addLast(15);
        ll.addLast(3);
        assertEquals(4, ll.length());
        ll.add(2, 23);
        assertEquals(5, ll.length());
        assertEquals(Integer.valueOf(23), ll.get(2));
    }
}