package DesignMeetingScheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MeetingScheduler {
    Comparator<MeetingRoom> meetingRoomComparator = Comparator.comparing(MeetingRoom::getCapacity)
            .thenComparing(MeetingRoom::getMeetingRoomId);
    private final TreeSet<MeetingRoom> meetingRooms = new TreeSet<>(meetingRoomComparator);

    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.add(room);
    }

    public void scheduleMeeting(LocalTime start, LocalTime end, int capacity, LocalDate date) {
        Meeting meeting = new Meeting(start, end);
        MeetingRoom dummy = new MeetingRoom(capacity);

        SortedSet<MeetingRoom> eligibleRooms = meetingRooms.tailSet(dummy);

        // 4. Iterate through the eligible rooms. The first one that successfully books is the "Best Fit".
        for (MeetingRoom room : eligibleRooms) {
            // Because we are relying on room.bookRoom(), this handles our overlap logic automatically.
            if (room.bookRoom(date, meeting)) {
                System.out.println("Successfully booked Room " + room.getMeetingRoomId() + " (Capacity: " + room.getCapacity() + ")");
                return;
            }
        }

        System.out.println("Booking Failed: No available rooms found for capacity " + capacity + " at the requested time.");
    }
}
