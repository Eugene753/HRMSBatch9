package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

  Properties prop;

   public  Properties readProperties(String filepath){
       try {
           FileInputStream fis=new FileInputStream(filepath);
           prop=new Properties();
           prop.load(fis);
           fis.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
       return prop;
   }

   public String getPropertyValue(String key){

       return prop.getProperty(key);
   }
}
