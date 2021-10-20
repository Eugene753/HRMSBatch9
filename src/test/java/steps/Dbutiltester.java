package steps;

import utils.DbUtils;

import java.util.List;
import java.util.Map;

public class Dbutiltester {

    public static void main(String[] args) {
        DbUtils dbUtils=new DbUtils();
        List<Map<String,String>> tableDataList=dbUtils.getTableDataAsList("select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where emp_number = 14024");
        System.out.println(tableDataList);
    }
}
