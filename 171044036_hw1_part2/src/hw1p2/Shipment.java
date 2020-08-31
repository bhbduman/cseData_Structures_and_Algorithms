package hw1p2;




/**
 *
 *
 * My Company class has details about Company
 * It keeps the Shipments, Branches Container and the Administrator
 * @author  Baran Hasan BOZDUMAN
 * @version 1.2
 * @since   2020-03-02
 */
public class Shipment {

    /**
     *
     */
    protected Person Reciever;
    protected Person Sender;
    protected String trackId;
    protected String ShipmentStatus="not mailed";
    protected Branch whichBranch;
    /**
     * the shipment constructor each shipment must have the given parameters
     * all given prameters are type of string
     * @param givetrackId
     * @param recieverName
     * @param recieverSurname
     * @param senderName
     * @param senderSurname
     * @param shipmentStatus
     */
    public Shipment(String givetrackId,String recieverName,String recieverSurname, String senderName,String senderSurname,String shipmentStatus) {
        trackId = givetrackId;
        setCustomer(recieverName, recieverSurname, senderName, senderSurname);
        ShipmentStatus = shipmentStatus;
        //whichBranch = (Branch) nowat.clone();

    }
    /**
     * for the set reciever and sender which are extends from person class
     * @param recieverNam
     * @param recieverSurnam
     * @param senderNam
     * @param senderSurnam
     */
    public void setCustomer(String recieverNam,String recieverSurnam, String senderNam, String senderSurnam) {
        Reciever = new Person(recieverNam,recieverSurnam);
        Sender   = new Person(senderNam,senderSurnam);

    }
    /**
     * to change status of shipment the branch employee and tansportation employee can reach it
     * @param situation takes string
     */
    protected void changeStatus(String situation) {
        ShipmentStatus = situation;
    }
    /**
     * overrided to string method retuns track id
     * it uses to find object of shipment to compare with other shipments
     */
    @Override
    public String toString() {
        return trackId;
    }
    /**
     * it is used to show information about shipment to customer
     * @return returns string of the shipment information
     */
    public String showShipmentInformation() {
        String information;
        information = "Reciever________________"+Reciever.name+" "+Reciever.id+"\n"+
                "Sender__________________"+Sender.name+" "+Sender.id+"\n"+
                "Track ID________________"+trackId+"\n"+
                "Shipment Status_________"+ShipmentStatus+"\n";
        return information;
    }
}

