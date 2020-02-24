package com.thusitha.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarSQLRepository carSQLRepository;

    @Autowired
    private CarNoSQLRepository carNoSQLRepository;

    public CarController() {
        super();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "Car Web-service";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<CarSQL> getAllCars() throws Exception {
        return this.carSQLRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    public CarSQL getCar(@PathVariable("plateNumber") final String plateNumber) throws Exception {
        return this.carSQLRepository.findById(plateNumber).get();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public void addCar(@RequestBody final CarSQL car) throws Exception {
        this.carSQLRepository.save(car);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("plateNumber") final String plateNumber) throws Exception {
        this.carSQLRepository.deleteById(plateNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    public void addRent(@PathVariable("plateNumber") final String plateNumber, @RequestParam(value = "rent", required = true) final Boolean rent, @RequestBody(required = false) final Rent dates) throws Exception {
        final CarSQL car = this.carSQLRepository.findById(plateNumber).get();
        car.setRent(rent ? dates : null);
        this.carSQLRepository.save(car);
    }

}
