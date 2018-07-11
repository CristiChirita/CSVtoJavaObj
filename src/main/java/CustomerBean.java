import java.util.Date;

public class CustomerBean {


    private String customerNo;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String mailingAddress;
    private boolean married;
    private Integer numberOfKids;
    private String favouriteQuote;
    private String email;
    private long loyaltyPoints;

    public CustomerBean(){
//        CSVtoJavaObj csvToJava = new CSVtoJavaObj();
//        CSVtoJavaObj.Customer c = csvToJava.new Customer();

    }

    public CustomerBean(final String customerNo, final String firstName, final String lastName, final Date birthDate,
                        final String mailingAddress, final Boolean married, final Integer numberOfKids, final String favouriteQuote,
                        final String email, final long loyaltyPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.married = married;
        this.numberOfKids = numberOfKids;
        this.favouriteQuote = favouriteQuote;
        this.email = email;
        this.customerNo = customerNo;
        this.loyaltyPoints = loyaltyPoints;
        this.mailingAddress = mailingAddress;
    }
    public String getCustomerNo(){ return this.customerNo;}
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Integer getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(Integer numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavouriteQuote() {
        return favouriteQuote;
    }

    public void setFavouriteQuote(String favouriteQuote) {
        this.favouriteQuote = favouriteQuote;
    }

    public long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return String.format("CustomerBean [customerNo=%s, firstName=%s, lastName=%s, birthDate=%s, mailingAddress=%s, married=%s, numberOfKids=%s, favouriteQuote=%s, email=%s, loyaltyPoints=%s]", customerNo, getFirstName(), getLastName(), getBirthDate(), mailingAddress, isMarried(), getNumberOfKids(), getFavouriteQuote(), getEmail(), loyaltyPoints);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
        result = prime * result + (int) (loyaltyPoints ^ (loyaltyPoints >>> 32));
        result = prime * result + ((mailingAddress == null) ? 0 : mailingAddress.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj ) {
            return true;
        }
        if( !super.equals(obj) ) {
            return false;
        }
        if( !(obj instanceof CustomerBean) ) {
            return false;
        }
        CustomerBean other = (CustomerBean) obj;
        if( customerNo == null ) {
            if( other.customerNo != null ) {
                return false;
            }
        } else if( !customerNo.equals(other.customerNo) ) {
            return false;
        }
        if( loyaltyPoints != other.loyaltyPoints ) {
            return false;
        }
        if( mailingAddress == null ) {
            if( other.mailingAddress != null ) {
                return false;
            }
        } else if( !mailingAddress.equals(other.mailingAddress) ) {
            return false;
        }
        return true;
    }
}
