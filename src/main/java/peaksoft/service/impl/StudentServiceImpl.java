package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.StudentRequest;
import peaksoft.dto.StudentResponse;
import peaksoft.dto.UpdateResponse;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;


    /*
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new NoSuchElementException("Student with id:"+id+"is not found"));
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student student1 = studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student with id:"+studentId+"is not found"));
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public String deleteStudentById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new NoSuchElementException("Student with id:"+id+" is not found");
        }
        studentRepository.deleteById(id);
        return "Student with id: "+id+" is deleted";
    }
*/








    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student=new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        student.setCreatedAt(LocalDate.now());
        student.setIsBlocked(false);
        studentRepository.save(student);
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getIsBlocked());
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.getAllStudents();
        //        return studentRepository.findAll(); бул только  студент кайтарат респонсто иштебейт
    }



   /* @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id:" + id + "is not found"));
        return new StudentResponse(
                student.getId(),
                student.getName(),     //1 вариант
                student.getEmail(),
                student.getAge(),
                student.getIsBlocked());
    }*/

    @Override
    public StudentResponse getStudentById(Long id) {//2 вариант
        return studentRepository.getStudentsById(id)
                .orElseThrow(() -> new NoSuchElementException("Student with id:" + id + "is not found"));
    }

    // TODO жава 8 кара
   /* @Override
    public Student updateStudent(Long studentId, Student student) {
        Student student1 = studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student with id:"+studentId+"is not found"));
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        studentRepository.save(student1);
        return student1;
    }*/



   /* @Override
    public UpdateResponse updateStudent(Long studentId, Student student) {
        studentRepository.updateStudent(studentId, student.getName(), student.getEmail(), student.getAge());
        Student updatedStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with id: " + studentId + " is not found"));

        return UpdateResponse.builder()
                .name(updatedStudent.getName())
                .email(updatedStudent.getEmail())
                .age(updatedStudent.getAge())
                .isBlocked(updatedStudent.getIsBlocked())
                .build();
    }*/


    @Override
    public UpdateResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        studentRepository.updateStudent(studentId, studentRequest.getName(), studentRequest.getEmail(), studentRequest.getAge());
        Student updatedStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with id: " + studentId + " is not found"));

        return UpdateResponse.builder()
                .name(updatedStudent.getName())
                .email(updatedStudent.getEmail())
                .age(updatedStudent.getAge())
                .isBlocked(updatedStudent.getIsBlocked())
                .build();
    }


    @Override
    public StudentResponse deleteStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student with id: " + id + " is not found"));

        studentRepository.deleteStudentById(id);

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getIsBlocked());
    }




    @Override
    public List<StudentResponse> getStudentsByIsBlockedOrNot(Boolean isBlocked) {
        return studentRepository.findAllByIsBlocked(isBlocked);
    }



    @Override
    public SimpleResponse blockUnblockStudent(Long studentId, Boolean block) {
        Student student1 = studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student with id:"+studentId+"is not found"));
        student1.setIsBlocked(block);
        studentRepository.save(student1);
        return new SimpleResponse("Blocked","Student with id:"+studentId+"is blocked");
    }
}
