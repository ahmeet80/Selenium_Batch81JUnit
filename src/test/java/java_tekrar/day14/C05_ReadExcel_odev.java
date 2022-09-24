package day14;

import com.google.j2objc.annotations.WeakOuter;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel_odev {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis =new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa2");

        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan stun sayisinin ise 3 oldugunu test edin
        int satirSayisi = workbook.getSheet("Sayfa2").getLastRowNum()+1; // satir sayisini verir
        Row row = sheet.getRow(satirSayisi-1); // en son satırı secer
        short sutunSayisi = row.getLastCellNum();

        Assert.assertEquals(satirSayisi,6);
        Assert.assertEquals(sutunSayisi,3);

       /*
        int satirStunToplam = satirSayisi + sutunSayisi; // Tek Assert icin
        Assert.assertEquals(satirStunToplam,9);          // alternatifcozum
       */


    }
}
