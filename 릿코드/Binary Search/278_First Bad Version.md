### 278 First Bad Version
  - 최신 버전의 제품은 품질 검사에 실패했습니다. 각 버전은 이전 버전을 기반으로 개발되기 때문에 품질 검사에 실패한 버전 이후의 모든 버전도 모두 품질 검사에 실패합니다.
  - n버전이 있고 첫 번째 잘못된 버전을 찾으세요.
  - java code
  ```java
    /* The isBadVersion API is defined in the parent class VersionControl.
       boolean isBadVersion(int version); 
     */
    public int firstBadVersion(int n) {
        int result = 1;
        long left = 1;
        long right = n;
        while(left <= right) {
            long mid = (right + left) / 2;
            
            if(!isBadVersion((int) mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = (int) mid;
            }
        }
        
        return result;
    }
  ```
