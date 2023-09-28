# University Event Management

## Framework and Language
* ### Framework
    * Spring Boot
* ### Language
    * Java

## Data Flow
### 1. Controller

* **Student Controller**
```java
    public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("students")
    public String addStudents(@RequestBody @Valid List<Student> stdList){
        return studentService.addStudents(stdList);
    }

    @PutMapping("student/id/{id}/department/{department}")
    public String updateStudentDepartmentById(@PathVariable Long id, @PathVariable String department){
        return  studentService.updateStudentDepartmentById(id,department);
    }

    @DeleteMapping("student/id/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return  studentService.deleteStudentById(id);
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("student/id/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
```
* **Event Controller**
```java
    public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("events")
    public String  addEvents(@RequestBody @Valid List<Event> eventList){
        return eventService.addEvents(eventList);
    }

    @PutMapping("event/id/{id}/date/{date}")
    public String updateEventDateById(@PathVariable Integer id,@PathVariable LocalDate date){
        return eventService.updateEventDateById(id,date);
    }

    @DeleteMapping("event/id/{id}")
    public String deleteEventById(@PathVariable Integer id){
        return eventService.deleteEventById(id);
    }

    @GetMapping("event/date/{date}")
    public  List<Event> getEventsByDate(@PathVariable LocalDate date){
        return eventService.getEventsByDate(date);
    }

    @PutMapping("event/id/{id}/eventName/{name}")
    public String updateEventNameById(Integer id, String name) {
        return eventService.updateEventNameById(id,name);
    }
}
```

### 2. Services
* **Student Service**
```java
    public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudents(List<Student> stdList) {
        studentRepo.saveAll(stdList);
        return "Added...";
    }

    @Transactional
    public String updateStudentDepartmentById(Long id, String department) {
        studentRepo.updateStudentDepartment(id,department);
        return "Updated...";
    }

    public String deleteStudentById(Long id) {
        studentRepo.deleteById(id);
        return "Deleted...";
    }

    public List<Student> getStudents() {
        return (List<Student>)studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        Student student = studentRepo.findById(id).get();
        return student;
    }
}
```
* **Event Service**
```java
    public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEvents(List<Event> eventList) {
        eventRepo.saveAll(eventList);
        return "Added...";
    }

    public String deleteEventById(Integer id) {
        eventRepo.deleteById(id);
        return "Deleted...";
    }

    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepo.findByDate(date);
    }

    @Transactional
    public String updateEventDateById(Integer id, LocalDate date) {
        eventRepo.updateEventDate(id,date);
        return "Updated...";
    }

    @Transactional
    public String updateEventNameById(Integer id, String name) {
        eventRepo.updateEventName(id,name);
        return "Updated...";
    }
}
```

### 3. Repository
* **Student Repo**
```java
    public interface IStudentRepo extends CrudRepository<Student, Long> {
    @Modifying
    @Query(value = "UPDATE student  SET department= :department where student_id= :id", nativeQuery = true)
    void updateStudentDepartment(@Param("id") Long id,@Param("department") String department);
}
```
* **Event Repo**
```java
    public interface IEventRepo extends CrudRepository<Event, Integer> {

    List<Event> findByDate(LocalDate date);

    @Modifying
    @Query(value = "update event set date=(:date) where event_id=(:id)",nativeQuery = true)
    void updateEventDate(Integer id, LocalDate date);

    @Modifying
    @Query(value = "update event set event_name = (:name) where event_id = (:id)",nativeQuery = true)
    void updateEventName(Integer id, String name);
}
```
### 4. Data Source
```java
    spring.datasource.url=jdbc:h2:mem:h2db
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=manjeet
    spring.datasource.password=uem
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    
    
    spring.h2.console.enabled=true
    spring.jpa.properties.hibernate.show_sql=true
    spring.jpa.properties.hibernate.use_sql_comments=true
    spring.jpa.properties.hibernate.format_sql=true

```

## Data Sturcture
* Searching
* List

## Project Summary
University Event Management involves the planning, organization, and execution of various events within a university setting. These events can encompass a wide range of activities, including academic conferences, seminars, workshops, cultural festivals, sports tournaments, and social gatherings.