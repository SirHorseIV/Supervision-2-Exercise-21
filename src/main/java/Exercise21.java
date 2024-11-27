import java.io.*;
import java.util.*;

public class Exercise21 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        ArrayList<int[]> numbersList = new ArrayList<>();
        while (line != null) {
            String[] numberStrings = line.split(",");
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].strip());
            }
            numbersList.add(numbers);
            line = br.readLine();
        }
        numbersList.sort((numbersA, numbersB) -> {
            for (int i = 0; i < numbersA.length; i++) {
                if (numbersA[i] < numbersB[i]) return -1;
                if (numbersA[i] > numbersB[i]) return 1;
            }
            return 0;
        });
        for (int[] numbers : numbersList) {
            for (int j = 0; j < numbers.length - 1; j++) {
                System.out.print(numbers[j] + ", ");
            }
            System.out.println(numbers[numbers.length - 1]);
        }
    }
}
