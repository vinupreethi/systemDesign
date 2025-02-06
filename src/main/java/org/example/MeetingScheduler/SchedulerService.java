package org.example.MeetingScheduler;

import java.time.LocalDate;
import java.util.*;

public class SchedulerService {
    public static void main(String args[]) throws RoomisAlreadyBookedException {
        Person organizer = new Person();
        List<Room> roomList = initializeRooms();
        List<Person> observerList = new ArrayList<>();

        /******* Enter the start and end time and get the list of rooms *******/
        long startTime = 10L;
        long endTime = 12L;
        Meeting meeting = new Meeting();
        meeting.setEndTime(endTime);
        meeting.setStartTime(startTime);
        meeting.setMeetingId(12);
        /**** Required persons ***/
        Person person = new Person();
        person.setName("vinu");
        person.setEmailId("vinuvas321@gmail.com");
        Person person1 = new Person();
        person1.setName("sarran");
        person1.setEmailId("sarran@gmail.com");

        Person person2 = new Person();
        person.setName("suganya");
        person.setEmailId("sugan321@gmail.com");


        meeting.setRequiredPersons(new ArrayList<>(Arrays.asList(person1, person)));
        meeting.setOptionalPersons(new ArrayList<>(Arrays.asList(person2)));
        meeting.setMeetingStatus(MeetingStatus.SCHEDULED);
        /****Get available room *****/
        Room room = extracted(roomList, meeting);
        if (Objects.nonNull(room)) {
            room.getCalender().getMeetingList().add(meeting);
            for (Person newperson : meeting.getOptionalPersons())
                meeting.addObserver(newperson);
            for (Person newperson : meeting.getRequiredPersons())
                meeting.addObserver(newperson);

        }
        meeting.notifyObserversNewMeeting();


        /******* Get a single room , list of available timings *******/
        Room particularroom = new Room();
        List<Meeting> meetingList = particularroom.getCalender().getMeetingList();
        long lastEndTimeofMeeting = 12;
        HashMap<Long, Long> hashMap = new HashMap();
        for (Meeting meeting1 : meetingList) {
            hashMap.put(lastEndTimeofMeeting, meeting1.getStartTime());
            lastEndTimeofMeeting = meeting1.getEndTime();

        }
        long EndOfCalender = 12;
        hashMap.put(lastEndTimeofMeeting, EndOfCalender);

        Meeting meeting1 = new Meeting();
        long startTimeofMeeting = 13;
        long endTimeMeeting = 15;
        meeting1.setEndTime(startTimeofMeeting);
        meeting1.setStartTime(endTimeMeeting);
        meeting1.setMeetingId(12);
        /**** Required persons ***/
        Person person4 = new Person();
        person4.setName("vinu");
        person4.setEmailId("vinuvas321@gmail.com");
        Person person5 = new Person();
        person4.setName("sarran");
        person4.setEmailId("sarran@gmail.com");
        meeting1.setMeetingStatus(MeetingStatus.SCHEDULED);
        meeting1.setRequiredPersons(new ArrayList<>(Arrays.asList(person4)));
        meeting.setOptionalPersons(new ArrayList<>(Arrays.asList(person5)));
        if (Objects.nonNull(room)) {
            room.getCalender().getMeetingList().add(meeting);
            for (Person newperson : meeting.getOptionalPersons())
                meeting.addObserver(newperson);
            for (Person newperson : meeting.getRequiredPersons())
                meeting.addObserver(newperson);

        }
        meeting.notifyObserversNewMeeting();


        /**** Reschedule  Meeting ****/
        int meetingId = 3;
        List<Meeting> meetings = organizer.getCalender().getMeetingList();
        for (Meeting newmeeting : meetings) {
            if (newmeeting.getMeetingId() == meetingId) {
                long newstartTime = 15;
                long newendTime = 16;
                newmeeting.setStartTime(newstartTime);
                newmeeting.setEndTime(newendTime);
                newmeeting.setMeetingStatus(MeetingStatus.RESCHEDULED);
                Room room1 = extracted(roomList, newmeeting);
                room1.getCalender().getMeetingList().add(newmeeting);
                newmeeting.notifyObserverUpdateMeeting();
            }
        }


        /**** Cancel Meeting ****/
        int meetingIdCancel = 3;
        List<Meeting> meetings1 = organizer.getCalender().getMeetingList();
        for (Meeting newmeeting : meetings1) {
            if (newmeeting.getMeetingId() == meetingIdCancel) {
                newmeeting.setMeetingStatus(MeetingStatus.CANCELLED);
                Room room1 = extracted(roomList, newmeeting);
                room1.getCalender().getMeetingList().remove(meeting);
                newmeeting.notifyObserverRemoveMeeting();
            }
        }

        /** Room is booked throw an error**/
        /** Recurring meeting invites**/
        Meeting recurringMeeting = new Meeting();
        LocalDate startDate = LocalDate.of(2025, 2, 6);  // Start date: February 6, 2025
        LocalDate endDate = LocalDate.of(2025, 2, 10);
        while (!startDate.isAfter(endDate)) {
            Room room1 = extracted(roomList, meeting);
            if(!Objects.nonNull(room1))
                throw new RoomisAlreadyBookedException("Room is full");
            room1.getCalender().getMeetingList().add(recurringMeeting);
            startDate.plusDays(1);
        }
        recurringMeeting.notifyObserversNewMeeting();

        /**Follow up a send notification**/


    }


    private static Room extracted(List<Room> roomList, Meeting meeting) {
        for (Room room : roomList) {
            List<Meeting> meetingList = room.getCalender().getMeetingList();
            for (Meeting existingmeeting : meetingList) {
                if (meeting.getStartTime() >= existingmeeting.getStartTime() && meeting.getStartTime() <= existingmeeting.getEndTime()
                        || (meeting.getEndTime() >= existingmeeting.getStartTime() && meeting.getEndTime() <= existingmeeting.getEndTime())) {
                    continue;
                }
                return room;
            }
        }
        return null;
    }

    private static List<Room> initializeRooms() {
        Room room = new Room();
        room.setRoomId(1);
        room.setCalender(new Calender());
        room.setCapacity(5);

        Room room1 = new Room();
        room.setRoomId(2);
        room.setCalender(new Calender());
        room.setCapacity(5);

        Room room2 = new Room();
        room.setRoomId(3);
        room.setCalender(new Calender());
        room.setCapacity(5);

        return new ArrayList<>(Arrays.asList(room2, room1, room));

    }


}
