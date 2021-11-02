package br.ucsal.Atividade.controllers;

import br.ucsal.Atividade.entities.Contact;
import br.ucsal.Atividade.services.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerContact {


    @Autowired
    private ServiceContact serviceContact;

    //    Métodos expositores de form's

    @GetMapping(value = "/searchContactForm")
    public String showFormContact() {
        return "searchForContact";
    }

    @GetMapping(value = "/searchForName")
    public String showFormName() {
        return "searchForName";
    }

    @GetMapping(path = "/contactForm")
    public String showForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "registrationContact";
    }

//    Métodos com lógica

    @PostMapping(path = "/registrationContact", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String insert(Contact obj) {
        System.out.println(obj);
        obj = serviceContact.save(obj);
        return "index";
    }

    @GetMapping("/listContacts")
    public String lisContacts(Model model) {
        model.addAttribute("ContactList", serviceContact.findAll());
        return "ContactList";
    }

    @GetMapping(value = "/name")
    public String name(Model model, @RequestParam(name = "name") String name) {
        System.out.println(name + "!!!!");
        List<Contact> contacts = serviceContact.findByName(name);
        contacts.forEach(System.out::println);
        model.addAttribute("contactList", contacts);
        return "contactList";
    }

    @GetMapping(value = "/contact")
    public String contact(Model model, @RequestParam(name = "id") String id) {
        Contact contact = serviceContact.findById(Long.decode(id));
        if (contact != null) {
            model.addAttribute("contact", contact);
        }
        return "findContact";
    }

    @GetMapping(value = "/deleteContactId")
    public String deleteContact(Model model, @RequestParam(name = "id") String id) {
        String ret = serviceContact.deleteById(Long.decode(id));
        model.addAttribute("ret", ret);
        return "success_error";
    }

    @GetMapping(value = "/updateContactId")
    public String updateContact(Model model, @RequestParam(name = "id") String id) {
        Contact contact = serviceContact.findById(Long.decode(id));
        model.addAttribute("contact", contact);
        return "updateContact";
    }

    @PostMapping(path = "/saveUpdate", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveUpdate(Model model, Contact obj, @RequestParam(name = "id") String id) {
        System.out.println(obj);
        obj = serviceContact.update(Long.decode(id), obj);
        model.addAttribute("contact", obj);
        return "findContact";
    }

}
