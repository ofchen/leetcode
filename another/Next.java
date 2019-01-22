package LeetCode.another;

public class Next {
//�ַ���ģʽƥ��next��nextval������
	public static void next(String s,int next[]){
//		int i = 1,  j = 0;
//		next[1] = 0;
//		while(i < (s.charAt(0) - '0')){
//			if(j == 0 || s.charAt(i) == s.charAt(j)){
//				++ i;
//				++ j;
//				next[i] = j;
//				System.out.println("i = "+i+" , j = "+j+" , next = "+ next[i]);
//			}
//			else{
//				j = next[j];
//				System.out.println("else j = " + j);
//			}
//		}
		int pos = 1,  cnd = 0;
		next[0] = -1;
		next[1] = 0;
		while(pos < s.length()){
			if(s.charAt(pos-1) == s.charAt(cnd)){
				++ cnd;
				next[pos] = cnd;
				++ pos;
				
				System.out.println("i = "+cnd+" , j = "+pos+" , next = "+ next[pos-1]);
			}
			else if(cnd>0){
				cnd = next[cnd];
				System.out.println("else j = " + cnd);
			}
			else{
				next[pos] = 0;
				pos ++;
			}
		}
	}
	
	public static void nextval(String s,int nextval[]){
		int i = 1,  j = 0;
		nextval[1] = 0;
		while(i < s.charAt(0)-'0'){
			if(j == 0 || s.charAt(i) == s.charAt(j)){
				++ i;
				++ j;
				if(s.charAt(i) == s.charAt(j)) nextval[i] = nextval[j];
				else nextval[i] = j;
				System.out.println("i = "+i+" , j = "+j+" , next = "+ nextval[i]);
			}
			else{
				j = nextval[j];
				System.out.println("else j = " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "5aaaab";//"PAYPALISHIRING";
		int[] next = new int[s.length()];
		nextval(s,next);
	}
}
