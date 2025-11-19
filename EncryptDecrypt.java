public class EncryptDecrypt {

    public static void main(String[] args) {

        int shift = 6;                         //The shift that the cipher users
        String text = "Why is This is A test!";       //Test text that is used to test the encryption/decryption
        String encryptedText = encrypt(text,shift);

        System.out.println("The original text is: " + text);
        System.out.println("The encrypted text is: " + encryptedText);
        System.out.println("The decrypted text is: " + decrypt(encryptedText, shift));


    }

    public static String encrypt(String input, int shift) {    //Takes the text input and the designated shift and encrypts the text through a caesar cipher.

        StringBuilder string= new StringBuilder();
        String encryptedMessage;

         for (int i=0; i<input.length(); i++)
        {
            if (Character.isUpperCase(input.charAt(i)))
            {
                char ch = (char)(((int)input.charAt(i) - 'A' + shift + 26) % 26 + 'A');
                string.append(ch);
            }
            else if (Character.isLowerCase(input.charAt(i))){
            
                char ch = (char)(((int)input.charAt(i) + - 'a' + shift + 26) % 26 + 'a');
                string.append(ch);
            }
            else {
                char ch = input.charAt(i);
                string.append(ch);
            }

            

            
            }
            encryptedMessage = string.toString();
        
        return encryptedMessage;
        
    }


    public static String decrypt(String input, int shift){  //Decrypts the encrypted text using the original shift as the reference to reverse the cipher and decrypt the message.

        int reverseShift = 26 - shift ;
        String decryptedString = encrypt(input, reverseShift) ;

        return decryptedString;

    }
    }
    

