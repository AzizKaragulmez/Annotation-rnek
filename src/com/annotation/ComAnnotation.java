package com.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target (ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface GeoBilgi{
    public String sekilIsmi();  //Burda string değer yazdık çünkü değerimiz sayı değil
    public int kenarSayisi();}  //burda int le bir değer girdik çünkü değerimiz sayı ve işlemlerimizde bol bol kullanıcaz
@GeoBilgi (sekilIsmi = "Dörtgen", kenarSayisi=4)  //String değerimize ve int değerimize değerlerini girdik
class GeometrikSekil {                          //Burada kenar sayısını çok kullanıcağız
        public int icAci (int kenar) {          // burda iç açı bulmak istediğimiz için işlem yaptıryoruz
            return (180* (kenar-2)) ; }
        public int kosegenSayisi (int kenar) {  //Burda köşegen sayılarını bulmak istediğimiz için işlem yaptırıyoruz
            return (kenar*(kenar-2))/2;}
        public int dışAci (int kenar) {     //Burda dış açıyı bulmak istediğimiz için işlem yaptıryoruz.
            return (270*kenar); }
         public int kenar (int kenar) {         // Burda işlem  yapmadan direk kenar sayısnı istedim
            return (kenar);}}
public class ComAnnotation {
    public static void main(String[] args) 
    {Geometriksekil g= new Geometriksekil( );
      GeoBilgi annotation= g.getClass( ).getAnnotation( GeoBilgi.class);
      //annotation bilgilerimizi oluşturduğumuz nesne içerisine aldık.
    int aci= g.icAci (annotation.kenarSayisi());
      //kenar sayısını annotation içerisinden aldırarak geometrik şekilimizin iç açısını bulduk.
    int daci= g.dışAci (annotation.kenarSayisi());
      //kenar sayısını annotation içerisinden aldırarak geometrik şekilimizin dış açısını bulduk.
    int kosegen = g.kosegenSayisi (annotation.kenarSayisi());
      //yine kenar sayısını annotation alarak köşegen sayısını bulduk
    int kenar = g.kenar (annotation.kenarSayisi());
      //yine kenar sayısını bildiğimiz için direk istedik
        System.out.println(annotation.sekilIsmi() + " :");    //Başlığımız direk çağrıdık
        System.out.println("karenin Bir iç açısı= "+ aci);      // hesapladığımız sonucu ve hangi sonuç olduğunu atadık
        System.out.println("köşegen sayısı=" + kosegen);    // hesapladığımız sonucu ve hangi sonuç olduğunu atadık
        System.out.println("Karenin dış açısı="+daci);   // hesapladığımız sonucu ve hangi sonuç olduğunu atadık
        System.out.println("Karenin kenar sayısı="+kenar);    // hesapladığımız sonucu ve hangi sonuç olduğunu atadık
    }}


        
    

    

