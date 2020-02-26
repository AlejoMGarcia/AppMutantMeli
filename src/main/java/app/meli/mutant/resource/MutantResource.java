package app.meli.mutant.resource;

import app.meli.mutant.dto.DNASequence;
import app.meli.mutant.dto.Stats;
import app.meli.mutant.exception.MutantException;
import app.meli.mutant.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantResource {

    @Autowired
    MutantService mutantService;

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void isMutant(@RequestBody DNASequence dnaSequence) throws MutantException {
       mutantService.checkDna(dnaSequence.getDna());
    }

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Stats stats(){
        return mutantService.getStats();
    }
}
