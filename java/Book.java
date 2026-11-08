/** @author Kingsley Darko
*   @version 2.0
*   @since 2026
**/

package javadocsdemo;

/**
*
*@author Kingsley Darko
*
*Class for Library Book
*
*/


public class Book{
    /**
    *@value 10 default value
    */
    static int val = 10;
    
    /**
    * Parameterized Constructor
    * @param s Book Name
    */
    public Book(String s){}
    
    
    /**
    *Issue a Book to a Student
    *@param roll roll number of a Strudent
    *@throws Exception if book is not available, throws Exception
    */
    public void issue(int roll) throws Exception{}
    
    /**
    * Check if book is available
    *@param str Book Name
    *@return if book is available returns true else false
    */
    public boolean available(String str){
        return true;
    }
    
    /**
    * Get Book Name
    * @param id book id
    * @return returns book name
    */
    public String getName(int id){
        return "";
    }
}