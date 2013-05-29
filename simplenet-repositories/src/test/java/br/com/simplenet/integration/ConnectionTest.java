package br.com.simplenet.integration;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/repository-context-test.xml")
public class ConnectionTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void DataSourceTest() {
	}

	@Test
	public void databaseConTest() throws SQLException {
		assertNotNull(dataSource);
	}
}
