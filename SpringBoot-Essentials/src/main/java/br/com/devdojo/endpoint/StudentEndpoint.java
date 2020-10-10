package br.com.devdojo.endpoint;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Alexandre Vogel
 */
@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final StudentRepository studentDao;

    @Autowired
    public StudentEndpoint(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        //System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name){
        return new ResponseEntity<>(studentDao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable("id") Long id){
        verifyStudentsExists(id);
        Optional<Student> student = studentDao.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        return new ResponseEntity<>(studentDao.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyStudentsExists(id);
        studentDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        verifyStudentsExists(student.getId());
        studentDao.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * method of verification
     */
    private void verifyStudentsExists(Long id){
        if (studentDao.findById(id) == null) {
            throw new ResourceNotFoundException("Student not found for ID: " + id);
        }
    }

}
