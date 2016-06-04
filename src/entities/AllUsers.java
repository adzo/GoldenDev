/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


public class AllUsers {
    private int id;
    private String login;
    private String mdp;
    private String type;

    /**
     *
     */
    public static AllUsers connected;
    public static AllUsers modifiedUser;
    /**
     *
     */
    public static java.util.List<AllUsers> listes;
    
    
    public AllUsers() {
        listes = new ArrayList<>();
    }

    public AllUsers(String login) {
        this.login = login;
    }

    public AllUsers(String login, String mdp, String type) {
        this.login = login;
        this.mdp = mdp;
        this.type = type;
    }
    
    public AllUsers(int id, String login, String mdp, String type) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AllUsers{" + "id=" + id + ", login=" + login + ", mdp=" + mdp + ", type=" + type + '}';
    }
    
    
     public static void affichage() {
        Iterator<AllUsers> iter = listes.iterator();
        AllUsers u = new AllUsers();
        while (iter.hasNext()) {
            u = iter.next();
            System.out.println(u);
        }
    }
}
