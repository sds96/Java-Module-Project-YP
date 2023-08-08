import java.util.Scanner;

public class Calculator {
    int numberOfPeople = 1;
    String allPurchasees = "";
    double totalSum = 0;
    public void readInputParameters(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите количество человек: ");
            try {
                numberOfPeople = scanner.nextInt();
            } catch (Exception e) {
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
            String name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")){
                break;
            }
            double value;
            while (true){
                System.out.println("Введите стоимость " + name + ":");
                value = scanner.nextDouble();
                if (value < 0){
                    System.out.println("Стоимость товара не может быть отрицательной.");
                } else {
                    break;
                }
            }

            totalSum += value;
            allPurchasees = allPurchasees.concat(String.format("\n%s %.2f", name, value));

            System.out.println(String.format("Товар %s со стоимостью %.2f успешно добавлен.", name, value));
        }
    }

    public void finish(){
        System.out.println("Добавленные товары:" + allPurchasees);
        System.out.println(String.format("Итоговая стоимость: %.2f", totalSum));
        double pricePerPerson = totalSum /numberOfPeople;
        System.out.println(String.format("Каждый гость должен заплатить %.2f %s", pricePerPerson, getPadezh(pricePerPerson)) );
    }

    String getPadezh(double d){
        String ret;
        int last = ((int)d)% 10;
        if (last == 1){
            ret = "рубль";
        } else if (last == 2 || last == 3 || last == 4){
            ret = "рубля";
        } else {
            ret = "рублей";
        }
        return ret;
    }
}
