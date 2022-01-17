public class PositiveObject {
    private int idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNum;
    private String Barcode;
    private String birthDate;
    private String takeDate;
    private String resultDate;
    private String labCode;
    private String StickerNumber;
    private int resultTest;
    private String variant;
    private String testType;


    public PositiveObject()
    {

    }

    public PositiveObject convertToClass(String[] data) {
        return new PositiveObject(data);
    }

    public PositiveObject(String[] data)
    {
        this.idNum=Integer.parseInt(data[0]);
        this.idType=Integer.parseInt(data[1]);
        this.firstName=data[2];
        this.lastName=data[3];
        this.city=data[4];
        this.street=data[5];
        this.buildingNum=Integer.parseInt(data[6]);
        this.Barcode=data[7];
        this.birthDate=data[8];
        this.labCode=data[9];
        this.resultDate=data[10];
        this.takeDate=data[11];
        this.StickerNumber=data[12];
        this.resultTest=Integer.parseInt(data[13]);
        this.variant=data[14];
        this.testType=data[15];
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getStickerNumber() {
        return StickerNumber;
    }

    public void setStickerNumber(String stickerNumber) {
        StickerNumber = stickerNumber;
    }

    public int getResultTest() {
        return resultTest;
    }

    public void setResultTest(int resultTest) {
        this.resultTest = resultTest;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
