### 35 Search Insert Position
  - 오름차순으로 정렬된 배열이 주어집니다. 배열에서 target 값이 들어가야 하는 index를 반환하고 target이 배열안에 있으면 그 위치의 index를 반환하세요
  ```java
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                int next = mid + 1 > nums.length - 1 ? nums.length - 1 : mid + 1;
                if (nums[next] < target) {
                    return mid + 1;
                }
                right = mid - 1;
            } else {
                int prev = mid - 1 < 0 ? 0 : mid - 1;
                if (nums[prev] > target) {
                    return mid - 1;
                }
                left = mid + 1;
            }
        }

        return left;
    }
  ```
