import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main2 {
    public static void main(String[] args) {
        String str=ReadFromFile("example.txt");
        WriteToFile(str);

    }
    public  static String ReadFromFile(String nameOfFile)
    { StringBuilder sb=null;
        try ( FileInputStream fileInputStream = new FileInputStream("example.txt");){
        sb = new StringBuilder();
        int data;
        while ((data = fileInputStream.read())!=-1) {
            sb.append ((char)data);
        }
        System.out.println(sb.toString());
    } catch (IOException e) {
        System.out.println("Mistakes!!!!");
    }
    return  sb.toString();
    }
    public static void WriteToFile(String str){

        try (FileOutputStream fileOutputStream = new FileOutputStream("example2.txt")) {
            for (var b: str.getBytes()){
                fileOutputStream.write(b);
            }

        }
        catch (IOException e) {
            System.out.println("error");
        }
        //почему finally не работает?
        // finally{
        //try {
          //     fileOutputStream.close();
        //    } catch (Exception e) {
        //        System.out.println("не получилось закрыть поток");
           // }
        }


    }

