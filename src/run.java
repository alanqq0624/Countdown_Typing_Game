import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class run {

    private static void TypingGame(){
        System.out.println("In Typing Game");

        File file_list = new File("res/typing_game_word_list.txt");
        Scanner input_list;
        ArrayList<String> word_list = new ArrayList();
        int rand ;
        String ans = new String();
        Scanner input_scanner = new Scanner(System.in);
        String input_string = new String();

        try {
            input_list = new Scanner(file_list);
        } catch (Exception e) {
            System.out.println("File typing_game_word_list.txt not exist.");
            e.printStackTrace();
            input_scanner.close();
            return;
        }
        
        while (input_list.hasNextLine()) {
            String str = input_list.nextLine();
            word_list.add(str);
        }
        input_list.close();
        System.out.println("Word list: ");
        for(String str : word_list){
            System.out.println(str);
        }

        while (true) {
            rand = (int)(Math.random()*word_list.size());
            ans = word_list.get(rand);
            System.out.println("\n"+ans);
            input_string = input_scanner.nextLine();
            if (input_string.equals(ans)) {
                System.out.println("Correct!!!");
            }
            else if (input_string.equals("end")) {
                input_list.close();
                input_scanner.close();
                return;
            }
            else{
                System.out.println("Wrong!!!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input_scanner = new Scanner(System.in);
        String input_string = new String();
        while (true) {
            input_string = input_scanner.nextLine();
            System.out.println(input_string);
            if (input_string.equals("typing")) {
                TypingGame();
            }
            else if (input_string.equals("end")) {
                input_scanner.close();
                return;
            }
        }
    }

}