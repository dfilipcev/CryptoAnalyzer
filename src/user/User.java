package user;

import constants.WorkWays;
import workways.BruteForce;
import workways.Decrypt;
import workways.Encrypt;

import java.util.Scanner;

import static constants.Phrases.*;

public class User {

    public User() {
    }

    public void choosingWorkWay(Scanner scanner) {
        System.out.println(WORKING_WAYS + GREETING);
        String consoleInput;
        while (scanner.hasNextLine()) {
            try {
                consoleInput = scanner.nextLine();
                int workWay = Integer.parseInt(consoleInput);
                //Если exit, то завершаем работу
                if (EXIT.equalsIgnoreCase(consoleInput)) {
                    System.exit(0);
                    //Если ввод больше 3, равен или меньше 0, то повторяем цикл
                } else if (workWay > 3 || workWay <= 0) {
                    System.out.println(REPEAT);
                    //Если 1, то делаем шифровку
                } else if (workWay == WorkWays.ENCRYPT.getNumber()) {
                    Encrypt.encrypt();
                    break;
                    //Если 2, то делаем расшифровку
                } else if (workWay == WorkWays.DECRYPT.getNumber()) {
                    Decrypt.decrypt();
                    break;
                    //Если 3, то делаем brute_force
                } else if (workWay == WorkWays.BRUTE_FORCE.getNumber()) {
                    BruteForce.bruteForce();
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(REPEAT);
            }
        }
    }
}
