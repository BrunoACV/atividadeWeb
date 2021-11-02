package br.ucsal.Atividade.services;

import br.ucsal.Atividade.entities.Contact;
import br.ucsal.Atividade.repositories.RepositoryContact;
import br.ucsal.Atividade.services.exception.ExceptionResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContact {

    @Autowired
    RepositoryContact repositoryContact;

    public List<Contact> findAll() {
        return repositoryContact.findAll();
    }

    public Contact findById(Long id) {
        Optional<Contact> obj = repositoryContact.findById(id);
//        return obj.orElseThrow(() -> new ExceptionResourceNotFound(id));
        return obj.orElse(null);
    }

    public List<Contact> findByName(String name) {
        return repositoryContact.findByName(name);
    }

    public Contact save(Contact contact) {
        return repositoryContact.save(contact);
    }

    public String deleteById(Long id) {
        try {
            repositoryContact.deleteById(id);
        } catch (Exception e) {
            return "Não foi possível achar o contato com id:" + id;
        }
        return "Exclusão feita com sucesso";
    }

    public Contact update(Long id, Contact obj) {
        try {
            Contact contact = repositoryContact.getById(id);
            updateDate(contact, obj);
            return repositoryContact.save(contact);
        } catch (Exception e) {
            return null;
        }
    }

    private void updateDate(Contact contact, Contact obj) {
        contact.setName(obj.getName());
        contact.setEmail(obj.getEmail());
        contact.setAddress(obj.getAddress());
        contact.setBirthDate(obj.getBirthDate());
    }


}

