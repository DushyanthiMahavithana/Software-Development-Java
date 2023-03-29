package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class ClassesSolution {

    public static void main(String[] args) throws FileNotFoundException {

        Passenger guest = new Passenger("empty", "empty", 0);

        Cabin[][] room = new Cabin[12][3];
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                room[x][y] = new Cabin(guest);
            }
        }

        CabinMenu(room, guest);

    }

    public static void CabinMenu(Cabin[][] room, Passenger guest) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------Menu System-------------------");
        System.out.println("V =  View All Cabins");
        System.out.println("A =  Add Customer to Cabin");
        System.out.println("E =  Display Empty Cabins");
        System.out.println("D =  Delete Customer from Cabin");
        System.out.println("F =  Find Cabin From Customers Name");
        System.out.println("S =  Store Program Data Into File");
        System.out.println("L =  Load Program Data From File");
        System.out.println("O =  View Passengers Ordered Alphabetically By Name");
        System.out.println("T =  Total Expenses");
        System.out.println("------------------------------------------------");
        while (true) {
            System.out.print("\nInput your selection(V/A/E/D/F/S/L/O/T): ");
            String selection = input.next();
            selection = selection.toUpperCase(); //convert all input letters to capital letters
            if (selection.equals("A")) {
                System.out.println("-----Add customer to cabin-----");
                AddCustomerCabin(room, guest);
            } else if (selection.equals(("V"))) {
                System.out.println("----view all cabins-----");
                ViewAllCabins(room, guest);
            } else if (selection.equals(("E"))) {
                System.out.println("----Display empty cabins----");
                EmptyCabins(room, guest);
            } else if (selection.equals(("D"))) {
                System.out.println("----Delete customer from cabin---");
                DeleteCabins(room, guest);
            } else if (selection.equals(("F"))) {
                System.out.println("----Find Cabin from customers name----");
                FindCabin(room, guest);
            } else if (selection.equals("S")) {
                System.out.println("----Store program data into file----");
                StoreData(room, guest);
            } else if (selection.equals(("L"))) {
                System.out.println("----Load program data from file----");
                LoadData(room, guest);
            } else if (selection.equals(("O"))) {
                System.out.println("-----Ordered passengers alphabetically by name----");
                OrderedPassengers(room, guest);
            }else  if(selection.equals("T")){
                TotalExpenses(room, guest);
            } else if (selection.equals("Q")) {
                System.out.println("End\nThank you!!!");
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void AddCustomerCabin(Cabin[][] room, Passenger guest) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter passenger number: ");
        int num = input.nextInt();
        System.out.println("Enter cabin number: ");
        int num2 = input.nextInt();
        if (room[num2][num].getGuest().equals(guest)) {
            System.out.println("Enter firstname: ");
            String firstname = input.next();
            System.out.println("Enter surname: ");
            String surname = input.next();
            room[num2][num].setGuest(new Passenger(firstname, surname, 1000));
        } else {
            System.out.println("cabin is full");
        }
    }

    public static void ViewAllCabins(Cabin[][] room, Passenger guest) {
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.println("cabin no - " + x + " guest " + y + room[x][y].getGuest());
            }
        }
    }

    public static void EmptyCabins(Cabin[][] room, Passenger guest) {
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                if (room[x][y].getGuest().equals(guest)) {
                    System.out.println("cabin" + x + " guest" + y + room[x][y].getGuest());
                }
            }
        }
    }

    public static void DeleteCabins(Cabin[][] room, Passenger guest) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your passenger number: ");
        int num = input.nextInt();
        System.out.println("Enter your cabin number: ");
        int num2 = input.nextInt();
        System.out.println("deleted cabin"+" "+num2 + " Passenger"+" "+num+":"+ room[num2][num].getGuest());
        room[num2][num].setGuest(guest);
    }

    public static void FindCabin(Cabin[][] room, Passenger guest) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstname = input.nextLine();
        for (int x = 0; x < room.length; x++) {
            for (int y = 0; y < 3; y++) {
                if (room[x][y].getGuest().getFirstname().equals(firstname)) {
                    System.out.println(firstname + " booked cabin number " + x + " Passenger " + y);
                }
            }
        }
    }

    public static void StoreData(Cabin[][] room, Passenger guest) throws FileNotFoundException {
        PrintWriter file = new PrintWriter("StoreCabinData2.txt");
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                file.println("cabin no-" + x + " Passenger no- " + y + room[x][y].getGuest());
            }
        }
        System.out.println("successfully stored the data.....");
        file.close();
    }
    public static void LoadData(Cabin[][] room, Passenger guest) throws FileNotFoundException {
        File file = new File("C:\\Users\\DELL\\Desktop\\task2\\StoreCabinData2.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
    public static void OrderedPassengers(Cabin[][] room, Passenger guest){
        ArrayList<String> array2= new ArrayList<String>();    //creating arraylist
        for (int i=0; i<12; i++) {
            for (int j = 0; j < 3; j++) {
                String name = room[i][j].getGuest().getFirstname();
                if (!Objects.equals(name, "empty")) {
                    array2.add(name);
                }
            }
        }
        Collections.sort(array2);
        System.out.println(array2);
    }
    public static void TotalExpenses(Cabin[][] room, Passenger guest){
        int total=0;
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 3; y++) {
                int expensepsgn = room[x][y].getGuest().getExpenses();
                if (expensepsgn>0){
                    System.out.println(room[x][y].getGuest());
                    total += expensepsgn;
                }
            }
        }
        System.out.println("Total is "+total);
    }
}





