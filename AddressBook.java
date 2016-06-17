
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/*
 * 
 * This program takes a text file as input with a set of addresses separated by new line. 
 * Address contains name and number separated by whitespace.
 *  
 * @produces all names and contact number in ascending order. Prompts user to input a name and number for saving
 * 
 */
public class AddressBook {
	public static void main(String...args){
		String fileName = "/Users/arbghl/Documents/pwc/Address.Book/src/arun/controller/AddressBook1.txt";

		// This will reference one line at a time
		String line = null;

		try {
			System.out.print("Enter file path to Address Book: ");
			Scanner scan = new Scanner(System.in);
			String s = scan.next();

			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(s);
			SortedMap<String, String> sm = new TreeMap<String, String>();

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String strArray[] = line.split(" ", 0);
				sm.put(strArray[0], strArray[1]);
			}
			//get the sorted keyset from a treemap and then printing them in ascending order
			Set<String> set = sm.keySet();
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()){
				String key = iter.next();
				System.out.println(key +" "+ sm.get(key));
			}
			// Always close files.
			bufferedReader.close(); 

			File file = new File(s);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// enter a name and number if you want to add a new contact
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
			System.out.println("Enter name: ");
			String name = scan.next();
			System.out.println("Enter contact number: ");
			String contact = scan.next();

			pw.append("\n" + name + " " + contact);
			pw.close();         
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  

		}
	}
}
