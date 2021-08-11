package com.ezen.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.jbpark.dabang.module.AddressMan;

public class PerformanceComp {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		connect_1000_timesWOpooling();
		long time = System.currentTimeMillis() - start;
		System.out.println("w/o pool time: " + time + "ms");
		
		start = System.currentTimeMillis();
		connect_1000_timesWithPooling();
		time = System.currentTimeMillis() - start;
		System.out.println("with pool time: " + time + "ms");
	}

	private static void connect_1000_timesWithPooling() {
		for (int i = 0; i<10000; i++) {
			try (var conn = DBCPDataSource.getConnection()) {
			} catch (SQLException e) {
			}
		}			
	}

	private static void connect_1000_timesWOpooling() {
		for (int i = 0; i<10000; i++) {
			try (var conn = AddressMan.getConnection()) {
			} catch (SQLException e) {
			}
		}		
	}
}

