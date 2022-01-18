public class serologyValidateDara implements ValidateData{
    @Override
    public boolean validate(String[] line) {
        if(line.length == 10)
        {
            if(line[0].length() == 9) {
                try {
                    int idVal = Integer.parseInt(line[0]);
                    return line[6].length() == 5 ? Character.isAlphabetic(line[6].charAt(2)) && Character.isAlphabetic(line[6].charAt(3)) && Character.isDigit(line[6].charAt(0)) && Character.isDigit(line[6].charAt(1)) && Character.isDigit(line[6].charAt(4)): false;
                } catch (NumberFormatException exception) {
                    return false;
                }
            }
        }
        return false;
    }
}

