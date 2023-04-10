	import java.util.HashMap;
public class LZW {

		public static void encode(String t)
		{
			HashMap<String, Integer> dic = new HashMap<String, Integer>();
			int dic_size=256;
			for(int i=0;i<dic_size;i++)
			{
				dic.put(String.valueOf((char)i), i);
			}
			String search="";//letters we want to encode
			int[]res=new int[100];
			int counter=0;
			for(int j=0;j<t.length();j++)
			{
				String match=search+t.charAt(j);//longest match we find with dictionary
				if(dic.containsKey(match))
				{
					search=match;
				}
				else
				{
					res[counter]=dic.get(search);
					counter++;
					dic.put(match, dic_size);
					dic_size++;
					search=String.valueOf(t.charAt(j));
				}
			}
			res[counter]=dic.get(search);
			for(int m=0;m<=counter;m++)
			{
				System.out.println(res[m]);
			}
			System.out.println("original size ="+(8*t.length()));
			int max=res[0];
			for (int n = 1; n< counter; n++)
	            if (res[n] > max)
	                max = res[n];
			
			int nbits=0;
			nbits=(int)(Math.log(max) /  Math.log(2)+1);
			System.out.println("size after compression =" + ((counter+1)* nbits));//counter +1 because count start from 0 tag

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String text="ABAABABBAABAABAAAABABBBBBBBB";
			encode(text);
			

		}

	}

