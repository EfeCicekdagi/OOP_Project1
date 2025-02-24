import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;

public class Main {
  
    public Main(){    //It is the empty constructor of the main class
    }
    
    public static boolean contains(int[][] scoring, int value,int scoring_lenght) {  //It is the function that finds whether id is used or not
        for (int i=0 ; i< scoring_lenght; i++) {                    //Searches the array from top to bottom to scann if there is an id in the two-dimensional array
            if (scoring[i][0] == value) {
                return true; 
            }
        }
        return false; 
    }
    
    public void entryData(LinkedList list,int[][] scoring,int scoring_lenght){  //It is the function that allows new users to enter
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your id: ");
        int id = keyboard.nextInt();
        while(contains(scoring, id, scoring_lenght)){  //Checks if the ID has been used before
            System.out.print("This id is in use, enter another id: ");
            id = keyboard.nextInt();
        }
        keyboard = new Scanner(System.in);
        System.out.print("Enter your name; ");
        String name = keyboard.nextLine();
        System.out.print("Enter your surname; ");
        String surname = keyboard.nextLine();
        System.out.print("Enter your country; ");
        String country = keyboard.nextLine();
        System.out.print("Enter your city; ");
        String city = keyboard.nextLine();
        System.out.print("Enter your occupation; ");
        String occupation = keyboard.nextLine();
        list.sortedAdd(id, name, surname, country, city, occupation);  //It makes sequential insertion in linkedliste
    }

    public int entryScore(int product_count, int[][] scoring,int id,int scoring_lenght){  //is the function that allows the new person to enter the product score
        Scanner scanner =new Scanner(System.in);            
        int total_perfect = 0 ;
        int counter = 0 ;
        
        for (int j = 0; j < product_count-1; j++) {   //The score of the first n-1 products from the new user is entered
                System.out.print("User " + (scoring_lenght + 1) + ", enter points for " + (j + 1) + ". product: ");
                scoring[scoring_lenght][j+1] = scanner.nextInt();
            }
        int perfect_point = 1000;
        int last_point = 0;  //It holds the score that the most similar person gave to the last product
        for(int i=0 ;i<scoring_lenght;i++){
            int similarity_value=0;
            for(int k=0;k<product_count-1;k++){  //Calculates the similarity score of the first n-1 products
                int difference = scoring[i][k+1] - scoring[scoring_lenght][k+1];
                similarity_value += Math.abs(difference);
            }
            if(perfect_point > similarity_value){   //It holds the most similar user's last product score.
                perfect_point = similarity_value;
                total_perfect = 0;
                counter = 0;
                last_point = scoring[i][product_count];
                total_perfect += last_point;
                counter ++;
            }
            else if(perfect_point == similarity_value){  //Calculates the final product scores of users with the same similarity value
                total_perfect += last_point;
                counter ++;
            }
            else{}
        }
        scoring[scoring_lenght][product_count]= (int)Math.floor((total_perfect/counter));  //IT adds the new user's last product score to the list
        scoring_lenght ++;
        return scoring_lenght;
    }

    public void averagePoint(int[][] scoring,int product_count,int scoring_lenght){  //Calculate the average of all customers' ratings of the products
        for(int i=1;i<product_count+1;i++){   
            int total_point = 0;
            for(int j=0; j<scoring_lenght;j++){
                total_point += scoring[j][i];
              
            }
            System.out.println((i)+". product average points: "+(total_point/scoring_lenght));
         }
    }

    public void averageTurkey(LinkedList list,int[][] scoring,int product_count,int scoring_lenght){
        ArrayList<Integer> turkey_ID =  list.avTurkey();  //Calculates the average score given to products by users living in Turkey
        for(int i=1;i <product_count+1 ;i++){             
            int total_point = 0;
            for(int j=0;j<scoring_lenght;j++){
                if(turkey_ID.contains(scoring[j][0])){
                    total_point += scoring[j][i];
                }
            }
            System.out.println("Average ratings of users living in Turkey for product "+(i)+": "+(total_point/turkey_ID.size()));
        }
    }

    public void averageNoneTurkey(LinkedList list,int[][] scoring,int product_count,int scoring_lenght){
        ArrayList<Integer> none_turkey_ID =  list.nonAvTurkey();  //Calculates the average score given to products by users dont live in Turkey
        for(int i=1;i <product_count+1 ;i++){                     
            int total_point = 0;
            for(int j=0;j<scoring_lenght;j++){
                if(none_turkey_ID.contains(scoring[j][0])){
                    total_point += scoring[j][i];
                }
            }
            System.out.println("Average ratings for product "+(i)+" by users who dont live in Turkey : "+(total_point/none_turkey_ID.size()));
        }
    }

    public void averageDoctor(LinkedList list,int[][] scoring,int product_count,int scoring_lenght){
        ArrayList<Integer> doctorID = list.doctor();   //Calculates the average score given to products by users who are doctors by profession
        for(int i=1;i < product_count+1;i++){
            int total_point = 0;
            for(int j=0;j<scoring_lenght;j++){
                if(doctorID.contains(scoring[j][0])){
                    total_point += scoring[j][i];
                }
            }
            System.out.println("Average ratings of users who are doctors to product "+(i)+": "+(total_point/doctorID.size()));
        }
    }

    public void printCustomerData(LinkedList list){  //Print customer information to the screen using the method in the linkedlist
        list.printCustomer();
    }

