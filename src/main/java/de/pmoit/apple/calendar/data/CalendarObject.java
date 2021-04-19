package de.pmoit.apple.calendar.data;

public class CalendarObject {

    /**
     * Handles the following objects:
     * 
     * RRULE:FREQ=YEARLY;UNTIL=20201127
     * 
     * CREATED:20171122T061139Z
     * 
     * DTEND;VALUE=DATE:20171128
     * 
     * DTSTAMP:20210207T114913Z
     * 
     * DTSTART;VALUE=DATE:20171127
     * 
     * SUMMARY:test bday
     * 
     * UID:08E483F0-9CA7-415E-B3FE-85C728DAE147
     */

    public String getRrule() {
        return rrule;
    }

    public void setRrule(String rrule) {
        this.rrule = rrule;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDtend() {
        return dtend;
    }

    public void setDtend(String dtend) {
        this.dtend = dtend;
    }

    public String getDtstamp() {
        return dtstamp;
    }

    public void setDtstamp(String dtstamp) {
        this.dtstamp = dtstamp;
    }

    public String getDtstart() {
        return dtstart;
    }

    public void setDtstart(String dtstart) {
        this.dtstart = dtstart;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String rrule;
    private String created;
    private String dtend;
    private String dtstamp;
    private String dtstart;
    private String summary;
    private String uid;
}
