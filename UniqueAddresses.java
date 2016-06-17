
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 
 * This program takes two files with a set of addresses separated by new line. 
 * Address contains name and number separated by whitespace.
 *  
 * @produces list of unique names in both the files
 * 
 */
public class UniqueAddresses {
	public static void main(String...args){
		String line = null;
		List<String> addressBook_1 = new ArrayList<String>();
		List<String> addressBook_2 = new ArrayList<String>();
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter file path to Address Book 1: ");
			FileReader addrBook1 = 
					new FileReader("/Users/arbghl/Documents/pwc/Address.Book/src/arun/controller/AddressBook1.txt");
			System.out.print("Enter file path to Address Book 2: ");
			FileReader addrBook2 = 
					new FileReader("/Users/arbghl/Documents/pwc/Address.Book/src/arun/controller/AddressBook2.txt");
			BufferedReader bufferedReader = 
					new BufferedReader(addrBook1);

			while((line = bufferedReader.readLine()) != null) {
				String strArray[] = line.split(" ", 0);
				addressBook_1.add(strArray[0]);
			}
			BufferedReader bufferedReader2 = 
					new BufferedReader(addrBook2);
			line = null;
			while((line = bufferedReader2.readLine()) != null) {
				String strArray[] = line.split(" ", 0);
				addressBook_2.add(strArray[0]);
			}
			bufferedReader.close();
			bufferedReader2.close();
			List<String> list = new ArrayList<String> (addressBook_1);
			list.removeAll(addressBook_2); 

			List<String> list2 = new ArrayList<String> (addressBook_2);
			list2.removeAll(addressBook_1); 

			list2.addAll(list);
			for(String s : list2){
				System.out.println(s);
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Unable to open file");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file");                  

		}
	}
}
