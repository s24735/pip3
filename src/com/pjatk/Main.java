package com.pjatk;

import java.util.Scanner;

public class Main {
    public static Scanner scanner=new Scanner(System.in);


    public static void main(String[] args) {

//        ZADANIE 1
        System.out.println("ZADANIE 1");
        zadanie1(scanner);

//        ZADANIE 2
        System.out.println("ZADANIE 2");
        zadanie2(scanner);

//        ZADANIE 3
        System.out.println("ZADANIE 3");
        zadanie3(scanner);


//        ZADANIE 4
        System.out.println("ZADANIE 4");
        zadanie4(scanner, 10.00, false);
//        zadanie4(scanner, 10.00, true);

//        ZADANIE 5
        System.out.println("ZADANIE 5");
//      pierwsza piosenka
        System.out.println("Podaj tytul pierwszego utworu: ");
        String firstTitle=scanner.nextLine();

        System.out.println("Podaj czas trwania pierwszego utworu(minuty): ");
        String firstTimeMinS=scanner.nextLine();
        int firstTimeMin=Integer.parseInt(firstTimeMinS);

        System.out.println("Podaj czas trwania pierwszego utworu(sekundy): ");
        String firstTimeSecS=scanner.nextLine();
        int firstTimeSec=Integer.parseInt(firstTimeSecS);

//      druga piosenka
        System.out.println("Podaj tytul drugiego utworu: ");
        String secondTitle=scanner.nextLine();

        System.out.println("Podaj czas trwania drugiego utworu(minuty): ");
        String secondTimeMinS=scanner.nextLine();
        int secondTimeMin=Integer.parseInt(secondTimeMinS);

        System.out.println("Podaj czas trwania drugiego utworu(sekundy): ");
        String secondTimeSecS=scanner.nextLine();
        int secondTimeSec=Integer.parseInt(secondTimeSecS);

        String firstSong = zadanie5(firstTitle, firstTimeMin, firstTimeSec);
        String secondSong = zadanie5(secondTitle, secondTimeMin, secondTimeSec);

        System.out.println("------------------------------");
        System.out.println("UTWORY");

        if(firstTimeMin>secondTimeMin){
            System.out.println("1. "+firstSong);
            System.out.println("2. "+secondSong);
        }
        else if(firstTimeMin<secondTimeMin){
            System.out.println("1. "+secondSong);
            System.out.println("2. "+firstSong);
        }
        else {
            if(firstTimeSec>secondTimeSec){
                System.out.println("1. "+firstSong);
                System.out.println("2. "+secondSong);
            }
            else if(firstTimeSec<secondTimeSec){
                System.out.println("1. "+secondSong);
                System.out.println("2. "+firstSong);
            }
            else {
                System.out.println("1. "+firstSong);
                System.out.println("2. "+secondSong);
            }
        }

        int minSumOfTwoSongs=firstTimeMin+secondTimeMin;
        int secSumOfTwoSongs=firstTimeSec+secondTimeSec;

        if(secSumOfTwoSongs>=60){
            minSumOfTwoSongs++;
            secSumOfTwoSongs=secSumOfTwoSongs-60;
        }
        String secSumOfTwoSongsString="";
        if(secSumOfTwoSongs<=9){
            secSumOfTwoSongsString="0"+secSumOfTwoSongs;
        }
        else
            secSumOfTwoSongsString=""+secSumOfTwoSongs;

        System.out.println("LACZNY CZAS TRWANIA: "+minSumOfTwoSongs+":"+secSumOfTwoSongsString);
        System.out.println("------------------------------");
    }

    public static String zadanie5(String title, int timeMin, int timeSec) {
        return title+" "+timeMin+":"+timeSec;
    }

    public static void zadanie4(Scanner scanner, double productPrice, boolean isDiscount) {
        System.out.println("Wczytaj liczbe sztuk zakupionego towaru:");
        String productCountS=scanner.nextLine();
        int productCount=Integer.parseInt(productCountS);

        if(!isDiscount)
            productPrice=productCount+(productCount*0.1);
        else {
            if(productCount<1)
                System.out.println("Liczba sztuk musi byc dodatnia");
            else if(productCount>=11)
                productPrice=productPrice/2.0;
        }

        System.out.println("Cena produktu: "+productPrice);
    }

    public static void zadanie3(Scanner scanner){
        System.out.println("Podaj rok");
        String yearS=scanner.nextLine();
        int year=Integer.parseInt(yearS);

        if(isYearLeap(year)){
            System.out.println("Rok jest przestepny");
        }
        else{
            System.out.println("Rok nie jest przestepny");
        }
    }

    public static boolean isYearLeap(int year) {
        if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
            return true;
        else
            return false;
    }


    public static void zadanie2(Scanner scanner) {
        System.out.println("Podaj miesiac:");
        String monthS=scanner.nextLine();
        int month=Integer.parseInt(monthS);


        System.out.println("Podaj rok:");
        String yearS=scanner.nextLine();
        int year=Integer.parseInt(yearS);

        String quarter="";

        if (month >= 0 && month <=3)
            quarter="I";
        else if (month >=4 && month <=6)
            quarter="II";
        else if (month >=7 && month <=9)
            quarter="III";
        else if (month >=10 && month <=12)
            quarter="IV";
        else
            System.out.println("ERROR");

        System.out.println(month+"."+year+" "+"to "+quarter+" "+year+" roku");
    }

    public static void zadanie1(Scanner scanner) {
        System.out.println("Podaj imie: ");
        String firstName=scanner.nextLine();

        System.out.println("Podaj nazwisko");
        String lastName=scanner.nextLine();

        System.out.println("Podaj plec (kobieta/mezczyzna): ");
        String gender=scanner.nextLine();

        if (gender.equals("kobieta")){
            System.out.println("Studentka: "+firstName+" "+lastName);
        }
        else if (gender.equals("mezczyzna")){
            System.out.println("Student: "+firstName+" "+lastName);
        }else{
            System.out.println("Nieznana plec");
        }
    }
}
