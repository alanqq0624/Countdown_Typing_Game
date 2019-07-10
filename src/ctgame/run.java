package ctgame;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class run {

    private static void TypingGame(){
        System.out.println("In Typing Game");

        File file_list = new File("res/typing_game_word_list.txt");
        Scanner input_list;
        ArrayList<String> word_list = new ArrayList<String>();
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
            if(input_scanner.hasNextLine()){
                input_string = input_scanner.nextLine();
                if (input_string.equals(ans)) {
                    System.out.println("Correct!!!");
                }
                else if (input_string.equals("end")) {
                    System.out.println("END1");
                    input_scanner.close();
                    System.out.println("END3");
                    return;
                }
                else{
                    System.out.println("Wrong!!!");
                }
            }
            
        }
    }

    private static void DelayTime(int i){
        try{
            Thread.sleep(i);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        System.out.print("Waiting for server resopnse");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.println(".");
        DelayTime(500);
        System.out.print("IP check");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.print(".");
        DelayTime(1000);
        System.out.println("Success!!");
        DelayTime(500);
        System.out.println("Server Connected!!");
        DelayTime(1000);
        System.out.println("");
        System.out.println("Welcome to A.I. System");
        DelayTime(1000);
        System.out.println("Username: guest (Default login as a guest)");
        Scanner input_scanner = new Scanner(System.in);
        String input_string = new String();
        while (true) {
            System.out.print("Password: ");
            if (input_scanner.hasNextLine()) {
                input_string = input_scanner.nextLine();
                if (input_string.equals("typing")) {
                    System.out.println("Enter the Typing Game.");
                    TypingGame();
                }
                else if (input_string.equals("clock")) {
                    System.out.println("Enter the Clock GUI.");
                    clock cl = new clock();
                }
                else if (input_string.equals("end")) {
                    input_scanner.close();
                    return;
                }
                else if(input_string.equals("19870604")){
                    System.out.print("Login Success");
                    DelayTime(1000);
                    System.out.print(".");
                    DelayTime(1000);
                    System.out.print(".");
                    DelayTime(1000);
                    System.out.print(".");
                    DelayTime(1000);
                    
                    while (true) {
                        System.out.print("Get file: ");
                        int i = (int)(Math.random()*999999999);
                        System.out.print(i);
                        System.out.println(".log");
                    }
                }
                else{
                    System.out.println("Login Failed: Password incorrect.");
                }
            }
        }
    }

}