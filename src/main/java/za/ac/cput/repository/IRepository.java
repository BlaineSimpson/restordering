package za.ac.cput.repository;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

public interface IRepository <T,ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
