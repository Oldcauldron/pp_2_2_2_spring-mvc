package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("")
    public String indexCar(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) count = 0;
        List<Car> carList = carDao.showCar(count);
        model.addAttribute(carList);
        return "cars";
    }

}