    public void printDoubleArray(int scoring_lenght, int[][] scoring, int product_count){      //Prints a two-dimensional array on the screen
        for(int i=0; i<scoring_lenght; i++){
            System.out.println((i + 1)+". User ");
            for(int j=0; j<product_count; j++){
                System.out.print((j + 1) + ". products rating point : " + scoring[i][j+1]);
                System.out.println(); 
            }
        }
    }

    public int printMenu(int choice){   //This is the method that print the menu information on the screen
        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.print("Press 1 to read the data in the file"+"\n"+
                             "Press 2 to enter a new user"+"\n"+
                             "Press 3 to print the average grading scores for each product on the screen"+"\n"+
                             "Press 4 to print the average grading given to the products by customers in Turkey on the screen"+"\n"+
                             "Press 5 to print on the screen the points given to the products by customers who do not live in Turkey"+"\n"+
                             "Press 6 to print the average rating points given by the doctors to the products."+"\n"+
                             "Press 7 to print customer information on the screen"+"\n"+
                             "Press 8 to print a two-dimensional array"+"\n"+
                             "Press 9 to exit the programme"+"\n");
        System.out.print("The operation you want to perform:");
        choice = scan.nextInt();
        System.out.println("--------------------------------------------------------------------------------------");
        return choice;
    }
    //Constant is created and used in switch case structure
    private static final int READ_FILE = 1;  
    private static final int ENTRY_DATA =2 ;
    private static final int AVERAGE_POINTS =3;
    private static final int AVERAGE_TURKEY = 4;
    private static final int NONE_TURKEY = 5;
    private static final int DOCTOR = 6;
    private static final int CUSTOMER_DATA = 7;
    private static final int PRINT_DOUBLE_ARRAY = 8;
    private static final int QUIT= 9;

    public static void main(String[] args) throws IOException {
        int choice = READ_FILE; //Choice is given the first value to enter the While loop.
        int product_count = 0;
        int scoring_lenght = 0;
        int id = 0;
        int[][] scoring = null;  //Create a 2-dimensional list.
        Main mainClass = new Main();  // Create an object in main class in order to call functions.
        LinkedList list = new LinkedList();
        while(choice != QUIT){
            choice = mainClass.printMenu(choice);
            switch(choice){
                case READ_FILE:
                    FileReader filereader1 = null;
                    try {
                        filereader1 =  new FileReader("Company_3.txt");
                    }
                    catch(FileNotFoundException e){
                        System.out.println("File not found.");
                        System.exit(0);
                    }
                    Scanner reader = new Scanner(filereader1);
                    String line1 = reader.nextLine();
                    String[] lines1 = line1.split(",");
                    product_count = Integer.parseInt(lines1[0]);  //This is the method that suppresses the menu information on the screen
                    scoring = new int[200][product_count+1];
                    //scoring = mainClass.readFile(filereader1,scoring,product_count,list,scoring_lenght);
                    int line_number = 0;
                    while(reader.hasNextLine()){
                        id =0;
                        if(reader.hasNextLine()){  //Saves customer information from the file in the linked list
                            String line2 = reader.nextLine();
                            String[] lines2 = line2.split(",");
                            id = Integer.parseInt(lines2[0]);
                            String name = lines2[1];
                            String surname = lines2[2];
                            String country = lines2[3];
                            String city = lines2[4];
                            String occupation = lines2[5];
                            list.sortedAdd(id, name, surname, country, city, occupation);
                        }
                        if(reader.hasNextLine()){
                            String line3 = reader.nextLine();  //saves the customer scores in the file to array
                            String[] lines3 = line3.split(",");
                            scoring[line_number][0] = id;
                            for(int j=0; j< product_count ; j++){
                                scoring[line_number][j+1] = Integer.parseInt(lines3[j]);
                            }
                            scoring_lenght ++;
                            line_number += 1;
                        }
                    }
                    System.out.println("File reading finished");
                    filereader1.close();
                    break; 
                                
                case ENTRY_DATA:  //Allows to enter a new user from the console.
                    Scanner scan1 = new Scanner(System.in);
                    int login = 1;
                    while(login == 1){
                        mainClass.entryData(list,scoring,scoring_lenght);
                        scoring_lenght = mainClass.entryScore(product_count,scoring,id,scoring_lenght);
                        System.out.println("If you want to enter a new user, press 1, if not, press a number other than 1: ");
                        login = scan1.nextInt();
                        if(scoring_lenght == 200){
                            break;
                        }
                    }
                    break;
                //They call the written methods and perform their functions
                case AVERAGE_POINTS:
                    mainClass.averagePoint(scoring,product_count,scoring_lenght);
                    break;
                case AVERAGE_TURKEY:
                    mainClass.averageTurkey(list,scoring,product_count,scoring_lenght);
                    break;
                case NONE_TURKEY:
                    mainClass.averageNoneTurkey(list, scoring, product_count,scoring_lenght);
                    break;
                case DOCTOR:
                    mainClass.averageDoctor(list,scoring,product_count,scoring_lenght);
                    break;
                case CUSTOMER_DATA:
                    mainClass.printCustomerData(list);
                    break;
                case PRINT_DOUBLE_ARRAY:
                    mainClass.printDoubleArray( scoring_lenght,scoring,product_count);
                    break;
                case QUIT:
                    choice = 9;
                    System.out.println("Exit the programm");
                    break;
            }
        } 
    }
}
