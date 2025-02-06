package org.example.MeetingScheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting implements Subject {
    private int meetingId;
    private Room room;
    private List<Person> requiredPersons = new ArrayList<>();
    private List<Person> optionalPersons = new ArrayList<>();
    private long startTime;
    private long endTime;
    private MeetingStatus meetingStatus;
    private List<Person> observers = new ArrayList<>();
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public MeetingStatus getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(MeetingStatus meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public List<Person> getObservers() {
        return observers;
    }

    public void setObservers(List<Person> observers) {
        this.observers = observers;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Person> getRequiredPersons() {
        return requiredPersons;
    }

    public void setRequiredPersons(List<Person> requiredPersons) {
        this.requiredPersons = requiredPersons;
    }

    public List<Person> getOptionalPersons() {
        return optionalPersons;
    }

    public void setOptionalPersons(List<Person> optionalPersons) {
        this.optionalPersons = optionalPersons;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public void addObserver(Person person) {
        observers.add(person);
    }

    @Override
    public void removeObserver(Person person) {
        observers.remove(person);
    }

    @Override
    public void notifyObserversNewMeeting() {
        for (Person observer : observers) {
            observer.addMeeting(this);
        }
    }

    @Override
    public void notifyObserverUpdateMeeting() {
        for (Person observer : observers) {
            observer.updateCalendar(this);
        }
    }

    @Override
    public void notifyObserverRemoveMeeting() {
        for (Person observer : observers) {
            observer.removeMeetingCalendar(this);
        }
    }


}
