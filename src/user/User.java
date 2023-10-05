package user;

import constants.WorkWays;
import workways.Encrypt;

import java.util.Scanner;

import static constants.Phrases.*;

public class User {

    public User() {
    }

    public void choosingWorkWay() {
        System.out.println(GREETING);
        Scanner scanner = new Scanner(System.in);
        String consoleInput;

        while (scanner.hasNextLine()) {
            try {
                consoleInput = scanner.nextLine();
                int workWay = Integer.parseInt(consoleInput);
                //Если 1, то делаем шифровку
                if (workWay == WorkWays.ENCRYPT.getNumber()) {
                    Encrypt.encryption();
                    break;
                //Если 2, то делаем расшифровку
                } else if (workWay == WorkWays.DECRYPT.getNumber()) {
                    System.out.println("go decrypt!");
                    break;
                //Если 3, то делаем brute_force
                } else if (workWay == WorkWays.BRUTE_FORCE.getNumber()) {
                    System.out.println("go brute force!");
                    break;
                //Если exit, то завершаем работу
                } else if (consoleInput.equalsIgnoreCase(EXIT)) {
                    System.exit(0);
                //Если ввод меньше или равен 0 или больше 3, то начинаем цикл заново
                } else if (workWay > 3 || workWay <= 0) {
                    System.out.println(REPEAT);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(REPEAT);
            }
        }
    }
}
