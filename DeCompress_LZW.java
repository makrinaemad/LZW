package decompress_LZW;

import java.util.HashMap;

public class DeLZW {
	public static void decode(int [] t)
	{
		HashMap<Integer, String> dic = new HashMap<Integer, String>();
		int dic_size=256;
		
		for(int i=0;i<dic_size;i++)
		{
			dic.put( i ,String.valueOf((char)i));
		}
		
		String decod=dic.get(t[0]);
		
		for(int j=1;j<t.length;j++)
		{
			if(t[j]==dic_size)
				dic.put( dic_size, dic.get(t[j-1])+dic.get(t[j-1]).charAt(0));	
			else
			    dic.put( dic_size, dic.get(t[j-1])+dic.get(t[j]).charAt(0));
			
			dic_size++;
			decod+=dic.get(t[j]);
		}
		
			System.out.println(decod);
			
			int max=t[0];
			for (int n = 1; n< t.length; n++)
	            if( t[n] > max)
	                max = t[n];
			
			int nbits=0;
			nbits=(int)(Math.log(max) /  Math.log(2)+1);
			System.out.println("Compression size= " + (t.length* nbits));
			System.out.println("Decompression size= "+(8*decod.length()));
		
	}

	public static void main(String[] args) {
		int [] arr= {65,66,65,256,256,257,259,262,258,257,66,266,267,266};
		decode(arr);
		
     //ABAABABBAABAABAAAABABBBBBBBB
	}
}
