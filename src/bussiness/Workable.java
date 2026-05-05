/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bussiness;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author khach
 */
public interface Workable<T> {
  void addNew(T x);

  void delete(T x);

  T search(String id);

  void showAll();
  
  void showAll(Collection<T> l);

  void readFromFile(String pathFile);
  
  void saveToFile(String pathFile);
  
  void addListToMap(List<T> data);
  
  T dataToObject(String data);
  
  boolean checkExist(String id);
}
