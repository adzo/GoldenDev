/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;

import entities.ResponsableAd;

/**
 *
 * @author AD ZO
 */
public interface InterfaceResponsableAD {
    public boolean add(ResponsableAd r);
    public boolean delete();
    public boolean update(ResponsableAd r);
}
