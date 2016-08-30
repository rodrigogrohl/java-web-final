package br.com.fiap.service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.AlunoRepository;
import br.com.fiap.data.ProfessorRepository;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Professor;
import br.com.fiap.model.Usuario;

@Stateless
public class UsuarioService {
	
	@Inject
	private ProfessorRepository professorRepository;
	
	@Inject
	private AlunoRepository alunoRepository;
	
	@Inject
	private Logger log;
	
	public Optional<Usuario> buscarPelasCredenciais(String login, String senha) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		try {
			
			Future<Professor> fProfessor = executorService.submit(() -> {
				return professorRepository.buscarPelasCredenciais(login, senha);
			});
			
			Future<Aluno> fAluno = executorService.submit(() -> {
				return alunoRepository.buscarPelasCredenciais(login, senha);
			});
			
			Professor prof = fProfessor.get();
			Aluno aluno = fAluno.get();
			
			if(prof != null) {
				return Optional.of(prof);
			}
			else if(aluno != null) {
				return Optional.of(aluno);
			}
		} 
		catch (ExecutionException | InterruptedException e) {
			log.severe(e.getMessage());
		}
		
		return Optional.empty();
	}	
}
