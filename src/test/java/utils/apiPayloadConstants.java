package utils;

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
}
