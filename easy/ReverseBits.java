package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {
	//NO.190  reverse������32λ�޷���������ÿbit
	
	public static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i ++, n >>= 1){
        	res = res << 1 | (n & 1);
        	System.out.println(res);
        }
        return res;
    }
	
	//�ֶ���򷨣�Java��׼��Integer.reverse()Դ�룬
	public static int reverseBits2(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) | ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
	
	//����÷������������ã��������ڴ��������ݣ�Bulk data��ʱ������Ҫ�õ��Ķ���������
	//��Map��¼֮ǰ��ת�������ֺͽ�������õ��Ż������ǽ��䰴��Byte�ֳ�4�δ洢����ʡ�ռ�
	private final static Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	public static int reverseBits3(int n) {
		byte[] bytes = new byte[4];
	    for (int i = 0; i < 4; i++) // convert int into 4 bytes
	        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
	    int result = 0;
	    for (int i = 0; i < 4; i++) {
	        result += reverseByte(bytes[i]); // reverse per byte
	        if (i < 3)
	            result <<= 8;
	    }
	    return result;
	}
	private static int reverseByte(byte b) {
	    Integer value = cache.get(b); // first look up from cache
	    if (value != null)
	        return value;
	    value = 0;
	    // reverse by bit
	    for (int i = 0; i < 8; i++) {
	        value += ((b >>> i) & 1);
	        if (i < 7)
	            value <<= 1;
	    }
	    cache.put(b, value);
	    return value;
	}
	
	public static void main(String[] args) {
		int n = 43261596; 
		System.out.println(reverseBits2(14));
		
		/*����Ԫ��ʹ����ʱ������ֱ������ʡһ����ʱ�䣬����ʾ��������λ����
		int a = 1, b = 2;
		long s1 = System.nanoTime();//System.currentTimeMillis();
		for(int i = 0; i < 10000; i++){
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		long s2 = System.nanoTime();//System.currentTimeMillis();
		
		long s3 = System.nanoTime();//System.currentTimeMillis();
		for(int i = 0; i < 10000; i++){
			int temp = a;
			a = b;
			b = temp;
		}
		long s4 = System.nanoTime();//System.currentTimeMillis();
		
		System.out.println("��������ʱ�䣺 "+(s2-s1)+"ns");
		System.out.println("��������ʱ�䣺 "+(s4-s3)+"ns");
		*/	
	}
}
