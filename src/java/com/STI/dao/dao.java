/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.STI.dao;

/**
 *
 * @author ilyes
 */
//import java.sql.Connection;

import java.sql.Connection;
import java.util.List;

public abstract class dao<T> {
	protected Connection cnx;

	public dao(Connection cnx) {
		super();
		this.cnx = cnx;
	}
	
	public Connection getCnx() {
		return cnx;
	}

	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}

	public abstract boolean create(T x);
	public abstract T read(String n);
	public abstract boolean updateConnect(T x, int m);
	public abstract boolean delete(T x);
	public abstract List<T> findAll();
        public abstract boolean updateUserInfo(T x);
}