package com.grh.formation.Service;

import com.grh.formation.model.Collaborateur;
import com.grh.formation.model.Responsable;

import java.util.List;

public interface ResponsableService {
    List<Responsable> getAll();


    Responsable ajouterResponsable(String name, Collaborateur collaborateur);
}
