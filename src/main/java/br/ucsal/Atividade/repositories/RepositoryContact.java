package br.ucsal.Atividade.repositories;

import br.ucsal.Atividade.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryContact extends JpaRepository<Contact, Long> {
    List<Contact> findByName(String name);
}
