package com.sucodev.student.payload.response;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sucodev.student.domain.Student;
import lombok.*;


import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class StudentResponse {
    private UUID id;
    private String name;
    private String lopName;

    public static StudentResponse createStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .lopName(student.getLop().getName())
                .build();
    }
}
