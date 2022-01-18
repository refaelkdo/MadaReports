import health_care_provider.errors.InvalidIdException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IsProtectedFactory extends TransformFactory {
    private List<String[]> filterData;

    public IsProtectedFactory(ValidateData validateData, List<String[]> filterData) {
        super(validateData);
        this.filterData = filterData;
    }

    @Override
    public List<String[]> transform(List<String[]> data) throws InvalidIdException {
        List<String[]> newData = new LinkedList<>();
        for (String[] line: data)
        {
            if(this.validateData.validate(line))
            {
                ArrayList<String> newLine = new ArrayList<>(Arrays.stream(line).toList());
                newLine.add(isProtected(Integer.parseInt(line[8]), Integer.parseInt(line[9])));
                newData.add(newLine.toArray(String[]::new));
            }
        }
        return newData;
    }

    private String isProtected(int antidots, int kitNumber)
    {
        for (int i = 1; i < this.filterData.size(); i++)
        {
            if (kitNumber == Double.parseDouble(this.filterData.get(i)[0]))
            {
                return antidots >= Integer.parseInt(StringUtils.chop(this.filterData.get(i)[1])) ? "Y": "N";
            }
        }
        return "N";
    }
}
