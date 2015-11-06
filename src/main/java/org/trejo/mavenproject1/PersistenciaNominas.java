/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trejo.mavenproject1;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author T-107
 */
public class PersistenciaNominas {
    ArrayList<Nomina> nomina;
     public PersistenciaNominas()    {
         nomina = new ArrayList<Nomina>();
         
     }
    public void guardar(Nomina n) throws Exception{
        File f = new File("");
        if(f.exists()) nomina = leerTodo();
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        nomina.add(n);
        ois.writeObject(nomina);
    }
    public ArrayList<Nomina> leerTodo() throws Exception{
        File f = new File("");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        nomina = (ArrayList<Nomina>) ois.readObject();
        return nomina;
    }
    public Nomina buscarPorId(int id) throws Exception{
        Nomina n = null;
        nomina = leerTodo();
        n = nomina.get(id);
        return n;
    }
}
