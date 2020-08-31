package hw1p2;


import java.util.ArrayList;

/**
 *
 * Transportation personnel class do the transportation personnel
 * it basically do the jobs like updating the shipment status
 *
 * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class TransportationPersonnel extends Person {

    /**
     * it creates new person
     */
    public TransportationPersonnel(String name,String id) {
        super(name,id);
    }
    /**
     * overrided to string method returns the id
     * @return it returns id
     */
    @Override
    public	String toString() {
        return id;
    }
    /**
     * The transportation personel can update the shipment status
     * @param Shipments takes shipments container
     * @param trackId takes string as a string
     * @param situation takes the situation as a string but it takes until to whitespace
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

