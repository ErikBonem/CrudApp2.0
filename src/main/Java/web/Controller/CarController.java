package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDao;
import web.Model.Car;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String carSheet(@RequestParam(defaultValue = "5") int count, Model model) {
        List<Car> cars = carDao.carSheet(count);
        model.addAttribute("cars", cars);
        return "cars/carSheet";

    }
}
