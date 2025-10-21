package PRO.Lv1;


public class PRO_1845 {
  public static void main(String[] args) {
      Solution_1845 s = new Solution_1845();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    

import java.util.*;

class Solution_1845 {
    public int solution(int[] nums) {
        int answer = -1;
		// 중복을 허용하지 않는 HashSet 선언 및 초기화
		Set<Integer> set = new HashSet<>();
		
		// nums 배열을 돌면서 set에 담기
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		// 전체 포켓몬 수
		int length = nums.length;
		int half = length / 2;
		
		if(set.size() >= half) {
			answer = half;
		} else {
			answer = set.size();
		}
		
        return answer;
    }
}