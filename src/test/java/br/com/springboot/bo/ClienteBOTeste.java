package br.com.springboot.bo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

public class ClienteBOTeste {

	@Autowired
	private ClienteBO bo;
	
	public void insere() {
		Cliente cliente = new Cliente();
		
		cliente.setNome("José Marinho");
		cliente.setCpf("01234567894");
		cliente.setDataDeNascimento(LocalDate.of(1965, 1, 11));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("0123456789");
		cliente.setCelular("01234567893");
		cliente.setAtivo(true);
		bo.insere(cliente);
	}
	
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setCpf("98765432103");
		bo.atualiza(cliente);
	}
	
}
