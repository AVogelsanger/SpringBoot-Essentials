package br.com.devdojo.repository;

import br.com.devdojo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author vogue
 * Classe pra acessar nosso banco de dados
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
}
