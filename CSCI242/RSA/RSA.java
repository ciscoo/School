
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void decrypt(String filename, BigInteger d, BigInteger n) throws FileNotFoundException, IOException {
        
        //Declare my objects, file, writer, scanner
        FileInputStream file = new FileInputStream(filename);
        PrintWriter writer = new PrintWriter("Decrypted.out");
        Scanner reader = new Scanner(file);
        
        //Declare some needed vars
        BigInteger letter;
        BigInteger p;
        int p2, i, j;
        
        //Loop through each line
        while (reader.hasNextLine()) {
            
            //Assign current line to currentNum
            letter = reader.nextBigInteger();
            
            //Do some fancy math
            p = letter.modPow(d, n);
            p2 = p.intValue();
            
            //Calculate letters and write to file
            i = p2/256;
            writer.print((char) i);
            
            j = p2%256;
            
            //Handle pesky 0
            if (j == 0) {
                j = i;
            } else {
                writer.print((char) j);
            }
        }
        
        //Close everything up
        reader.close();
        file.close();
        writer.close();
    }

    public static void encrypt(String filename, BigInteger e, BigInteger n) throws FileNotFoundException, IOException {
        
        //Declare my file objects, reader and writer
        BufferedReader file = new BufferedReader(new FileReader(filename));
        PrintWriter writer = new PrintWriter("Encrypted.out");

        //Declare some needed vars
        int text = file.read();
        int i = 2;
        int p = 0;
        BigInteger c;
        BigInteger output;
        
        //While not end of file, loop
        while (text != -1) {
            
            //First letter is always even, second is odd
            if (i%2 == 0) {
                //Multiply first number and cast to BigInteger and assign to c
                p = text*256;
                c = BigInteger.valueOf(p);
            } else {
                //Second number is odd, add to first number above, cast to BigInteger
                p += text;
                c = BigInteger.valueOf(p);
            }
            
            //modPow the output from above and assign, then write to file
            output = c.modPow(e, n);
            writer.println(output);
            
            //Read file again and increment counter
            text = file.read();
            i++;
        }
        
        //Print final line with 0
        writer.print(0);
        
        //Close everything up
        file.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        
        //Mateo's keys
        BigInteger modulo = new BigInteger("4295229443");
        BigInteger encryption = new BigInteger("155");
        BigInteger decryption = new BigInteger("1607198099");
        
        //RSA.encrypt("test.txt", encryption, modulo);
        //RSA.decrypt("Encrypted.out", decryption, modulo);
    }
}