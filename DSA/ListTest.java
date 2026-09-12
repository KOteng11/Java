package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import interfaces.ListInterface;
import interfaces.Collection;
import datastructures.*;

public class ListTest
{
    ListInterface<Integer> ll;
    
    @Before
    public void init(){
        ll = new DoublyLinkedList<>();
    }
    
    @Test
    public void testAddLast_throwsException(){
        assertThrows(UnsupportedOperationException.class, () -> {
            ll.addLast(2);
        });
    }
}