// Используя FileOutputStream создать на диске файл example.txt,
// который должен содержать строку:
// Jeff,jeff@mail.com,23;Jack,jack@mail.com,45;Nick,
// nick@mail.com,24;Oleg,oleg@mail.com,22


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
      String str = "Jeff,jeff@mail.com,23; Jack, jack@mail.com, 45; Nick, nick@mail.com, 24; Oleg, oleg@mail.com,22";
      try{
        FileOutputStream fileOutputStream = new FileOutputStream("example.txt");
      for (var b:str.getBytes()) {
          fileOutputStream.write(b);
      }}
      catch (IOException e) {
          System.out.println("File not found");

      }
    }
    }