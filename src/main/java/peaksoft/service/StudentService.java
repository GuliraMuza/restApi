package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.StudentRequest;
import peaksoft.dto.StudentResponse;
import peaksoft.dto.UpdateResponse;
import peaksoft.entity.Student;
import java.util.List;

public interface StudentService {
  /*  Student saveStudent(Student student);
    List<Student>getAllStudents();
   Student  getStudentById(Long id);
    Student updateStudent(Long studentId,Student student);


    String deleteStudentById(Long id);*/


    StudentResponse saveStudent(StudentRequest studentRequest);
//StudentResponse ответ кайтарат
    List<StudentResponse>getAllStudents();
    StudentResponse  getStudentById(Long id);
    UpdateResponse updateStudent(Long studentId, StudentRequest studentRequest);
    StudentResponse deleteStudentById(Long id);

    List<StudentResponse>getStudentsByIsBlockedOrNot(Boolean isBlocked);

    SimpleResponse blockUnblockStudent(Long studentId, Boolean block);
}
