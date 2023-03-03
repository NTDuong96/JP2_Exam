/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tsuki-no-Ame
 */
public class LoadMain {
    public static void main(String[] args) {
        StudentList stl = new StudentList();
        boolean loadResult = stl.loadDataFromFile();
        if(loadResult)
        {
            System.out.println("Completed");
            System.out.println("Students List");
            stl.DisplayList();
        }
        else
            System.out.println("Error writing file");
    }
}
