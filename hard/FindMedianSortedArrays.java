package LeetCode.hard;
//�ҵ�������������ϲ������λ��
public class FindMedianSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2){

		int len1 = nums1.length, len2 = nums2.length;
		if(len2 == 0){
			if((len1 & 1) == 0)
				return (nums1[len1/2]+nums1[len1/2-1]) * 0.5;
			return nums1[len1/2];
		}
		if(len1 == 0){
			if((len2 & 1) == 0)
				return (nums2[len2/2]+nums2[len2/2-1]) * 0.5;
			return nums2[len2/2];
		}
		
		if(len1 > len2) //��֤nums1����С��nums2
			return findMedianSortedArrays(nums2,nums1);
		
		int k = (len1 + len2 + 1)/2;
		int left = 0, right = len1;
		
		while(left < right){
			int m1 = (left + right) / 2;
			int m2 = k - m1;
			if(nums1[m1] < nums2[m2-1])
				left = m1 + 1;
			else
				right = m1;
		}
		
		int m1 = left;
		int m2 = k - left;
		double c1 = Math.max(m1 > 0 ? nums1[m1-1] : Integer.MIN_VALUE, 
				 m2 > 0 ? nums2[m2-1] : Integer.MIN_VALUE);
		if(((len1 + len2) & 1) == 1){
			return c1;
		}
		
		double c2 = Math.min(m1 < len1 ? nums1[m1] : Integer.MAX_VALUE, 
				m2 < len2 ? nums2[m2] : Integer.MAX_VALUE);
		return (c1 + c2) * 0.5;

	}
	
	public static void main(String[] args) {
		int[] nums1 = {};//{1, 2};//{};
		int[] nums2 = {2, 3};//{3, 4};//{};
		
		System.out.println("result="+ findMedianSortedArrays(nums1,nums2));
	}

}
