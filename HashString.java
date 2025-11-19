import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashString {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        int option;
        boolean validInput = false;
        String filePath = "C:\\Users\\funky\\Downloads\\hashtextexample.txt";


        
        while (!validInput) {

            System.out.println("Press 1 to convert a file to hash or two to convert an input to hash then press enter: ");
            input = scanner.nextLine();

            try{
            option = Integer.parseInt(input);
            if (option == 1) {
                try {
                    Path path = Paths.get(filePath);
                    String content = Files.readString(path);
                    byte[] hashedBytes = generateHash(content);
                    String hashString = hashToString(hashedBytes);
                    System.out.println("The pre-hashed text is: " + content);
                    System.out.println("The hash is: " + hashString);
                    validInput = true;
        }       catch (IOException e) {
                    System.err.println("Error:  " + e.getMessage());
        };
                
                break;
            }
            if (option == 2) {
                System.out.println("Please enter the text you would wish to hash. Then press enter to finish: ");
                String test = scanner.nextLine();
                byte[] hashedBytes = generateHash(test);
                String hashString = hashToString(hashedBytes);
                System.out.println("The pre-hashed text is: " + test);
                System.out.println("The hash is: " + hashString);
                validInput = true;
                break;
            }
            else {
                System.out.println("Error: " + option + " is not an option. Please enter 1 or 2 and press enter");
                input = scanner.nextLine();
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid option.");
        }
        }
    

        
        scanner.close() ;
    }

    public static byte[] generateHash(String stringToHash) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(stringToHash.getBytes());
        return hashBytes;
    }
    public static String hashToString(byte[] hashedBytes) {
        StringBuilder builtString = new StringBuilder();
        String stringToReturn = "";
        for (byte b : hashedBytes) {
            String a = Integer.toHexString(0xff & b);
            if (a.length() == 1) {
                builtString.append('0');
        }
        builtString.append(a);
        stringToReturn =  builtString.toString();

    }
    return stringToReturn;
    
}
}
