/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamexample.ex3;

import java.util.Arrays;
import java.util.List;
import streamexample.ex2.Person;

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
                new Person("mkyong",30),
                new Person("jack",20),
                new Person("lawrance",40)
        );
        
        Person result1 = persons.stream()
                .filter(p -> "jack".equals(p.getName()) && 20 == p.getAge() )
                .findAny()
                .orElse(null);
        
        System.out.println("result 1 :" + result1);
        
        Person result2 = persons.stream()
                .filter(p -> "jack".equals(p.getName()) && 20 == p.getAge() )
                .findAny()
                .orElse(null);        
    }
    
}
