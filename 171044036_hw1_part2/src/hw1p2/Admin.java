package hw1p2;

import java.util.ArrayList;

/**
 *
 * Admin class do the administrator jobs
 * Administrators manage the system by
 * adding and removing branches, branch employees and transportation personnel
  * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class Admin extends Person {

    /**
     *it creates admin
     */

    public Admin(String name, String surname) {
        super(name,surname);
    }
    public String toString() {
    	return name+" "+id;
    }
    /**
     * It adds new branch element by using container add method to branches container
     * @param Branches takes the branches which is type of branch container
     * @param newBranch the user must create the new branch object before send to this method
     */
    public void addBranch(ArrayList<Branch> Branches, Branch newBranch) {
        Branches.add(newBranch);
    }
    /**
     * It deletes Branch from branches container by using container add method
     * @param Branches takes branches container
     * @param deletedBranch the branch must be indexOf before the send delete method by using indexOf method of container
     */
    public void deleteBranch(ArrayList<Branch> Branches, Branch deletedBranch) {
        int iter = Branches.indexOf(deletedBranch);
    	Branches.remove(iter);
    }
    /**
     * Adds a new branch employee to a specific branch by using container add method
     * it check the id of shipment to prevent the adding same shipment
     * @param Branches takes branches container
     * @param chosenBranch the user must give a branch as type of Branch before send method
     * @param employee the user must send an employee which is type of BranchEmployee
     */
    public void addBranchEmployee(ArrayList<Branch> Branches, Branch chosenBranch, BranchEmployee employee) {
    	int iter = Branches.indexOf(chosenBranch);
    	for (int i = 0; i < Branches.get(iter).BranchEmployees.size(); i++) {
			if(Branches.get(iter).BranchEmployees.get(i).toString().equalsIgnoreCase((String)employee.toString())){
				System.out.println("You cannot add new branch employee name which belongs to others track ids ");
				return;
			}
		}
    	
    	Branches.get(iter).getBranchEmployees().add(employee);
    }
    /**
     * deletes an employee from a specific branch by using container delete method
     * @param Branches  takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param employee the user must send an employee which is type of BranchEmployee user can indexOf by using indexOf method of container
     */
    public void deleteBranchEmployee(ArrayList<Branch> Branches, Branch chosenBranch, BranchEmployee employee) {
        int iter1 = Branches.indexOf(chosenBranch);
        int iter2= Branches.get(iter1).BranchEmployees.indexOf(employee);
    	Branches.get(iter1).BranchEmployees.remove(iter2);
    }
    /**
     * It adds a transportation personel in a specific branch by using container add function
     * it check the id of shipment to prevent the adding same shipment
     * @param Branches takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param personel the user must send an employee which is type of BranchEmployee user can indexOf by using indexOf method of container
     */
    public void addTransportationPersonnel(ArrayList<Branch> Branches, Branch chosenBranch, TransportationPersonnel personel) {
    	int iter1 = Branches.indexOf(chosenBranch);
    	for (int i = 0; i < Branches.get(iter1).TransporterPersonnels.size(); i++) {
			if(Branches.get(iter1).TransporterPersonnels.get(i).toString().equalsIgnoreCase((String)personel.toString())){
				System.out.println("You cannot add new branch employee name which belongs to others track ids ");
				return;
			}
		}
    	Branches.get(iter1).TransporterPersonnels.add(personel);
    }
    /**
     * it deletes a transportation personel in a specific branch by using container delete function
     * @param Branches takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param personel the user must send an employee which is type of BranchEmployee user can indexOf by using indexOf method of container
     */
    public void deleteTransportationPersonnel(ArrayList<Branch> Branches, Branch chosenBranch, TransportationPersonnel personel) {
        int iter1 = Branches.indexOf(chosenBranch);
    	int iter2= Branches.get(iter1).TransporterPersonnels.indexOf(personel);
    	Branches.get(iter1).TransporterPersonnels.remove(iter2);
    }


}

