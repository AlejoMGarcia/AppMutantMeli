package app.meli.mutant.service;

import app.meli.mutant.dto.Stats;
import app.meli.mutant.exception.MutantException;

public interface MutantService {
    void checkDna(String[] dna) throws MutantException;
    Stats getStats();
}
