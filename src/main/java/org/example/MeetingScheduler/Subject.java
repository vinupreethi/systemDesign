package org.example.MeetingScheduler;

public interface Subject {
    void addObserver(Person person);
    void removeObserver(Person person);
    void notifyObserversNewMeeting();
    void notifyObserverUpdateMeeting();
    void notifyObserverRemoveMeeting();
}
