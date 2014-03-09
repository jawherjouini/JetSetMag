/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.dao;

import java.util.List;
import javafx.collections.ObservableList;


/**
 *
 * @author tasnim
 */
public interface IJetSet<T> {
    
    	public int create(T obj);
	public int update(T obj);
	public int delete(T obj);
	public ObservableList<T> read();
	public T readById(int id);
    
}
