
package com.example.evaluator.dto;

import lombok.Data;
import java.util.List;

@Data
public class Project {
    private String title;
    private List<String> techStack;
    private String description;
}
