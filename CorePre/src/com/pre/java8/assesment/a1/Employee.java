package com.pre.java8.assesment.a1;

import java.util.List;

class Employee {
    List<Skill> skills;

    public Employee(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
