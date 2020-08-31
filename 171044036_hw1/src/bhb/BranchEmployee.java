package bhb;

/**
 *
 * BranchEmployee keeps the name and surname of branch employees and do their jobs
 * Branch
 *employees can enter and remove information about the shipments sent from that branch,
 *add and remove users (customers) to the system. The information of the sender and receiver
 *are recorded for each shipment. When the package arrives at a branch or leaves the branch,
 *its current status is entered into the system by the branch employee.
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class BranchEmployee extends Person{

    /**
     * it creates new branch employee
     */
    public BranchEmployee(String name, String surname) {
        super(name,surname);
    }
    /**
     * overrided to string methods reurns name and surname of branch employee as a string
     */
    @Override
    public	String toString() {
        return name+" "+surname;
    }
    /**
     * takes new shipment as the type of shipment object and adds it into shipment container
     * @param Shipments takes shipments container
     * @param newCargo takes a shipment as shipment type
     */
    public void addShipment(MyContainer<Shipment> Shipments, Shipment newCargo) {
        Shipments.add(newCargo);
    }
    /**
     * deletes shipment by using mycontainer delete method
     * @param Shipments takes shipments container
     * @param deleteCargo the cargo which will be deleted must find before send to deleteshipment method
     */
    public void deleteShipment(MyContainer<Shipment> Shipments, Shipment deleteCargo) {
        Shipments.delete(deleteCargo);
    }
    /**
     * takes the parameters and
     * @param Shipments takes shipment container
     * @param trackId takes trackid as string
     * @param situation takes situation as string but you can not leave space between words
     */
    public void changeStatusofShipment(MyContainer<Shipment> Shipments,String trackId, String situation) {
        Shipments.find(trackId).changeStatus(situation);
    }
}

