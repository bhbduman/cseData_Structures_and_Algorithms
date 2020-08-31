import bhb.*;
import java.util.Scanner;
/**
 *
 *
 * My Company program is used for the cargo autoation
 * @author  Baran Hasan BOZDUMAN
 * @version 1.0
 * @since   2020-02-23
 */
public class CargoCompProgram {
/**************************You can look up report to understand main class********************/
    public static void main(String[] args) {
        Company myCompany = new Company("UPS");
        int chosen = 1;
        String name1;
        String employeeName;
        String employeeSurname;
        String nameSurname;
        @SuppressWarnings("resource")
        Scanner input= new Scanner(System.in);
        @SuppressWarnings("resource")
        Scanner inputString= new Scanner(System.in);
        while(chosen!=0){
            System.out.println("1- Login as Admin ");
            System.out.println("2- Login as Branch Employee");
            System.out.println("3- Login as Transportation Personel");
            System.out.println("4- Login as Customer");
            System.out.println("0- EXIT ");
            System.out.println("Please enter your choice:");
            chosen = input.nextInt();

            while(chosen>4 || chosen<0) {
                System.out.println("Try a valid choice!!!");
                System.out.println("Please enter your choice:");
                chosen = input.nextInt();
            }
            switch (chosen) {
                case 1:
                    System.out.println("Welcome "+myCompany.getAdministrator() );
                    System.out.println("1- Add a branch");
                    System.out.println("2- Remove a branch");
                    System.out.println("3- Add a branchemployee");
                    System.out.println("4- Remove a branch employee");
                    System.out.println("5- Add a transportation personel");
                    System.out.println("6- Remove a transportation personnel");
                    System.out.println("7- Show all getBranches(),personnel,shipments");
                    System.out.println("Enter your choice:");
                    chosen = input.nextInt();
                    switch (chosen) {
                        case 1:
                            System.out.println("Enter Branch Name that you want to add");
                            name1 = inputString.next();
                            Branch newBranch = new Branch(name1);
                            myCompany.getAdministrator().addBranch(myCompany.getBranches(), newBranch);
                            break;
                        case 2:

                            System.out.println("Enter Branch Name that you want to remove");
                            System.out.println(myCompany.getBranches());
                            if(myCompany.getBranches().getSize() != 0) {
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);
                                myCompany.getAdministrator().deleteBranch(myCompany.getBranches(), myCompany.getBranches().find(name1));
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;
                        case 3:
                            if(myCompany.getBranches().getSize() != 0) {
                                System.out.println("Enter Branch Name to add a Branch  Emoloyee:");
                                System.out.println(myCompany.getBranches());
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                System.out.println(myCompany.getBranches().find(name1).getBranchEmployees());

                                System.out.println("Enter name BranchEmployee:");
                                employeeName = inputString.next();

                                System.out.println("Enter surname BranchEmployee:");
                                employeeSurname = inputString.next();

                                BranchEmployee newEmployee= new BranchEmployee(employeeName,employeeSurname);
                                myCompany.getAdministrator().addBranchEmployee(myCompany.getBranches(), myCompany.getBranches().find(name1), newEmployee);
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;
                        case 5:
                            if(myCompany.getBranches().getSize() != 0) {
                                System.out.println("Enter Branch Name to add a Transportation Personel:");
                                System.out.println(myCompany.getBranches());
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);
                                System.out.println(myCompany.getBranches().find(name1).getTransporterPersonnels());

                                System.out.println("Enter name transportation Personel:");
                                employeeName = inputString.next();

                                System.out.println("Enter surname transportation Personel:");
                                employeeSurname = inputString.next();

                                TransportationPersonnel newTranspEmployee= new TransportationPersonnel(employeeName,employeeSurname);
                                myCompany.getAdministrator().addTransportationPersonnel(myCompany.getBranches(), myCompany.getBranches().find(name1), newTranspEmployee);
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");

                            break;
                        case 4:
                            if(myCompany.getBranches().getSize() != 0 ) {
                                System.out.println("Enter Branch Name to remove a Branch  Emoloyee:");
                                System.out.println(myCompany.getBranches());
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                if(myCompany.getBranches().find(name1).getBranchEmployees().getSize() != 0 ) {
                                    System.out.println(myCompany.getBranches().find(name1).getBranchEmployees());
                                    do{
                                        System.out.println("Enter a Branch Employee Name");
                                        employeeName = inputString.next();
                                        System.out.println("Enter a Branch Employee Surame");
                                        employeeSurname = inputString.next();
                                        nameSurname = employeeName+" "+employeeSurname;
                                    }while(myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname) == null);

                                    myCompany.getAdministrator().deleteBranchEmployee(myCompany.getBranches(), myCompany.getBranches().find(name1), myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname));
                                }
                                else
                                    System.out.println("You are forwarding to menu there is not any Branch Employee");
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;
                        case 6:
                            System.out.println(myCompany.getBranches());
                            if(myCompany.getBranches().getSize() != 0 ) {
                                System.out.println("Enter Branch Name to remove a Transportation Personel:");
                                System.out.println(myCompany.getBranches());
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                System.out.println(myCompany.getBranches().find(name1).getTransporterPersonnels());
                                if(myCompany.getBranches().find(name1).getTransporterPersonnels().getSize() != 0 ) {
                                    do{
                                        System.out.println("Enter a Transporter Personel Name");
                                        employeeName = inputString.next();
                                        System.out.println("Enter a Transporter Personel Surame");
                                        employeeSurname = inputString.next();
                                        nameSurname = employeeName+" "+employeeSurname;
                                    }
                                    while(myCompany.getBranches().find(name1).getTransporterPersonnels().find(nameSurname) == null);

                                    myCompany.getAdministrator().deleteTransportationPersonnel(myCompany.getBranches(), myCompany.getBranches().find(name1), myCompany.getBranches().find(name1).getTransporterPersonnels().find(nameSurname));
                                }
                                else
                                    System.out.println("You are forwarding to menu there is not any Transportation Personnel");
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;
                        case 7:
                            //System.out.println(myCompany);
                            System.out.println("This exstra feature is not available for this version");
                            System.out.println("Bugs will be fixed in next version");
                        	break;


                        default:
                            System.out.println("Exitting to main menu");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1- Change shipment status");
                    System.out.println("2- Add new shipment");
                    System.out.println("3- Remove a shipment");
                    System.out.println("Enter your choice:");
                    chosen = input.nextInt();
                    switch (chosen) {
                        case 1:
                            System.out.println(myCompany.getBranches());
                            if(myCompany.getBranches().getSize() != 0 ) {
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                System.out.println(myCompany.getBranches().find(name1).getBranchEmployees());
                                if(myCompany.getBranches().find(name1).getBranchEmployees().getSize() != 0 ) {
                                    do{
                                        System.out.println("Enter a Branch Employee Name");
                                        employeeName = inputString.next();
                                        System.out.println("Enter a Branch Employee Surame");
                                        employeeSurname = inputString.next();
                                        nameSurname = employeeName+" "+employeeSurname;
                                    }while(myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname) == null);

                                    String givetrackID;
                                    if(myCompany.getShipments().getSize() != 0) {
                                        do{
                                            System.out.println("Enter the Track ID");
                                            givetrackID = inputString.next();
                                        }
                                        while( myCompany.getShipments().find(givetrackID) == null);

                                        System.out.println("Enter the status of shipment");
                                        String situation = inputString.next();

                                        myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname).changeStatusofShipment(myCompany.getShipments(), givetrackID, situation);
                                    }
                                    else
                                        System.out.println("You are forwarding to menu there is not any Shipment");
                                }
                                else
                                    System.out.println("You are forwarding to menu there is not any Branch Employee");

                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");


                            break;
                        case 2:
                            System.out.println(myCompany.getBranches());
                            if(myCompany.getBranches().getSize() != 0 ) {
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                System.out.println(myCompany.getBranches().find(name1).getBranchEmployees());
                                if(myCompany.getBranches().find(name1).getBranchEmployees().getSize() != 0 ) {
                                    do{
                                        System.out.println("Enter a Branch Employee Name");
                                        employeeName = inputString.next();
                                        System.out.println("Enter a Branch Employee Surame");
                                        employeeSurname = inputString.next();
                                        nameSurname = employeeName+" "+employeeSurname;
                                    }while(myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname) == null);

                                    System.out.println("Enter the Track ID");
                                    String givetrackId1 = inputString.next();

                                    System.out.println("Enter the Sender Name");
                                    String senderName = inputString.next();
                                    System.out.println("Enter the Sender Surname");
                                    String senderSurname = inputString.next();

                                    System.out.println("Enter the Reciever Name");
                                    String recieverName = inputString.next();
                                    System.out.println("Enter the Reciever Surame");
                                    String recieverSurname = inputString.next();

                                    System.out.println("Enter the Shipment Status");
                                    String shipmentStatus = inputString.next();

                                    Shipment newShipment =new Shipment(givetrackId1, recieverName, recieverSurname, senderName, senderSurname, shipmentStatus);

                                    myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname).addShipment(myCompany.getShipments(), newShipment);
                                }
                                else
                                    System.out.println("You are forwarding to menu there is not any Branch Employee");
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;
                        case 3:
                            System.out.println(myCompany.getBranches());
                            if(myCompany.getBranches().getSize() != 0 ) {
                                do{
                                    System.out.println("Enter a Branch Name");
                                    name1 = inputString.next();
                                }
                                while(myCompany.getBranches().find(name1) == null);

                                System.out.println(myCompany.getBranches().find(name1).getBranchEmployees());
                                do{
                                    System.out.println("Enter a Branch Employee Name");
                                    employeeName = inputString.next();
                                    System.out.println("Enter a Branch Employee Surame");
                                    employeeSurname = inputString.next();
                                    nameSurname = employeeName+" "+employeeSurname;
                                }while(myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname) == null);

                                System.out.println(myCompany.getShipments());
                                if(myCompany.getShipments().getSize() != 0) {
                                    String trackId;
                                    do {
                                        System.out.println("Enter the Track ID of shipment that you want to remove ");
                                        trackId = inputString.next();
                                    }while( myCompany.getShipments().find(trackId) == null);

                                    myCompany.getBranches().find(name1).getBranchEmployees().find(nameSurname).deleteShipment(myCompany.getShipments(), myCompany.getShipments().find(trackId));
                                }
                                else
                                    System.out.println("You are forwarding to menu there is not any Shipments");
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Branch");
                            break;

                        default:
                            System.out.println("Exitting to main menu");
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Update shipment status ");

                    System.out.println(myCompany.getBranches());
                    if(myCompany.getBranches().getSize() != 0 ) {
                        do{
                            System.out.println("Enter a Branch Name");
                            name1 = inputString.next();
                        }
                        while(myCompany.getBranches().find(name1) == null);

                        System.out.println(myCompany.getBranches().find(name1).getTransporterPersonnels());
                        if(myCompany.getBranches().find(name1).getTransporterPersonnels().getSize() != 0 ) {
                            do{
                                System.out.println("Enter a Transporter Personel Name");
                                employeeName = inputString.next();
                                System.out.println("Enter a Transporter Personel Surame");
                                employeeSurname = inputString.next();
                                nameSurname = employeeName+" "+employeeSurname;
                            }
                            while(myCompany.getBranches().find(name1).getTransporterPersonnels().find(nameSurname) == null);

                            System.out.println(myCompany.getShipments());
                            if(myCompany.getShipments().getSize() != 0) {
                                String trackID;

                                do{
                                    System.out.println("Enter the Track ID");
                                    trackID = inputString.next();
                                }
                                while( myCompany.getShipments().find(trackID) == null);

                                System.out.println("Enter the status of shipment");
                                String situation = inputString.next();

                                myCompany.getBranches().find(name1).getTransporterPersonnels().find(nameSurname).changeStatusofShipment(myCompany.getShipments(), trackID, situation);
                            }
                            else
                                System.out.println("You are forwarding to menu there is not any Shipments");
                        }
                        else
                            System.out.println("You are forwarding to menu there is not any Transportation Personnel");

                    }
                    else
                        System.out.println("You are forwarding to menu there is not any Branch");

                    break;
                case 4:
                    String id;
                    if(myCompany.getShipments().getSize() != 0) {
                        do{
                            System.out.println("Enter your track id:");
                            id = inputString.next();
                        }
                        while(myCompany.getShipments().find(id) == null);

                        System.out.println(myCompany.getShipments().find(id).showShipmentInformation());
                    }
                    else
                        System.out.println("You are forwarding to menu there is not any Shipments");

                    break;
                case 0:
                    System.out.println("Exitting...");
                    break;

                default:
                    break;
            }
        }

    }

}

