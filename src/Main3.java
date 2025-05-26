import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        //System.out.println(checkAddInEmail("fdhsjfk"));
        ReadFromFile("example.txt");
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

}

