package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите вес (кг):");
        double weight = input.nextDouble();

        System.out.println("Введите рост (см):");
        double height = input.nextDouble();

        System.out.println("Введите возраст (лет):");
        int age = input.nextInt();

        System.out.println("Выберите активность:\n1. Низкая\n2. Умеренная\n3. Высокая");
        int activityChoice = input.nextInt();
        String activity;

        switch (activityChoice) {
            case 1:
                activity = "Низкая";
                break;
            case 2:
                activity = "Умеренная";
                break;
            case 3:
                activity = "Высокая";
                break;
            default:
                activity = "Низкая";
                break;
        }

        System.out.println("Выберите пол:\n1. Мужской\n2. Женский");
        int genderChoice = input.nextInt();
        String gender;

        switch (genderChoice) {
            case 1:
                gender = "Мужской";
                break;
            case 2:
                gender = "Женский";
                break;
            default:
                gender = "Мужской";
                break;
        }

        double activityFactor, genderFactor;

        switch (activity) {
            case "Низкая":
                activityFactor = 1.2;
                break;
            case "Умеренная":
                activityFactor = 1.375;
                break;
            case "Высокая":
                activityFactor = 1.55;
                break;
            default:
                activityFactor = 1.2;
                break;
        }

        switch (gender) {
            case "Мужской":
                genderFactor = 5;
                break;
            case "Женский":
                genderFactor = -161;
                break;
            default:
                genderFactor = 5;
                break;
        }

        double bju = (10 * weight + 6.25 * height - 5 * age + genderFactor) * activityFactor;

        System.out.println("БЖУ: " + bju + " г");
    }
}
