package br.com.springboot.integrationtests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.springboot.entity.data.ClientData;
import br.com.springboot.entity.enumeration.GenderEnum;
import br.com.springboot.rest.ClientRest;
import br.com.springboot.service.ClientService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientRest.class)
public class ClientTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientService clientService;

	@Test
	public void getAllClientsTest() throws Exception {
		List<ClientData> clients = new ArrayList<>();
		clients.add(createClient(1L));
		clients.add(createClient(2L));
		clients.add(createClient(3L));

		when(clientService.findAll()).thenReturn(clients);

		this.mockMvc.perform(get("/client/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(Matchers.hasSize(3)));
	}

	@Test
	public void getClientByIdTest() throws Exception {
		ClientData client = createClient(1L);
		
		when(clientService.findOne(1L)).thenReturn(client);
		
		this.mockMvc.perform(get("/client/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("name 1"));
	}

	@Test
	public void getNameClientByIdTest() throws Exception {
		ClientData client = createClient(1L);
		
		when(clientService.findOne(1L)).thenReturn(client);
		
		this.mockMvc.perform(get("/client/name/by?id=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").value("name 1"));
	}

	private ClientData createClient(Long id) {
		return new ClientData(id, "name ".concat(id.toString()), 3, GenderEnum.FEMININO);
	}

}
