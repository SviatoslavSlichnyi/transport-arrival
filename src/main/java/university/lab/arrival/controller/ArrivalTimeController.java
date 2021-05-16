package university.lab.arrival.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.lab.arrival.dto.CalculatedArrivalTimeDto;
import university.lab.arrival.service.ArrivalTimeCalculatorService;
import university.lab.transport.dto.ArrivalTimeDto;

@RequiredArgsConstructor

@RestController
@RequestMapping("/arrival-time")
public class ArrivalTimeController {

    private final ArrivalTimeCalculatorService arrivalTimeCalculatorService;

    @PostMapping("/calculate")
    public CalculatedArrivalTimeDto calculateTime(@RequestBody ArrivalTimeDto arrivalTimeDto) {
        return arrivalTimeCalculatorService.calculateArrivalTimeDto(arrivalTimeDto);
    }
}
