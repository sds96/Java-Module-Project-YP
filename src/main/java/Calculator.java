import java.util.Scanner;

public class Calculator {
    int numberOfPeople = 1;
    StringBuilder allPurchasees = new StringBuilder();
    double totalSum = 0;
    public void readInputParameters(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите количество человек: ");
            if (scanner.hasNextInt()){
                numberOfPeople = scanner.nextInt();
            } else {
                System.out.println("Получена ошибка ввода. Введите число.");
                scanner.next();
                continue;
            }

            if (numberOfPeople < 2){
                System.out.println("Для работы программы нужно число > 1.");
            } else {
                break;
            }
        }
        System.out.println("Отлично, количество гостей = " + numberOfPeople + ".");
    }

    public void readPurchases(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте добавим ваши товары.");
        while(true){
            System.out.println("Введите название товара или 'Завершить' если вы закончили.");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("Завершить")){
                break;
            }
            double value;
            while (true){
                System.out.println("Введите стоимость " + name + ":");
                if(scanner.hasNextDouble()) {
                    value = scanner.nextDouble();
                    if (value < 0){
                        System.out.println("Стоимость товара не может быть отрицательной.");
                    } else {
                        break; // всё ок, выходим из цикла
                    }
                } else{
                    scanner.nextLine();
                    System.out.println("Стоимость товара должна быть числом.");
                }
            }
            // после чтения double в буфере остаётся \n и nextLine в цикле для названия товара кушает пустую строку автоматом.
            // этот nextLine съедает остатки после nextDouble.
            scanner.nextLine();
            totalSum += value;
            allPurchasees.append(String.format("\n%s %.2f", name, value));

            System.out.println(String.format("Товар %s со стоимостью %.2f успешно добавлен.", name, value));
        }
    }

    public void finish(){
        System.out.println("Добавленные товары:" + allPurchasees);
        System.out.println(String.format("Итоговая стоимость: %.2f", totalSum));
        double pricePerPerson = totalSum /numberOfPeople;
        System.out.println(String.format("Каждый гость должен заплатить %.2f %s", pricePerPerson, getEnding(pricePerPerson)) );
    }

    String getEnding(double d){
        String ret;
        int tens = ((int)d) % 100;
        int last = ((int)d)% 10;
        if (tens > 10 && tens <20){
            ret = "рублей";
        } else if (last == 1){
            ret = "рубль";
        } else if (last == 2 || last == 3 || last == 4){
            ret = "рубля";
        } else {
            ret = "рублей";
        }
        return ret;
    }
}
