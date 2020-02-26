package app.meli.mutant.service.impl;

import app.meli.mutant.dto.Stats;
import app.meli.mutant.exception.MutantException;
import app.meli.mutant.service.MutantService;
import app.meli.mutant.util.SequenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

    @Autowired
    SequenceUtils seqUtil;

    @Override
    public void checkDna(String[] dna) throws MutantException {
        checkMutant(dna);
    }

    @Override
    public Stats getStats(){
        throw new UnsupportedOperationException();
    }

    public void checkMutant(String[] sequence) throws MutantException {
        int count = 0;

        int rangeMatrix = sequence[0].length();
        int quotient = rangeMatrix / 2;
        int indexColumn = 2;

        for(int i=2; i <= quotient; i = i+2){
            for (int indexRow = 0; indexRow < rangeMatrix; indexRow++) {
                count = countEqualSequences(sequence, indexRow, indexColumn, count);

                if(count > 1)
                    throw new MutantException("this DNA corresponds to a mutant.");
            }
            indexColumn = indexColumn + 4;
        }
    }

    private int countEqualSequences(String[] sequence, int indexRow, int indexColumn, int count) {
        //Horizontal
        if(seqUtil.checkSequenceHorizontally(sequence, indexRow, indexColumn))
            count = count++;

        //Vertical
        if(seqUtil.checkSequenceVertically(sequence, indexRow, indexColumn))
            count = count++;

        //Oblique ascending from left to right
        if(seqUtil.countSequenceObliqueLeftRight(sequence, indexRow, indexColumn))
            count = count++;

        //Oblique ascending from right to left
        if(seqUtil.countSequenceObliqueRightLeft(sequence, indexRow, indexColumn));
            count = count++;

        return count;
    }
}
