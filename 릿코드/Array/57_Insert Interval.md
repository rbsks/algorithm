### 57 Insert Interval
- 겹치지 않는 간격의 배열이 주어지는데, 여기서 intervals[i] = [starti, endi]는 째 간격의 시작과 끝을 나타내고 간격은 starti를 기준으로 오름차순으로 정렬됩니다. 또한 다른 간격의 시작과 끝을 나타내는 간격 newInterval = [start, end]가 주어집니다.
- intervals가 여전히 starti를 기준으로 오름차순으로 정렬되고 간격에 여전히 겹치는 간격이 없도록 intervals에 newInterval을 삽입합니다(필요한 경우 겹치는 간격을 병합합니다).
- java code
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
