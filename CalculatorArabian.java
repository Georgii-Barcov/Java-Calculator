package CalculatorArabian;



import arabian.Converter;
import arabian.ConverterBuilder;

import java.util.Scanner;

public class CalculatorArabian {
    public static void main(String[] args){
        //2+3
        //V-VII
        Converter converter = new ConverterBuilder().createConverter();
        String[] actions = {"+", "-", "/", "*",};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner csn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = csn.nextLine();
        //Определяем арифметическое действие
        int actionIndex=-1;
        for (int i = 0; i <actions.length; i++ ) {
            if(exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия завершаем программу
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        //"2-4".split("\\+")-> {"2", "4"}
        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;

            //Конвертируем арабские числа из строки в число
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);

            //Выполняем с числами арифметическое действие
            int result = switch (actions[actionIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };
            //Если числа были арабские, возвращаем результат в арабском числе
            System.out.println(result);

        }else{
            System.out.println("Числа должны быть в одном формате");






        }
    }
}
