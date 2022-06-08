package com.infoworks.lab.dao;

import com.infoworks.lab.dto.DataTransferObject;

import java.util.List;

public interface DataAccessObject <ID, T extends DataTransferObject> {

    T findById(ID id);
    List<T> findAll();
    T update(T dto);
    T create(T dto);
    void delete(ID id);

}
