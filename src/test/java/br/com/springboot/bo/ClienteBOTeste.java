package br.com.springboot.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTeste {

	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		
		cliente.setNome("José Marinho");
		cliente.setCpf("01234567894");
		cliente.setDataDeNascimento(LocalDate.of(1965, 1, 11));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("0123456789");
		cliente.setCelular("01234567893");
		cliente.setAtivo(true);
		cliente.setEmail("jose@email.com.br");
		bo.insere(cliente);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setCpf("98765432103");
		bo.atualiza(cliente);
	}
	
	@Test
	@Order(4)
	public void lista() {
		System.out.println(bo.lista());
	}
	
	@Test
	@Order(5)
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setAtivo(false);
		bo.inativa(cliente);
	}
	
	@Test
	@Order(6)
	public void ativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setAtivo(true);
		bo.ativa(cliente);
	}
	
	@Test
	@Order(7)
	public void remove() {
		bo.remove(1L);
	}
	
}
