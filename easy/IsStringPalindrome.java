package LeetCode.easy;

public class IsStringPalindrome {
	//�߽�����δ�������������Ч�ַ�Ϊ��ʱδ����
	public static boolean isPalindrome(String s) {
		//isEmpty��ȫ��ͬ��string.length()==0
		if(s == null || s.isEmpty()) return true;
		char[] sc = s.toCharArray();
		int len = sc.length, i = 0, j = len-1;
		
		while(i < len && i <= j){
			while(i < len && !isAlpha(sc[i]) && !isNumber(sc[i])) i++;
			while(j >= 0 && !isAlpha(sc[j]) && !isNumber(sc[j])) j--;
			char l = sc[i], h = sc[j];
			System.out.println(i+" "+l+" ,"+j+" "+h);
			if(i == len && j == -1) return true;
			else {
				if(isAlpha(sc[i]) && isAlpha(sc[j]) && (sc[i]==sc[j] ||Math.abs(sc[i]-sc[j])==32)){
					i++;
					j--;
				}
				else if(isNumber(sc[i]) && isNumber(sc[j]) && sc[i]==sc[j]){
					i++;
					j--;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isNumber(char c){
		if(c >= '0' && c <='9')
			return true;
		return false;		
	}
	
	public static boolean isAlpha(char c) {
		if((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z'))
			return true;
		return false;		
	}
	
	public static void main(String[] args) {
		String string = "race a car";//"A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(string));

	}

}
