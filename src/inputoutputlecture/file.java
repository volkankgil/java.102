package inputoutputlecture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class file {
    public static void main(String[] args)throws IOException {

        File dosya=new File("src/inputoutputlecture/Patika");


        dosya.createNewFile();  // dosya yarat�yor.

        //dosya.delete();  yaratt���m�z dosyay� siliyor.

        FileOutputStream input =new FileOutputStream("a",true); // yan�na true de�eri vermezisek i�indekileri siliyor.



    }
}
