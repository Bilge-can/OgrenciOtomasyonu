import Models.StudentPointModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Helpers {

    public static void verilerTxtReader(){
        // verileri proje içerisinde bulunan veriler.txt dosyasından projeye aktarıyoruz
        File file = new File("C:\\Users\\cekix\\Desktop\\Bilge Can Ogrenci Otomasyonu\\src\\Veriler\\veriler.txt");

        try {
            //BufferedReader nesnesi ile file olarak yolunu vermiş olduğumuz dosyamızı okutuyoruz
            //okunan dosyada her satırı alarak satırları parçalayacak olan fonksiyona gönderiyoruz
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                shredTheData(st);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void shredTheData(String satır){
        //almış olduğumuz satırı toCharArray yardımı ile for içinde dönderebilmek için char tipinde bir diziye aktardık
        //veriler txt dosyamızda 5 adet verimiz ve 4 adet ; ayracımız olduğu için ayrac position ları tutabilmek içinde ayracPosition dizisini tanımladık
        //ilk for döngüsü ile ; karakterinin satır içerisinde ki position değerlerini aldık
        //
        char[] stringToCharArray = satır.toCharArray();
        int[] ayracPosition = new int[4];
        String idNo = "",ders = "",vizeStr="",finalStr="";
        int vize,finalNotu;
        double puanOrt;

        int k=0;
        for (int i=0;i<stringToCharArray.length;i++){
            if (stringToCharArray[i] == ';'){
                ayracPosition[k] = i;
                k++;
            }
        }

        int baslangıc = 1;
        for (int i=0;i<ayracPosition.length;i++){
            for (int j=baslangıc;j<ayracPosition[i];j++){
                if (stringToCharArray[j] != ';'){
                    if (i == 0){
                        idNo = idNo + stringToCharArray[j];
                    }else if (i == 1){
                        ders = ders + stringToCharArray[j];
                    }else if (i == 2){
                        vizeStr = vizeStr + stringToCharArray[j];
                    }else if (i == 3){
                        finalStr = finalStr + stringToCharArray[j];
                    }
                }
            }
            baslangıc = ayracPosition[i];
        }

        vize = Integer.parseInt(vizeStr);
        finalNotu = Integer.parseInt(finalStr);
        puanOrt = (vize * 0.4) + (finalNotu * 0.6);

        StudentPointModel postModel = new StudentPointModel();
        postModel.setStudentIdNo(idNo);
        postModel.setDers(ders);
        postModel.setPuanVize(vize);
        postModel.setPuanFinal(finalNotu);
        postModel.setPuanOrt(puanOrt);

        Main.studentPoints.add(postModel);
    }


}
