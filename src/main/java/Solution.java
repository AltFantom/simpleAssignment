import java.io.*;
class Result {

    public static int minimumNumber(int n, String password) {
        int result = 0;
        if (!isContainsDigit(password)) {
            result += 1;
        }
        if (!isContainsLowerCase(password)) {
            result += 1;
        }
        if (!isContainsUpperCase(password)) {
            result += 1;
        }
        if (!isContainsSpecialCharacter(password)) {
            result += 1;
        }
        if (n + result < 6){
            result += 6 - (n + result);
        }
        return result;
    }

    private static boolean isContainsUpperCase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean isContainsLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean isContainsDigit(String password) {
        char[] passwordArray = password.toCharArray();
        for (char element : passwordArray) {
            if (Character.isDigit(element)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsSpecialCharacter(String password) {
        int i = -1;
        String specialCharacter = "!@#$%^&*()-+";
        char[] passwordArray = password.toCharArray();
        for (char element : passwordArray) {
            if (i != specialCharacter.indexOf(element)) {
                return true;
            }
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        System.out.println(answer);
        bufferedReader.close();
    }
}