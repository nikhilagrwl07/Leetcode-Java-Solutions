//package java8;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class StreamPractice {
//    public static void main(String[] args) {
//
////        Stream<Integer> streamWithLimit = Stream.generate(() -> 1).limit(5);
////        streamWithLimit.forEach(integer -> System.out.println(integer));
////
////        List<String> names = Arrays.asList("Nik", "Ritu", "AB");
////        names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
////
////        Stream<Integer> streamWithIterate = Stream.iterate(100, n-> n+1).limit(5);
////        streamWithIterate.forEach(integer -> System.out.println(integer));
//
//
////        Stream<String> nameStream = Stream.of("mohan","john","vaibhav","amit");
////        Stream<String> nameStartJ = nameStream.map(
////                (s) ->
////                {
////                    System.out.println("Map: "+s);
////                    return s.toUpperCase();
////
////                })
////                .filter(
////                        (s) ->
////                        {
////                            System.out.println("Filter: "+s);
////                            return s.startsWith("J");
////                        }
////                );
////
////        Optional<String> findAny = nameStartJ.findAny();
////        System.out.println("Final output: "+findAny.get());
//        Employee a = new Employee("f1", "l1", 10);
//        Employee b = new Employee("f2", "l2", 20);
//        Employee c = new Employee("f3", "l3", 30);
//        List<Employee> employees = Arrays.asList(a, b, c);
//
//        employees.sort(Comparator.comparing(String::toString));
//
//        // collect first Names of employee;
////        List<String> firstNames = employees.stream().map(Employee::getFirstName).collect(Collectors.toList());
////        System.out.println(firstNames);
////
////        // find person with min age
////        employees.stream().min(Comparator.comparingInt(Employee::getAge)).ifPresent(employee -> System.out.println(employee));
////
////        employees.stream().reduce((e1, e2) -> (e1.getAge()< e2.getAge())?e1:e2).ifPresent(employee -> System.out.println(employee));
////
////        int totalAgeOfEmployees = employees.stream().mapToInt(e -> e.getAge()).reduce(0, (age1, age2) -> (age1 + age2));
////        System.out.println(totalAgeOfEmployees);
//
//        int[] numbers = {1,2,3,4,5,6};
//        IntStream parallelIntStream = Arrays.stream(numbers).parallel();
//        parallelIntStream.forEach(number -> System.out.println(number + " "+ Thread.currentThread().getName()));
//
//        System.out.println("apple".compareTo("banana"));
//    }
//}
//
//
//class Employee {
//    String firstName;
//    String lastName;
//    int age;
//
//    public Employee(String firstName, String lastName, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}