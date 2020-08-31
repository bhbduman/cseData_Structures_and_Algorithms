package hw1p2;

import java.util.ArrayList;
/**
 *
 * BranchEmployee keeps the name and surname of branch employees and do their jobs
 * Branch
 *employees can enter and remove information about the shipments sent from that branch,
 *add and remove users (customers) to the system. The information of the sender and receiver
 *are recorded for each shipment. When the package arrives at a branch or leaves the branch,
 *its current status is entered into the system by the branch employee.
 * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class BranchEmployee extends Person{

    /**
     * it creates new branch employee
     */
    public BranchEmployee(String name, String id) {
        super(name,id);
    }
    /**
     * overrided to string methods
     * @return it returns id
     */
    @Override
    public	String toString() {
        return id;
    }
    /**
     * takes new shipment as the type of shipment object and adds it into shipment container
     * it check the id of shipment to prevent the adding same shipment
     * @param Shipments takes shipments container
     * @param newCargo takes a shipment as shipment type
     */
    public void addShipment(ArrayList<Shipment> Shipments, Shipment newCargo) {
    	for (int i = 0; i < Shipments.size(); i++) {
			if(Shipments.get(i).toString().equalsIgnoreCase((String)newCargo.toString())){
				System.out.println("You cannot add new shipment with old track ids ");
				return;
			}
		}
        Shipments.add(newCargo);
    }
    /**
     * deletes shipment by using ArrayList delete method
     * @param Shipments takes shipments container
     * @param deleteCargo the cargo which will be deleted must find before send to deleteshipment method
     */
    public void deleteShipment(ArrayList<Shipment> Shipments, Shipment deleteCargo) {
    	int iter = Shipments.indexOf(deleteCargo);
    	Shipments.remove(iter);
    }
    /**
     * takes the parameters and
     * @param Shipments takes shipment container
     * @param trackId takes trackid as string
     * @param situation takes situation as string but you can not leave space between words
     */
    public void changeStatusofShipment(ArrayList<Shipment> Shipments,String trackId, String situation) {
    	int iter = 0;
    	for(int i=0; i<Shipments.size(); i++) {
        	if(trackId.equals(Shipments.get(i).toString()))
        		iter=i;
        	else iter=-1;
        } 
    	Shipments.get(iter).changeStatus(situation);
    }
}

