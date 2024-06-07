package hash_tables.medium;

import java.util.*;

// https:// leetcode.com/problems/design-underground-system/description/
// 1396. Design Underground System
class UndergroundSystem {

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, TripInfo> tripTimes;

    private class CheckInInfo {
        String stationName;
        int time;

        public CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private class TripInfo {
        int totalTime;
        int tripCount;

        public TripInfo() {
            this.totalTime = 0;
            this.tripCount = 0;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        tripTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkIns.get(id);
        if (checkInInfo != null) {
            String tripKey = checkInInfo.stationName + "_" + stationName;
            int tripTime = t - checkInInfo.time;

            tripTimes.putIfAbsent(tripKey, new TripInfo());
            TripInfo tripInfo = tripTimes.get(tripKey);
            tripInfo.totalTime += tripTime;
            tripInfo.tripCount++;

            // Remove the check-in info since the trip is completed
            checkIns.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String tripKey = startStation + "_" + endStation;
        TripInfo tripInfo = tripTimes.get(tripKey);

        if (tripInfo == null || tripInfo.tripCount == 0) {
            return 0;
        }

        return (double) tripInfo.totalTime / tripInfo.tripCount;
    }
}
