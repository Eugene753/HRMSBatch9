package utils;

import com.google.gson.JsonObject;
import org.json.JSONObject;

public class apiPayloadConstants {


    public static String createEmployeePayload(){
         String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Danillo\",\n" +
                "  \"emp_lastname\": \"Igor\",\n" +
                "  \"emp_middle_name\": \"Igor\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1995-08-17\",\n" +
                "  \"emp_status\": \"employeed\",\n" +
                "  \"emp_job_title\": \"Engeneer\"\n" +
                "}";

         return createEmployeePayload;
    }

    /**
     * Second way to send payload/body using JSONObject
     * @return
     */
    public static String createEmployeeBody(){

        /**
         * We imported a dependency for JSONObject
         *
         */
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Gobia");
        obj.put("emp_lastname","Gellar");
        obj.put("emp_middle_name","Grom");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1995-08-17");
        obj.put("emp_status","employeed");
        obj.put("emp_job_title","Engineer");

        return obj.toString();
    }

    public static String creteEmployeeBodyMoreDynamic(String firstname,String lastNmae, String middleName, String gender, String employeeBday, String employeeStatus, String employeeJobTitle){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",firstname);
        obj.put("emp_lastname",lastNmae);
        obj.put("emp_middle_name",middleName);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",employeeBday);
        obj.put("emp_status",employeeStatus);
        obj.put("emp_job_title",employeeJobTitle);

        return obj.toString();
    }
}
