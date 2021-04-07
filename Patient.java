package cse360_database;

public class Patient {
	int ID;
	String lastName, firstName, vaccineType, vaccinationDate, vaccineLocation;
	
	Patient nextPatient = null;
	
	/*					Constructor							*/
	public Patient() {}
	public void setPatient(int ID, String LN, String FN, String VT, String VD, String VL) {
		this.ID = ID;
		lastName = LN;
		firstName = FN;
		vaccineType = VT;
		vaccinationDate = VD;
		vaccineLocation = VL;		
	}
	public void setPatient(Patient p) {
		ID = p.getID();
		lastName = p.getLastName();
		firstName = p.getFirstName();
		vaccineType = p.getVaccineType();
		vaccinationDate = p.getVaccinationDate();
		vaccineLocation = p.getVaccineLocation();
	}
	
	/*					Linked List							*/
	public void setNextPatient(Patient newPatient) { nextPatient = newPatient; }
	public Patient getNextPatient() { return nextPatient; }
	
	/*					Handling Data						*/
	//Set Data
	public void setID(int ID) { this.ID = ID; }
	public void setLastName(String LN) { lastName = LN; }
	public void setFirstName(String FN) { firstName = FN; }
	public void setVaccineType(String VT) { vaccineType = VT; }
	public void setVaccinationDate(String VD) { vaccinationDate = VD; }
	public void setVaccineLocation(String VL) { vaccineLocation = VL; }

	//Get Data
	public int getID() { return ID; }
	public String getLastName() { return lastName; }
	public String getFirstName() { return firstName; }
	public String getVaccineType() { return vaccineType; }
	public String getVaccinationDate() { return vaccinationDate; }
	public String getVaccineLocation() { return vaccineLocation; }	
	
}
