package bhb;


/**
 *
 *
 * My Company class has details about Company
 * It keeps the Shipments, Branches Container and the Administrator
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class Branch {

    /**
     *
     */
    protected MyContainer<BranchEmployee> BranchEmployees = new MyContainer<BranchEmployee>();
    protected MyContainer<TransportationPersonnel> TransporterPersonnels = new MyContainer<TransportationPersonnel>();
    protected String BranchName;
    /**
     * constructor the branch must have a name
     * @param name takes name as string
     */
    public Branch(String name) {
        BranchName=name;
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
    /**
     * colone method uses default clone of Object class
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MyContainer<TransportationPersonnel> getTransporterPersonnels(){ return TransporterPersonnels; }
    public MyContainer<BranchEmployee> getBranchEmployees(){ return BranchEmployees; }
}
