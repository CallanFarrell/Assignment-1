import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
* Created by: Callan Farrell.
* Created on: Feburary 24 2020
*/

class DateCalculator {

  public static void main(String[] args) {

    System.out.println("Enter the date in (dd/mm/yyyy) format, to recieve the day of the week:");
    Scanner scan = new Scanner(System.in);
    String time = scan.nextLine();

    try {
      boolean dateValid = dateValidate(time);

      if (dateValid == true) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        java.util.Date date = df.parse(time);   
        df.applyPattern("EEE");  
        String day = df.format(date); 

        if (day.compareTo("Sat") == 0 || day.compareTo("Sun") == 0) {
          System.out.println(day + ": Weekend");
        } else {
          System.out.println(day + ": Weekday");
        }
      } else {
        System.out.println("Invalid Date!!!");
      }
    } catch (Exception e) {
      System.out.println("Invalid Date Formats!!!");
    }
  }

  public static boolean dateValidate(String d) {

    String[] dateArray = d.split("/");
    int day = Integer.parseInt(dateArray[0]);
    int month = Integer.parseInt(dateArray[1]);
    int year = Integer.parseInt(dateArray[2]);
    System.out.print(day + "\n" + month + "\n" + year + "\n");
    boolean leapYear = false;

    if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
      leapYear = true;
    }

    if (year > 2099 || year < 1900) {
      return false;
    }
    if (month < 13) {
      if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
        if (day > 31) {
          return false;
        }
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
        if (day > 30) {
          return false; 
        }
      } else if (leapYear == true && month == 2) {
        if (day > 29) {
          return false;
        }
      } else if (leapYear == false && month == 2) {
        if (day > 28) {
          return false;
        }
      }

      return true;    
    } else {
      return false; 
    }
  }
}