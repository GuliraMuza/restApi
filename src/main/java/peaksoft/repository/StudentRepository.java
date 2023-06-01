package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.StudentResponse;
import peaksoft.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select new peaksoft.dto.StudentResponse(s.id,s.name,s.email,s.age,s.isBlocked) from Student s")
    List<StudentResponse>getAllStudents();


   // @Query("select new peaksoft.dto.StudentResponse(s.id,s.name,s.email,s.age,s.isBlocked) from Student s where s.id=?1")//where s.id=:id
      Optional< StudentResponse> getStudentsById(Long id);



   // @Query("select new peaksoft.dto.StudentResponse(s.id,s.name,s.email,s.age,s.isBlocked) from Student s where s.isBlocked=?1")//where s.id=:id
      List<StudentResponse>findAllByIsBlocked(Boolean isBlocked);



    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    void deleteStudentById(@Param("id") Long id);

        @Modifying
        @Query("UPDATE Student s SET s.name = :name, s.email = :email, s.age = :age WHERE s.id = :id")
        void updateStudent(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("age") int age);
    }


