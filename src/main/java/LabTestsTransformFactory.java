import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabTestsTransformFactory extends TransformFactory{
    private HealthCareInfoProvider healthCareInfoProvider;
    private final int ID_NUMBER = 0;
    private final int ID_TYPE = 1;
    @Override
    public List<String[]> transform(List<String[]> data) throws InvalidIdException {
        ArrayList<String[]> transformedData = new ArrayList<>();
        int numLines = 0;
        for(String[] line: data)
        {
            if(numLines != 0)
            {
                ArrayList<String> newLine = new ArrayList<>(Arrays.asList(line));
                //if the necessary information is correct we can add the data.
                if(this.validateData.validate(line))
                {
                    PersonInsured personInsured = this.healthCareInfoProvider.fetchInfo(Integer.parseInt(line[ID_NUMBER]), Integer.parseInt(line[ID_TYPE]));
                    newLine.add(personInsured.getJoinDate().toString());
                    newLine.add(String.valueOf(personInsured.getHealthCareId()));
                    newLine.add(personInsured.getHealthCareName());
                }
                else {
                    newLine.add(null);
                    newLine.add(null);
                    newLine.add(null);
                }
                transformedData.add(newLine.toArray(String[]::new));
            }
            numLines++;
        }
        return transformedData;
    }


    public LabTestsTransformFactory(ValidateData validateData) {
        super(validateData);
        this.healthCareInfoProvider = new HealthCareInfoProvider();
    }
}
