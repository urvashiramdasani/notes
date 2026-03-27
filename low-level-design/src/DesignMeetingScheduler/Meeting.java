package DesignMeetingScheduler;

import java.time.LocalTime;
import java.util.UUID;

public class Meeting {
    private final String meetingId;
    private final LocalTime start;
    private final LocalTime end;

    public Meeting(LocalTime start, LocalTime end) {
        this.meetingId = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
    }

    public String getMeetingId() {
        return this.meetingId;
    }

    public LocalTime getStart() {
        return this.start;
    }

    public LocalTime getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return "Meeting(" + this.start + ", " + this.end + ")";
    }
}
