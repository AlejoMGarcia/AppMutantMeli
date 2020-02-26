package app.meli.mutant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stats implements Serializable {
    private Long countMutantDNA;
    private Long countHumanDNA;
    private Double ratio;
}
