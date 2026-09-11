package interfaces;

public interface Collection<E>
{
    /**
        clear method removes all the elements from this list
    */
    void clear();

    /**
        length method returns the number of elements in this list
    */
    int length();    

    /**
        isEmpty method returns true if the list is empty
        @return True
    */
    boolean isEmpty();
}