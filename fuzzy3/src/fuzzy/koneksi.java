/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
 private static Connection koneksi;
    public static Connection getConnection(){
        //cek apakah koneksi null
        if(koneksi==null){
            
            try{
                String url="jdbc:mysql://localhost:3306/beasiswa";
                String user="root";
                String password="";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi=DriverManager.getConnection(url,user,password);
                
            }catch(SQLException t){
                System.out.println("error membuat koneksi");
                System.exit(0);
            }
            }
            return koneksi;
        }
    
}