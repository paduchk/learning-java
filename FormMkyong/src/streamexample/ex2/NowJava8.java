/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamexample.ex2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author KrzysztofPaduch
 */
public class NowJava8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Person> persons = Arrays.asList(
                new Person("mykong",30),
                new Person("jack",20),
                new Person("lwrance",40)
            );
            
        Person p1 = persons.stream()
                .filter(f -> "mykong".equals(f.getName()))
                .findAny()
                .orElse(null);
        
        System.out.println(p1);
        
        Person p2 = persons.stream()
                .filter(f -> "ahmook".equals(f.getName()))
                .findAny()
                .orElse(null);
        System.out.println(p2);
    }
    
}
