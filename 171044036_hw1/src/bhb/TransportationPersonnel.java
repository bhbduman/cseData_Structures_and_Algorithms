package bhb;


/**
 *
 * Transportation personnel class do the transportation personnel
 * it basically do the jobs like updating the shipment status
 *
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class TransportationPersonnel extends Person {

    /**
     * it creates new person
     */
    public TransportationPersonnel(String name,String surname) {
        super(name,surname);
    }
    /**
     * overrided to string method returns the name+whitespace+surname
     */
    @Override
    public	String toString() {
        return name+" "+surname;
    }
    /**
     * The transportation personel can update the shipment status
     * @param Shipments takes shipments container
     * @param trackId takes string as a string
     * @param situation takes the situation as a string but it takes until to whitespace
     */
    public void changeStatusofShipment(MyContainer<Shipment> Shipments,String trackId, String situation) {
        Shipments.find(trackId).changeStatus(situation);
    }

}

