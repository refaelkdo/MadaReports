public class MadaReportConverter extends ConvertToClass{
    @Override
    public Object convert(String[] line) {
        return new MadaObject().convertToClass(line);
    }
}
