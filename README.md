# apple-calendar
Java library for reading Apple calendar data 


Use the readCalendarUrl method to read meeting data and the respective metadata, e.g. begin date or end date.
With the AppleCalendarOperations class you have the ability to use the read meta information.

Example:
```
public static void main(String[] args) throws IOException {
  AppleCalendar ct = new AppleCalendar("APPLE CALENDER URL");
  HashMap<String, CalendarObject> xx = ct.readCalendarUrl();
  AppleCalendarOperations co = new AppleCalendarOperations(xx);
  HashMap<String, CalendarObject> result = co.searchForAllParcialDate("0420");
}
```
