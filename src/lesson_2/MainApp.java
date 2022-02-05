package lesson_2;

public class MainApp {
    static int SIZE = 4;

    public static void main(String[] args) {

        String[][] myMass = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };
        try {
            sumArrItem(myMass);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getRow() + " " + e.getCol());
        }


    }

    static void sumArrItem(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != SIZE) {
            throw new MyArraySizeException();
        }

        for (String[] strings : arr) {
            if (strings.length != SIZE) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong data in cell " + i + ", " + j, i, j);
                }
            }
        }

        System.out.println("The sum of the elements is " + sum);
    }
}

