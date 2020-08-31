package bhb;


/**
 * My Company class has details about Company
 * It keeps the Shipments, Branches Container and the Administrator
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class Company {

    /**
     *
     */
    protected MyContainer<Shipment> Shipments;
    protected MyContainer<Branch> Branches;
    protected Admin Administrator ;
    private String companyName;
    /**
     * constructor needs to initialize company name
     * and to take place for shipments
     * and creates an administrator
     * @param name to get name from user
     */
    public Company(String name) {
        Shipments     = new MyContainer<Shipment>();
        Branches      = new MyContainer<Branch>();
        Administrator = new Admin("Baran Hasan","BOZDUMAN");
        companyName   = name;
    }
    /**
     * Overrided to string method
     * to print information about company
     */
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
    }
    /**
     *
     * @return company name as string
     */
    public String getCompanyName() {
        return companyName;
    }

    public Admin getAdministrator(){ return Administrator; }

    public MyContainer<Branch> getBranches(){ return Branches; }
    public MyContainer<Shipment> getShipments(){ return Shipments; }


}

