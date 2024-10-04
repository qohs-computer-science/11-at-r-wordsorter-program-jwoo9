//Justin Wu, 10/2/24, Period 3
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		ArrayList<String> [] wordList = new ArrayList[26];
		for (int i = 0; i<26; i++){
			wordList[i]=new ArrayList<String>();
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
			char letter = word.charAt(0);
			if (checkDupe(word,letter-97,wordList)==false)
				wordList[letter-97].add(word);	
		}//end while
		Scanner input = new Scanner(System.in);
		boolean runAgain = true;
		while (runAgain){
			System.out.println("What would you like to do?");
			System.out.println("1.  Print out all words starting with a specific letter ");
			System.out.println("2. Print out all words");
			System.out.println("3. Print out the total number of unique words");
			System.out.println("4. Search and determine if a word is in the article");
			System.out.println("5. Remove a word from the data structure ");
			System.out.println("6. Exit");
			int choice = input.nextInt();
			input.nextLine();
			while (choice <1 || choice >6){
				System.out.println("Please enter a valid input:");
				choice = input.nextInt();
				input.nextLine();
			}//end while

			if (choice == 1){
				System.out.println("What letter?");
				String l =input.nextLine();
				while (l.length()>1){
					System.out.println("Please enter just one character");
					l = input.nextLine();
				} //end while
				char letter = l.charAt(0);
				if (wordList[letter-97].size()==0)
					System.out.println("No words start with this letter");
				else
					printLetter(wordList, letter-97);
			} else if (choice ==2)
				printAll(wordList);
		}//end runAgain while

	}//end main

	public static boolean checkDupe(String w, int index,ArrayList<String> [] arr){
		boolean dupe = false;
		for (int i =0; i<arr[index].size();i++){
			if (w.equals(arr[index].get(i)))
				dupe = true;
		}//end for
		return dupe;
	}//end method notDupe

	public static void printLetter(ArrayList<String>[] arr, int index){
		for (int i = 0; i<arr[index].size(); i++)
			System.out.println(arr[index].get(i));
	}//end method printLetter

	public static int printAll(ArrayList<String>[] arr){
		char x = 97;
		int numWords =0;
		for (int i = 0; i<26; i++){
			System.out.println(x + ": ");
			printLetter(arr,i);
			x++;
		}
		return numWords;
	} //end method printAll

}//end class