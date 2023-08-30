```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int len = intervals.length;
        List<int[]> ret = new ArrayList<>();

        while (i < len && intervals[i][1] < newInterval[0]) {
            ret.add(intervals[i++]);
        }

        while (i < len 
        && intervals[i][0] <= newInterval[1] 
        && intervals[i][1] >= newInterval[0]
        ) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ret.add(newInterval);

        while (i < len) {
            ret.add(intervals[i++]);
        }

        return getResult(ret);
    }

    private static boolean check(int start, int end, int newStart, int newEnd) {
        if (start <= newEnd && newEnd <= end) {
            return true;
        } else if (start <= newStart && newStart <= end) {
            return true;
        } else {
            return start >= newStart && end <= newEnd;
        }
    }

    private static int[][] getResult(List<int[]> newIntervals) {
        int[][] result = new int[newIntervals.size()][2];
        for (int i = 0; i < newIntervals.size(); i++) {
            int[] ints = newIntervals.get(i);
            result[i][0] = ints[0];
            result[i][1] = ints[1];
        }
        return result;
    }
}
```
