package br.gov.sp.etec.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.sp.etec.gestaofesta.model.Login;

@Controller
public class LoginController {
	@Autowired
	LoginRepository repository;

	@GetMapping("/")
	public String abrirLogin() {
		return "login";
	}

	@PostMapping("/efetuar-login")
	public String abrirLogin(Login login) {

		Login user = repository.findByEmail(login.getEmail());

		if (login.getEmail().equals(user.getEmail()) && login.getSenha().equals(user.getSenha())) {
			return "redirect:/convidado/lista-convidados";
		} else {
			return "login";
		}

	}

	@GetMapping("login/cadastrar")
	public String loginCadastrar() {
		return "cadastro-login";
	}

	@PostMapping("/login/salvar")
	public String salvarCadastro(Login login) {
		repository.save(login);
		return "login";
	}

}