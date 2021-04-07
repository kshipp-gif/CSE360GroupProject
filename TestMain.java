package cse360_database;

public class TestMain {
	
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		//Adding test patients
		Iterator test = new Iterator();
		
		for(int i = 0; i < 20; i ++) {
			test.addNewPatient( (int) (Math.random() * 1000), "John", "Smith", "Type", "Date", "Location");
		}
		
		test.printList();
		
	}
}
