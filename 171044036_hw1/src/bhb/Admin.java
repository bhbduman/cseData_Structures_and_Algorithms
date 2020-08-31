package bhb;



/**
 *
 * Admin class do the administrator jobs
 * Administrators manage the system by
 * adding and removing branches, branch employees and transportation personnel
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class Admin extends Person {

    /**
     *it creates admin
     */

    public Admin(String name, String surname) {
        super(name,surname);
    }
    /**
     * It adds new branch element by using container add method to branches container
     * @param Branches takes the branches which is type of branch container
     * @param newBranch the user must create the new branch object before send to this method
     */
    public void addBranch(MyContainer<Branch> Branches, Branch newBranch) {
        Branches.add(newBranch);
    }
    /**
     * It deletes Branch from branches container by using container add method
     * @param Branches takes branches container
     * @param deletedBranch the branch must be find before the send delete method by using find method of container
     */
    public void deleteBranch(MyContainer<Branch> Branches, Branch deletedBranch) {
        Branches.delete(deletedBranch);
    }
    /**
     * Adds a new branch employee to a specific branch by using container add method
     * @param Branches takes branches container
     * @param chosenBranch the user must give a branch as type of Branch before send method
     * @param employee the user must send an employee which is type of BranchEmployee
     */
    public void addBranchEmployee(MyContainer<Branch> Branches, Branch chosenBranch, BranchEmployee employee) {
        Branches.find(chosenBranch).BranchEmployees.add(employee);
    }
    /**
     * deletes an employee from a specific branch by using container delete method
     * @param Branches  takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param employee the user must send an employee which is type of BranchEmployee user can find by using find method of container
     */
    public void deleteBranchEmployee(MyContainer<Branch> Branches, Branch chosenBranch, BranchEmployee employee) {
        Branches.find(chosenBranch).BranchEmployees.delete(employee);
    }
    /**
     * It adds a transportation personel in a specific branch by using container add function
     * @param Branches takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param personel the user must send an employee which is type of BranchEmployee user can find by using find method of container
     */
    public void addTransportationPersonnel(MyContainer<Branch> Branches, Branch chosenBranch, TransportationPersonnel personel) {
        Branches.find(chosenBranch).TransporterPersonnels.add(personel);
    }
    /**
     * it deletes a transportation personel in a specific branch by using container delete function
     * @param Branches takes branches container
     * @param chosenBranch  the user must give a branch as type of Branch before send method
     * @param personel the user must send an employee which is type of BranchEmployee user can find by using find method of container
     */
    public void deleteTransportationPersonnel(MyContainer<Branch> Branches, Branch chosenBranch, TransportationPersonnel personel) {
        Branches.find(chosenBranch).TransporterPersonnels.delete(personel);
    }


}
