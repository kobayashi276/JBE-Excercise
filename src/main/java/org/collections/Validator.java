package org.collections;

import java.util.ArrayList;

public class Validator {
    public static boolean validateCode(String code) {
        if (code.length() != 5) { return false; }
        if (!code.startsWith("RA")) { return false; }
        String digit = code.substring(2);
        try{
            Integer.parseInt(digit);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> course) {
        for (Course c : course) {
            if (c.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateStatus(String status){
        return status.equals("active") || status.equals("in-active");
    }

    public static boolean validateFlag(String flag){
        return flag.equals("optional") || flag.equals("prerequisite") || flag.equals("N/A");
    }

    public static boolean validateDuration(short duration){
        try{
            return duration > 0;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
