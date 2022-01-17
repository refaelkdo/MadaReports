public class LabValidateData implements ValidateData
{
    private final int ID_LENGTH = 9;
    private final int ID_NUMBER_INDEX = 0;
    @Override
    public boolean validate(String[] line) {
        return line[ID_NUMBER_INDEX].length() == ID_LENGTH;
    }
}
