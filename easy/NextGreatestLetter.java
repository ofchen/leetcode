package LeetCode.easy;

public class NextGreatestLetter {
	public static char nextGreatestLetter(char[] letters, char target) {		
		int len = letters.length, l = 0, h = len-1;
		
		while(l <= h && l <= len-1 && h >= 0){
			int m = (h-l)/2+l;
			if(letters[m] == target){
				for(; m < len && letters[m] == target; m ++); 
				if(m == len) 
					return letters[0];
				else 
					return letters[m];
			}
			else if(letters[m] < target)
				l = m+1;
			else 
				h = m-1;
		}
        
        if(l == len) 
            return letters[0];
        else 
            return letters[l];		       		
    }
	
	public static char nextGreatestLetter2(char[] letters, char target) {
		int s = 0, e = letters.length-1;
		while(s+1 < e){
			int m = (e-s)/2+s;
			if(letters[m] <= target) s = m;
			else e = m;
		}
		if(s == 0 && letters[s] > target) return letters[s];
		if(letters[e] > target) return letters[e];
		return letters[0];
	}
	
	public static void main(String[] args) {
		char[] ls = {'e','e','e','e','e','e','n','n','n','n'};
		char t = 'e';
		System.out.print(nextGreatestLetter(ls, t));
	}

}
