package com.xinglongjian.bigdata.recommender.movie.importdata;

import org.apache.mahout.cf.taste.model.JDBCDataModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataModel {
	
	public static JDBCDataModel getMySqlDataModel()
	{
		MysqlDataSource mds=new MysqlDataSource();
		JDBCDataModel jdm=null;
		try {
			mds.setServerName("127.0.0.1");
			mds.setUser("root");
			mds.setPassword("");
			mds.setDatabaseName("movie");

			//
			//jdm=new MySQLJDBCDataModel(mds,"movie_preferences","UserID","movieID","preference");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jdm;
	}

}
