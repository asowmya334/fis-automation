package ApiAutomation.pojoClasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bpi {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private double rate_float;
}
