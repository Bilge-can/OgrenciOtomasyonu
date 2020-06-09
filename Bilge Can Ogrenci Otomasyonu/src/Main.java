import Models.StudentPointModel;
import Models.StudentModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<StudentModel> studentModelList = new ArrayList<StudentModel>();
    static ArrayList<StudentPointModel> studentPoints = new ArrayList<StudentPointModel>();

    public static void main(String args[]){
        Helpers.verilerTxtReader();
        welcomePage();
    }

    public static void welcomePage(){
        System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
        System.out.println("*                                                                *");
        System.out.println("*             Ogrenci Takip Uygulamasına Hoşgeldiniz             *");
        System.out.println("*                                                                *");
        System.out.println("*                          Bilge Can                             *");
        System.out.println("*                          195541001                             *");
        System.out.println("*                                                                *");
        System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
        System.out.println("*                                                                *");
        System.out.println("*----------------------------------------------------------------*");
        System.out.println("*                                                                *");
        System.out.println("*                Ogrenci Takip Uygulama Menüsü                   *");
        System.out.println("*                                                                *");
        System.out.println("*                  Ogrenci Eklemek İçin - 1                      *");
        System.out.println("*                Ogrencileri Gormek İçin - 2                     *");
        System.out.println("*               Ogrenci Notu Eklemek İçin - 3                    *");
        System.out.println("*                    Ogrenci Notları    - 4                      *");
        System.out.println("*                                                                *");
        System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
        menuSelection();
    }

    public static void menuSelection(){
        // menuSelection fonksiyonu uygulama açıldıktan sonra kullanıcının hangi işlemi yapmak istediğini seçecerek
        // ilgili menüye erişimini sağlar

        Scanner keyboard = new Scanner(System.in);
        System.out.println("*                                                                *");
        System.out.println("Lütfen erişmek istediğiniz Menü Numarasını Giriniz : ");

        int menuNo = keyboard.nextInt();

        switch (menuNo){
            case 1://ogrenci eklemek icin
                studentRegister();
                break;
            case 2://tum ogrencileri gormek icin
                getStudents();
                break;
            case 3://ogrenci notu ekleme
                setStudentPoint();
                break;
            case 4://veriler txt dosyasında bulunan öğrenci verilerini okur
                getStudentPoint();
                break;
        }
    }

    public static void studentRegister(){
        // studentRegister fonksiyonu yeni bir ogrenci oluşturmak için hazırlanmıştır

        String name,surname,country,program,studentNumber;
        Integer age;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ogrenci Adını Giriniz : ");
        name = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ogrenci Soyadını Giriniz : ");
        surname = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ülkenizi Giriniz(Türkiye,Fransa,Almanya) : ");
        country = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ogrenci Bolumunu Giriniz");
        program = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ogrenci Okul Numarasini Giriniz");
        studentNumber = keyboard.nextLine();
        System.out.println("Lütfen Yaşınızı Giriniz(10 dan büyük 95 den küçük) : ");
        age = keyboard.nextInt();
        System.out.println("*                                                                *");

        // Scanner sınıfı ile cmd-console ekran üzerinden kullanıcıdan verileri alarak
        // bu fonksiyona özel olan değişkenlere atadık.
        // StudentModel sınıfı ile oop ye uygun olarak kullanıcımızı model olarak oluşturarak
        // Main sınıfı içerisinde bulunan arrayList tipinde ki kullanıcılar listesine ekleyeceğiz

        switch (country){
            case "Türkiye":
                break;
            case "Fransa":
                break;
            case "Almanya":
                break;
            default:
                System.out.println("*                                                                *");
                System.out.println("*     Hatalı Ülke Seçtiniz.Üyelik İşlemi baştan Başlatılıyor     *");
                studentRegister();
                break;
        }

        StudentModel studentModel = new StudentModel();

        if (age>10 && age<95){
            studentModel.setName(name);
            studentModel.setSurname(surname);
            studentModel.setAge(age);
            studentModel.setCountry(country);
            studentModel.setIdNo(generateUserId(country));//generateUserId fonksiyonu ile ogrenciye özel bir idNo oluşturduk
            studentModel.setProgram(program);
            studentModel.setSchoolNumber(studentNumber);

            // studentModel değişkeni bu fonksiyon içerisinde özel tanımlı olan kullanıcı model nesnesiydi
            // studentModel değişkenini son olarak studentModelList isimli kullanıcı modeli tipindeki arrayList e ekledik

            studentModelList.add(studentModel);

            System.out.println("*                                                                *");
            System.out.println("*                 Ogrenci Sisteme Basarıyla Eklendi              *");
            menuSelection();//tekrar uygulama menüsüne giriş hakkı veriyoruz
        }else{
            System.out.println("*                                                                *");
            System.out.println("*      Hatalı Yaş Girdiniz.Üyelik İşlemi baştan Başlatılıyor     *");
            studentRegister();
        }
    }

    public static String generateUserId(String country){
        // dışarıdan ülke adını alarak özel ülke kodunu oluşturduk
        // daha sonra random olarak 10 karakterlik bir sayı oluşturduk ve kullanıcıya özel bir idNo üreterek
        // bu idNo değerini geriye döndürdük
        String idNo = null;
        String countryCode = null;

        switch (country){
            case "Türkiye":
                countryCode = "TR";
                break;
            case "Fransa":
                countryCode = "FR";
                break;
            case "Almanya":
                countryCode = "DE";
                break;
        }

        idNo = countryCode;

        for (int i=0;i<10;i++){
            idNo = idNo + (int)((Math.random() * 9)+0);
        }

        return idNo;
    }

    public static void getStudents(){
        // getStudents fonksiyonu ile tum ogrenciler listesini gösteriyoruz

        System.out.println("*                                                                *");
        System.out.println("*                   Sistemde Kayitli Tum Ogrenciler              *");

        int userSize = studentModelList.size();

        if (userSize>0){
            for (int i=0;i<userSize;i++){
                System.out.println("* "+(i+1)+"-> Ad : "+studentModelList.get(i).getName()+" -- Soyad : "+studentModelList.get(i).getSurname()
                        +" -- Ülke : "+studentModelList.get(i).getCountry()+" -- Yaş : "+studentModelList.get(i).getAge()
                        +" -- IdNo : "+studentModelList.get(i).getIdNo()
                        +" -- Okudugu Bolum : "+studentModelList.get(i).getProgram()
                        +" -- Okul Numarası : "+studentModelList.get(i).getSchoolNumber()
                        +" *");
            }
            System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
            System.out.println("*              Toplam "+userSize+" Orenci Kayıtlı                *");
            System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
            menuSelection();//tekrar uygulama menüsüne giriş hakkı veriyoruz
        }else {
            System.out.println("*                                                                *");
            System.out.println("*                   Kayıtlı Orenci Yok                           *");
            menuSelection();//tekrar uygulama menüsüne giriş hakkı veriyoruz
        }
    }

    public static void getStudentPoint(){
        int postSize = studentPoints.size();

        for (int i=0;i<postSize;i++){
            if (studentPoints.get(i).getPuanFinal()>50){
                if (studentPoints.get(i).getPuanOrt()>50){
                    System.out.println("* "+i+" **  **  **  **  **  **  ** ** **  **  **  **  **  **  *  *");
                    System.out.println("* Kullancı IdNo :"+studentPoints.get(i).getStudentIdNo());
                    System.out.println("* ders :"+studentPoints.get(i).getDers());
                    System.out.println("* vize :"+studentPoints.get(i).getPuanVize());
                    System.out.println("* final :"+studentPoints.get(i).getPuanFinal());
                    System.out.println("* ortalama :"+studentPoints.get(i).getPuanOrt());
                    System.out.println("* ders geçme durumu : GEÇTİ");
                    System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
                }else {
                    System.out.println("* "+i+" **  **  **  **  **  **  ** ** **  **  **  **  **  **  *  *");
                    System.out.println("* Kullancı IdNo :"+studentPoints.get(i).getStudentIdNo());
                    System.out.println("* ders :"+studentPoints.get(i).getDers());
                    System.out.println("* vize :"+studentPoints.get(i).getPuanVize());
                    System.out.println("* final :"+studentPoints.get(i).getPuanFinal());
                    System.out.println("* ortalama :"+studentPoints.get(i).getPuanOrt());
                    System.out.println("* ders geçme durumu : geçemedi");
                    System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
                }
            }else{
                System.out.println("* "+i+" **  **  **  **  **  **  ** ** **  **  **  **  **  **  *  *");
                System.out.println("* Kullancı IdNo :"+studentPoints.get(i).getStudentIdNo());
                System.out.println("* ders :"+studentPoints.get(i).getDers());
                System.out.println("* vize :"+studentPoints.get(i).getPuanVize());
                System.out.println("* final :"+studentPoints.get(i).getPuanFinal());
                System.out.println("* ortalama :"+studentPoints.get(i).getPuanOrt());
                System.out.println("* ders geçme durumu : geçemedi");
                System.out.println("*  **  **  **  **  **  **  ** ** **  **  **  **  **  **  **  **  *");
            }
        }
        menuSelection();//tekrar uygulama menüsüne giriş hakkı veriyoruz
    }

    public static void setStudentPoint(){
        String studentId,ders;
        int vizePoint,finalPoint;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ogrenci Numarası Giriniz : ");
        studentId = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Ders Adını Giriniz : ");
        ders = keyboard.nextLine();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Vize Notu Giriniz : ");
        vizePoint = keyboard.nextInt();
        System.out.println("*                                                                *");
        System.out.println("Lütfen Final Notu Giriniz : ");
        finalPoint = keyboard.nextInt();

        StudentPointModel studentPointModel = new StudentPointModel();
        studentPointModel.setStudentIdNo(studentId);
        studentPointModel.setDers(ders);
        studentPointModel.setPuanVize(vizePoint);
        studentPointModel.setPuanFinal(finalPoint);
        studentPointModel.setPuanOrt((vizePoint * 0.4)+(finalPoint * 0.6));
        setTxtWrite(studentPointModel);
    }

    public static void setTxtWrite(StudentPointModel pointModel){
        try {
            FileWriter writer = new FileWriter("C:\\Users\\cekix\\Desktop\\Bilge Can Ogrenci Otomasyonu\\src\\Veriler\\veriler.txt", true);
            String line = "("+pointModel.getStudentIdNo()+";"+pointModel.getDers()+";"+pointModel.getPuanVize()+";"+pointModel.getPuanFinal()+";"+pointModel.getPuanOrt()+")";
            writer.write(line+"\n");
            writer.close();
            Helpers.verilerTxtReader();
            menuSelection();//tekrar uygulama menüsüne giriş hakkı veriyoruz
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
