/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xelias1
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> nums = List.of(1, 2, 3, 4, 6, 2, 5);
        int result = nums.stream()
                .filter(x -> x > 10)
                .findFirst()
                .orElse(0);

        
        System.out.println(result);
        List<Object> idk = List.of(5,"no", 0.2);
        System.out.println(idk.get(1).toString()+"no");
        List<? super Integer> another = idk;
                

    }

}
