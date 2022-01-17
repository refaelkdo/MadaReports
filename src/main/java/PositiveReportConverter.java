public class PositiveReportConverter extends ConvertToClass{
    @Override
    public Object convert(String[] line) {
        return new PositiveObject().convertToClass(line);
    }
}
