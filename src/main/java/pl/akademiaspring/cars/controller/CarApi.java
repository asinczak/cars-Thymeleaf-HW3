package pl.akademiaspring.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiaspring.cars.model.Car;
import pl.akademiaspring.cars.model.Colour;
import pl.akademiaspring.cars.model.Id;
import pl.akademiaspring.cars.service.CarService;

@Controller
@CrossOrigin
public class CarApi {

    private CarService carService;
    private Car findCar;


    @Autowired
    public CarApi (CarService carService){
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCar(Model model){
        model.addAttribute("cars", carService.getCarsList());
        model.addAttribute("newCar",new Car());
        model.addAttribute("id", new Id());
        model.addAttribute("idList", carService.getIdList());
        model.addAttribute("colourList", carService.getColoursAsList());
        model.addAttribute("modifiedWholeCar", new Car());

        return "car";
    }

    @PostMapping("/carsList")
    public ModelAndView getCarsList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("carList");
        mav.addObject("cars", carService.getCarsList());
        return mav;
    }

    @PostMapping("/getCarById")
    public ModelAndView getCarById(@ModelAttribute Id id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("foundCarById");
       findCar = carService.getCarById(id.getId());
        mav.addObject("findCar", findCar);

        return mav;
    }

    @PostMapping("/getCarByColour")
    public ModelAndView getCarByColour(@ModelAttribute Colour colour){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("foundCarByColour");
        findCar = carService.getCarByColour(colour);
        mav.addObject("findCar", findCar);

        return mav;

    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car){
        carService.addCar(car);
    return "redirect:/cars";
}

    @PostMapping("/modifyWholeCar")
    public String modCar(@ModelAttribute Car car){
        carService.modCar(car);
        return "redirect:/cars";
    }
//
//    @PatchMapping("/{id}/{colour}")
//    public ResponseEntity modCarElement(@PathVariable long id, @PathVariable String colour){
//        if(carService.modCarElement(id, colour)){
//            return new ResponseEntity(HttpStatus.OK);
//        }
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
    @PostMapping("/deleteById")
    public String removeCar(@ModelAttribute Id id){
        carService.removeCar(id.getId());
        return "redirect:/cars";
    }

}
