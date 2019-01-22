package LeetCode.easy;

import java.util.Arrays;

public class FindRadius {
/*�ö��ֲ��ҷ��������ҵ���һ�����ڵ��ڵ�ǰhouseλ�õ����������������ڣ�
 * ��ô���ǿ���������house�Ĳ�ֵ������������������heater�������֣�
 * ���ǿ������house��ǰ��һ�����Ĳ�ֵ������������ȡ��С��Ϊcover��ǰhouse����С�뾶��
 * Ȼ������ÿ�θ��½��res����
 * */
	public static int findRadius(int[] houses, int[] heaters) {
        int res = 0, n = heaters.length;
        Arrays.sort(heaters);
        for (int house : houses) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) left = mid + 1;
                else right = mid;
            }
            int dist1 = (right == n) ? Integer.MAX_VALUE : heaters[right] - house;
            int dist2 = (right == 0) ? Integer.MAX_VALUE : house - heaters[right - 1];
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};
		System.out.println(findRadius(houses, heaters));
	}

}
