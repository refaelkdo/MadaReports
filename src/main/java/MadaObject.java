import java.util.List;

public class MadaObject
{
    private String MDACode;
    private int IDNum;
    private int IDType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNum;
    private String Barcode;
    private String getDate;
    private String takeDate;
    private String resultDate;


    public MadaObject()
    {

    }

    public MadaObject convertToClass(String[] data)
    {
        return new MadaObject(data);
    }

    public MadaObject(String[] data)
    {
        this.MDACode = data[0];
        this.IDNum = Integer.parseInt(data[1]);
        this.IDType = Integer.parseInt(data[2]);;
        this.firstName = data[3];
        this.lastName = data[4];
        this.city = data[5];
        this.street = data[6];
        this.buildingNum = Integer.parseInt(data[7]);
        this.Barcode = data[8];
        this.getDate = data[9];
        this.takeDate = data[10];
        this.resultDate = data[11];
    }

    public String getMDACode() {
        return MDACode;
    }

    public void setMDACode(String MDACode) {
        this.MDACode = MDACode;
    }

    public int getIDNum() {
        return IDNum;
    }

    public void setIDNum(int IDNum) {
        this.IDNum = IDNum;
    }

    public int getIDType() {
        return IDType;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(int buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public String getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }
}
