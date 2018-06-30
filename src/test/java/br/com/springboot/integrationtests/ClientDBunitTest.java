package br.com.springboot.integrationtests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import br.com.springboot.Application;
import br.com.springboot.entity.data.ClientData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = { Application.class }, webEnvironment=WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
 		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@ActiveProfiles("integrationtest")
@DatabaseSetup(value = "classpath:inputdata/SetupClient.xml", type = DatabaseOperation.REFRESH)
public class ClientDBunitTest {

	private RestOperations restTemplate;

	@Value("http://localhost:${local.server.port}/")
	private String host;
	
	@Before
	public void setup() {
		this.restTemplate = new RestTemplate();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllClientsTest() throws Exception {
		List<ClientData> client = this.restTemplate.getForObject(this.host + "/client/" , List.class);
		
		Assert.assertEquals(1, client.size());
	}

	@Test
	public void getNotExistingClientTest() throws Exception {
		ClientData client = this.restTemplate.getForObject(this.host + "/client/1" , ClientData.class);
		
		Assert.assertEquals(null, client.getName());
	}

	@Test
	public void getClientTest() throws Exception {
		ClientData client = this.restTemplate.getForObject(this.host + "/client/2" , ClientData.class);
		
		Assert.assertEquals("TESTE", client.getName());
	}

}
