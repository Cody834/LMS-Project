
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Lockedme {
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("*******************************************************");
	    System.out.println("***********************LOCKED.ME***********************");
	    System.out.println("*******************************************************");
	    System.out.println("------------------- CDW Development--------------------");
	    
	    System.out.println("Press Enter to continue ");
	    scanner.nextLine();
	    fileManager.displayMenu();
	    
	}
	
}
class FileManager{
	Scanner scanner = new Scanner (System.in);
	public void displayMenu() {
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("1. List all files");
		System.out.println("2. Manage individual");
		System.out.println("3. Close Application");
		System.out.println("Enter your choice" );
		int inputValue = 0;
		try {
			inputValue = scanner.nextInt();
			switch(inputValue) {
				case 1: System.out.println("All Files : ");		    
				this.listAllFiles();
				  
				    break;
				case 2: this.manageIndividualFiles();
					break;
				case 3: this.close();
			    default: System.out.println("Not a valid option ");	
			    	this.displayMenu();
			}
		}
		catch (Exception e) {
			System.out.println("Please specify valid number ");
			scanner = new Scanner (System.in);
			this.displayMenu();
		}
	}
	
	private void close () {
		System.out.println("Application closed");
		System.exit(0);
	}
	
	private void manageIndividualFiles() {
		System.out.println("1.Add ");
		System.out.println("2.Delete ");
		System.out.println("3.Search ");
		System.out.println("4.Go Back ");
		System.out.println("Enter your choice ");
		int inputValue = scanner.nextInt();
		switch(inputValue) {
			case 1: this.addFile();
				this.displayMenu();
		       	break;
			case 2: this.deleteFile();
				this.displayMenu();
		       	break;
				case 3: this.findFile();
				this.displayMenu();
				break;
			default: System.out.println("Not a valid option ");
			case 4: this.displayMenu();
		}
	}
	
	private void addFile() {
		System.out.println("Specify file name" );
		String fileName = scanner.next();
		File folder = new File("Lockedme files/");
		if (!folder.exists()){
	   		folder.mkdirs();
	   	}
	   	File file = new File("Lockedme files/" + fileName);
	    try {
	    	if(file.exists()) {
	    		System.out.println("File already Exists");
	    	}
	    	else {
	    		file.createNewFile();
				System.out.println("File " + fileName + " created " );
	    	}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void deleteFile() {
		System.out.println("Specify file name" );
		String fileName = scanner.next();
		File file = new File("Lockedme files/" + fileName);
		if (file.exists()){ 
			file.delete();
			System.out.println("File Deleted : " + fileName);
		}
		else {
			System.out.println("File not Found");
		}
		
	    
	}
	
	private void findFile() {
		System.out.println("Specify file name" );
		String fileName = scanner.next();
		File file = new File("Lockedme files/" + fileName);

		if(file.exists()) {
    		System.out.println("File Found : " + fileName);
    	}
    	else {
			System.out.println("File not Found : " + fileName);
    	}
		
	}
	
	
   private void listAllFiles() {
	   	File folder = new File("Lockedme files/");
	   	if (!folder.exists()){
	   		folder.mkdirs();
	   	}
	   	
       if(folder.isDirectory())
       {
           File[] fileList = folder.listFiles();

           Arrays.sort(fileList);

           fileList = folder.listFiles();

           Arrays.sort(fileList, new Comparator<Object>()
           {
               @Override
               public int compare(Object f1, Object f2) {
                   return ((File) f1).getName().toLowerCase().compareTo(((File) f2).getName().toLowerCase());
               }
           });

           for(File file:fileList)
           {
               System.out.println(file.getName());
           }
           System.out.println("1.Return to Main Menu"); 
           scanner.next();
           this.displayMenu();

       }   
   }
   
}