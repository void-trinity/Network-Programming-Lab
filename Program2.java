public class Program2
{
	public static void main(String args[])
	{
		String s = new String("My_name_is_Siddharth");
		for(String str: s.split("_"))
		{
			System.out.println(str);
		}
	}
}