package com.example.softwareengineering;

//Подключается для работы с библиотекой
import org.apache.commons.cli.*;
//Для работы с той же библиотекой
import org.apache.commons.cli.ParseException;
//Мы пользуем этот метод, нам его надо импортнуть, иначе говоря, так надо
//import static com.example.softwareengineering.Secure.MD5;
//Класс, который позволит нам обработать текст, даты, числа
//import java.text.*;
//Ещё один класс для работы с текстом, датой, случайными числами и тому подобное
import java.util.*;


public class Client {
    private String[] args = null;
    //Конструктор опции
    private Options options = new Options();


    public Client(String[] args) {

        this.args = args;
        //Опция принимает на вход 4 параметра:
        //1-Короткое название опции (да-да, оно короткое, мой юный друг)
        //2-Длинное название опции
        //3-Флаг, который показывает, есть ли у данной опции какие-либо параметры
        //4-И, собственно, обозначение самой опции, т.е. зачем она добавлена
        options.addOption("Help", "help", false, "HEEEEEELP!!!!!");
        options.addOption("Login", "login", true, "Your Login: ");
        options.addOption("Password","password",true,"Your Password: ");
        options.addOption("Resource","resource",true,"Resource: ");
        options.addOption("Role","role",true,"Your role for working with this resource: ");
        options.addOption("Date-Start","datestart",true,"Start Date: ");
        options.addOption("Date-End","dateend",true,"End-Date: ");
        options.addOption("Value","value",true,"Value: ");

    }

    //Далее используется структура HashMap, которая позволяет сохранять данные в виде пар значений
    //И у нас пара значений идёт с типом String String
        public HashMap<String,String> parse() {

            HashMap<String, String> Parameters = new HashMap<>();

            CommandLineParser parser = new BasicParser();

            //Вызываем командную строку и там вводим короткое название опции
            //Командная строка "парсится", если всё верно, то появится ответ, соответствующий запросу
            //Например: ourprogram.exe -login kreamganatanatda -password 123456
            //Вызывается наша программуля, вызывается опция отвечающая за ввод логина, и логин принимает значение "кримганатанатда"
            //Следующая вызванная опция отвечает за ввод пароля соответственно, и пароль становится "123456"
            //Всё гениальное просто
            CommandLine cmd;
            try {
                cmd = parser.parse(options, args);

                if (cmd.hasOption("help")) {
                    help();
                }

                if (cmd.hasOption("login")) {
                    Parameters.put("login", cmd.getOptionValue("login"));
                    System.out.println("Entered login -->" + Parameters);
                }

                if (cmd.hasOption("password")) {
                   Parameters.put("password", cmd.getOptionValue("password"));
                    System.out.println("Entered password -->" + Parameters);
                }

                if (cmd.hasOption("resource")) {
                    Parameters.put("resource", cmd.getOptionValue("resource"));
                    System.out.println("Resource -->" + Parameters);
                }

                if (cmd.hasOption("role")) {
                    Parameters.put("role", cmd.getOptionValue("role"));
                    System.out.println("Role -->" + Parameters);
                }


            } catch (ParseException e) {
                //Если парсинг командной строки прошёл неудачно, то появится сообщение об этом
                System.err.println("Failed to parse command line properties");
                help();
            }

            return Parameters;
        }


    }


    //Функция служащая для вывода на экран справку
    //private void help() {
    private static void help(){
        // This prints out some help
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Our options: ", options);
        System.exit(0);
    }
}