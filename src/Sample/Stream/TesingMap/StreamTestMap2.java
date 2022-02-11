package Sample.Stream.TesingMap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTestMap2 {
    public static void main(String[] args) {

        class StaffPublic {
            private String name;
            private int age;
            private String extra;

            StaffPublic() {
            }
            public void setName(String name) {
                this.name = name;
            }
            public void setAge(int age) {
                this.age = age;
            }
            public void setExtra(String extra) {
                this.extra = extra;
            }
        }
        class Staff {

            private String name;
            private int age;
            private BigDecimal salary;

            public Staff(String name, int age, BigDecimal salary) {
                this.name = name;
                this.age = age;
                this.salary = salary;
            }
            public String getName() {
                return name;
            }
            public int getAge() {
                return age;
            }
            public BigDecimal getSalary() {
                return salary;
            }

        }

        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        // convert inside the map() method directly.
        List<StaffPublic> result = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            return obj;
        }).collect(Collectors.toList());

        System.out.println(result);


    }
}
