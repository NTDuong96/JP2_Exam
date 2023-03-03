
import java.io.Serializable;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tsuki-no-Ame
 */
//1. Creating Students class
public class Students implements Serializable{
    String EnrollID;
    String FirstName;
    String LastName;
    int Age;

    public Students() {
    }

    public Students(String EnrollID, String FirstName, String LastName, int Age) {
        this.EnrollID = EnrollID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
    }

    public String getEnrollID() {
        return EnrollID;
    }

    public void setEnrollID(String EnrollID) {
        this.EnrollID = EnrollID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enroll ID:");
        this.EnrollID = sc.nextLine();
        System.out.println("Firstname:");
        this.FirstName = sc.nextLine();
        System.out.println("Lastname:");
        this.LastName = sc.nextLine();
        System.out.println("Age:");
        this.Age = sc.nextInt();
    }
    public void Display()
    {
        System.out.println(this.EnrollID + "\t\t\t" 
                + this.LastName + " " + this.FirstName + "\t\t\t" 
                + this.Age);
    }
    
}
