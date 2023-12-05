package com.grh.formation.Service;

import com.grh.formation.model.SalaryAdvantage;

import java.util.List;

public interface SalaryAdvantageService {
    List<SalaryAdvantage> getAll();

    SalaryAdvantage addSalaryAdvantage(SalaryAdvantage salaryAdvantage, long contractType_id);
}
