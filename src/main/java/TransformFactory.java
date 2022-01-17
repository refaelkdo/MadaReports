import health_care_provider.errors.InvalidIdException;

import java.util.List;

public abstract class TransformFactory {
    protected ValidateData validateData;

    public abstract List<String[]> transform(List<String[]> data) throws InvalidIdException;

    public TransformFactory(ValidateData validateData) {
        this.validateData = validateData;
    }
}
