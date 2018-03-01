package com.company;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    List<Main> lekarstwa= new ArrayList<Main>();
    public void dodajLek(Main lek){
        lekarstwa.add(lek);
        System.out.println("dodano pomyslnie");
    }
    public void dlugoscTab(Main lek){
        System.out.println(lekarstwa.size()) ;
    }
    public void wypiszListe(Main lek){
        for(int i =0;i<lekarstwa.size();i++)
        {   Main poz =lekarstwa.get(i);
            System.out.println(poz);
        }
    }
    public List<Main> getLeki(){
        return lekarstwa;

    }
}
