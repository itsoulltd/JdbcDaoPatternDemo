package com.infoworks.lab.dao;

import com.infoworks.lab.dto.DataTransferObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDataAccessObject<ID, T extends DataTransferObject> implements DataAccessObject<ID, T> {

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";
    protected final static String CUSTOMER_SEQUENCE = "hp_customer_seq";

    public AbstractDataAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    protected int getLastVal(String sequence){
        int key = 0;
        String sql = LAST_VAL + sequence;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                key=rs.getInt(1);
            }
            return key;
        }catch (SQLException e ){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
