package Models;

public class StudentPointModel {
    // Model sınıfı her bir ogrencilerin ders not durumu için oop ye uygun olarak modellenen bir sınıftır
    // Bu sınıf içerisinde belirtilmiş değişkenler bulunmaktadır
    // Her bir değişkenin kendi veri tipine uygun şekilde hazırlanmış get ve set fonksiyionları vardır
    // Set fonksiyonları(Metod) belirtilen değişkenin yeni değerini ayarlamak için kullanılır
    // Get fonksiyonları(Metod) belirtilen değişkenin Model sınıfı içerisinde var olan değerini bize verir

    // Bu model yapısında yapılandırıcı(Constructors) kullanmaya gerek duymadım.
    // Bunun sebebi ise, farklı bir yaklaşım ile projeyi tamamalamaktır


    String studentIdNo;
    int puanVize,puanFinal;
    double puanOrt;
    String ders;

    public String getStudentIdNo() {
        return studentIdNo;
    }

    public void setStudentIdNo(String studentIdNo) {
        this.studentIdNo = studentIdNo;
    }

    public int getPuanVize() {
        return puanVize;
    }

    public void setPuanVize(int puanVize) {
        this.puanVize = puanVize;
    }

    public int getPuanFinal() {
        return puanFinal;
    }

    public void setPuanFinal(int puanFinal) {
        this.puanFinal = puanFinal;
    }

    public double getPuanOrt() {
        return puanOrt;
    }

    public void setPuanOrt(double puanOrt) {
        this.puanOrt = puanOrt;
    }

    public String getDers() {
        return ders;
    }

    public void setDers(String ders) {
        this.ders = ders;
    }
}
