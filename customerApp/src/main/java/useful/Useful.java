package useful;

import java.util.Scanner;

public class Useful {

    /**
     * Reading an int value on keyboard. If the user doesn't enter an int value
     * A short error message displays and asks again to enter an int value. And till
     * the int value is read on keyboard.
     *
     * @param message displayed message before reading
     * @return int value read on keyboard.
     */
    public static int readInt(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message + ":");
        while (!kbd.hasNextInt()) {
            kbd.next();
            System.err.println("Error!!! It's not the expected answer, try again ");
            System.out.println(message);

        }
        return kbd.nextInt();
    }

    /**
     * Reading an int value on keyboard between min and max included. If the user
     * doesn't enter an int value, or when an entered value is out of range
     * A short error message displays and ask again to
     * enter an int value. And till the int value is read on keyboard and in asked
     * interval.
     *
     * @param message displayed message before reading
     * @param min     minimal value allowed.
     * @param max     maximal value allowed
     * @return int value read on keyboard.
     */
    public static int readInt(String message, int min, int max) {
        int nb = readInt(message);
        while (nb < min || nb > max) {
            System.err.println("Error!! the count must be between " + min + " et " + max);
            nb = readInt(message);
        }
        return nb;
    }

    /**
     * Reading a double on keyboard. If the user doesn't enter a double, A
     * short error message diplays and ask again to enter a double till
     * the double is read on keyboard.
     *
     * @param message displayed message before reading
     * @return double read on keyboard.
     */
    public static double readDouble(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message + ":");
        while (!kbd.hasNextDouble()) {
            kbd.next();
            System.out.println("Error!!! It's not the expected answer, try again");
            System.out.println(message);

        }
        return kbd.nextDouble();
    }

    /**
     * Reads a boolean value on keyboard. If the user doesn't enter a boolean value, A
     * short error message diplays and ask again to enter a boolean value till
     * the boolean value is read on keyboard.
     *
     * @param message displayed message before reading
     * @return boolean value read on keyboard.
     */
    public static boolean readBoolean(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message + ":");
        while (!kbd.hasNextBoolean()) {
            kbd.next();
            System.out.println("  Error!! It's not the expected answer, try again ");
            System.out.println(message);

        }
        return kbd.nextBoolean();
    }

    /**
     * Reads a string value on keyboard. If the user doesn't enter a string value, A
     * short error message diplays and ask again to enter a string value till
     * the string value is read on keyboard.
     *
     * @param message displayed message before reading
     * @return string value read on keyboard.
     */
    public static String readString(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(message + ":");
        while (!kbd.hasNextLine()) {
            kbd.next();
            System.out.println("  Error!!It's not a string value, try again ");
            System.out.println(message);

        }
        return kbd.nextLine();
    }

    /**
     * Gives a random value between the maximum and the minimum values received.
     * The received values will be included in random values
     *
     * @param max maximum value received
     * @param min minimum value received
     * @return random value
     */
    public static int hasard(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
