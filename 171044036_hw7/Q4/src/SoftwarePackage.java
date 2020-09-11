import java.math.BigDecimal;

/**
 * My class to keep software informations
 */
public class SoftwarePackage implements Comparable<SoftwarePackage> {
    //Data Fields
    /**
     * name of package and version
     */
    protected String packageNameVersion;
    /**
     * the price of ppackage as big decimal
     */
    protected BigDecimal packagePrice;
    /**
     * the number of package
     */
    protected int packageQuantity;

    /**
     * COnstructor
     * @param name name of package with version
     * @param price price of package
     * @param quantity number of package
     */
    public SoftwarePackage(String name, BigDecimal price, int quantity){
        packageNameVersion = name;
        packagePrice = price;
        packageQuantity = quantity;
    }

    /**
     * Getter of name
     * @return name of package
     */
    public String getPackageNameVersion() {
        return packageNameVersion;
    }

    /**
     * getter of price
     * @return returns price as big decimal
     */
    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    /**
     * number of package
     * @return integer
     */
    public int getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * Overrided compareto method to use  compare with linkedlist elements
     * it copares according to names
     * @param softwarePackage takes Software package as parameter
     * @return returns 0 if equals otherwise leesthan -1 biggerthan +1
     */
    @Override
    public int compareTo(SoftwarePackage softwarePackage) {
        return packageNameVersion.compareTo(softwarePackage.packageNameVersion);
    }

    /**
     * to print software informations
     * @return information as string
     */
    @Override
    public String toString() {
        return "SoftwarePackage\n" +
                "Software Name and Version=" + packageNameVersion + '\n' +
                "Price " + packagePrice.doubleValue() + '\n' +
                "Quantity=" + packageQuantity + '\n' ;
    }

    /**
     * setter of name
     * @param packageNameVersion given name with version
     */
    public void setPackageNameVersion(String packageNameVersion) {
        this.packageNameVersion = packageNameVersion;
    }

    /**
     * setter for price
     * @param packagePrice given price as big decimal
     */
    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    /**
     * setter for quantitiy
     * @param packageQuantity number of quantity as integer
     */
    public void setPackageQuantity(int packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
}
