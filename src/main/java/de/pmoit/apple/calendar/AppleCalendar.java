package de.pmoit.apple.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import de.pmoit.apple.calendar.data.CalendarObject;


/**
 *
 * Class to handle Apple calendardata
 * 
 * BEGIN:VEVENT
 * 
 * CREATED:20210228T100023Z
 * 
 * DTEND;TZID=Europe/Berlin:20210228T120000
 * 
 * DTSTAMP:20210228T100024Z
 * 
 * DTSTART;TZID=Europe/Berlin:20210228T110000
 * 
 * LAST-MODIFIED:20210228T100023Z
 * 
 * SEQUENCE:0
 * 
 * SUMMARY:Test
 * 
 * UID:DDEEFF0D-4BFD-40B3-82F0-13010BBDEEF4
 * 
 * URL;VALUE=URI:
 * 
 * END:VEVENT
 */

public class AppleCalendar {

    public AppleCalendar(String url) {
        this.url = url;
    }

    /**
     * Reads a calendarURL and puts them into a hashmap with CalendarObjects
     * 
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public HashMap<String, CalendarObject> readCalendarUrl() throws MalformedURLException, IOException {
        HashMap<String, CalendarObject> calendarObjects = new HashMap<String, CalendarObject>();
        CalendarObject currentCalendarObject = null;
        URL calendarURL = new URL(url);
        URLConnection connection = calendarURL.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while (reader.ready()) {
            String currentLine = reader.readLine();
            currentCalendarObject = buildHashMap(calendarObjects, currentCalendarObject, currentLine);
        }
        return calendarObjects;
    }

    private CalendarObject buildHashMap(HashMap<String, CalendarObject> calendarObjects,
        CalendarObject currentCalendarObject, String currentLine) {
        if (currentLine.startsWith("BEGIN:")) {
            currentCalendarObject = new CalendarObject();
        } else if (currentLine.startsWith("END:")) {
            writeToHashmap(calendarObjects, currentCalendarObject);
        } else {
            handleCreated(currentCalendarObject, currentLine);
            handleDtend(currentCalendarObject, currentLine);
            handleDtstamp(currentCalendarObject, currentLine);
            handleDtstart(currentCalendarObject, currentLine);
            handleSummary(currentCalendarObject, currentLine);
            handleRrule(currentCalendarObject, currentLine);
            handleUid(currentCalendarObject, currentLine);
        }
        return currentCalendarObject;
    }

    private void writeToHashmap(HashMap<String, CalendarObject> calendarObjects, CalendarObject currentCalendarObject) {
        if (currentCalendarObject.getRrule() == null || ! currentCalendarObject.getRrule().contains("UNTIL")) {
            calendarObjects.put(currentCalendarObject.getUid(), currentCalendarObject);
        }
    }

    private void handleUid(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "UID:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setUid(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleRrule(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "RRULE:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setRrule(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleSummary(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "SUMMARY:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setSummary(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleDtstart(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "DTSTART;VALUE=DATE:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setDtstart(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleDtstamp(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "DTSTAMP:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setDtstamp(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleDtend(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "DTEND;VALUE=DATE:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setDtend(substringSearchStringLength(currentLine, searchString));
        }
    }

    private void handleCreated(CalendarObject currentCalendarObject, String currentLine) {
        String searchString = "CREATED:";
        if (currentLine.startsWith(searchString)) {
            currentCalendarObject.setCreated(substringSearchStringLength(currentLine, searchString));
        }
    }

    private String substringSearchStringLength(String currentLine, String searchString) {
        return currentLine.substring(searchString.length());
    }

    private String url;
}
