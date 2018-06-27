/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy;
import java.awt.*;
import java.math.RoundingMode;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author ACER
 */
public class fuzifikasi extends javax.swing.JFrame {
    DecimalFormat koma = new DecimalFormat("0.##");
    Connection koneksi;
    Statement stm;
    ResultSet RsBrg;
    String goal;
    DefaultTableModel tabModel;
    boolean ada=false;
    boolean edit=false;
    private Object[][]dataTable=null;
      Object[]header={"NAMA","DIAGNOSA","SOLUSI","NILAI CF"};
      rules b= new rules();
      logika log= new logika();
      caridrajat a= new caridrajat();
    /**
     * Creates new form fuzifikasi
     */
    public fuzifikasi() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/fuzzy/toga2.png")));
		this.setTitle("SISTEM PAKAR PENYELEKSIAN PENERIMAAN BEASISWA");
        openDB();
        tampil();
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int x=(dim.width-getWidth())/2;
        int y=(dim.height-getHeight())/2;
        setLocation(x,y);  
        awal();
        aktif();
    }

    private fuzifikasi(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /*    fuzifikasi(Object object) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    fuzifikasi(Object object) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    fuzifikasi(Object object) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

        private void autonomor(){
        String sql="select max(id)from rekap";
        try{
            stm=koneksi.createStatement();
            RsBrg=stm.executeQuery(sql);
            while(RsBrg.next()){
                int a=RsBrg.getInt(1);
                txt_id.setText(""+Integer.toString(a+1));    
            }
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }
    
    public void cardrajat(){
        String ipk=txt_ipk.getText();
        String gaji=txt_gaji.getText();
        String tanggungan=txt_tanggungan.getText();
        double ipk2= Double.parseDouble(ipk);
        double gaji2=Double.parseDouble(gaji);
        double tanggungan2=Double.parseDouble(tanggungan);
		txt_icukup.setText(Double.toString(a.drajatanggotacukup(ipk2)));
        txt_inormal.setText(Double.toString( a.drajatanggotanormal(ipk2)));
		txt_itinggi.setText(Double.toString(a.drajatanggotatinggi(ipk2)));
        txt_gcukup.setText(Double.toString(a.drajatanggotacukup2(gaji2)));
        txt_gnormal.setText(Double.toString(a.drajatanggotanormal2(gaji2)));
        txt_gtinggi.setText(Double.toString(a.drajatanggotatinggi2(gaji2)));
        txt_tcukup.setText(Double.toString( a.drajatanggotacukup3(tanggungan2)));
		txt_tnormal.setText(Double.toString( a.drajatanggotanormal3(tanggungan2)));
		txt_ttinggi.setText(Double.toString( a.drajatanggotatinggi3(tanggungan2)));
    }
    
    public void cariiidrajat(){
      try{
        cardrajat();
        double ip1 = (Double.parseDouble(txt_icukup.getText()));
        double ip2 = (Double.parseDouble(txt_inormal.getText()));
        double ip3 = (Double.parseDouble(txt_itinggi.getText()));
        double gj1 = (Double.parseDouble(txt_gcukup.getText()));
        double gj2 = (Double.parseDouble(txt_gnormal.getText()));
        double gj3 = (Double.parseDouble(txt_gtinggi.getText()));
        double tg1 = (Double.parseDouble(txt_tcukup.getText()));
        double tg2 = (Double.parseDouble(txt_tnormal.getText()));
        double tg3 = (Double.parseDouble(txt_ttinggi.getText()));
        
        txt_ic1.setText(koma.format(ip1));
        txt_gc1.setText(koma.format(gj1));
        txt_tc1.setText(koma.format(tg1));
        txt_ic2.setText(koma.format(ip1));
        txt_gn2.setText(koma.format(gj2));
        txt_tc2.setText(koma.format(tg1));        
        txt_in3.setText(koma.format(ip2));
        txt_gc3.setText(koma.format(gj1));
        txt_tn3.setText(koma.format(tg2));
        txt_in4.setText(koma.format(ip2));
        txt_gn4.setText(koma.format(gj2));
        txt_tn4.setText(koma.format(tg2));
        txt_ic5.setText(koma.format(ip1));
        txt_gc5.setText(koma.format(gj1));
        txt_tn5.setText(koma.format(tg2));
        txt_ic6.setText(koma.format(ip1));
        txt_gn6.setText(koma.format(gj2));
        txt_tn6.setText(koma.format(tg2));
        txt_in7.setText(koma.format(ip2));
        txt_gc7.setText(koma.format(gj1));
        txt_tc7.setText(koma.format(tg1));
        txt_in8.setText(koma.format(ip2));
        txt_gn8.setText(koma.format(gj2));
        txt_tc8.setText(koma.format(tg1));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    
    public void bhminimum(){
        double i1 = (Double.parseDouble(txt_icukup.getText()));
        double g1 = (Double.parseDouble(txt_gcukup.getText()));
        double t1 = (Double.parseDouble(txt_tcukup.getText()));
        double i2 = (Double.parseDouble(txt_icukup.getText()));
        double g2 = (Double.parseDouble(txt_gnormal.getText()));
        double t2 = (Double.parseDouble(txt_tcukup.getText()));
        double i3 = (Double.parseDouble(txt_inormal.getText()));
        double g3 = (Double.parseDouble(txt_gcukup.getText()));
        double t3 = (Double.parseDouble(txt_tnormal.getText()));
        double i4 = (Double.parseDouble(txt_inormal.getText()));
        double g4 = (Double.parseDouble(txt_gnormal.getText()));
        double t4 = (Double.parseDouble(txt_tnormal.getText()));
        double i5 = (Double.parseDouble(txt_icukup.getText()));
        double g5 = (Double.parseDouble(txt_gcukup.getText()));
        double t5 = (Double.parseDouble(txt_tnormal.getText()));
        double i6 = (Double.parseDouble(txt_icukup.getText()));
        double g6 = (Double.parseDouble(txt_gnormal.getText()));
        double t6 = (Double.parseDouble(txt_tnormal.getText()));
        double i7 = (Double.parseDouble(txt_inormal.getText()));
        double g7 = (Double.parseDouble(txt_gcukup.getText()));
        double t7 = (Double.parseDouble(txt_tcukup.getText()));
        double i8 = (Double.parseDouble(txt_inormal.getText()));
        double g8 = (Double.parseDouble(txt_gnormal.getText()));
        double t8 = (Double.parseDouble(txt_tcukup.getText()));

        double [] nilai1 = {i1,g1,t1};
        double max1 = 0;
        double min1 = 1000;
        for (int con=0;con<nilai1.length;con++){
            if (nilai1[con]< min1){
                min1 = nilai1 [con];
            }else if (nilai1[con]>max1){
                max1 = nilai1 [con];
            }}
            txt_tl1.setText(""+min1);
            txt_mt1.setText(""+min1);

            double [] nilai2 = {i2,g2,t2};
            double max2 = 0;
            double min2 = 1000;
            for (int con=0;con<nilai2.length;con++){
                if (nilai2[con]< min2){
                    min2 = nilai2 [con];
                }else if (nilai2[con]>max2){
                    max2 = nilai2 [con];
                }}
                txt_tl2.setText(""+min2);
                txt_mt2.setText(""+min2);

                double [] nilai3 = {i3,g3,t3};
                double max3 = 0;
                double min3 = 1000;
                for (int con=0;con<nilai3.length;con++){
                    if (nilai3[con]< min3){
                        min3 = nilai3 [con];
                    }else if (nilai3[con]>max3){
                        max3 = nilai3 [con];
                    }}
                    txt_l3.setText(""+min3);
                    txt_ml1.setText(""+min3);
                    txt_mlh.setText(""+min3);
                    txt_B.setText(""+min3);
                    txt_B1.setText(""+min3);
                    txt_B2.setText(""+min3);

                    double [] nilai4 = {i4,g4,t4};
                    double max4 = 0;
                    double min4 = 1000;
                    for (int con=0;con<nilai4.length;con++){
                        if (nilai4[con]< min4){
                            min4 = nilai4 [con];
                        }else if (nilai4[con]>max4){
                            max4 = nilai4 [con];
                        }}
                        txt_tl4.setText(""+min4);
                        txt_mt3.setText(""+min4);

                        double [] nilai5 = {i5,g5,t5};
                        double max5 = 0;
                        double min5 = 1000;
                        for (int con=0;con<nilai5.length;con++){
                            if (nilai5[con]< min5){
                                min5 = nilai5 [con];
                            }else if (nilai5[con]>max5){
                                max5 = nilai5 [con];
                            }}
                            txt_tl5.setText(""+min5);
                            txt_mt4.setText(""+min5);

                            double [] nilai6 = {i6,g6,t6};
                            double max6 = 0;
                            double min6 = 1000;
                            for (int con=0;con<nilai6.length;con++){
                                if (nilai6[con]< min6){
                                    min6 = nilai6 [con];
                                }else if (nilai6[con]>max6){
                                    max6 = nilai6 [con];
                                }}
                                txt_tl6.setText(""+min6);
                                txt_mt5.setText(""+min6);

                                double [] nilai7 = {i7,g7,t7};
                                double max7 = 0;
                                double min7 = 1000;
                                for (int con=0;con<nilai7.length;con++){
                                    if (nilai7[con]< min7){
                                        min7 = nilai7 [con];
                                    }else if (nilai7[con]>max7){
                                        max7 = nilai7 [con];
                                    }}
                                    txt_tl7.setText(""+min7);
                                    txt_mt6.setText(""+min7);

                                    double [] nilai8 = {i8,g8,t8};
                                    double max8 = 0;
                                    double min8 = 1000;
                                    for (int con=0;con<nilai8.length;con++){
                                        if (nilai8[con]< min8){
                                            min8 = nilai8 [con];
                                        }else if (nilai8[con]<max8){
                                            max8 = nilai8 [con];
                                        }}
                                        txt_tl8.setText(""+min8);
                                        txt_mt7.setText(""+min8);
    }
    
    public void bhmaximum(){
            double t1 = (Double.parseDouble(txt_mt1.getText()));
        double t2 = (Double.parseDouble(txt_mt2.getText()));
        double l1 = (Double.parseDouble(txt_ml1.getText()));
        double t3 = (Double.parseDouble(txt_mt3.getText()));
        double t4 = (Double.parseDouble(txt_mt4.getText()));
        double t5 = (Double.parseDouble(txt_mt5.getText()));
        double t6 = (Double.parseDouble(txt_mt6.getText()));
        double t7 = (Double.parseDouble(txt_mt7.getText()));

        double [] nilai = {t1,t2,t3,t4,t5,t6,t7};
        double max = 0;
        double min = 1000;
        for (int dis=0;dis<nilai.length;dis++){
            if (nilai[dis]> max){
                max = nilai [dis];
            }else if (nilai[dis]<min){
                min = nilai [dis];
            }}
            txt_mth.setText(""+max);
            txt_A.setText(""+max);
            txt_AA1.setText(""+max);
            txt_AA2.setText(""+max);
            txt_AA3.setText(""+max);
            txt_AA4.setText(""+max);
            txt_AA5.setText(""+max);
            txt_AA6.setText(""+max);
            txt_AA7.setText(""+max);
            txt_AA8.setText(""+max);
    }
    
    
    public void simpanlulus(){
        String t1 = txt_id.getText();
        String t2 = txt_nama.getText();
        String t3 = txt_nim.getText();
        String t4 = txt_jurusan.getText();
        String t5 = txt_ipk.getText();
        String t6 = txt_icukup.getText();
        String t7 = txt_inormal.getText();
        String t8 = txt_itinggi.getText();
        String t9 = txt_gaji.getText();
        String t10 = txt_gcukup.getText();
        String t11 = txt_gnormal.getText();
        String t12 = txt_gtinggi.getText();
        String t13 = txt_tanggungan.getText();
        String t14 = txt_tcukup.getText();
        String t15 = txt_tnormal.getText();
        String t16 = txt_ttinggi.getText();
        String t17 = txt_mt1.getText();
        String t18 = txt_mt2.getText();
        String t19 = txt_ml1.getText();
        String t20 = txt_mt3.getText();        
        String t21 = txt_mt4.getText();
        String t22 = txt_mt5.getText();
        String t23 = txt_mt6.getText();
        String t24 = txt_mt7.getText();
        String t25 = txt_mth.getText();
        String t26 = txt_mlh.getText();
        String t27 = txt_defuzzy.getText();  
        String t28 = txt_keputusan.getText();  
        
                try{
                        stm = koneksi.createStatement();
                        String sql="INSERT into rekap VALUES('" + t1 + "','" + t2 + "','" + t3 + "','" + t4 + "','" + t5 + "','" + t6 + "','" + t7 + "','" + t8 + "','" + t9 + "','" + t10 + "','" + t11 + "','" + t12 + "','" + t13 + "','" + t14 + "','" + t15 + "','" + t16 + "','" + t17 + "','" + t18 + "','" + t19 + "','" + t20 + "','" + t21 + "','" + t22 + "','" + t23 + "','" + t24 + "','" + t25 + "','" + t26 + "','" + t27 + "','" + t28 + "')";
                        stm.executeUpdate(sql);
                       
                       JOptionPane.showMessageDialog(null,"Sukses!");
                                    tbl_data.setModel(new DefaultTableModel(dataTable, header));
                        tampil();
                        aktif();       
                        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null,"Proses penyimpanan gagal / No Pasien sudah ada "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
                        System.out.println(e.getMessage());
                       
                        }

    }
    
    public void simpantidaklulus(){
        String t1 = txt_id.getText();
        String t2 = txt_nama.getText();
        String t3 = txt_nim.getText();
        String t4 = txt_jurusan.getText();
        String t5 = txt_ipk.getText();
        String t6 = txt_icukup.getText();
        String t7 = txt_inormal.getText();
        String t8 = txt_itinggi.getText();
        String t9 = txt_gaji.getText();
        String t10 = txt_gcukup.getText();
        String t11 = txt_gnormal.getText();
        String t12 = txt_gtinggi.getText();
        String t13 = txt_tanggungan.getText();
        String t14 = txt_tcukup.getText();
        String t15 = txt_tnormal.getText();
        String t16 = txt_ttinggi.getText();
        String t17 = txt_mt1.getText();
        String t18 = txt_mt2.getText();
        String t19 = txt_ml1.getText();
        String t20 = txt_mt3.getText();        
        String t21 = txt_mt4.getText();
        String t22 = txt_mt5.getText();
        String t23 = txt_mt6.getText();
        String t24 = txt_mt7.getText();
        String t25 = txt_mth.getText();
        String t26 = txt_mlh.getText();
        String t27 = txt_defuzzy.getText();  
        String t28 = txt_keputusan.getText();  
        
                try{
                        stm = koneksi.createStatement();
                        String sql="INSERT into rekap VALUES('" + t1 + "','" + t2 + "','" + t3 + "','" + t4 + "','" + t5 + "','" + t6 + "','" + t7 + "','" + t8 + "','" + t9 + "','" + t10 + "','" + t11 + "','" + t12 + "','" + t13 + "','" + t14 + "','" + t15 + "','" + t16 + "','" + t17 + "','" + t18 + "','" + t19 + "','" + t20 + "','" + t21 + "','" + t22 + "','" + t23 + "','" + t24 + "','" + t25 + "','" + t26 + "','" + t27 + "','" + t28 + "')";
                        stm.executeUpdate(sql);
                       
                       JOptionPane.showMessageDialog(null,"Sukses!");
                                    tbl_data.setModel(new DefaultTableModel(dataTable, header));
                        tampil();
                        awal();
                        aktif();      
                        } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null,"Proses penyimpanan gagal / No Pasien sudah ada "+e,"Koneksi Gagal",JOptionPane.WARNING_MESSAGE);
                        System.out.println(e.getMessage());
                       
                        }

    }
    
    
    public void defuzzi(){
            double A = (Double.parseDouble(txt_mth.getText()));
        double B = (Double.parseDouble(txt_mlh.getText()));
        double fuzzy_setA = ((1.91 + 2.1 + 2.15 + 3.21 + 3.4 + 3.60 + 3.62 + 3.90) * A);
        double fuzzy_setB = ((3.80 + 7.60) * B);
        double hasil = ( fuzzy_setA + fuzzy_setB /(A + A + A + A + A + A + A + A + B + B ));
        double potongA = (1.91);
        double potongB = (3.85);
        double lulus = ((potongA + potongB) / 2);
        String jikatidaklulus = "TIDAK LULUS" ;
        String jikalulus = "LULUS" ;

        txt_defuzzy.setText(koma.format(hasil));

        if(hasil>lulus){
            txt_keputusan.setText((jikalulus));
            JOptionPane.showMessageDialog(null, "Data Di Proses");
            simpanlulus();
        }
        else if(hasil<lulus){
            txt_keputusan.setText((jikatidaklulus));
            JOptionPane.showMessageDialog(null, "Data Di Proses");
            simpantidaklulus();
        }
    }
    
    public void openDB(){
		try{ 
		koneksi kon = new koneksi();
		koneksi=kon.getConnection();
		System.out.println("berhasil");
		}catch(Exception err){
		System.out.println(err);
		}
	}
    
    private void kosong(){
          c_nama.setSelectedItem("-PILIH-");
          txt_ipk.setText("");
          txt_nama.setText("");
          txt_nim.setText("");
          txt_ipk.setText("");
          txt_gaji.setText("");
          txt_tanggungan.setText("");
          txt_icukup.setText("");
          txt_inormal.setText("");
          txt_itinggi.setText("");
          txt_gcukup.setText("");
          txt_gnormal.setText("");
          txt_gtinggi.setText("");
          txt_tcukup.setText("");
          txt_tnormal.setText("");
          txt_ttinggi.setText("");
          txt_ic1.setText("");
          txt_gc1.setText("");
          txt_tc1.setText("");
          txt_tl1.setText("");
          txt_ic2.setText("");
          txt_gn2.setText("");
          txt_tc2.setText("");
          txt_tl2.setText("");
          txt_in3.setText("");
          txt_gc3.setText("");
          txt_tn3.setText("");
          txt_l3.setText("");
          txt_in4.setText("");
          txt_gn4.setText("");
          txt_tn4.setText("");
          txt_tl4.setText("");
          txt_ic5.setText("");
          txt_gc5.setText("");
          txt_tn5.setText("");
          txt_tl5.setText("");
          txt_ic6.setText("");
          txt_gn6.setText("");
          txt_tn6.setText("");
          txt_tl6.setText("");
          txt_in7.setText("");
          txt_gc7.setText("");
          txt_tc7.setText("");
          txt_tl7.setText("");
          txt_in8.setText("");
          txt_gn8.setText("");
          txt_tc8.setText("");
          txt_tl8.setText("");
          txt_mt1.setText("");
          txt_mt2.setText("");
          txt_mt3.setText("");
          txt_mt4.setText("");
          txt_mt5.setText("");
          txt_mt6.setText("");
          txt_mt7.setText("");
          txt_mth.setText("");
          txt_ml1.setText("");
          txt_mlh.setText("");
          txt_defuzzy.setText("");
          txt_keputusan.setText("");
    }
    
    void awal(){
        tbl_data.setModel(tampil());
  //      kosong();
    }
       
    void aktif(){
        c_nama.setEnabled(true);
        txt_nama.setEnabled(true);
        txt_nim.setEnabled(true);
        txt_ipk.setEnabled(true);
        txt_gaji.setEnabled(true);
        txt_tanggungan.setEnabled(true);
    }
    
    private void setField(){
      int row=tbl_data.getSelectedRow();
      txt_id.setText((String)tbl_data.getValueAt(row, 0));
      c_nama.setSelectedItem((String)tbl_data.getValueAt(row, 1));
      txt_nama.setText((String)tbl_data.getValueAt(row, 2));
      txt_nim.setText((String)tbl_data.getValueAt(row, 3));
//      txt_nama.getSelectedItem((String)tbl_data.getValueAt(row, 0));
    }
       
  
public DefaultTableModel tampil(){

    String[]judul={"NAMA","DIAGNOSA","SOLUSI","NILAI CF"};
DefaultTableModel colom=new DefaultTableModel(null,judul);
try{
    stm = koneksi.createStatement();
        RsBrg=stm.executeQuery("select * from rekap ");
String data[]=new String[8];
while(RsBrg.next()){
    		data[0]=RsBrg.getString(1);    data[1]=RsBrg.getString(2);
    		data[2]=RsBrg.getString(3);    data[3]=RsBrg.getString(4);
    		colom.addRow(data);}}
catch(Exception ex){JOptionPane.showMessageDialog(null,"error"+ex,"GAGAL",JOptionPane.WARNING_MESSAGE);}
       return colom;
} 

        private void combo_nilai1(){
 try{
    
    stm = koneksi.createStatement();
    RsBrg=stm.executeQuery("select * from d_mahasiswa where id='"+c_nama.getSelectedItem()+"'");
           RsBrg.beforeFirst();
           while(RsBrg.next()){
               txt_nama.setText(RsBrg.getString(2).trim());
               txt_nim.setText(RsBrg.getString(3).trim());
               txt_jurusan.setText(RsBrg.getString(4).trim());
               txt_gaji.setText(RsBrg.getString(5).trim());
               txt_tanggungan.setText(RsBrg.getString(6).trim());
               txt_ipk.setText(RsBrg.getString(7).trim());
           }

       }catch (Exception e){
           e.printStackTrace();
       }
 }

private void baca_nilai1(){
try{

    stm=koneksi.createStatement();
    ResultSet RsBrg=stm.executeQuery("SELECT * FROM d_mahasiswa");
    RsBrg.beforeFirst();
    while(RsBrg.next()){
        c_nama.addItem(RsBrg.getString(1).trim()+". "+RsBrg.getString(2).trim());
    }
}catch(SQLException e)
{e.printStackTrace();
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel21 = new fuzzy.panel2();
        clGlossyPanel1 = new GlossyPanel.ClGlossyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        clPanelTransparan1 = new PanelTransparan.ClPanelTransparan();
        clRoundTransButton1 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton2 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton3 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton4 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton5 = new RoundedTransparanButton.ClRoundTransButton();
        clPanelTransparan2 = new PanelTransparan.ClPanelTransparan();
        bplus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        c_nama = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nama = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_ipk = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_nim = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_jurusan = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_gaji = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_tanggungan = new RoundedTransparanTextField.ClRoundTransTxt();
        clPanelTransparan3 = new PanelTransparan.ClPanelTransparan();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_icukup = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_inormal = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_itinggi = new RoundedTransparanTextField.ClRoundTransTxt();
        clPanelTransparan5 = new PanelTransparan.ClPanelTransparan();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_gcukup = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_gnormal = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_gtinggi = new RoundedTransparanTextField.ClRoundTransTxt();
        clPanelTransparan6 = new PanelTransparan.ClPanelTransparan();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_tcukup = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_tnormal = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_ttinggi = new RoundedTransparanTextField.ClRoundTransTxt();
        bcdrajat = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton6 = new RoundedTransparanButton.ClRoundTransButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        txt_ic2 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        txt_gn2 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        txt_tc2 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txt_tl2 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        txt_in3 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        txt_gc3 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        txt_tn3 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        txt_l3 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        txt_ic5 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        txt_gc5 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        txt_tn5 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        txt_tl5 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        txt_ic6 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        txt_gn6 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        txt_tn6 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        txt_tl6 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        txt_in7 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        txt_gc7 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        txt_tc7 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        txt_tl7 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        txt_tc8 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        txt_in8 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        txt_gn8 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        txt_tl8 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        txt_tl4 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        txt_tn4 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        txt_gn4 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        txt_in4 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txt_tl1 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_ic1 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        txt_gc1 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        txt_tc1 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        bhminimum = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        bcari1 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        txt_mt2 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_mt1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_mt3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_mt4 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_mt5 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_mt6 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_mt7 = new javax.swing.JLabel();
        txt_mth = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_ml1 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_mlh = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        bdefuzzy = new javax.swing.JButton();
        txt_defuzzy = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txt_A = new javax.swing.JLabel();
        txt_A1 = new javax.swing.JLabel();
        txt_B = new javax.swing.JLabel();
        txt_A3 = new javax.swing.JLabel();
        txt_A4 = new javax.swing.JLabel();
        txt_AA8 = new javax.swing.JLabel();
        txt_A5 = new javax.swing.JLabel();
        txt_A6 = new javax.swing.JLabel();
        txt_AA7 = new javax.swing.JLabel();
        txt_AA6 = new javax.swing.JLabel();
        txt_A9 = new javax.swing.JLabel();
        txt_AA5 = new javax.swing.JLabel();
        txt_A11 = new javax.swing.JLabel();
        txt_AA4 = new javax.swing.JLabel();
        txt_A13 = new javax.swing.JLabel();
        txt_A14 = new javax.swing.JLabel();
        txt_AA3 = new javax.swing.JLabel();
        txt_A16 = new javax.swing.JLabel();
        txt_AA2 = new javax.swing.JLabel();
        txt_A18 = new javax.swing.JLabel();
        txt_AA1 = new javax.swing.JLabel();
        txt_B2 = new javax.swing.JLabel();
        txt_A21 = new javax.swing.JLabel();
        txt_B1 = new javax.swing.JLabel();
        txt_A23 = new javax.swing.JLabel();
        txt_A24 = new javax.swing.JLabel();
        txt_keputusan = new javax.swing.JTextField();
        txt_A25 = new javax.swing.JLabel();
        txt_A26 = new javax.swing.JLabel();
        txt_A27 = new javax.swing.JLabel();
        txt_id = new RoundedTransparanTextField.ClRoundTransTxt();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SPK Penyeleksian Penerimaan Beasiswa Dengan Methode Fuzzy Logic");

        jLabel31.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("_");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("X");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout clGlossyPanel1Layout = new javax.swing.GroupLayout(clGlossyPanel1);
        clGlossyPanel1.setLayout(clGlossyPanel1Layout);
        clGlossyPanel1Layout.setHorizontalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(27, 27, 27))
        );
        clGlossyPanel1Layout.setVerticalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel31))
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        clPanelTransparan1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        clRoundTransButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/proses.png"))); // NOI18N
        clRoundTransButton1.setText("Proses Fuzzy");
        clRoundTransButton1.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton1ActionPerformed(evt);
            }
        });

        clRoundTransButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/home.png"))); // NOI18N
        clRoundTransButton2.setText("Home");
        clRoundTransButton2.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton2ActionPerformed(evt);
            }
        });

        clRoundTransButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/report.png"))); // NOI18N
        clRoundTransButton3.setText("Report");
        clRoundTransButton3.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton3ActionPerformed(evt);
            }
        });

        clRoundTransButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/plus.png"))); // NOI18N
        clRoundTransButton4.setText("Data\nMahasiswa");
        clRoundTransButton4.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton4ActionPerformed(evt);
            }
        });

        clRoundTransButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/logout.png"))); // NOI18N
        clRoundTransButton5.setText("Logout");
        clRoundTransButton5.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clPanelTransparan1Layout = new javax.swing.GroupLayout(clPanelTransparan1);
        clPanelTransparan1.setLayout(clPanelTransparan1Layout);
        clPanelTransparan1Layout.setHorizontalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(clRoundTransButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clRoundTransButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(clRoundTransButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(clRoundTransButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(clRoundTransButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        clPanelTransparan1Layout.setVerticalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clRoundTransButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        clPanelTransparan2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bplus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/Create.png"))); // NOI18N
        bplus.setAutoscrolls(true);
        bplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bplusActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 20)); // NOI18N
        jLabel2.setText("Fuzzyfikasi");

        jLabel44.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel44.setText("Pilih Mahasiswa");

        c_nama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-PILIH-" }));
        c_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_namaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel7.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel3.setText("NIM");

        jLabel45.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel45.setText("Jurusan");

        jLabel6.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel6.setText("IPK Terakhir");

        jLabel4.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel4.setText("Gaji Orang Tua");

        jLabel5.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel5.setText("Tanggungan Ortu");

        clPanelTransparan3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel13.setText("Drajat Keanggotaan IPK :");

        jLabel21.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel21.setText("Cukup");

        jLabel22.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel22.setText("Normal");

        jLabel23.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel23.setText("Tinggi");

        javax.swing.GroupLayout clPanelTransparan3Layout = new javax.swing.GroupLayout(clPanelTransparan3);
        clPanelTransparan3.setLayout(clPanelTransparan3Layout);
        clPanelTransparan3Layout.setHorizontalGroup(
            clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txt_icukup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(8, 8, 8)
                        .addComponent(txt_inormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(22, 22, 22)
                        .addComponent(txt_itinggi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clPanelTransparan3Layout.setVerticalGroup(
            clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_icukup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_inormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_itinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clPanelTransparan5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel14.setText("Drajat Keanggotaan Gaji :");

        jLabel24.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel24.setText("Cukup");

        jLabel25.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel25.setText("Normal");

        jLabel26.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel26.setText("Tinggi");

        javax.swing.GroupLayout clPanelTransparan5Layout = new javax.swing.GroupLayout(clPanelTransparan5);
        clPanelTransparan5.setLayout(clPanelTransparan5Layout);
        clPanelTransparan5Layout.setHorizontalGroup(
            clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(clPanelTransparan5Layout.createSequentialGroup()
                        .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_gcukup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gnormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gtinggi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        clPanelTransparan5Layout.setVerticalGroup(
            clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_gcukup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_gnormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_gtinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clPanelTransparan6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel15.setText("Drajat Keanggotaan Tanggungan :");

        jLabel27.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel27.setText("Normal");

        jLabel28.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel28.setText("Tinggi");

        jLabel29.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel29.setText("Cukup");

        javax.swing.GroupLayout clPanelTransparan6Layout = new javax.swing.GroupLayout(clPanelTransparan6);
        clPanelTransparan6.setLayout(clPanelTransparan6Layout);
        clPanelTransparan6Layout.setHorizontalGroup(
            clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(clPanelTransparan6Layout.createSequentialGroup()
                        .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(8, 8, 8)
                        .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tcukup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tnormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ttinggi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clPanelTransparan6Layout.setVerticalGroup(
            clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txt_tcukup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tnormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clPanelTransparan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ttinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bcdrajat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/calculate.png"))); // NOI18N
        bcdrajat.setText("Hitung");
        bcdrajat.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        bcdrajat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bcdrajat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bcdrajat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcdrajatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clPanelTransparan2Layout = new javax.swing.GroupLayout(clPanelTransparan2);
        clPanelTransparan2.setLayout(clPanelTransparan2Layout);
        clPanelTransparan2Layout.setHorizontalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createSequentialGroup()
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(c_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                                    .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel45)
                                        .addComponent(txt_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addGap(33, 33, 33)
                                    .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_ipk, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(txt_tanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txt_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcdrajat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)))
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(clPanelTransparan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clPanelTransparan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clPanelTransparan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bplus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        clPanelTransparan2Layout.setVerticalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bplus))
                .addGap(10, 10, 10)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addComponent(clPanelTransparan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clPanelTransparan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clPanelTransparan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ipk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(7, 7, 7)
                                .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcdrajat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        clRoundTransButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/kanan.png"))); // NOI18N
        clRoundTransButton6.setToolTipText("");
        clRoundTransButton6.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton6ActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel118.setText("(Rule 2)");

        jLabel122.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel122.setText("if ipk=cukup(");

        txt_ic2.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel124.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel124.setText(") and gaji=normal(");

        txt_gn2.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        jLabel126.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel126.setText(") and tanggungan=cukup(");

        txt_tc2.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        jLabel132.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel132.setText(")");

        jLabel128.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel128.setText("Then Tidak Lulus(");

        txt_tl2.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N

        jLabel206.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel206.setText(")");

        jLabel134.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel134.setText("(Rule 3)");

        jLabel136.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel136.setText("if ipk=normal(");

        txt_in3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel138.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel138.setText(") and gaji=cukup(");

        txt_gc3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel142.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel142.setText(") and tanggungan=normal(");

        txt_tn3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel207.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel207.setText(")");

        jLabel144.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel144.setText("Then Lulus(");

        txt_l3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel146.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel146.setText(")");

        jLabel162.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel162.setText(")");

        jLabel164.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel164.setText("(Rule 5)");

        jLabel166.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel166.setText("if ipk=cukup(");

        txt_ic5.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel168.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel168.setText(") and gaji=cukup(");

        txt_gc5.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel170.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel170.setText(") and tanggungan=normal(");

        txt_tn5.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel172.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel172.setText("Then Tidak Lulus(");

        txt_tl5.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel174.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel174.setText(")");

        jLabel177.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel177.setText("(Rule 6)");

        jLabel188.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel188.setText("if ipk=cukup(");

        txt_ic6.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel189.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel189.setText(") and gaji=normal(");

        txt_gn6.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel190.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel190.setText(") and tanggungan=normal(");

        txt_tn6.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel191.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel191.setText("Then Tidak Lulus(");

        txt_tl6.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel192.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel192.setText(")");

        jLabel193.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel193.setText("(Rule 7)");

        jLabel194.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel194.setText("if ipk=normal(");

        txt_in7.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel195.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel195.setText(") and gaji=cukup(");

        txt_gc7.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel196.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel196.setText(") and tanggungan=cukup(");

        txt_tc7.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel197.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel197.setText("Then Tidak Lulus(");

        txt_tl7.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel198.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel198.setText(")");

        txt_tc8.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel199.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel199.setText("Then Tidak Lulus(");

        txt_in8.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel200.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel200.setText(") and gaji=normal(");

        txt_gn8.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel201.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel201.setText("(Rule 8)");

        jLabel202.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel202.setText("if ipk=normal(");

        txt_tl8.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel203.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel203.setText(") and tanggungan=cukup(");

        txt_tl4.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel158.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel158.setText("Then Tidak Lulus(");

        jLabel208.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel208.setText(")");

        txt_tn4.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel156.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel156.setText(") and tanggungan=normal(");

        txt_gn4.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel154.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel154.setText(") and gaji=normal(");

        txt_in4.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel152.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel152.setText("if ipk=normal(");

        jLabel148.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel148.setText("(Rule 4)");

        jLabel221.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel221.setText(")");

        jLabel222.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel222.setText(")");

        jLabel223.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel223.setText(")");

        jLabel224.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel224.setText(")");

        jLabel209.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel209.setText(")");

        jLabel116.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel116.setText(")");

        txt_tl1.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel58.setText("Then Tidak Lulus(");

        jLabel38.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel38.setText("if ipk=cukup(");

        txt_ic1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        jLabel112.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel112.setText(") and gaji=cukup(");

        txt_gc1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        jLabel114.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel114.setText(") and tanggungan=cukup(");

        txt_tc1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        jLabel205.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel205.setText(")");

        bhminimum.setBackground(new java.awt.Color(255, 255, 255));
        bhminimum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bhminimum.setText("Hitung");
        bhminimum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhminimumActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel40.setText("Nilai Minimum (Conjuction)");

        jLabel109.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel109.setText("(Rule 1)");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel43.setText("Nilai Maximum (Disjuction)");

        bcari1.setBackground(new java.awt.Color(255, 255, 255));
        bcari1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bcari1.setText("cari");
        bcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcari1ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel75.setText("(O)");

        txt_mt2.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel33.setText(")v  keputusan is TIDAK LULUS (");

        txt_mt1.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel35.setText("keputusan is TIDAK LULUS (");

        txt_mt3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel36.setText(")v  keputusan is TIDAK LULUS(");

        txt_mt4.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel47.setText("keputusan is TIDAK LULUS (");

        txt_mt5.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel49.setText("keputusan is TIDAK LULUS(");

        txt_mt6.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel52.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel52.setText("keputusan is TIDAK LULUS (");

        jLabel53.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel53.setText(")  Dihasilkan  is TIDAK LULUS(");

        txt_mt7.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        txt_mth.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel104.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel104.setText(")");

        jLabel106.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel106.setText("(O)");

        jLabel55.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel55.setText("keputusan is LULUS (");

        txt_ml1.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel57.setText(")  Dihasilkan is LULUS (");

        txt_mlh.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        jLabel108.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel108.setText(")");

        jLabel37.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel37.setText("keputusan is TIDAK LULUS (");

        jLabel217.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel217.setText(")v");

        jLabel218.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel218.setText(")v");

        jLabel219.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel219.setText(")v");

        jLabel220.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel220.setText(")v");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel39.setText("Defuzzyfikasi");

        jLabel41.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel41.setText("((1.91 + 2.1 + 2.15 + 3.21 + 3.4 + 3.60 + 3.62 + 3.90)   X");

        bdefuzzy.setBackground(new java.awt.Color(255, 255, 255));
        bdefuzzy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bdefuzzy.setText("Defuzzy");
        bdefuzzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdefuzzyActionPerformed(evt);
            }
        });

        txt_defuzzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_defuzzyActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        jLabel72.setText("((3.80 + 7.60)    X");

        txt_A.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        txt_A1.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        txt_A1.setText(")  +");

        txt_B.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N

        txt_A3.setFont(new java.awt.Font("Poor Richard", 1, 13)); // NOI18N
        txt_A3.setText(") ");

        txt_A4.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A4.setText("___________________________________________________________________");

        txt_AA8.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A5.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A5.setText("+");

        txt_A6.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A6.setText("+");

        txt_AA7.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_AA6.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A9.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A9.setText("+");

        txt_AA5.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A11.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A11.setText("+");

        txt_AA4.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A13.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A13.setText("+");

        txt_A14.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A14.setText("+");

        txt_AA3.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A16.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A16.setText("+");

        txt_AA2.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A18.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A18.setText("+");

        txt_AA1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_B2.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A21.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A21.setText("+");

        txt_B1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N

        txt_A23.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A23.setText("=");

        txt_A24.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A24.setText("=");

        txt_keputusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keputusanActionPerformed(evt);
            }
        });

        txt_A25.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A25.setText("=");

        txt_A26.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A26.setText("Nilai Defuzzy");

        txt_A27.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        txt_A27.setText("Keputusan");

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(625, Short.MAX_VALUE)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(417, 417, 417))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel134)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel136)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_in3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel138)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_gc3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel142)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tn3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel128)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tl2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel206, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel118)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel122)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_ic2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel124)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_gn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel126)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tc2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel58)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tl1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel38)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_ic1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel40)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bhminimum))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel112)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_gc1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(jLabel114)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tc1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(118, 118, 118)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel75)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel35)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txt_mt3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel47)
                                                                .addComponent(jLabel52))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txt_mt7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt_mt5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel53)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txt_mth, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel219, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel49)
                                                                    .addComponent(jLabel36)))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txt_mt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txt_mt6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel220)
                                                                .addComponent(jLabel218))
                                                            .addGap(2, 2, 2))))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel43)
                                                            .addGap(78, 78, 78)
                                                            .addComponent(bcari1))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel37)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txt_mt1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel33)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txt_mt2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel217))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel106)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel55)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_ml1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel57)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_mlh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel158)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tl4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel152)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_in4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel154)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_gn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel156)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tn4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel166)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_ic5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel168)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_gc5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel170)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_tn5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel164)
                                        .addComponent(jLabel148)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel144)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_l3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(217, 217, 217)
                                            .addComponent(jLabel39)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_A23)
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_A4)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel41)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_A, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel72)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_B, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_A3))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_AA8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(txt_A5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_AA7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txt_A6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_AA6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A9)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_AA5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A11))
                                                    .addComponent(txt_A26)
                                                    .addComponent(txt_A27))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bdefuzzy)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txt_AA4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_AA3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A14)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_AA2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_AA1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(txt_A18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_B2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_A21)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txt_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txt_A24)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txt_defuzzy, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txt_A25)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txt_keputusan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel202)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_in8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel200)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_gn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel203)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tc8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel201)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel199)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tl8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel194)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_in7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel195)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_gc7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel196)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tc7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel193)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel197)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tl7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel188)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_ic6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel189)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_gn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel190)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tn6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel177)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel191)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_tl6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel172)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_tl5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel109))
                    .addGap(39, 39, 39)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(703, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(236, 236, 236))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bhminimum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40))
                            .addGap(16, 16, 16)
                            .addComponent(jLabel109)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_gc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel205, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tl1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel118)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_gn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel132, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tl2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel206, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel134)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_in3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_gc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel207)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel43)
                                        .addComponent(bcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel75)
                                            .addComponent(jLabel37))
                                        .addComponent(jLabel33)
                                        .addComponent(txt_mt2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_mt1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(jLabel217, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txt_mt6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel35)
                                                            .addComponent(txt_mt3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel36))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(txt_mt4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(6, 6, 6)))
                                                    .addGap(6, 6, 6))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_mt5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel47)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel219)
                                                    .addComponent(jLabel49))
                                                .addComponent(jLabel220))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel52)
                                        .addComponent(txt_mt7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel53)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_mth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(6, 6, 6)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel106)
                                .addComponent(jLabel55)
                                .addComponent(jLabel57)
                                .addComponent(jLabel108)
                                .addComponent(txt_mlh, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ml1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_l3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel148)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel208, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel154, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel156, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_in4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_gn4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel158, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tl4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel164)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel221, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel168, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel170, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_ic5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_gc5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tl5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(txt_A, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72))
                                .addComponent(txt_B, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_A4)
                                .addComponent(txt_A23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_AA8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_A5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_AA6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_A9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_AA5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AA4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AA3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AA2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AA1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_AA7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_B2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_A24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_defuzzy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_A25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_keputusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_A27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(bdefuzzy)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(jLabel177)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel188, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel189, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel190, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ic6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_gn6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel191, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel192, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tl6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel193)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_in7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel194, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tc7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel195, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel196, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gc7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel197, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel198, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tl7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel201)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tc8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel200, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_in8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_gn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel199, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tl8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel224, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(107, 107, 107)))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout panel21Layout = new javax.swing.GroupLayout(panel21);
        panel21.setLayout(panel21Layout);
        panel21Layout.setHorizontalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clGlossyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel21Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(clRoundTransButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clPanelTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
        );
        panel21Layout.setVerticalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clRoundTransButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
            .addGroup(panel21Layout.createSequentialGroup()
                .addComponent(clGlossyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clPanelTransparan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clRoundTransButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton2ActionPerformed
        new home().setVisible(true);
        dispose();
    }//GEN-LAST:event_clRoundTransButton2ActionPerformed

    private void clRoundTransButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton4ActionPerformed
        new utama1().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_clRoundTransButton4ActionPerformed

    private void clRoundTransButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton5ActionPerformed
 new login().setVisible(true);
 dispose();
    }//GEN-LAST:event_clRoundTransButton5ActionPerformed

    private void bplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bplusActionPerformed
        edit = false;
        aktif();
        kosong();
        baca_nilai1();
        autonomor();
    }//GEN-LAST:event_bplusActionPerformed

    private void c_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_namaActionPerformed
        combo_nilai1();
    }//GEN-LAST:event_c_namaActionPerformed

    private void bcdrajatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcdrajatActionPerformed
        cariiidrajat();
        bhminimum();
        bhmaximum();
        defuzzi();
    }//GEN-LAST:event_bcdrajatActionPerformed

    private void clRoundTransButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton6ActionPerformed
String D1 = txt_id.getText();
Object D2 = c_nama.getSelectedItem();
String D3 = txt_nama.getText();
String D4 = txt_nim.getText();
String D5 = txt_jurusan.getText();
String D6 = txt_ipk.getText();
String D7 = txt_gaji.getText();
String D8 = txt_tanggungan.getText();
String D9 = txt_icukup.getText();
String D10 = txt_inormal.getText();
String D11 = txt_itinggi.getText();
String D12 = txt_gcukup.getText();
String D13 = txt_gnormal.getText();
String D14 = txt_gtinggi.getText();
String D15 = txt_tcukup.getText();
String D16 = txt_tnormal.getText();
String D17 = txt_ttinggi.getText();
String min1 = txt_ic1.getText();
String min2 = txt_gc1.getText();
String min3 = txt_tc1.getText();
String min4 = txt_ic2.getText();
String min5 = txt_gn2.getText();
String min6 = txt_tc2.getText();
String min7 = txt_in3.getText();
String min8 = txt_gc3.getText();
String min9 = txt_tn3.getText();
String min10 = txt_in4.getText();
String min11 = txt_gn4.getText();
String min12 = txt_tn4.getText();
String min13 = txt_ic5.getText();
String min14 = txt_gc5.getText();
String min15 = txt_tn5.getText();
String min16 = txt_ic6.getText();
String min17 = txt_gn6.getText();
String min18 = txt_tn6.getText();
String min19 = txt_in7.getText();
String min20 = txt_gc7.getText();
String min21 = txt_tc7.getText();
String min22 = txt_in8.getText();
String min23 = txt_gn8.getText();
String min24 = txt_tc8.getText();
String minn1 = txt_tl1.getText();
String minn2 = txt_tl2.getText();
String minn3 = txt_l3.getText();
String minn4 = txt_tl4.getText();
String minn5 = txt_tl5.getText();
String minn6 = txt_tl6.getText();
String minn7 = txt_tl7.getText();
String minn8 = txt_tl8.getText();
String maxx1 = txt_mt1.getText();
String maxx2 = txt_mt2.getText();
String maxx3 = txt_mt3.getText();
String maxx4 = txt_mt4.getText();
String maxx5 = txt_mt5.getText();
String maxx6 = txt_mt6.getText();
String maxx7 = txt_mt7.getText();
String maxx8 = txt_ml1.getText();
String max1 = txt_mth.getText();
String max2 = txt_mlh.getText();
String maks1 = txt_A.getText();
String maks2 = txt_B.getText();
String mmax11 = txt_AA1.getText();
String mmax12 = txt_AA2.getText();
String mmax13 = txt_AA3.getText();
String mmax14 = txt_AA4.getText();
String mmax15 = txt_AA5.getText();
String mmax16 = txt_AA6.getText();
String mmax17 = txt_AA7.getText();
String mmax18 = txt_AA8.getText();
String mmax21 = txt_B1.getText();
String mmax22 = txt_B2.getText();
String nilai = txt_defuzzy.getText();
String keputusan = txt_keputusan.getText();
aturanrule objek_aturanrule = new aturanrule(D1, (String) D2,D3,D4,D5,D6,D7,D8,D9,D10,D11,D12,D13,D14,D15,D16,D17,min1,min2,min3,min4,min5,min6,min7,min8,min9,min10,min11,min12,min13,min14,min15,min16,min17,min18,min19,min20,min21,min22,min23,min24,minn1,minn2,minn3,minn4,minn5,minn6,minn7,minn8,maxx1,maxx2,maxx3,maxx4,maxx5,maxx6,maxx7,maxx8,max1,max2,maks1,maks2,mmax11,mmax12,mmax13,mmax14,mmax15,mmax16,mmax17,mmax18,mmax21,mmax22,nilai,keputusan);
objek_aturanrule.setVisible(true);
        dispose();
    }//GEN-LAST:event_clRoundTransButton6ActionPerformed

    private void bcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcari1ActionPerformed

    }//GEN-LAST:event_bcari1ActionPerformed

    private void bhminimumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhminimumActionPerformed

    }//GEN-LAST:event_bhminimumActionPerformed

    private void bdefuzzyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdefuzzyActionPerformed

    }//GEN-LAST:event_bdefuzzyActionPerformed

    private void txt_defuzzyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_defuzzyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_defuzzyActionPerformed

    private void txt_keputusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keputusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keputusanActionPerformed

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel32MouseClicked

    private void clRoundTransButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton1ActionPerformed
 new fuzifikasi().setVisible(true);
 dispose();
    }//GEN-LAST:event_clRoundTransButton1ActionPerformed

    private void clRoundTransButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton3ActionPerformed
        new report().setVisible(true);
        dispose();
    }//GEN-LAST:event_clRoundTransButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fuzifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fuzifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fuzifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fuzifikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fuzifikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari1;
    private RoundedTransparanButton.ClRoundTransButton bcdrajat;
    private javax.swing.JButton bdefuzzy;
    private javax.swing.JButton bhminimum;
    private javax.swing.JButton bplus;
    private javax.swing.JComboBox c_nama;
    private GlossyPanel.ClGlossyPanel clGlossyPanel1;
    private PanelTransparan.ClPanelTransparan clPanelTransparan1;
    private PanelTransparan.ClPanelTransparan clPanelTransparan2;
    private PanelTransparan.ClPanelTransparan clPanelTransparan3;
    private PanelTransparan.ClPanelTransparan clPanelTransparan5;
    private PanelTransparan.ClPanelTransparan clPanelTransparan6;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton1;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton2;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton3;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton4;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton5;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private fuzzy.panel2 panel21;
    private javax.swing.JTable tbl_data;
    private javax.swing.JLabel txt_A;
    private javax.swing.JLabel txt_A1;
    private javax.swing.JLabel txt_A11;
    private javax.swing.JLabel txt_A13;
    private javax.swing.JLabel txt_A14;
    private javax.swing.JLabel txt_A16;
    private javax.swing.JLabel txt_A18;
    private javax.swing.JLabel txt_A21;
    private javax.swing.JLabel txt_A23;
    private javax.swing.JLabel txt_A24;
    private javax.swing.JLabel txt_A25;
    private javax.swing.JLabel txt_A26;
    private javax.swing.JLabel txt_A27;
    private javax.swing.JLabel txt_A3;
    private javax.swing.JLabel txt_A4;
    private javax.swing.JLabel txt_A5;
    private javax.swing.JLabel txt_A6;
    private javax.swing.JLabel txt_A9;
    private javax.swing.JLabel txt_AA1;
    private javax.swing.JLabel txt_AA2;
    private javax.swing.JLabel txt_AA3;
    private javax.swing.JLabel txt_AA4;
    private javax.swing.JLabel txt_AA5;
    private javax.swing.JLabel txt_AA6;
    private javax.swing.JLabel txt_AA7;
    private javax.swing.JLabel txt_AA8;
    private javax.swing.JLabel txt_B;
    private javax.swing.JLabel txt_B1;
    private javax.swing.JLabel txt_B2;
    private javax.swing.JTextField txt_defuzzy;
    private RoundedTransparanTextField.ClRoundTransTxt txt_gaji;
    private javax.swing.JLabel txt_gc1;
    private javax.swing.JLabel txt_gc3;
    private javax.swing.JLabel txt_gc5;
    private javax.swing.JLabel txt_gc7;
    private RoundedTransparanTextField.ClRoundTransTxt txt_gcukup;
    private javax.swing.JLabel txt_gn2;
    private javax.swing.JLabel txt_gn4;
    private javax.swing.JLabel txt_gn6;
    private javax.swing.JLabel txt_gn8;
    private RoundedTransparanTextField.ClRoundTransTxt txt_gnormal;
    private RoundedTransparanTextField.ClRoundTransTxt txt_gtinggi;
    private javax.swing.JLabel txt_ic1;
    private javax.swing.JLabel txt_ic2;
    private javax.swing.JLabel txt_ic5;
    private javax.swing.JLabel txt_ic6;
    private RoundedTransparanTextField.ClRoundTransTxt txt_icukup;
    private RoundedTransparanTextField.ClRoundTransTxt txt_id;
    private javax.swing.JLabel txt_in3;
    private javax.swing.JLabel txt_in4;
    private javax.swing.JLabel txt_in7;
    private javax.swing.JLabel txt_in8;
    private RoundedTransparanTextField.ClRoundTransTxt txt_inormal;
    private RoundedTransparanTextField.ClRoundTransTxt txt_ipk;
    private RoundedTransparanTextField.ClRoundTransTxt txt_itinggi;
    private RoundedTransparanTextField.ClRoundTransTxt txt_jurusan;
    private javax.swing.JTextField txt_keputusan;
    private javax.swing.JLabel txt_l3;
    private javax.swing.JLabel txt_ml1;
    private javax.swing.JLabel txt_mlh;
    private javax.swing.JLabel txt_mt1;
    private javax.swing.JLabel txt_mt2;
    private javax.swing.JLabel txt_mt3;
    private javax.swing.JLabel txt_mt4;
    private javax.swing.JLabel txt_mt5;
    private javax.swing.JLabel txt_mt6;
    private javax.swing.JLabel txt_mt7;
    private javax.swing.JLabel txt_mth;
    private RoundedTransparanTextField.ClRoundTransTxt txt_nama;
    private RoundedTransparanTextField.ClRoundTransTxt txt_nim;
    private RoundedTransparanTextField.ClRoundTransTxt txt_tanggungan;
    private javax.swing.JLabel txt_tc1;
    private javax.swing.JLabel txt_tc2;
    private javax.swing.JLabel txt_tc7;
    private javax.swing.JLabel txt_tc8;
    private RoundedTransparanTextField.ClRoundTransTxt txt_tcukup;
    private javax.swing.JLabel txt_tl1;
    private javax.swing.JLabel txt_tl2;
    private javax.swing.JLabel txt_tl4;
    private javax.swing.JLabel txt_tl5;
    private javax.swing.JLabel txt_tl6;
    private javax.swing.JLabel txt_tl7;
    private javax.swing.JLabel txt_tl8;
    private javax.swing.JLabel txt_tn3;
    private javax.swing.JLabel txt_tn4;
    private javax.swing.JLabel txt_tn5;
    private javax.swing.JLabel txt_tn6;
    private RoundedTransparanTextField.ClRoundTransTxt txt_tnormal;
    private RoundedTransparanTextField.ClRoundTransTxt txt_ttinggi;
    // End of variables declaration//GEN-END:variables
}
