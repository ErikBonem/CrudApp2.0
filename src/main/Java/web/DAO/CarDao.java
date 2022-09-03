package web.DAO;

import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDao {
        private final List<Car> cars;

        {
            cars = new ArrayList<>();
            cars.add(new Car("Ford", "Focus", 90));
            cars.add(new Car("Nissan", "X-Trail", 145));
            cars.add(new Car("Daewoo", "Matiz", 60));
            cars.add(new Car("Skoda", "Rapid", 110));
            cars.add(new Car("Dodge", "Ram TRX", 700));
        }
        public List<Car> carSheet(int count) {
            if (count == 0 || count > 5) return cars;
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }

