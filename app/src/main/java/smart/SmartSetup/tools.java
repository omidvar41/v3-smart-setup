package smart.SmartSetup;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class tools {
    public static String StringToChar(String str) {
        int i = 0;
        String text = "";
        int unicodInt;
        char c;
        while (i < str.length()) {

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = (c * 0x1000);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + (c * 0x100);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + (c * 0x10);

            c = str.charAt(i++);
            c = hexToInt(c);
            unicodInt = unicodInt + c;

            c = (char) unicodInt;

            String str1 = String.valueOf(c);
            text = text + str1;
        }
        return text;
    }


    //...............................................................................................
    public static char hexToInt(char c) {
        switch (c) {
            case '0':
                c = 0;
                break;
            case '1':
                c = 1;
                break;
            case '2':
                c = 2;
                break;
            case '3':
                c = 3;
                break;
            case '4':
                c = 4;
                break;
            case '5':
                c = 5;
                break;
            case '6':
                c = 6;
                break;
            case '7':
                c = 7;
                break;
            case '8':
                c = 8;
                break;
            case '9':
                c = 9;
                break;
            case 'A':
                c = 10;
                break;
            case 'B':
                c = 11;
                break;
            case 'C':
                c = 12;
                break;
            case 'D':
                c = 13;
                break;
            case 'E':
                c = 14;
                break;
            case 'F':
                c = 15;
                break;
            case 'a':
                c = 10;
                break;
            case 'b':
                c = 11;
                break;
            case 'c':
                c = 12;
                break;
            case 'd':
                c = 13;
                break;
            case 'e':
                c = 14;
                break;
            case 'f':
                c = 15;
        }
        return c;
    }

}
