/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamexample.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> lines  = Arrays.asList("spring","node","mykong");
        String filter ="mykong";
        List<String> result = lines.stream()
                .filter( line -> !filter.equals(line) )
                .collect(Collectors.toList());
        
        result.forEach(System.out::println);
    }
    
   
    
}
