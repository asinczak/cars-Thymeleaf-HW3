package pl.akademiaspring.cars.service;

import org.springframework.stereotype.Service;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.Colour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private List<Car> carsList;
    private List<Colour> coloursAsList;
    private List<Long> idList;

    public CarService() {
        this.carsList = new ArrayList();
        carsList.add(new Car(1L, "Volvo", "V70", Colour.STEEL));
        carsList.add(new Car(2L, "Audi", "A6", Colour.BLACK));
        carsList.add(new Car(3L, "Kia", "Stinger", Colour.RED));
        this.coloursAsList = Arrays.asList(Colour.values());
        this.idList = new ArrayList<>();
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public List<Colour> getColoursAsList() {
        return coloursAsList ;
    }

    public List<Long> getIdList() {
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

    public boolean modCar(Car car) {
        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == car.getId()).findFirst();
        if(firstCar.isPresent()) {
            carsList.remove(firstCar.get());
            carsList.add(car);
            return true;
        }
        return false;
    }

//    public boolean modCarElement(long id, String colour) {
//        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
//        if(firstCar.isPresent()){
//            firstCar.get().setColour(colour);
//            return true;
//        }
//        return false;
//    }

    public boolean removeCar(long id) {
        Optional<Car> firstCar = carsList.stream().filter(carFromList -> carFromList.getId() == id).findFirst();
        if(firstCar.isPresent()){
            carsList.remove(firstCar.get());
            return true;
        }
        return false;
    }
}
