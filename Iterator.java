package cse360_database;

public class Iterator {
	
	Patient head = null;
	
	/*					List Interactions					*/
	public void addNewPatient(int ID, String FN, String LN, String VT, String VD, String VL) {
		Patient link = new Patient();
		link.setPatient(ID, FN, LN, VT, VD, VL);
		
		//Is the list empty?
		if(head == null) {
			head = link;
			return;
		}
		
		//Adding Link to the head of the list
		link.setNextPatient(head);
		head = link;
		sortList();
	}
	
	/*					List Functions					*/
	public void sortList() {
		
		if(head == null) return;
		
		Patient iterator = head, index = null;
		int temp;
		
		//Iterate through the list
		while(iterator != null) {
			index = iterator.getNextPatient();
			
			while(index != null) {
				if(iterator.getID() > index.getID()) {
					/*temp = iterator.getID();
					iterator.setID(index.getID());
					index.setID(temp);*/
					swap(index, iterator);
				}
				index = index.getNextPatient();
			}			
			iterator = iterator.getNextPatient();
		}// Close While
	}

	public void swap(Patient link, Patient iterator) {
		Patient holder = new Patient();
		holder.setPatient(link);
		link.setPatient(iterator);
		iterator.setPatient(holder);
	}
	
	/*					List Calls					*/
	public void printList() {
		
		if(head == null) {
			System.out.println("List Empty");
			return;
		}
		
		Patient iterator = head;
		
		while(iterator != null) {
			//Print out the messages
			System.out.println("ID: " + iterator.getID());
			System.out.println("Name: " + iterator.getLastName() + ", " + iterator.getFirstName());
			System.out.println("Vaccine Type: " + iterator.getVaccineType());
			System.out.println("Vaccine Location: " + iterator.getVaccineLocation());
			System.out.println("Vaccination Date: " + iterator.getVaccinationDate());
			System.out.println();
			
			//Iterate the iterator (lol)
			iterator = iterator.getNextPatient();
			
		}
	}
	
	
}
