package com.ezen.connection;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DBCPDataSourceTest {

	@Test
	public void test() {
		try (var conn = DBCPDataSource.getConnection()) {
			assertTrue(conn.getMetaData().getUserName()
				.equals("myself"));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
