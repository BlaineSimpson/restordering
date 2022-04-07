/* LoginHelper.java
 implement methods for the login classes
 Author: Ali Mohamed (219113505)
 Date: 04 April 2022
*/
package za.ac.cput.util;

public class LoginHelper {

    public static boolean isNull(String s){
        return s == null || s.isEmpty() || s.equals("") || s.equals(" ");
    }
    public static boolean invalidId(int i){
        return i <= 0;
    }
}
