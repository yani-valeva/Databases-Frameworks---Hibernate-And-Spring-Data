package lastDigitName;

public class LastDigitName {
    private int number;
    private int lastDigit;

    public LastDigitName(int number) {
        this.number = number;
        this.lastDigit = Math.abs(number % 10);
    }

    public String englishNameOfDigit () {
        String englishName = "";
        switch (this.lastDigit) {
            case 0:
                englishName = "zero";
                break;
            case 1:
                englishName = "one";
                break;
            case 2:
                englishName = "two";
                break;
            case 3:
                englishName = "three";
                break;
            case 4:
                englishName = "four";
                break;
            case 5:
                englishName = "five";
                break;
            case 6:
                englishName = "six";
                break;
            case 7:
                englishName = "seven";
                break;
            case 8:
                englishName = "eight";
                break;
            case 9:
                englishName = "nine";
                break;
        }

        return englishName;
    }
}
