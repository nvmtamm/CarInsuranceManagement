/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khach
 */
public class FileUtils {
 
/**
 * Load data from file
 * @param pathFile
 * @return 
 */
   public static List loadFromFile( String pathFile) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = null;

            
            //--------1. tao anh xa file tren thiet bi luu tru
            File f = new File(pathFile);
            //--------2. Tao luong anh xa toi file de van chuyen thong tin
            fr = new FileReader(f);
            //------ 3. Tao bo dem de van chuyen thong tin, BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String temp;
            try {
                //-------4. Lap de doc cac dong tu file va phan tich thanh obj(Setmenu)
                //doc 1 dong du lieu tu bo dem de gan cho bien temp phai co thi moi lam tiep
                while ((temp = br.readLine()) != null) {
                    list.add(temp);
                       
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //------------------5.Dong: bo dem, tap tin
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
               
        }

    /**
     *
     * @param <T>
     * @param filename
     * @param map
     */
    public static<T> void saveToFile(String filename, Collection<T> map) {

    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        for(T t : map){

            bw.write(t.toString());

            bw.newLine();
        }

        bw.close();

        System.out.println("Save file successfully!");

    } catch (IOException e) {
        System.out.println("Error saving file");
    }
}


}
