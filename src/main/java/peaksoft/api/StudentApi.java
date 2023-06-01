package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.StudentRequest;
import peaksoft.dto.StudentResponse;
import peaksoft.dto.UpdateResponse;
import peaksoft.entity.Student;
import peaksoft.service.StudentService;

import java.util.List;
//@Controller мурун сонтроолер класска жазчуубуз азыр жазбайбыз
@RestController // под капотам @Controller иштейт , @ResponseBody боди тузуп берет
//@RequestMapping("/api/students")
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;


/*
    @GetMapping
    public List<Student> getAllStudents(){//Model ди  html ге бериш учун колдончубуз
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
       return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return  studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
       return studentService.deleteStudentById(id);
    }
*/


    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return  studentService.getStudentById(id);
    }
    //id лерге PathVariable колдонгон жакшы
    // @RequestParam boolean, search кылганга жакшы

    @PutMapping("/{id}")
    public UpdateResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id,studentRequest);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/block")
    public List<StudentResponse> getAllStudentsByBlockedOrNot(@RequestParam(required = false) Boolean isBlocked){
        return studentService.getStudentsByIsBlockedOrNot(isBlocked);
    }


    @PostMapping("/{studentId}")
    public SimpleResponse blockUnblockStudent(@PathVariable Long studentId, @RequestParam Boolean block){
        return studentService.blockUnblockStudent(studentId,block);

        }
    }



