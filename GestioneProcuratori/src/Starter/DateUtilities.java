package Starter;

public class DateUtilities {
 
	public  java.sql.Date convertUtilToSql (java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
