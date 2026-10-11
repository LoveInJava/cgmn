package com.abha.prep.dto;

import com.abha.prep.entity.EmployeeEntity;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FetchEmployee {
    private List<EmployeeDto> employees;
}
