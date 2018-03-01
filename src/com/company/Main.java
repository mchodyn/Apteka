package com.company;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;



public class Main {
    static Lista dodanyLek = new Lista();
    static Scanner input = new Scanner(System.in);
    public String name;
    public String producent;
    public Integer cena;
    public Integer ilosc;
    public String dataProdukcji;
    public Date dataWaznosci;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public String getDataProdukcji() {
        return dataProdukcji;
    }

    public void setDataProdukcji(String dataProdukcji) {
        this.dataProdukcji = dataProdukcji;
    }

    public Date getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }
    public static String getinput() {

        return input.nextLine().trim();
    }
    public void Wypisz(){
        System.out.println(name);
        System.out.println(producent);
        System.out.println(cena);
        System.out.println(ilosc);
        System.out.println(dataProdukcji);
        System.out.println(dataWaznosci);
    }
    public void Dodaj(){
        System.out.println("Podaj imie");
        if(input.hasNextLine()) {
            this.setName(input.nextLine());
        }
        System.out.println("podaj nazwe producenta");
        if (input.hasNextLine()) {
                this.setProducent(input.nextLine());
        }
        do {
            System.out.println("podaj cene leku");
            try{
                this.setCena(Integer.valueOf(getinput()));
            }
            catch (NumberFormatException nfe){
                System.out.println("to nie jest liczba");
            }
        }while(this.getCena()==null);
        do {
            System.out.println("podaj ilosc leku");
            try{
                this.setIlosc(Integer.valueOf(getinput()));
            }
            catch (NumberFormatException nfe) {
                System.out.println("to nie jest liczba");
            }
        }while(this.getIlosc()==null);

String Datawczytana;
Pattern Data = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        do{
        System.out.println("podaj date produkcji(yyyy.mm.dd)");
            Datawczytana=getinput();
            Matcher matcher = Data.matcher(Datawczytana);
            if(matcher.matches()) {
                this.setDataProdukcji(Datawczytana);
            }
            else{
                System.out.println("niepoprawny format");
            }
        }while(getDataProdukcji()==null);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
        do{
            System.out.println("podaj date waznosci leku yyyy.mm.dd");
            try{
                this.setDataWaznosci(sdf.parse(getinput()));
            }
            catch(ParseException pe){
                System.out.println("zle podana data");
            }
        }while(this.getDataWaznosci()==null);
    }






    public static void main(String[] args) {
String wybor;
        do{
            System.out.println("1.dodaj lek");
            System.out.println("2. wyswietl liste lekow");
            System.out.println("3.zamknij");

            wybor=getinput();
            if(wybor.equals("1"))
            {
                Main lek = new Main();
                lek.Dodaj();
                lek.Wypisz();
                dodanyLek.dodajLek(lek);
            }
            if(wybor.equals("2")) {
                Main lek;
                for (int i = 0; i < dodanyLek.getLeki().size(); i++) {
                    lek = dodanyLek.getLeki().get(i);
                    System.out.println(i + ":" + lek.getName());

                }
                System.out.println();
                Pattern wzorNumeru= Pattern.compile("[0-9]+");
                String numerWczytany;
                do{
                    System.out.println("wybierz lek");
                    numerWczytany=getinput();
                }while(!wzorNumeru.matcher(numerWczytany).matches());
                Integer numerLeku= Integer.parseInt(numerWczytany);
                if(dodanyLek.getLeki().size()>numerLeku){
                        Main wybranyLek=dodanyLek.getLeki().get(numerLeku);
                    System.out.println("Nazwa: "+wybranyLek.getName()+"Nazwa producenta: "+wybranyLek.getProducent()+"Cena: "+wybranyLek.getCena()+"Ilosc: "+wybranyLek.getIlosc());
                    }


            }
        }while(!wybor.equals("3"));


        }
       // dodanyLek.dlugoscTab(lek);

        //dodanyLek.wypiszListe(lek);


}
