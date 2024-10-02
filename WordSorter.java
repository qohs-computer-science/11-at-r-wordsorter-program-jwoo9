//Justin Wu, 10/2/24, Period 3
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		ArrayList<String> [] words = new ArrayList[26];
		for (int i = 0; i<26; i++){
			words[i]=new ArrayList<String>();
		}//end for
		
		
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}//end try
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}//end catch
		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			word=word.toLowerCase();
			System.out.println(word);

			
		}//end while
	}//end main

	public static boolean checkDupe(String w, int index,ArrayList<String> [] arr){
		boolean dupe = false;
		for (int i =0; i<arr[index].size();i++){
			if (w.equals(arr[index].get(i)))
				dupe = true;
		}//end for
		return dupe;
	}//end method notDupe
}//end class