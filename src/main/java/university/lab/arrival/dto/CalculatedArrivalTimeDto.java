package university.lab.arrival.dto;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CalculatedArrivalTimeDto {

    private Instant expectedArrivalTime;

    private Double distance;

    private String distanceMeasurementTypeShortCode;
}
