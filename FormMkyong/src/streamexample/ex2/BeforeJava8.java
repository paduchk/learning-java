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
public class BeforeJava8 {

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
        
        Person result = getStudentByName(persons,"jack");
        System.out.println(result);
    }
    private static Person getStudentByName(List<Person> persons, String name) {
        Person result = null;
        for(Person person:persons) {
            if ( name.equals(person.getName()) ) {
                result = person;
                break;
            }
        } 
        return result;
    }
}
