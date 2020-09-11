import java.math.BigDecimal;
import java.util.Scanner;

public class SoftwareStore {
    public static void main(String[] args){
        String adminPasswd = "fadimem";
        Scanner scan = new Scanner(System.in);
        String input="0";
        String softwareName;
        BigDecimal softwarePrice;
        SoftwarePackage currentSoftware;
        int softwareQuantity;
       // SoftwareStoreCreate store = new SoftwareStoreCreate(new BinarySearchTree());
        SoftwareStoreCreate store = new SoftwareStoreCreate(new SkipListBook());

        store.add(new SoftwarePackage("Adobe Photoshop 6.0",new BigDecimal(10.99),8));
        store.add(new SoftwarePackage("Adobe Photoshop 6.2",new BigDecimal(21.99),6));
        store.add(new SoftwarePackage("Norton 4.5",new BigDecimal(8.50),12));
        store.add(new SoftwarePackage("Norton 5.5",new BigDecimal(12.99),20));
        store.add(new SoftwarePackage("Adobe Flash 3.3",new BigDecimal(4.25),1));
        store.add(new SoftwarePackage("Adobe Flash 4.0",new BigDecimal(7.80),16));

try {

        boolean  quit = false;
        while(!quit){
            System.out.print("********WELCOME TO STORE LOGIN PANEL********\n" +
                            "1- Login as Admin\n" +
                            "2- Login as User\n" +
                            "0- Quit\n");
            input= scan.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter the password('fadimem')\n");
                    input = scan.nextLine();
                    if (input.equalsIgnoreCase(adminPasswd)) {
                        while (!quit) {
                            System.out.print("********ADMIN PANEL********\n" +
                                    "1- Add Software Package\n" +
                                    "2- Update Software Package\n" +
                                    "3- Delete Software Package\n" +
                                    "4- Show All Softwares\n" +
                                    "0- Back to Main Menu\n");
                            input = scan.nextLine();
                            switch (input) {
                                case "1":
                                    System.out.print("Enter the software name and version (Exp.: Adobe Photoshop 6.2)\n");
                                    softwareName = scan.nextLine();
                                    System.out.print("Enter the software price (Exp.: 12.25)\n");
                                    softwarePrice = scan.nextBigDecimal();
                                    System.out.print("Enter the software quantity (Exp.: 12)\n");
                                    softwareQuantity = scan.nextInt();
                                    store.add(new SoftwarePackage(softwareName, softwarePrice, softwareQuantity));
                                    break;
                                case "2":
                                    System.out.print("Enter the software name and version that you want to update (Exp.: Adobe Photoshop 6.2)\n");
                                    softwareName = scan.nextLine();
                                    currentSoftware = store.find(new SoftwarePackage(softwareName, new BigDecimal(0), 0));

                                    if (currentSoftware == null)
                                        break;

                                    System.out.print(currentSoftware);

                                    System.out.print("Enter the software new quantity (Exp.: 12)\n" +
                                            "(If you Enter '0' as quantity the software will be removed)\n");
                                    softwareQuantity = scan.nextInt();
                                    if (softwareQuantity == 0) {
                                        store.delete(currentSoftware);
                                        break;
                                    }
                                    currentSoftware.setPackageQuantity(softwareQuantity);

                                    System.out.print("Enter the software new price (Exp.: 12.25)\n");
                                    softwarePrice = scan.nextBigDecimal();
                                    currentSoftware.setPackagePrice(softwarePrice);
                                    break;
                                case "3":
                                    System.out.print("Enter the software name and version that you want to remove (Exp.: Adobe Photoshop 6.2)\n");
                                    softwareName = scan.nextLine();
                                    currentSoftware = store.find(new SoftwarePackage(softwareName, new BigDecimal(0), 0));
                                    store.delete(currentSoftware);
                                    break;
                                case "4":
                                    System.out.print(store);
                                    break;
                                case "0":
                                    System.out.print("Forwarding to Main Menu....\n");
                                    quit = true;
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                        }

                    quit = false;
                        break;
                    }else {
                        System.out.print("Wrong password\nForwarding to Main Menu....\n");
                        break;
                    }
                case "2":
                    quit=false;
                    while(!quit) {
                        System.out.print("********USER PANEL********\n" +
                                "   Search Package \n" +
                                "1- by NameVersion\n" +
                                "2- Show all Softwares\n"+
                                "0- Back to Main Menu\n");
                        input = scan.nextLine();
                        switch (input) {
                            case "1":
                                System.out.print("Enter the software name and version (Exp.: Adobe Photoshop 6.2)\n");
                                softwareName = scan.nextLine();
                                currentSoftware = store.find(new SoftwarePackage(softwareName, new BigDecimal(0), 0));
                                if (currentSoftware == null)
                                    throw new NullPointerException();
                                System.out.println(currentSoftware);
                                break;
                            case "2":
                                System.out.print(store);
                                break;
                                /*System.out.print("Enter the software quantity (Exp.: 12)\n");
                                softwareQuantity = scan.nextInt();
                                break;
                            case "3":
                                System.out.print("Enter the software price (Exp.: 12.25)\n");
                                softwarePrice = scan.nextBigDecimal();
                                break;*/
                            case "0":
                                System.out.print("Forwarding to Main Menu....\n");
                                quit=true;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                    quit = false;
                    break;
                case "0":
                    quit= true;
                    System.out.println("Exitting...");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
}catch (NullPointerException x){
    System.out.print("There is no such element");
}

    }
}
