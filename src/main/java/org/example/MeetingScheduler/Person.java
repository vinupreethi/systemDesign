package org.example.MeetingScheduler;

public class Person {
    private String name;
    private String emailId;
    private Calender calender;

    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void updateCalendar(Meeting meeting) {
        for (Meeting meeting1 : getCalender().getMeetingList()) {
            if (meeting.getMeetingId() == meeting.getMeetingId()) {
                getCalender().getMeetingList().remove(meeting);
                getCalender().getMeetingList().add(meeting1);
                break;
            }
        }
    }

    public void addMeeting(Meeting meeting) {
        getCalender().getMeetingList().add(meeting);
    }

    public void removeMeetingCalendar(Meeting meeting) {
        getCalender().getMeetingList().remove(meeting);
    }
}
