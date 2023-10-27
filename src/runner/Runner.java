package runner;

import user.User;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        User user = new User();
        user.choosingWorkWay(new Scanner(System.in));
    }
}
