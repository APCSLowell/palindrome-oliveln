import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(isPalindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
  public boolean isPalindrome(String sWord) {
    String clean = noCapitals(sWord);
    clean = onlyLetters(clean);
    clean = noSpaces(clean);
    String backward = reverse(clean);
    if (clean.equals(backward)) {
      return true;
    }
    return false;
  }

  public String reverse(String sWord) {
    String s = "";
    for (int i = sWord.length() - 1; i >= 0; i--) {
      s = s + sWord.charAt(i);
    }
    return s;
  }
  public String noCapitals(String sWord) {
    return sWord.toLowerCase();
  }

  public String onlyLetters(String sString) {
    String empty = "";
    for (int i = 0; i <= sString.length() - 1; i++) {
      if (Character.isLetter(sString.charAt(i)) == true) {
        empty+=sString.charAt(i);
      }
    }
    return empty;
  }

  public String noSpaces(String sWord) {
    String empty = "";
    for (int i = 0; i <= sWord.length()-1; i++) {
      if ((Character.isWhitespace(sWord.charAt(i))) == false) {
        empty = empty + sWord.charAt(i);
      }
    }
    return empty;
  }
}
