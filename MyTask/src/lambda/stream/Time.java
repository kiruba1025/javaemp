package lambda.stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Time {
	private String timeline;
    private String sdate;
    private String edate;

    public Time(String timeline, String sdate, String edate) {
        super();
        this.timeline = timeline;
        this.sdate = sdate;
        this.edate = edate;
    }

    public Time() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        System.out.println("timeline:");
        int a = value.nextInt();

        ArrayList<Time> tlist = new ArrayList<Time>();
        for (int i = 1; i <= a; i++) {
            System.out.printf("Enter timeline %d:%n", i);
            String timeline = value.next();

            System.out.println("Startdate:");
            String sdate = value.next();
            System.out.println("enddate:");
            String edate = value.next();

            Time cusObj = new Time(timeline, sdate, edate);
            tlist.add(cusObj);
        }

        System.out.println("Initial TimeLine Details:");
        for (Time x : tlist) {
            System.out.println("TName: " + x.timeline + " Sdate: " + x.sdate + " Edate: " + x.edate +
                    " Interval b/W sdate and edate: " + x.getdatecount());
        }

        Time dateZigZag1 = new Time();
        // Update dates for any tname based on a new end date
        System.out.println("Enter the tname to update:");
        String tNameToUpdate = value.next();
        System.out.println("Enter a new end date for the specified tname:");
        String newEndDate = value.next();
        dateZigZag1.updateDates(tlist, tNameToUpdate, newEndDate);

        // Print updated details
        System.out.println("Updated TimeLine Details:");
        for (Time x : tlist) {
            System.out.println("TName: " + x.timeline + " Sdate: " + x.sdate + " Edate: " + x.edate +
                    " Interval b/W sdate and edate: " + x.getdatecount());
        }
    }

    public long getdatecount() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(sdate, formatter);
        LocalDate endDate = LocalDate.parse(edate, formatter);

        // Calculate the number of days between start and end date (excluding both)
        return ChronoUnit.DAYS.between(startDate.plusDays(1), endDate);
    }

    public void updateDates(List<Time> tdate, String tNameToUpdate, String newEndDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (Time x : tdate) {
            if (x.timeline.equals(tNameToUpdate)) {
                try {
                    long datedifference = ChronoUnit.DAYS.between(LocalDate.parse(x.sdate, formatter), LocalDate.parse(x.edate, formatter));
                    // Update start and end dates based on the new end date
                    LocalDate newEndDateParsed = LocalDate.parse(newEndDate, formatter);
                    LocalDate newStartDate = newEndDateParsed.minusDays(datedifference);

                    // Set the values for the current instance (dateZigZag1)
                    x.edate = newEndDateParsed.format(formatter);
                    x.sdate = newStartDate.format(formatter);

                    // Update the start date of timeline 2 based on the end date of timeline 1
                    for (Time y : tdate) {
                        if (y.timeline.equals("1")) {
                            LocalDate newTimeline2StartDate = LocalDate.parse(x.edate, formatter).plusDays(1);
                            y.sdate = newTimeline2StartDate.format(formatter);
                            break;
                        }
                        //tdate.add(new Time(tNameToUpdate + "&" + x.timeline, x.sdate, y.edate));
                    }

                    // Add a new combined timeline
                    
                } catch (Exception e) {
                    System.err.println("Error updating dates: " + e.getMessage());
                }
                break;
            }
        }
    }
}