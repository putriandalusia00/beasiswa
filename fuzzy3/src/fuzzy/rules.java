/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzy;

import java.math.BigDecimal;

/**
 *
 * @author Teguh
 */
public class rules {
    //if nilai= tinggi and iq= cerdas  Then AI tinggi SM Rendah
    public double ai1(double nil,double iq){
        double ai=0;
        if(nil>iq){
            System.out.println(iq);
            if(iq==0){
                System.out.println(ai);
            }
            else if(iq==1){
                System.out.println(ai=1);
            }
            else if((iq<1)&&(iq>0)){
                ai=(iq*0.3)+0.6;
                BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 

               System.out.println("Nilai Z1 AI:"+ai);
            }
        }
        else if (nil<iq){
            System.out.println(nil);
            if(nil==0.0){
                System.out.println(ai);
            }
            else if(nil==1){
                System.out.println(ai=1);
            }
            else if((nil<1)&&(nil>0)){
                ai=(nil*0.3)+0.6;
                  BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z1 AI:"+ai);
            }
        }
        else {
            System.out.println(ai);
        }
        return ai;
    }
    public double sm1(double nil,double iq){
        double sm=0;
        if(nil>iq){
            System.out.println(iq);
            if(iq==0.0){
                System.out.println(sm);
            }
            else if(iq==1){
                System.out.println(sm=1);
            }
            else if((iq<1)&&(iq>0)){
                sm=(iq*0.3)-0.5;
                  BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue(); 
                System.out.println("Nilai Z1 SM="+Math.abs(sm));
            }
        }
        else if (nil<iq){
            System.out.println(nil);
            if(nil==0.0){
                System.out.println(sm);
            }
            else if(nil==1){
                System.out.println(sm=1);
            }
            else if((nil<1)&&(nil>0)){
               sm=(nil*0.3)-0.5;
               BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z1 SM="+Math.abs(sm));
            }
        }
        else {
            System.out.println(sm);
        }
        return sm;
    }
    public double rule1(double nil,double iq){
        double a=ai1(nil, iq);
        sm1(nil, iq);
        return a;
    }
    
    //if ipk= bagus and iq=biasa AI rendah SM tinggi
    public double ai2(double ipk,double iq){
        double ai=0;
        if(ipk>iq){
            System.out.println(iq);
            if(iq==0.0){
                System.out.println(ai);
            }
            else if(iq==1){
                System.out.println(ai=1);
            }
            else if((iq<1)&&(iq>0)){
                ai=(iq*0.4)-0.7;
                  BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z2 AI="+Math.abs(ai));
            }
        }
        else if (ipk<iq){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(ai);
            }
            else if(ipk==1){
                System.out.println(ai=1);
            }
            else if((ipk<1)&&(ipk>0)){
                 ai=(ipk*0.4)-0.7;
                   BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z2 AI="+Math.abs(ai));
            }
        }
        else {
            System.out.println(ai);
        }
        return ai;
    }
    public double sm2(double ipk,double iq){
        double sm=0;
        if(ipk>iq){
            System.out.println(iq);
            if(iq==0.0){
                System.out.println(sm);
            }
            else if(iq==1){
                System.out.println(sm=1);
            }
            else if((iq<1)&&(iq>0)){
                sm=(iq*0.5)+0.4;
                BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z2 SM="+sm);
            }
        }
        else if (ipk<iq){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(sm);
            }
            else if(ipk==1){
                System.out.println(sm=1);
            }
            else if((ipk<1)&&(ipk>0)){
               sm=(ipk*0.5)+0.4;
               BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z2 SM="+sm);
            }
        }
        else {
            System.out.println(sm);
        }
    return sm;
    }
    public void rule2(double ipk,double iq){
        ai2(ipk, iq);
        sm2(ipk, iq);
    }
  
    //if nilai= rendah or ipk=bagus  Then Ai Rendah SM Tinggi
    public double ai3(double nil, double ipk){
        double ai=0;
        if(nil>ipk){
            System.out.println(nil);
            if(nil==0.0){
                System.out.println(ai);
            }
            else if(nil==1){
                System.out.println(ai=1);
            }
            else if((nil<1)&&(nil>0)){
               ai=(nil*0.4)-0.7;
                 BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z3 AI="+Math.abs(ai));
            }
        }
        else if (nil<ipk){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(ai);
            }
            else if(ipk==1){
                System.out.println(ai=1);
            }
            else if((ipk<1)&&(ipk>0)){
               ai=(ipk*0.4)-0.7;
                 BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z3 AI="+Math.abs(ai));
            }
        }
        else {
            System.out.println(ai);
        }
        return ai;
    }
    public double sm3(double nil, double ipk){
         double sm=0;
        if(nil>ipk){
            System.out.println(nil);
            if(nil==0.0){
                System.out.println(sm);
            }
            else if(nil==1){
                System.out.println(sm=1);
            }
            else if((nil<1)&&(nil>0)){
                sm=(nil*0.5)+0.4;
                BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z3 SM="+sm);
            }
        }
        else if (nil<ipk){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(sm);
            }
            else if(ipk==1){
                System.out.println(sm=1);
            }
            else if((ipk<1)&&(ipk>0)){
                sm=(ipk*0.5)+0.4;
                BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z3 SM="+sm);
            }
        }
        else {
            System.out.println(sm);
        }
        return sm;
    }
    public void rule3(double nil, double ipk){
        ai3(nil, ipk);
        sm3(nil, ipk);
    }

    //if iq=cerdas or ipk= sangat bagus Then Ai tinggi SM rendah
    public double ai4(double iq, double ipk){
        double ai=0;
        if(iq>ipk){
            System.out.println(iq);
            if(iq==0.0){
                System.out.println(ai);
            }
            else if(iq==1){
                System.out.println(ai=1);
            }
            else if((iq<1)&&(iq>0)){
               ai=(iq*0.3)+0.6;
                 BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z4 A4="+ai);
            }
        }
        else if (iq<ipk){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(ai);
            }
            else if(ipk==1){
                System.out.println(ai=1);
            }
            else if((ipk<1)&&(ipk>0)){
               ai=(ipk*0.3)+0.6;
                 BigDecimal bd= new BigDecimal(ai);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                ai=bd.doubleValue(); 
                System.out.println("Nilai Z4 AI="+ai);
            }
        }
        else {
            System.out.println(ai);
        }
        return ai;
    }
    public double sm4(double iq, double ipk){
        double sm=0;
        if(iq>ipk){
            System.out.println(iq);
            if(iq==0.0){
                System.out.println(sm);
            }
            else if(iq==1){
                System.out.println(sm=1);
            }
            else if((iq<1)&&(iq>0)){
                sm=(iq*0.3)-0.5;
                BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z4 SM="+Math.abs(sm));
            }
        }
        else if (iq<ipk){
            System.out.println(ipk);
            if(ipk==0.0){
                System.out.println(sm);
            }
            else if(ipk==1){
                System.out.println(sm=1);
            }
            else if((ipk<1)&&(ipk>0)){
                sm=(ipk*0.3)-0.5;BigDecimal bd= new BigDecimal(sm);
                bd=bd.setScale(2, BigDecimal.ROUND_UP);
                sm=bd.doubleValue();
                System.out.println("Nilai Z4 SM="+Math.abs(sm));
            }
        }
        else {
            System.out.println(sm);
        }
        return sm;
    }
    public void rule4(double iq, double ipk){
        ai4(iq, ipk);
        sm4(iq, ipk);
    }
}
