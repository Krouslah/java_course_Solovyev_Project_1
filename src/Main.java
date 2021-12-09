import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        int j;
        boolean check = false;
        double result = 0;
        while (i != 3) {
            i = cycle();
            if (i == 1) {
                System.out.print("Выражение : ");
                String line = read();
                String[] array = split(line);
                double number1 = parse(array[0]);
                double number2 = 0;
                if (array.length >2) {
                    number2 = parse(array[2]);
                }
                switch (array[1]) {
                    case "+":
                        result = sum(number1, number2);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "-":
                        result = difference(number1, number2);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "/":
                        result = division(number1, number2);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "*":
                        result = multiplication(number1, number2);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "!":
                        result = factorial(number1);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "^":
                        result = exponentiation(number1, number2);
                        System.out.println("Результат : "+result);
                        check = true;
                        continue;
                    case "?":
                        System.out.println("Результат : "+number1 + " " + comparison(number1, number2) + " " + number2);
                        check = true;
                        continue;
                    default:
                        System.out.println("Закралась ошибка");
                        break;
                }
            }
            if (i == 2) {
                j = 1;
                if (check) {
                    while (j != 0) {
                        j = cycle2();
                        switch (j) {
                            case 1:
                                System.out.print("Введите второе значение : ");
                                result += readForSecondOption();
                                System.out.println("Результат : "+result);
                                continue;
                            case 2:
                                System.out.print("Введите второе значение : ");
                                result -= readForSecondOption();
                                System.out.println("Результат : "+result);
                                continue;
                            case 3:
                                System.out.print("Введите второе значение : ");
                                result *= readForSecondOption();
                                System.out.println("Результат : "+result);
                                continue;
                            case 4:
                                System.out.print("Введите второе значение : ");
                                result /= readForSecondOption();
                                System.out.println("Результат : "+result);
                                continue;
                            case 5:
                                System.out.print("Введите второе значение : ");
                                result = Math.pow(result, readForSecondOption());
                                System.out.println("Результат : "+result);
                                continue;
                            case 6:
                                System.out.print("Введите второе значение : ");
                                result = factorial(result);
                                System.out.println("Результат : "+result);
                                continue;
                            case 7:
                                System.out.print("Введите второе значение : ");
                                double lastNumber = readForSecondOption();
                                System.out.println("Результат : "+result + " " + comparison(result, lastNumber) + " " + lastNumber);
                                continue;
                            default:
                                break;
                        }

                    }
                }
                else
                    System.out.println("В памяти нет крайнего значения, посчитайте что=нибудь в первом пункте меню" + "\n");
            }
        }
    }

    public static String read() {
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }
    public static double readForSecondOption() {
        Scanner src = new Scanner(System.in);
        return src.nextDouble();
    }

    public static String[] split(String l) {
        if (l.endsWith("!")) {
            l=l.replace("", " ");
            l = l.trim();
            return l.split(" ");
        }
        return l.split(" ");
    }

    public static double parse(String l) {
        return Double.parseDouble(l);
    }

    public static double sum(double number1, double number2) {
        return number1 + number2;
    }

    public static double difference(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    public static double division(double number1, double number2) {
        return number1 / number2;
    }

    public static double exponentiation(double number1, double number2) {
        return Math.pow(number1, number2);
    }

    public static double factorial(double number1) {
        double total = 1;
        if (number1 == 0) return 1;
        total *= number1;
        return total * factorial(number1 - 1);
    }

    public static String comparison(double number1, double number2) {
        if (number1 > number2) return ">";
        else return "<";
    }

    public static int cycle() {
        System.out.println("""
                1. Ввести пример.
                2. Продолжить работать с предыдущим ответом.
                3. Выход""");
        System.out.print("Введите интересующий пункт меню : ");
        return Integer.parseInt(read());
    }

    public static int cycle2() {
        System.out.println("""
                1. Сложение
                2. Вычитание
                3. Умножение
                4. Деление
                5. Факториал
                6. Возведение в степень
                7. Сравнение
                0. Назад
                """);
        return Integer.parseInt(read());
    }
}
