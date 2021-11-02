package br.ucsal.Atividade.config;

import br.ucsal.Atividade.entities.Contact;
import br.ucsal.Atividade.repositories.RepositoryContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {

    @Autowired
    RepositoryContact repositoryContact;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Contact profile1 = new Contact(null, "Bruno", "Bruno.Vieira@ucsal.edu.br", "Rua 1", sdf.parse("02/11/2001"));
        Contact profile2 = new Contact(null, "Davi", "davi.brito@ucsal.edu.br", "Rua 2", sdf.parse("12/05/2001"));
        Contact profile3 = new Contact(null, "Lucilândia", "lucilandia.oliveira@ucsal.edu.br", "Rua 3", sdf.parse("27/01/1972"));
        repositoryContact.saveAll(Arrays.asList(profile1, profile2, profile3));
    }
}


