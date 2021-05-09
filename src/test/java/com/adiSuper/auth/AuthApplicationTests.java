package com.adiSuper.auth;

import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private DSLContext dslContext;


	@Test
	void contextLoads() {
	}

	@Test
	public void hikariConfiguration() {
		assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
		assertEquals(10, ((HikariDataSource) dataSource).getMaximumPoolSize());
		assertEquals("core", ((HikariDataSource) dataSource).getSchema());
	}

	@Test
	public void jooqDialect() {
		assertEquals("POSTGRES", dslContext.dialect().name());
	}

}
