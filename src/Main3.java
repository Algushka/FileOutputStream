//Напишите программу,
//        которая читает файл example.txt и
//        формирует список Person(String name,
//        String email,int age) Подсказка 1:
//        в исходной строке поля разделены ','
//        а объекты ';' Подсказка 2: преобразование
//        возраста из строки в int - Integer.parseInt()
//        Подсказка 2: преобразование возраста из строки
//        в int - Integer.parseInt() (и кстати, там может быть Exception)
//
//
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws MyException{

       // System.out.println(checkAddInEmail("fdhsjfk"));
        String str=ReadFromFile("example.txt");
        //addToPerson(str);
        List<Person> list = formPersonListFromString(str);
        printPersonList(list);
    }

    public static String ReadFromFile(String nameOfFile) {
StringBuilder sb = null;
        try ( FileInputStream fileInputStream = new FileInputStream(nameOfFile);){
        sb= new StringBuilder();
        int data;
        int counterOfCommas=0;
        int counterOfPersons=0;
      boolean firstElement = true;
        while ((data = fileInputStream.read())!=-1) {
            if (!firstElement) sb.append(',');
            counterOfPersons++;
            //System.out.println("Количество человек" + counterOfPersons);
            if ((firstElement)||(counterOfCommas==2)){
            counterOfCommas=0;
            firstElement=false;}
            else {
                System.out.println("Not enough fields, add fields to: " +counterOfPersons+ "   Person");
                throw new RuntimeException();

            }
            while ((((char)data)!=';')) // && (data = fileInputStream.read())!=-1){
            {
                //System.out.println(counterOfCommas);
                if (((char)data) ==',')  {counterOfCommas++;}
                System.out.println((char)data);
                sb.append((char) data);
            data = fileInputStream.read();

            }
            System.out.println(sb.toString());
        }

    }
        catch (IOException e ){
            System.out.println("Error");
        }
        finally {
            System.out.println("Всем привет !");
        }
        return sb.toString();
    }
    public static boolean checkAddInEmail (String email) {
        return email.contains("@");
    }
    public static void addToPerson(String str) {
        String[]strings=str.split(",");
        for (String element:strings) {
            System.out.println(element);
        }
    }
    public static List<Person> formPersonListFromString(String str) throws MyException {
        List <Person> list =new ArrayList<>() ;
        String[]strings=str.split(",");
        System.out.println("длина массива строк"+ strings.length);
        for (int i=0; i< strings.length-2; i=i+3){
              //  int index=0;
                if (checkAddInEmail (strings[i+1])!=true)
                {
                    //System.out.println("ээээээ"+strings[i+1]);
                    System.out.println("Mistake! Add '@' to email address: " + strings[i+1]);
                throw new MyException();}


               try {int age=Integer.parseInt(strings[i+2]);
                   Person person = new Person(strings[i], strings[i + 1], age);
                   System.out.println(person);
                   list.add(person);
                }
               catch (Exception e){
                   System.out.println("Not proper format of age");
           }
         //   Person person = new Person(strings[i], strings[i + 1], Integer.parseInt(strings[i + 2]));
        //    System.out.println(person);
        //    list.add(person);
        }
        return list;
    }

    public static void printPersonList(List<Person> list) {
        for (Person element: list ) {
            System.out.println(element);
        }
    }
}

