# apple-calendar
Java library for reading Apple calendar data

Example:
```
public static void main(String[] args) throws IOException {
  AppleCalendar ct = new AppleCalendar("APPLE CALENDER URL");
  HashMap<String, CalendarObject> xx = ct.readCalendarUrl();
  AppleCalendarOperations co = new AppleCalendarOperations(xx);
  HashMap<String, CalendarObject> result = co.searchForAllParcialDate("0420");
}
```
