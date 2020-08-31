package hw1p2;

import java.util.ArrayList;
/**
 *
 *
 * My Company class has details about Company
 * It keeps the Shipments, Branches Container and the Administrator
  * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class Branch implements authorizedIndex {

    /**
     *
     */
    protected ArrayList<BranchEmployee> BranchEmployees;
    protected ArrayList<TransportationPersonnel> TransporterPersonnels;
    protected String BranchName;
    /**
     * constructor the branch must have a name
     * @param name takes name as string
     */
    public Branch(String name) {
        BranchName=name;
        BranchEmployees = new ArrayList<BranchEmployee>() ;
        TransporterPersonnels =new ArrayList<TransportationPersonnel>();
    }
    /**
     * gets branch name
     * @return returns branch name as string
     */
    public String getBranchName() {
        return BranchName;
    }
    /**
     * overrided to string method returns branch name as string
     * it usually uses to find objects
     */
    @Override
    public String toString() {
        return BranchName;
    }
   /* @Override
    public boolean equals(Object ob) {
    	if((String)ob != null&&(String)ob.equals(this.toString()))
    		return true;
    	return false;
    }*/
    /**
     * colone method uses default clone of Object class
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    /**
     * @param search takes the string as parameter which is id of object
     * @return integer the index of arraylist otherwise it returns -1 if it doesnt find
     */
    @Override
    public int index(String search) {
        for(int i=0; i<BranchEmployees.size(); i++) {
        	System.out.print(BranchEmployees.size());
        	if(search.equals(BranchEmployees.get(i).toString()))
        		return i;
        } 
        	return -1;
    
    }

    /**
     * @param search takes the string as parameter which is id of object
     * @return integer the index of arraylist otherwise it returns -1 if it doesnt find
     */
    public int indexPers(String search) {
        for(int i=0; i<TransporterPersonnels.size(); i++) {
        	System.out.print(TransporterPersonnels.size());
        	if(search.equals(TransporterPersonnels.get(i).toString()))
        		return i;
        } 
        	return -1;
    
    }
    public ArrayList<TransportationPersonnel> getTransporterPersonnels(){ return TransporterPersonnels; }
    public ArrayList<BranchEmployee> getBranchEmployees(){ return BranchEmployees; }
}
