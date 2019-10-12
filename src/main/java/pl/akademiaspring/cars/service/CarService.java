package pl.akademiaspring.cars.service;

import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.Colour;
import pl.akademiaspring.cars.model.Id;

import java.util.*;

@Service
public class CarService {

    private List<Car> carsList;
    private List<Colour> coloursAsList;
    private Set<Long> idList;

    public CarService() {
        this.carsList = new ArrayList();
        carsList.add(new Car(1L, "Volvo", "V70", Colour.STEEL));
        carsList.add(new Car(2L, "Audi", "A6", Colour.BLACK));
        carsList.add(new Car(3L, "Kia", "Stinger", Colour.RED));
        this.coloursAsList = Arrays.asList(Colour.values());
        this.idList = new HashSet<>();
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public List<Colour> getColoursAsList() {
        return coloursAsList ;
    }

    public Set<Long> getIdList() {
        for (Car car : carsList) {
            idList.add(car.getId());
        }
        return idList;
    }


    public Car getCarById (long id){
        Optional<Car> first = carsList.stream().filter(car -> car.getId() == id).findFirst();
        return first.get();
    }

    public Car getCarByColour(Colour colour) {
        Optional<Car> first =  carsList.stream().filter(car -> car.getColour().equals(colour)).findFirst();
        return first.get();
    }

    public void addCar(Car car) {
         carsList.add(car);
    }

    public void modCar(Car car) {
        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == car.getId()).findFirst();
            carsList.remove(firstCar.get());
            carsList.add(car);
    }

    public void modCarElement(long id, Colour colour) {
        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
        firstCar.get().setColour(colour);
    }

    public void removeCar(long id) {
        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
        carsList.remove(firstCar.get());
    }

    public Id getIdToAddNewCar(){
        Long id = getIdList().stream().max(Long::compareTo).get();
        Id idForNewCar = new Id();
        idForNewCar.setId(id + 1L);
        return idForNewCar;
    }
}
