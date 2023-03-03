
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tsuki-no-Ame
 */
public class MenuMain {
    public static int Menu(){
        int choice;
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Students Manager"
                    + "\n1. Add new students\n2. Save to file"
                    +"\n3. Display students\n4. Exit"
                    +"\nPlease enter choice:");
                choice = sc.nextInt();
                return choice;
            }
            catch (java.util.InputMismatchException e){
                System.out.println("Wrong input, please retry");
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        StudentList stl = new StudentList();
        do{
            choice = Menu();
            switch(choice){
                case 1:
                    System.out.println("Enter students:");
                    String str="";
                        do{
                            stl.InputStudent();
                            System.out.println("Continue adding? (Y/N):");
                            str = sc.nextLine();
                        }while(!str.equalsIgnoreCase("n"));
                case 2:
                    boolean saveResult = stl.saveToFile();
                    if(saveResult)
                        System.out.println("Save completed!");
                    else
                        System.out.println("Error reading/saving file");
                case 3:
                    System.out.println("Students list");
                    stl.DisplayList();
                case 4:
                    System.out.println("Exit Students Manager");
                    break;
                default:
                    break;
            }
        }while(choice!=4);
    }
}
