package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    static String[] CruiseShip = new String[12];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        for (int c = 0; c < 12; c++) {
            CruiseShip[c] = " empty";
        }
        System.out.println("------------------Menu System-------------------");
        System.out.println("V =  View All Cabins");
        System.out.println("A =  Add Customer to Cabin");
        System.out.println("E =  Display Empty Cabins");
        System.out.println("D =  Delete Customer from Cabin");
        System.out.println("F =  Find Cabin From Customers Name");
        System.out.println("S =  Store Program Data Into File");
        System.out.println("L =  Load Program Data From File");
        System.out.println("O =  View Passengers Ordered Alphabetically By Name");
        System.out.println("------------------------------------------------");
        while (true) {   //repeatedly check
            System.out.print("\nInput your selection(V/A/E/D/F/S/L/O): ");
            String selection = input.next();
            selection = selection.toUpperCase();       // converts all the inputs to capital letters
            if (selection.equals("V")) {
                System.out.println("-----View all cabins-----");
                ViewAllCabins();
            } else if (selection.equals("A")) {
                System.out.println("-----Add customer to cabin-----");
                AddCustomerCabin();
            } else if (selection.equals("E")){
                System.out.println("-----Display empty cabins-----");
                EmptyCabins();
            }else if(selection.equals("D")) {
                System.out.println("-----Delete customer from cabin-----");
                DeleteCabins();
            }else if (selection.equals("F")){
                System.out.println("-----Find cabin from customers name----");
                FindCabin();
            }else if (selection.equals("S")){
                System.out.println("------Store program data into file-----");
                StoreData();
            }else if (selection.equals("L")){
                System.out.println("-----Load program data from file-----");
                LoadData();
            }else if (selection.equals("O")){
                System.out.println("-------View passengers ordered alphabetically by name-----");
                OrderedPassengers();
            }else if (selection.equals("Q")) {
                System.out.println("End\nTHANK YOU!!!!");
                break;
            }
        }
    }
        public static void AddCustomerCabin () {
            Scanner input = new Scanner(System.in);
            System.out.println("Select a cabin number:  ");
            try {                                                //checking correct input
                int num = input.nextInt();
                System.out.println("Enter name for cabin: ");
                String name = input.next();
                CruiseShip[num] = name;
            }catch (Exception e){                                //if not program will give an error message
                System.out.println("invalid");
            }

        }
        public static void ViewAllCabins () {
            for (int x = 0; x < 12; x++) {
                System.out.println("Cabin- "+ x +" "+CruiseShip[x]);
            }
        }
        public static void EmptyCabins() {
            for(int x= 0;x < 12;  x++){
                if(CruiseShip[x].equals(" empty")){
                    System.out.println("cabin-"+ x);
                }
            }
        }
        public static void DeleteCabins(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your cabin name: ");
            String Name = input.next();
            for(int x = 0;x <12; x++){
                if(CruiseShip[x].equals(Name)){
                    CruiseShip[x]=" empty";
                }
            }
            System.out.println("Successfully deleted....");
        }
        public static void FindCabin(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter customer name: ");
            String Name = input.next();
            for (int x = 0;x < CruiseShip.length; x++){
                if(CruiseShip[x].equals(Name)){
                    System.out.println("cabin number is: "+x);
                }
            }
        }
        public static void StoreData() throws FileNotFoundException{
            PrintWriter file = new PrintWriter("StoreCabinData.txt");
            for(int x=0; x<12; x++){
                file.println("Cabin" + x +" "+CruiseShip[x]);
            }
            file.close();
            System.out.println("Successfully stored...");
        }
        public static void LoadData() throws FileNotFoundException{
            File file = new File("C:\\Users\\DELL\\Desktop\\task1\\StoreCabinData.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()){
                System.out.println(in.nextLine());
            }
        }
        public static void OrderedPassengers(){
            String[] CruiseShip2 =new String[12];
            System.arraycopy(CruiseShip,0,CruiseShip2,0,12);
            String temp;
            for(int x = 0; x < CruiseShip2.length; x++){
                for(int y = x + 1; y < CruiseShip2.length; y++){
                    if(CruiseShip2[x].compareTo(CruiseShip2[y])>0){
                        temp = CruiseShip2[x];
                        CruiseShip2[x] = CruiseShip2[y];
                        CruiseShip2[y] = temp;
                    }
                }
            }
            for (int i=0; i<12; i++){
                if (!Objects.equals(CruiseShip2[i], " empty")){
                    System.out.println(CruiseShip2[i]);
                }
            }

        }
}



























