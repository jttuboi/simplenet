package br.com.simplenet.repository.integration.test;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/repositoryContext-test.xml"})
public class ConnectionTest {
	@Autowired
	private DataSource ds;
	
	@Test
	public void DataSourceTest(){
		assertNotNull(ds);
	}
}
