public class XMLConverter extends ConvertToClass{
    private String[] columnNames;
    @Override
    public Object convert(String[] line) {
        String newLine = "\t<labTest>\n";
        for(int i = 0; i < line.length; i++)
        {
            newLine += "\t\t<" + columnNames[i] + ">" + line[i] + "</" + columnNames[i] + ">\n";
        }
        newLine += "\t</labTest>\n";
        return newLine;
    }

    public XMLConverter(String[] columnNames) {
        this.columnNames = columnNames;
    }
}
