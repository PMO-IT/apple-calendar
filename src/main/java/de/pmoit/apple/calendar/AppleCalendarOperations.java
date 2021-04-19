package de.pmoit.apple.calendar;

import java.util.HashMap;
import java.util.Map;

import de.pmoit.apple.calendar.data.CalendarObject;


public class AppleCalendarOperations {

    public AppleCalendarOperations(HashMap<String, CalendarObject> appleCalendarData) {
        this.appleCalendarData = appleCalendarData;
    }

    public CalendarObject searchForSummary(String searchString) {
        for (Map.Entry<String, CalendarObject> e : appleCalendarData.entrySet()) {
            String currentSummary = appleCalendarData.get(e.getKey()).getSummary();
            if (currentSummary != null && currentSummary.trim().equals(searchString)) {
                return appleCalendarData.get(e.getKey());
            }
        }
        return null;
    }

    public CalendarObject searchForParcialDate(String searchDate) {
        for (Map.Entry<String, CalendarObject> e : appleCalendarData.entrySet()) {
            String dtStart = appleCalendarData.get(e.getKey()).getDtstart();
            if (dtStart != null && dtStart.trim().substring(4).equals(searchDate)) {
                return appleCalendarData.get(e.getKey());
            }
        }
        return null;
    }

    public HashMap<String, CalendarObject> searchForAllParcialDate(String searchDate) {
        HashMap<String, CalendarObject> resultSet = new HashMap<String, CalendarObject>();
        for (Map.Entry<String, CalendarObject> e : appleCalendarData.entrySet()) {
            String dtStart = appleCalendarData.get(e.getKey()).getDtstart();
            if (dtStart != null && dtStart.trim().substring(4).equals(searchDate)) {
                resultSet.put(e.getKey(), appleCalendarData.get(e.getKey()));
            }
        }
        return resultSet;
    }

    public CalendarObject searchForDate(String searchDate) {
        for (Map.Entry<String, CalendarObject> e : appleCalendarData.entrySet()) {
            String dtStart = appleCalendarData.get(e.getKey()).getDtstart();
            if (dtStart != null && dtStart.trim().equals(searchDate)) {
                return appleCalendarData.get(e.getKey());
            }
        }
        return null;
    }

    public HashMap<String, CalendarObject> getAppleCalendar() {
        return appleCalendarData;
    }

    public void toString(HashMap<String, CalendarObject> result) {
        for (Map.Entry<String, CalendarObject> e : result.entrySet()) {
            if (result.get(e.getKey()).getSummary() != null) {
                System.out.println(result.get(e.getKey()).getSummary());
                System.out.println(result.get(e.getKey()).getDtstart());
            }
        }
    }

    private HashMap<String, CalendarObject> appleCalendarData;
}
