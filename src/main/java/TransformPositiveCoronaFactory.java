import health_care_provider.errors.InvalidIdException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TransformPositiveCoronaFactory extends TransformFactory
{
    private final int RESULT_TEST_INDEX = 8;
    private final int POSITIVE_RESULT = 1;
    private final int ID_INDEX_LABS = 0;
    private final int ID_LENGTH = 9;
    private final int ID_INDEX_MADA = 1;
    private List<String[]> labTests;
    public TransformPositiveCoronaFactory(ValidateData validateData, List<String[]> labTests) {
        super(validateData);
        this.labTests = labTests;
    }

    @Override
    public List<String[]> transform(List<String[]> data) throws InvalidIdException {
        ArrayList<String[]> newData = new ArrayList<>();
        labTests = labTests.stream().filter(i->Integer.parseInt(i[RESULT_TEST_INDEX]) == POSITIVE_RESULT && i[ID_INDEX_LABS].length() == ID_LENGTH).collect(Collectors.toList());
        ArrayList<String> ids = new ArrayList<>();
        labTests.stream().forEach(i->ids.add(i[ID_INDEX_LABS]));
        data = data.stream().filter(i->ids.contains(i[ID_INDEX_MADA])).collect(Collectors.toList());
        for (int i= 0; i < labTests.size(); i++)
        {
            ArrayList<String> newLine = new ArrayList<>();
            newLine.add(labTests.get(i)[indexes.IDNum.value]);
            newLine.add(labTests.get(i)[indexes.IDType.value]);
            newLine.add(labTests.get(i)[indexes.FIRST_NAME.value]);
            newLine.add(labTests.get(i)[indexes.LAST_NAME.value]);
            newLine.add(data.get(i)[indexes.CITY.value]);
            newLine.add(data.get(i)[indexes.STREET.value]);
            newLine.add(data.get(i)[indexes.BUILDING_NUMBER.value]);
            newLine.add(data.get(i)[indexes.BARCODE.value]);
            newLine.add(labTests.get(i)[indexes.BIRTH_DATE.value]);
            newLine.add(labTests.get(i)[indexes.LABCODE.value]);
            newLine.add(data.get(i)[indexes.RESULT_DATE.value]);
            newLine.add(data.get(i)[indexes.TAKE_DATE.value]);
            newLine.add(labTests.get(i)[indexes.STICKER_NUMBER.value]);
            newLine.add(labTests.get(i)[indexes.RESULT_TEST_CORONA.value]);
            newLine.add(labTests.get(i)[indexes.VARIANT.value]);
            newLine.add(labTests.get(i)[indexes.TEST_TYPE.value]);
            newData.add(newLine.toArray(String[]::new));
        }
        return newData;
    }
}


