/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Teguh
 */
public class caridrajat {
    public double drajatanggotacukup( double nilaiipk){
        //drajat keanggotaan untuk nilai rata2 rendah
        double x = 0.11;
       
        if (nilaiipk>=3.36) {
            System.out.println(x);
        } else if(nilaiipk<=2.74) {
            System.out.println(x=1);
        }else if((nilaiipk>2.74)&&(nilaiipk<3.36)){
                
                x=(3.36-nilaiipk)/3.06;
                BigDecimal bd= new BigDecimal(x);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                x=bd.doubleValue();
                System.out.println(x);
        }
        else{
            System.out.println(x);
        }
       
        return x;
    }
    public double drajatanggotanormal(double nilaiipk){
         //drajat keanggotaan untuk nilai rata2 normal
        double y = 0.03;
        
        if((nilaiipk<=3.06)&&(nilaiipk>=3.79)) {
            System.out.println(y);
        }else if((nilaiipk>3.06)&&(nilaiipk<3.36)){
                y=(nilaiipk-3.06)/2.74;
                BigDecimal bd= new BigDecimal(y);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                y=bd.doubleValue();
                System.out.println(y);
        }else if((nilaiipk>3.67)&&(nilaiipk<3.79)){
            y=(3.79-nilaiipk)/2.74;
            BigDecimal bd= new BigDecimal(y);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                y=bd.doubleValue();
            System.out.println(y);
        }
        else{
            System.out.println(y);
        }
        return y;   
    }
    public double drajatanggotatinggi(double nilaiipk){
        //drajat keanggotaan untuk nilai rata2 tinggi
        double z = 0;
        if (nilaiipk<=3.67) {
            System.out.println(z);
        } else if(nilaiipk>=3.89) {
            System.out.println(z=1);
        }else if((nilaiipk>3.67)&&(nilaiipk<3.89)){
                
                z=(nilaiipk-3.67)/3.89;
                BigDecimal bd= new BigDecimal(z);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                z=bd.doubleValue();
                System.out.println(z);
        }
        else{
            System.out.println(z);
        }
       
        return z;
    }
    public double drajatanggotacukup2(double gaji){
       //drajat keanggotaan iqbiasa
        double z = 0.02;
        if (gaji>=4212045) {
            System.out.println(z);
        } else if(gaji<=2023906) {
            System.out.println(z=1);
        }else if((gaji>2023906)&&(gaji<4212045)){
                
                z=(4212045-gaji)/3504500;
                 BigDecimal bd= new BigDecimal(z);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                z=bd.doubleValue();
                System.out.println(z);
        }
        else{
            System.out.println(z);
        }
       
        return z;
     
    }
    public double drajatanggotanormal2(double gaji){
        //drajat keanggotaan iqcerdas
        double z = 0.4;
        if((gaji<=3504500)&&(gaji>=7237000)) {
            System.out.println(z);
        }else if((gaji>3504500)&&(gaji<4212045)){
                z=(gaji-3504500)/2023906;
                BigDecimal bd= new BigDecimal(z);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                z=bd.doubleValue();
                System.out.println(z);
        }else if((gaji>5098100)&&(gaji<7237000)){
            z=(7237000-gaji)/2023906;
            BigDecimal bd= new BigDecimal(z);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                z=bd.doubleValue();
            System.out.println(z);
        }
        else{
            System.out.println(z);
        }
        return z;   
    }
    
     public double drajatanggotatinggi2(double gaji){
        //drajat keanggotaan iqcerdas
        double z = 0;
        if (gaji<=5098100) {
            System.out.println(z);
        } else if(gaji>=12000000) {
            System.out.println(z=1);
        }else if((gaji>5098100)&&(gaji<1200000)){
                
                z=(gaji-5098100)/1200000;
                 BigDecimal bd= new BigDecimal(z);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                z=bd.doubleValue();
                System.out.println(z);
        }
        else{
            System.out.println(z);
        }
       
        return z;
     
    }
    
    public double drajatanggotacukup3(double tanggungan){
        double x = 0.04;
        if (tanggungan>=3) {
            System.out.println(x);
        } else if(tanggungan<=1) {
            System.out.println(x=1);
        }else if((tanggungan>1)&&(tanggungan<3)){
                
                x=(3-tanggungan)/2;
                BigDecimal bd= new BigDecimal(x);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                x=bd.doubleValue();
                System.out.println(x);
        }
        else{
            System.out.println(x);
        }
       
        return x;
    }
    public double drajatanggotanormal3(double tanggungan){
        double x = 0.99;
        if((tanggungan<=2)&&(tanggungan>=6)) {
            System.out.println(x);
        }else if((tanggungan>2)&&(tanggungan<3)){
                x=(tanggungan-2)/1;
                BigDecimal bd= new BigDecimal(x);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                x=bd.doubleValue();
                System.out.println(x);
        }else if((tanggungan>4)&&(tanggungan<6)){
            x=(6-tanggungan)/1;
            BigDecimal bd= new BigDecimal(x);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                x=bd.doubleValue();
            System.out.println(x);
        }
        else{
            System.out.println(x);
        }
        return x;   
    }
    public double drajatanggotatinggi3(double tanggungan){
        double x = 0;
        if (tanggungan<=5) {
            System.out.println(x);
        } else if(tanggungan>=8) {
            System.out.println(x=1);
        }else if((tanggungan>4)&&(tanggungan<8)){
                
                x=(tanggungan-4)/8;
                BigDecimal bd= new BigDecimal(x);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                x=bd.doubleValue();
                System.out.println(x);
        }
        else{
            System.out.println(x);
        }
       
        return x;
    }
}
