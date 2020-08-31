package hw1p2;



import java.util.ArrayList;

/**
 * My Company class has details about Company
 * It keeps the Shipments, Branches Container and the Administrator
 * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class Company implements authorizedIndex {

    /**
     *
     */
    protected ArrayList<Shipment> Shipments;
    protected ArrayList<Branch> Branches;
    protected Admin Administrator ;
    private String companyName;
    /**
     * constructor needs to initialize company name
     * and to take place for shipments
     * and creates an administrator
     * @param name to get name from user
     */
    public Company(String name) {
        Shipments     = new ArrayList<Shipment>();
        Branches      = new ArrayList<Branch>();
        Administrator = new Admin("Baran Hasan","BOZDUMAN");
        companyName   = name;
    }
    /**
     * Overrided to string method
     * to print information about company
     *//*
    @Override
    public String toString() {
        String company=companyName+"\n\n";
        String shipmentDetail= " ";
        String information = " ";
        Branch iter;
        for(int i=0; i<Branches.getSize(); i++) {
            company+="\n\n"+Branches.getterArray(i).toString()+" \n";
            iter=(Branch) Branches.getterArray(i);
            company+="Branch Employees \n";
            for(i=0; i<iter.BranchEmployees.getSize(); i++) {
                company+= iter.BranchEmployees.getterArray(i).toString()+" \n";
        	}
            
            company+="Transportationn Personnel \n";
            
            for(i=0; i<iter.TransporterPersonnels.getSize(); i++) {
                company+= iter.TransporterPersonnels.getterArray(i).toString()+" \n";
            }    
        }
        for(int i=0; i<Shipments.getSize(); i++) {
            shipmentDetail+= Shipments.getterArray(i).toString()+" \n";
        }
        
        information= company+shipmentDetail;
        
        return company+shipmentDetail;
    }*/
    public String toString() {
    	String print=companyName+"\n\n";
    	for(int i=0; i<Branches.size(); i++) {
    		print+="\n";
    		print+=Branches.get(i);
    		print+="\nBranch Employees";
    		for(int j=0; j<Branches.get(i).BranchEmployees.size(); j++) {
    			print+=Branches.get(i).BranchEmployees.get(j);
    			print+="\n";
    		}
    		print+="\nTransportation Personnel";
    		for(int k=0; k<Branches.get(i).TransporterPersonnels.size(); k++) {
    			print+=Branches.get(i).TransporterPersonnels.get(k);
    			print+="\n";
    		}
    	}
    	return print;
    }
    /**
     *
     * @return company name as string
     */
    public String getCompanyName() {
        return companyName;
    }
    public int indexBranch(String search) {
        for(int i=0; i<Branches.size(); i++) {
        	System.out.print(Branches.size());
        	if(search.equals(Branches.get(i).toString()))
        		return i;
        } 
        	return -1;
    
    }

    /**
     * @param search takes the string as parameter which is id of object
     * @return integer the index of arraylist otherwise it returns -1 if it doesnt find
     */
    @Override
    public int index(String search) {
        for(int i=0; i<Shipments.size(); i++) {
        	System.out.print(Shipments.size());
        	if(search.equals(Shipments.get(i).toString()))
        		return i;
        } 
        	return -1;
    
    }

    public Admin getAdministrator(){ return Administrator; }

    public ArrayList<Branch> getBranches(){ return Branches; }
    public ArrayList<Shipment> getShipments(){ return Shipments; }


}

