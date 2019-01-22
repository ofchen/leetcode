package LeetCode.easy;

public class ArrangeCoins {
	//�˷�����Խ��,m,hb,lb����Ϊlong  ��ʹ�������ʽ
	public static int arrangeCoins(int n) {
        if(n <= 1) return n;
        long l = 1, r = n;
        while(l < r){
            long m = (r-l)/2+l;
            long lb, hb;
            if((m & 1) == 0){//m��ż��
            	lb = m/2*(m+1);
            	hb = (m+2)/2*(m+1)-1;
            }
            else {
            	lb = (m+1)/2*m;
            	hb = (m+1)/2*(m+2)-1;
			}
            if(lb <= n && hb >= n)
                return (int) m;
            else if(hb < n)
                l = m;
            else if(lb > n)
                r = m;
        }
        return (int) l;
    }
	
	public static void main(String[] args) {
		int m = 5;
		System.out.println(arrangeCoins(m));
		System.out.println((int)((-1 + Math.sqrt(1 + 8 * (long)m)) / 2));
	}

}
