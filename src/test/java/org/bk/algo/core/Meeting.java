package org.bk.algo.core;

import java.util.ArrayList;
import java.util.List;

class Meeting {

    Meeting(String id, int s, int e) {
        this.id = id;
        this.startTime = s;
        this.endTime = e;
    }

    String id;
    int startTime;
    int endTime;
}

enum TimeTypeEnum {
    S, E;
}

class MeetingInstant {
    int time;
    String meetingId;
    TimeTypeEnum type;


    public MeetingInstant(int time, String id, TimeTypeEnum type) {
        this.time = time;
        this.meetingId = id;
        this.type = type;
    }
}


class Solution {

    public static int maxCollissions(List<Meeting> meetings) {

        List<MeetingInstant> instants = new ArrayList<>();

        for (Meeting m : meetings) {
            instants.add(new MeetingInstant(m.startTime, m.id, TimeTypeEnum.S));
            instants.add(new MeetingInstant(m.endTime, m.id, TimeTypeEnum.E));
        }


        instants.sort((MeetingInstant inst1, MeetingInstant inst2) -> {
          int diff = inst1.time - inst2.time;
          if (diff != 0) {
            return diff;
          } else {
            return inst1.meetingId.compareTo(inst2.meetingId);
          }
        });

      List<MeetingInstant> sorted = instants;


        int concurrent = 0;

        int max = 0;

        for (MeetingInstant inst : sorted) {

            if (inst.type == TimeTypeEnum.S) {
                concurrent++;
            }

            if (concurrent > max) {
                max = concurrent;
            }

            if (inst.type == TimeTypeEnum.E) {
                concurrent--;
            }

        }

        return max;
    }

    public static boolean isColliding(Meeting m1, Meeting m2) {
      return (m1.startTime < m2.endTime && m2.startTime < m1.endTime);
    }

    public static void main(String[] args) {
        Meeting m1 = new Meeting("m1", 1, 3);
        Meeting m2 = new Meeting("m2", 3, 6);
        Meeting m3 = new Meeting("m3", 2, 4);

      // System.out.println(maxCollissions(List.of(m1, m2, m3)));

      System.out.println(isColliding(m3, m1));
      System.out.println(isColliding(m2, m3));

    }
}





