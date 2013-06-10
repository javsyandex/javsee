/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author miha
 */
public interface Remainder {
    public List<RemainderDocument> getRemainderList(Date date);
}
