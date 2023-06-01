package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private int age;
    private Boolean isBlocked;

    public StudentResponse(Long id, String name, String email, int age, Boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.isBlocked = isBlocked;
    }
}
