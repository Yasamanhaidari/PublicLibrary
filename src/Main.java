import java.util.Scanner;

public class Main {
    public static final int MAX_MEMBERS = 5;
    public static long[] MemberID=new long[MAX_MEMBERS];
    public static String[] MemberName=new String[MAX_MEMBERS];
    public static int[] MemberAge=new int[MAX_MEMBERS];
    public static String[] MemberGender=new String[MAX_MEMBERS];
    public static int numMembers = 0;



    public static void main(String[] args) {
        System.out.println("Hello, welcome to the library!");
        System.out.println("Enter 1 go Main menu:");
        Scanner input=new Scanner(System.in);
        int FirstValue= input.nextInt();
        if (FirstValue==1)
            menu();
        else System.out.println("Bye!");
    }
    public static void menu(){
        Scanner input=new Scanner(System.in);
        int choice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1-New Member");
            System.out.println("2-Show Member");
            System.out.println("3-Edit information of Member");
            System.out.println("4-Delete Member");
            System.out.println("5-Exit");
            System.out.println("What you want to do?");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    NewMember();
                    break;
                case 2:
                    System.out.println("Enter Member ID:");
                    long inputMemberID = input.nextLong();
                    ShowMember(inputMemberID);
                    break;
                case 3:
                    System.out.println("Enter Member ID:");
                    long memberID = input.nextLong();
                    EditInformation(memberID);
                    break;
                case 4:
                    System.out.println("Enter Member ID:");
                    memberID = input.nextLong();
                    DeleteMember(memberID);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }while (true);
    }
    public static void NewMember(){
        if (numMembers >= MAX_MEMBERS) {
            System.out.println("Maximum number of members reached.");
            return;
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("Define a 6-digit ID for it");
        MemberID[numMembers]= scanner.nextLong();
        System.out.println("Enter Name:");
        MemberName[numMembers]= scanner.next();
        System.out.println("Enter Gender with F OR M");
        MemberGender[numMembers]=scanner.next();
        System.out.println("Enter Age of Member");
        MemberAge[numMembers]= scanner.nextInt();
        numMembers++;
        System.out.println("Member added successfully.");
        scanner.nextLine();
    }
    public static int findMemberIndex(long memberID) {
        for (int i = 0; i < numMembers; i++) {
            if (MemberID[i] == memberID) {
                return i;
            }
        }
        return -1;
    }
    public static void ShowMember(long memberID) {
        int index = findMemberIndex(memberID);
        if (index == -1) {
            System.out.println("Member not found.");
            return;
        }
        System.out.println("Member ID: " + MemberID[index]);
        System.out.println("Member Name: " + MemberName[index]);
        System.out.println("Member Gender: " + MemberGender[index]);
        System.out.println("Member Age: " + MemberAge[index]);
    }
    public static void EditInformation(long memberID) {
        int index = findMemberIndex(memberID);
        if (index == -1) {
            System.out.println("Member not found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new Name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new Gender (F/M):");
        String newGender = scanner.nextLine();
        System.out.println("Enter new Age:");
        int newAge = scanner.nextInt();
        MemberName[index] = newName;
        MemberGender[index] = newGender;
        MemberAge[index] = newAge;
        System.out.println("Member information updated successfully.");
    }
    public static void DeleteMember(long memberID) {
        int index = findMemberIndex(memberID);
        if (index == -1) {
            System.out.println("Member not found.");
            return;
        }
        for (int i = index; i < numMembers - 1; i++) {
            MemberID[i] = MemberID[i + 1];
            MemberName[i] = MemberName[i + 1];
            MemberGender[i] = MemberGender[i + 1];
            MemberAge[i] = MemberAge[i + 1];
        }
        MemberID[numMembers - 1] = 0;
        MemberName[numMembers - 1] = null;
        MemberGender[numMembers - 1] = null;
        MemberAge[numMembers - 1] = 0;
        numMembers--;
        System.out.println("Member deleted successfully.");
    }
}