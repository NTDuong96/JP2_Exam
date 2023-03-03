
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tsuki-no-Ame
 */
public class StudentList {
    Vector<Students> list;

    public StudentList() {
        this.list = new Vector<Students>();
    }

    public void InputStudent()
    {
        Students st = new Students();
        st.Input();
        list.add(st);
    }
    //Display list
    public void DisplayList()
    {
        System.out.println("Enroll ID \t\tFull name \t\t Age");
        System.out.println("----------\t\t--------- \t\t -----");
        for(int i=0; i<list.size();i++)
        {
            list.get(i).Display();
        }
    }
    
    //2. Save entered students to data file
    public boolean saveToFile(){
        if(list.isEmpty())
            return false;
        String filename;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path:");
        filename = sc.nextLine();
        //Writing data from list to file
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            
            oos.writeInt(list.size());
            //Write Students objects to File
            for(int i=0; i<list.size();i++)
            {
                oos.writeObject(list.get(i));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            System.out.println("Error writing data");
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            
            try {
                    if(oos!=null)
                        oos.close();
                    if(fos!=null)
                        fos.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    public boolean loadDataFromFile()
    {
        String filename;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path:");
        filename = sc.nextLine();
        
        //Clear old list (if exists)
        list.clear();
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            
            int n = ois.readInt();
            //Reading Students objects from File
            for(int i=0; i<n;i++)
            {
                Students st = (Students)ois.readObject();
                list.add(st);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (IOException ex) {
            System.out.println("Error reading file");
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                    if(ois!=null)
                        ois.close();
                    if(fis!=null)
                        fis.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
