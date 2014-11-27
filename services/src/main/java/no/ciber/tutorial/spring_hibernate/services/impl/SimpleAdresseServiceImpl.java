package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SimpleAdresseServiceImpl implements AdresseService {

    private static final List<Adresse> adresseListe;

    static {
        List<Adresse> l = new ArrayList<>();
        l.add(new Adresse(1L).land("Norge").postnummer(7300).poststed("Orkanger").linje1("Nylandet 2"));
        l.add(new Adresse(2L).land("Norge").postnummer(7320).poststed("Fanrem").linje1("Orkdalsveien 21").linje2("Pb 2000"));
        l.add(new Adresse(3L).land("Norge").postnummer(7300).poststed("Orkanger").linje1("Nylandet 3"));
        l.add(new Adresse(4L).land("Norge").postnummer(7300).poststed("Fanrem").linje1("Orkdalsveien 50"));
        adresseListe = Collections.unmodifiableList(l);
    }

    @Override
    public Adresse getAdresse(Long id) {
        return adresseListe.stream()
                .filter(adresse -> adresse.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Adresse> getAdresser() {
        return adresseListe;
    }
}
