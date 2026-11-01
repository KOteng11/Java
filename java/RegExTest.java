package regextest;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExTest{
    public static void main(String[] args){
        Pattern pattern = Pattern.compile("agent \\d{3}");
        Matcher matcher = pattern.matcher("agent 00800");
        
        boolean found = matcher.find();
        
        System.out.println("found: "  + found);
    }
}