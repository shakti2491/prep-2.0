package algods.maths;

import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.charset.StandardCharsets.UTF_8;

public class IntToByteString {

    // return length of string to bytes
    public static String intToByteString(int x){
        byte[] bytes = new byte[4];
        for(int i = 0; i <4; ++i) {
            bytes[i] =  (byte)(x >> ((3-i) * 8));
        }

        String result =  new String(bytes, US_ASCII);
        StringBuilder sb = new StringBuilder();
        return result;
    }

    public static void main(String args[]) {
        String Str = new String("Welcome-to-Tutorialspoint.com");

        System.out.println("Return Value2 :" );
        for (String retval: Str.split("-", 2)) {
            System.out.println(retval);
        }
        System.out.println("");
        System.out.println("Return Value3 :" );

        for (String retval: Str.split("-", 3)) {
            System.out.println(retval);
        }
        System.out.println("");
        System.out.println("Return Value0 :" );

        for (String retval: Str.split("-", 0)) {
            System.out.println(retval);
        }
        System.out.println("");
    }


}
