package tn.pi.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.pi.entities.Carte;
import tn.pi.services.CarteService;

import java.util.List;

@Controller
@RequestMapping("/api/cartes")
@RequiredArgsConstructor
public class CarteController {

    private final CarteService carteService;

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCartes();
    }

    @GetMapping("/{id}")
    public Carte getCarteById(@PathVariable Long id) {
        return carteService.getCarteById(id).orElseThrow(() -> new RuntimeException("Carte not found"));
    }

    @PostMapping
    public Carte createCarte(@RequestBody Carte carte) {
        return carteService.createCarte(carte);
    }

    @PutMapping("/{id}")
    public Carte updateCarte(@PathVariable Long id, @RequestBody Carte updatedCarte) {
        return carteService.updateCarte(id, updatedCarte);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable Long id) {
        carteService.deleteCarte(id);
    }
}
