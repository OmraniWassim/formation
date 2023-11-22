package com.grh.formation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @SequenceGenerator(name="salaryAdvantage",sequenceName ="salaryAdvantage",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "salaryAdvantage")
    private Long id;

    private String advantage;
    @JsonIgnore
    @OneToMany(mappedBy = "salaryAdvantage")
    private List<Collaborateur> collaborateurs;

    @ManyToOne
    @JoinColumn(name = "contract_type_id")
    private ContractType contractType;

    public SalaryAdvantage(String advantage) {
        this.advantage = advantage;
    }
}
