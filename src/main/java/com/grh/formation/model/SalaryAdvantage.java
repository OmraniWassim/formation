package com.grh.formation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "SALARYADVANTAGE")
public class SalaryAdvantage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String advantage;

    @OneToMany(mappedBy = "salaryAdvantage")
    private List<Collaborateur> collaborateurs;

    public SalaryAdvantage(String advantage) {
        this.advantage = advantage;
    }
}
