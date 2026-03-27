package DesignMeetingScheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        MeetingScheduler scheduler = new MeetingScheduler();

        // Create meeting rooms
        MeetingRoom room1 = new MeetingRoom(10);
        MeetingRoom room2 = new MeetingRoom(20);
        MeetingRoom room3 = new MeetingRoom(5);

        scheduler.addMeetingRoom(room1);
        scheduler.addMeetingRoom(room2);
        scheduler.addMeetingRoom(room3);

        scheduler.scheduleMeeting(LocalTime.parse("11:45:00", formatter),
                LocalTime.parse("12:15:00", formatter), 6, LocalDate.of(2026, 3, 27));
        scheduler.scheduleMeeting(LocalTime.parse("13:45:00", formatter),
                LocalTime.parse("14:15:00", formatter), 15, LocalDate.of(2026, 3, 27));
        scheduler.scheduleMeeting(LocalTime.parse("11:45:00", formatter),
                LocalTime.parse("12:15:00", formatter), 10, LocalDate.of(2026, 3, 27));
        // conflict -- room available but capacity is an issue
        scheduler.scheduleMeeting(LocalTime.parse("11:45:00", formatter),
                LocalTime.parse("12:15:00", formatter), 17, LocalDate.of(2026, 3, 27));
        scheduler.scheduleMeeting(LocalTime.parse("11:45:00", formatter),
                LocalTime.parse("12:15:00", formatter), 3, LocalDate.of(2026, 3, 27));
        scheduler.scheduleMeeting(LocalTime.parse("11:45:00", formatter),
                LocalTime.parse("12:15:00", formatter), 3, LocalDate.of(2026, 3, 30));
    }
}
