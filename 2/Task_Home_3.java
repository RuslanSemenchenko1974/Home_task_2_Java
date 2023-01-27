/*Задание 3 *.

К калькулятору из предыдущего дз добавить логирование.

Реализовать простой калькулятор (операции + - / * ) 
*/
import java.util.logging.*;
import java.util.Scanner;

public class Task_Home_3 {
    public static void main(String[] args) {
    float n1,n2;
    try {
    System.out.print("\033\143");
    Logger logger = Logger.getLogger(Task_Home_3.class.getName());
    ConsoleHandler ch = new ConsoleHandler();
    logger.addHandler(ch);
    SimpleFormatter sFormat = new SimpleFormatter();
    ch.setFormatter(sFormat);
    logger.log(Level.WARNING, "Test");
    Scanner iScanner = new Scanner(System.in);
    
    System.out.print("Задайте число 1 : ");
    n1 = iScanner.nextFloat();
    System.out.print("Введите операцию: ");
    String operation = iScanner.next();
    System.out.print("Задайте число 2 : ");
    n2 = iScanner.nextFloat();
    Boolean bool = true;
    float result=0;
    switch (operation) {
        case "+":
        result = n1+n2;
        break;
        case "-":
        result = n1-n2;
        break;
        case "*":
        result = n1*n2;
        break;
        case "/":
        if (n2==0) {System.out.println("Деление на 0!"); break;}
        result = n1/n2;
        break;
        default:
        bool = false;
        System.out.print("Ошибка ввода операции: ");
        logger.log(Level.WARNING, "Enter incorrect!");
        break;
    }
    if (bool) System.out.printf("%.2f %s %.2f = %f", n1, operation, n2, result);
    iScanner.close();
    }
    catch (Exception ex) {
        System.out.println("!Вводите корректные данные!");
        
        //System.out.println(ex);
    }
    }
}