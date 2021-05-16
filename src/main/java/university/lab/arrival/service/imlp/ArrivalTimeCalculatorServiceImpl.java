package university.lab.arrival.service.imlp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.lab.arrival.dto.CalculatedArrivalTimeDto;
import university.lab.arrival.service.ArrivalTimeCalculatorService;
import university.lab.transport.dto.ArrivalTimeDto;
import university.lab.transport.dto.PublicTransportDto;
import university.lab.transport.dto.StationDto;
import university.lab.transport.dto.TransportLocationDto;
import university.lab.transport.entity.type.MeasurementType;
import university.lab.transport.service.TransportLocationByGpsTrackerService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor

@Service
public class ArrivalTimeCalculatorServiceImpl implements ArrivalTimeCalculatorService {

    private static final Double AVERAGE_PUBLIC_TRANSPORT_SPEED = 45.0;

    private final TransportLocationByGpsTrackerService trackerService;

    @Override
    public CalculatedArrivalTimeDto calculateArrivalTimeDto(ArrivalTimeDto requestArrivalTimeDto) {
        PublicTransportDto transportDto = requestArrivalTimeDto.getTransport();
        StationDto stationDto = requestArrivalTimeDto.getSelectedStation();

        TransportLocationDto transportLocationDto = trackerService.getLocationByTransportId(transportDto.getPublicTransportId());
        transportDto.setLocation(transportLocationDto);

        Double distance =
                (transportLocationDto.getX() * 2 + transportLocationDto.getY() * 2 + stationDto.getStreetNumber())
                        % 1000;
        int expectedArrivalTimeHours = (int) (distance / AVERAGE_PUBLIC_TRANSPORT_SPEED);
        Instant expectedArrivalTime = Instant.now().plus(expectedArrivalTimeHours, ChronoUnit.HOURS);

        return CalculatedArrivalTimeDto.builder()
                .expectedArrivalTime(expectedArrivalTime)
                .distance(distance)
                .distanceMeasurementTypeShortCode(MeasurementType.KM.getShortCode())
                .build();
    }
}
