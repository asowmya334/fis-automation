package ApiAutomation.pojoClasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class CoinDeskResponse {
    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, Bpi> bpi;
}
