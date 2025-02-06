package org.example.MeetingScheduler;

public class RoomisAlreadyBookedException extends Throwable {
    public RoomisAlreadyBookedException(String message)
    {
        super(message);
    }
}
