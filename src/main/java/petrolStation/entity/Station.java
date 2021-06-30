package petrolStation.entity;

import lombok.*;

@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Station {
    private String name;
    private Petrol petrol1;
    private Petrol petrol2;
    private Petrol petrol3;
    private Petrol petrol4;

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private abstract class Petrol{
        private String name;
        private int price;
    }
}
