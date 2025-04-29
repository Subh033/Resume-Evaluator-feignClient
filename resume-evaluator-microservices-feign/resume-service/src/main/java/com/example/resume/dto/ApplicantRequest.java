
package com.example.resume.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApplicantRequest {
    private String applicantId;
    private PersonalInfo personal;
    private List<Education> education;
    private List<Experience> experience;
    private List<Project> projects;

    @Data
    public static class PersonalInfo {
        private String name;
        private String email;
        private Contact contact;
    }

    @Data
    public static class Contact {
        private String phone;
        private String linkedin;
    }

    @Data
    public static class Education {
        private String degree;
        private String major;
        private double cgpa;
        private int year;
    }

    @Data
    public static class Experience {
        private String company;
        private String role;
        private int durationInMonths;
        private List<String> skillsUsed;
    }

    @Data
    public static class Project {
        private String title;
        private List<String> techStack;
        private String description;
    }
}
