import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] actions1 = {"\\+", "-", "\\*", "/"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите, пожалуйста, арифметическую операцию, которую следует выполнить / калькулировать (Input)! \n" +
                "При этом вводимые цифры должны быть в значениях от 1 до 10 (или от I/i до X/x) включительно, \nа сами арифметические действия должны быть указаны символами '+', '-', '*' и '/' соответственно. \n" +
                "Кроме того, нельзя в одной и той же вводимой арифметической операции указывать как арабскую цифру, так и римскую.\n" +
                "Иными словами, в одной и той же вводимой арифметической операции обе оцифры должны быть либо арабскими, либо римскими.");
        String arithmeticOperation = sc.nextLine().replaceAll("\\s", "").toUpperCase();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (arithmeticOperation.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            System.out.println("Вы некорректно ввели арифметическую операцию.");
            return;
        }


        String[] data = arithmeticOperation.split(actions1[actionIndex]);

        try {
                if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                    int a, b;
                    boolean isRoman = converter.isRoman(data[0]);
                    if (isRoman) {
                        a = converter.romanToInt(data[0]);
                        b = converter.romanToInt(data[1]);
                    } else {
                        a = Integer.parseInt(data[0]);
                        b = Integer.parseInt(data[1]);
                    }


                    int result;

                    if (a >= 1) {
                        if (a <= 10) {
                            if (b >= 1) {
                                if (b <= 10) {
                                    switch (actions[actionIndex]) {
                                        case "+":
                                            result = a + b;
                                            break;
                                        case "-":
                                            result = a - b;
                                            break;
                                        case "*":
                                            result = a * b;
                                            break;
                                        default:
                                            result = a / b;
                                            break;
                                    }

                                    if (isRoman) {
                                        System.out.println("Результатом выполнения арифметической операции / калькуляции является число: " + converter.intToRoman(result));
                                    } else {
                                        System.out.println("Результатом выполнения арифметической операции / калькуляции является число (Output): " + result);
                                    }
                                } else {
                                    System.out.println("Введённая Вами вторая цифра больше 10.");
                                }
                            } else {
                                System.out.println("Введённая Вами вторая цифра меньше 1.");
                            }
                        } else {
                            System.out.println("Введённая Вами первая цифра больше 10.");
                        }
                    } else {
                        System.out.println("Введённая Вами первая цифра меньше 1.");
                    }
                } else {
                    System.out.println("Вы одновременно ввели как арабскую цифру, так и римскую.");
                }

        } catch (Exception e){System.out.println("Вы ввели не тот символ / не те символы.");}
    }
}






