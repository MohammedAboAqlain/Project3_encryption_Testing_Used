/*
 * Usama R. Al Zayan
 * Mohammed N. Abo Aqlain
 * Ali J. Barghot
 */
package project3;

import java.util.Scanner;
public class Project3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder Records = new StringBuilder();
        int count = 0;
        System.out.print("===================SECURITY SERVICES===================\n\n");
        while (true) {
            
            //Display the security service and take the number of service from the user
            SECURITY_SERVICES();
            
            int serviceNumber = input.nextInt();
            
            //display the End of Service
            if (serviceNumber == 0) {
                System.out.println("---------------------End of Service---------------------");
                break;
            }
            //display the records
            if (serviceNumber == 3) {
                // In case there is no service to print them
                if (count == 0){
                    System.out.println("\n========================================================\n"
                    +"\nNo services yet!!\n"
                    +"\n========================================================\n"
                    +"\n********************************************************\n\n");
                    continue;
                }
                System.out.println("\n===================SERVICES COMPLETED===================\n"
                +Records
                +"\n========================================================");
                continue;
            }
            // In case there is Invalid Input
            while (0 <= serviceNumber && serviceNumber >= 4){
                System.out.println("\n********************************************************\n"
                + "Invalid Input!\n\n"
                +"********************************************************\n");
                SECURITY_SERVICES();
                serviceNumber = input.nextInt();
            }
            
            // display the Techniques Menu
            TechniquesMenu();
            
            int serviceNumber2 = input.nextInt();
            
            // In case there is Invalid Input
            while (0 <= serviceNumber2 && serviceNumber2 >= 4){
                System.out.println("\n********************************************************\n"
                + "Invalid Input!\n\n"
                +"********************************************************\n");
                TechniquesMenu();
                serviceNumber2 = input.nextInt();
            }
            System.out.println("\n********************************************************\n");

            //ciphering
            if (serviceNumber == 1) {
                System.out.print("Enter the text to ciphered: ");
                String str1 = input.next();
                String str2 = input.nextLine();
                String str = str1 + str2;// هذه الخطوة أتت عن طريق التجريب 
                String result = switching(serviceNumber, serviceNumber2, str);
                count++;
                Records.append(count).append(". ").append(str).append(" has been ciphered using ").append(key(serviceNumber2)).append(" to: ").append(result).append("\n");
            }
            //deciphering
            if (serviceNumber == 2) {
                System.out.print("Enter the text to deciphered: ");
                String str1 = input.next();
                String str2 = input.nextLine();
                String str = str1 + str2;// هذه الخطوة أتت عن طريق التجريب 
                String result = switching(serviceNumber, serviceNumber2, str);
                count++;
                Records.append(count).append(". ").append(str).append(" has been deciphered using ").append(key(serviceNumber2)).append(" to: ").append(result).append("\n");
            }
            
            
            System.out.println("\n********************************************************\n");
        }
    }
    // Service routing process
    public static String switching(int n1, int n2, String str){
        switch (n1) {
            case 1 : 
                //ciphering
                System.out.print(str + " has been ciphered using " + key(n2) + " to: ");
                switch (n2) {
                    case 1 : return ATBASH(str);
                    case 2 : return HexadecimalCiphering(str);
                    case 3 : return VigenereCiphering(str);
                    default: return "*";
                }
            case 2 :
                //deciphering
                System.out.print(str + " has been deciphered using " + key(n2) + " to: ");
                switch (n2) {
                    case 1 : return ATBASH(str);
                    case 2 : return HexadecimalDeciphering(str);
                    case 3 : return VigenereDeciphering(str);
                    default: return "*";
                }
            default: return "*";
        }
        
    }
    // Print the service name
    public static String key(int num) {
        switch (num) {
            case 1 : return "ATBASH";
            case 2 : return "Hexadecimal";
            case 3 : return "Vigenere";
            default : return "*";
        }
    }
    // Print the SECURITY SERVICES
    public static void SECURITY_SERVICES() {
        System.out.print("Services Menu\n"
        + "1 - Ciphering Text\n"
        + "2 - Deciphering Text\n"
        + "3 - Records\n"
        + "0 - EXIT\n\n"
        + "Please enter the number of the service needed : ");
    }
    // Print the Techniques Menu
    public static void TechniquesMenu(){
        System.out.print("\n********************************************************\n"
        +"Techniques Menu\n"
        + "1 - ATBASH\n"
        + "2 - HEX\n"
        + "3 - VIGENERE\n"
        + "0 - Return to Main Menu\n\n"
        + "Please enter the number of the service needed : ");
    }
    //ATBASH ciphering or deciphering
    public static String ATBASH(String str) {
        String result = "";
        int x;
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == ' '){
                result += " ";
            }else{  // a letter
               x = letterRank(str.charAt(i));
               result += (((char) (x * -1 + 26 + 'A')) + "");
            }
        }
        System.out.println(result);
        return result;
    }
    
    public static String VigenereCiphering(String str) {
        String keyword = "SECRET"; //the keyword for vigenere
        String result = "";
        str.trim();
        String assistantString = "";//to fill in the keyword inside it
        int x, y, count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                assistantString += " ";
                result += " ";
                count++;//to count the spaces
                continue;
            }
            //filling in the assistant string using the keyword
            if (i < keyword.length()) {
                assistantString += keyword.charAt(i-count);
            } else {
                assistantString += keyword.charAt((i-count) % keyword.length());
            }
            
            x = letterRank(str.charAt(i));
            y = letterRank(assistantString.charAt(i));
            
            result += ((char)((x + y)%26 - 2 + 'A')) + "";
            
        }
        System.out.println(result);        
        return result;
    }
    public static String VigenereDeciphering(String str) {
        String keyword = "SECRET";//the keyword for vigenere
        String result = "";
        str.trim();
        String assistantString = "";//to fill in the keyword inside it
        int x, y, z, count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                assistantString += " ";
                result += " ";
                count++;//to count the spaces
                continue;
            }
            //filling in the assistant string using the keyword
            if (i < keyword.length()) {
                assistantString += keyword.charAt(i-count);
            } else {
                assistantString += keyword.charAt((i-count) % keyword.length());
            }
            
            x = letterRank(str.charAt(i));
            y = letterRank(assistantString.charAt(i));
            
            result += ((char)(((x - y >= 0)? (x-y) : (x-y +26)) + 'A')) + "";
            
        }
        System.out.println(result);
        return result;
    }
    //getting the rank of the letter such as letterRank(B) is 2 ...
    public static int letterRank(char ch) {
        int result;
        ch = Character.toUpperCase(ch);
        result = ch - 'A' + 1;
        return result;
    }
    // Hexa Ciphering
    public static String HexadecimalCiphering(String str) {
        StringBuilder hex = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            
            //casting char to int
            int decimal = str.charAt(i);
            
            String hexString = "";
            
            //Converting the decimal to its equivalent in the hex digit
            while (decimal != 0) {
                int hexValue = decimal % 16;

                // Convert a decimal value to a hex digit
                char hexDigit = (0 <= hexValue && hexValue <= 9) ?
                        (char)(hexValue + '0') : (char)(hexValue - 10 + 'A');

                hexString = hexDigit + hexString;
                decimal = decimal / 16;
            }
            if (i == str.length() - 1) { 
                //So as not to add space after last character
                hex.append(hexString);
            }
            else hex.append(hexString).append(" ");
            
        }
        System.out.println(hex);
        return hex.toString();
        
    }
    // Hex Deciphering
    public static String HexadecimalDeciphering(String str) {
        StringBuilder hex = new StringBuilder();
        
        while (str.length() > 0) {
            String s = "";
            if (str.length() <= 2) {
                //When the last hex number arrives, it is added and stopped
                hex.append((char)(hexToDecimal(str)));
                break;
            }
            else s = str.substring(0, str.indexOf(" "));
            hex.append((char)(hexToDecimal(s)));
            str = str.substring(str.indexOf(" ")).trim();
        }
        System.out.println(hex);
        return hex.toString();
    }
    // converted hex to decimal
    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    // converted hex char to decimal
    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
        return ch - '0';
    }

    
    
}
