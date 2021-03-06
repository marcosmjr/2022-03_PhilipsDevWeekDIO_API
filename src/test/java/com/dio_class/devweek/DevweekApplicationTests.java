package com.dio_class.devweek;

import com.dio_class.devweek.controller.ControllerRegiao;
import com.dio_class.devweek.entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {
	private final String URL="/api/regioes";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ControllerRegiao controller;

	//listar os objetos
	@Test
	public void getControllerTest() throws Exception{
		mockMvc.perform(get(URL)).andExpect(status().isOk());
	}

	@Test
	public void getByIdControllerTest() throws Exception{
		mockMvc.perform(get(URL+"/1")).andExpect(status().isOk());
	}

	@Test
	public void addNewRegiaoTest() throws Exception {
		Regiao newRegiao = new Regiao("Centro Oeste", 1000L);
		mockMvc.perform(post(URL+"/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newRegiao)))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteByIdRedgiaoTest() throws Exception {
		mockMvc.perform(delete(URL+"/delete/{id}","6")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	@Test
	public static String asJsonString(final Object obj){
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e){
			throw  new RuntimeException(e);
		}
	}

}
