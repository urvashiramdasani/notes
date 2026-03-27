package DesignMeetingScheduler;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class MeetingRoom {
    private final ReentrantLock lock;
    private final String meetingRoomId;
    private final int capacity;
    Comparator<Meeting> meetingComparator = Comparator.comparing(Meeting::getStart);
    private final Map<LocalDate, TreeSet<Meeting>> meetings;

    public MeetingRoom(int capacity) {
        this.meetingRoomId = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.meetings = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getMeetingRoomId() {
        return this.meetingRoomId;
    }

    public boolean bookRoom(LocalDate date, Meeting meeting) {
        lock.lock();
        try {
            meetings.putIfAbsent(date, new TreeSet<>(meetingComparator));
            TreeSet<Meeting> dailyMeetings = this.meetings.get(date);

            if(!isAvailableForDate(meeting, dailyMeetings)) {
                return false;
            }

            dailyMeetings.add(meeting);
            return true;
        } finally {
            lock.unlock();
        }
    }

    private boolean isAvailableForDate(Meeting newMeeting, TreeSet<Meeting> dailyMeetings) {
        // 1. Find our immediate neighbors on the timeline
        Meeting meetingBefore = dailyMeetings.floor(newMeeting);
        Meeting meetingAfter = dailyMeetings.ceiling(newMeeting);

        // 2. Does the meeting BEFORE us end AFTER we start?
        // (e.g., They booked 1:00-2:00, but we want to start at 1:30)
        if (meetingBefore != null && meetingBefore.getEnd().isAfter(newMeeting.getStart())) {
            return false; // Overlap!
        }

        // 3. Does our meeting end AFTER the next meeting starts?
        // (e.g., We want to book 2:00-3:00, but they already booked 2:30-3:30)
        if (meetingAfter != null && newMeeting.getEnd().isAfter(meetingAfter.getStart())) {
            return false; // Overlap!
        }

        // If neither neighbor overlaps with us, the slot is completely free!
        return true;
    }
}
