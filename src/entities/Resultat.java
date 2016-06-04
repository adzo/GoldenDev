/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author ift
 */
public class Resultat {
   private int idResultate;
   private String set1;
   private String set2;
   private String set3;

    public Resultat() {
    }

    public Resultat(int idResultate, String set1, String set2, String set3) {
        this.idResultate = idResultate;
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
    }

    public int getIdResultate() {
        return idResultate;
    }

    public String getSet1() {
        return set1;
    }

    public String getSet2() {
        return set2;
    }

    public String getSet3() {
        return set3;
    }

    public void setIdResultate(int idResultate) {
        this.idResultate = idResultate;
    }

    public void setSet1(String set1) {
        this.set1 = set1;
    }

    public void setSet2(String set2) {
        this.set2 = set2;
    }

    public void setSet3(String set3) {
        this.set3 = set3;
    }
}
