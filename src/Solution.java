import java.io.IOException;
import java.util.*;

/*
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            String [] wheelsArray = loadWheelNamesFromDB();
            Enum[] wheelsEnum = Wheel.values();
            List <String> wheelsString = new ArrayList<>();
            for (int i = 0; i < wheelsEnum.length; i++) {
                wheelsString.add(String.valueOf(wheelsEnum[i]));
//                System.out.println(wheelsString.get(i));
            }
//            System.out.println("///");
//            System.out.println(wheelsString.contains("BACK_RIGHT"));
//            System.out.println("///");

            Set <Wheel> result = new HashSet<>();
            for (String wheel : wheelsArray) {
                try {
                    if (wheelsString.contains(wheel)) {
//                        System.out.println("wheelsArray = " + wheel);
//                        System.out.println(wheelsString.contains(wheel));
                        Wheel newWheel = Wheel.valueOf(wheel);
                        result.add(newWheel);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
            if (result.size() != 4)
            throw new IllegalArgumentException();
            else {
                this.wheels = new ArrayList<>(result);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println("car");
        System.out.println(new Car().wheels);
    }
}
