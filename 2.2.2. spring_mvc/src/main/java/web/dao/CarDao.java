package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDao {
    private static int COUNT = 1;
    private static List<Car> carList;

    static {
        carList = new ArrayList<>();
        String[] companies = {"BMW", "Mitsubisi", "Audi", "Subaru", "Toyota"};
        String[] models = {"model1", "model2", "model3", "model4", "model5"};
        for(int i = 0; i < models.length; i++) {
            carList.add(new Car(COUNT++, companies[i], models[i]));
        }
    }

    public List<Car> showCar(Integer number) {
        if (number < 5 && number != 0) return carList.stream().limit(number).collect(Collectors.toList());
        return carList;
    }



}
