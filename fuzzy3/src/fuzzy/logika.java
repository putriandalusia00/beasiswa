/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzy;

/**
 *
 * @author Teguh
 */
public class logika {
    public double and(double x, double y){
       double nilai = 0;
       if(x>y){
           System.out.println(nilai=y);
       }
       else if(x<y){
           System.out.println(nilai=x);
       }
       else {
           System.out.println(nilai);
       }
       return nilai;
    }  
    public double or(double x, double y){
        double nilai = 0;
        if(x>y){
            System.out.println(nilai=x);
        }
        else if(x<y){
            System.out.println(nilai=y);
        }
        else{
            System.out.println(nilai);
        }
        return nilai;
    }
}
