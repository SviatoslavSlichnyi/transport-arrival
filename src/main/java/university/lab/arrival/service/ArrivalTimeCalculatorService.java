package university.lab.arrival.service;

import university.lab.arrival.dto.CalculatedArrivalTimeDto;
import university.lab.transport.dto.ArrivalTimeDto;

public interface ArrivalTimeCalculatorService {
    CalculatedArrivalTimeDto calculateArrivalTimeDto(ArrivalTimeDto requestArrivalTimeDto);
}
