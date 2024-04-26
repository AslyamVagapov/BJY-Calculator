package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Person NewPerson = new Person();
        NewPerson.inputWeight();
        NewPerson.inputHeight();
        NewPerson.inputAge();
        NewPerson.inputGender();
        NewPerson.inputActivity();

        System.out.println("Бжу = "+NewPerson.getBJU());

    }

    public static class Person{
        private double weight;
        private double height;
        private int age;
        private String gender;
        private double activityFactor;

        public void inputWeight(){
            Scanner input = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput){
                try{
                    System.out.println("Введите ваш вес (в кг): ");
                    this.weight = input.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите цисло.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        }

        public void inputHeight(){
            Scanner input = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput){
                try{
                    System.out.println("Введите ваш рост (в см): ");
                    height = input.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите цисло.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        }

        public void inputAge(){
            Scanner input = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput){
                try{
                    System.out.println("Введите ваш возраст: ");
                    age = input.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите целое цисло.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        }

        public void inputGender(){
            Scanner input = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput){
                try{
                    System.out.println("Выберите пол:\n1. Мужской\n2. Женский");
                    int genderChoice = input.nextInt();

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
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите номер выбранного варианта.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        }

        public void inputActivity(){
            Scanner input = new Scanner(System.in);
            boolean validInput = false;
            while (!validInput){
                try{
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
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите номер выбранного варианта.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        }

        public double getBJU(){
            int genderFactor;
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

            return (10 * weight + 6.25 * height - 5 * age + genderFactor) * activityFactor;
        }



    }
}
