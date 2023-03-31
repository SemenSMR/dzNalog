import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long earnings = 0;    // доходы
        int spendings = 0;  // расходы

        while (true) {
            System.out.println("Выберете операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода: ");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;

                    case 2:
                        System.out.println("Введите сумму расхода: ");
                        String moneyStr2 = scanner.nextLine();
                        int money2 = Integer.parseInt(moneyStr2);
                        spendings += money2;
                        break;

                    case 3:
                        if (taxEarningsMinusSpendings(earnings, spendings) > taxEarnings(earnings)) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + taxEarnings(earnings) + " рублей");
                            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                            System.out.println("Экономия " + (taxEarningsMinusSpendings(earnings, spendings) - (taxEarnings(earnings))) + " рублей");
                            System.out.println("");
                        } else if (taxEarningsMinusSpendings(earnings, spendings) < taxEarnings(earnings)) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                            System.out.println("Налог на другой системе: " + taxEarnings(earnings) + " рублей");
                            System.out.println("Экономия " + ((taxEarnings(earnings)) - (taxEarningsMinusSpendings(earnings, spendings))) + " рублей");
                            System.out.println("");
                        } else {
                            System.out.println("Можете выбрать любую систему налогооблажения ");
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(long earnings, int spending) {
        int tax = (int) (earnings - spending) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            System.out.println("Налог не может быть отрицательным! ");
            return 0;
        }
    }

    public static int taxEarnings(long earnings) {
        int tax = (int) earnings * 6 / 100;
        return tax;

    }
}