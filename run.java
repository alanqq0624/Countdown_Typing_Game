import java.util.*;

public class run {
    public static void main(String[] args) {
        Scanner input_Scanner = new Scanner(System.in);
        String inputString = new String();
        while (true) {
            inputString = input_Scanner.nextLine();
            System.out.println(inputString);
            if (inputString.equals("end")) {
                input_Scanner.close();
                return;
            }
        }
    }
}