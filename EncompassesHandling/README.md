# Student Management System

## Framework and Language
* ### Framework
    * Spring Boot
* ### Language
    * Java

## Data Flow
### 1. Controller

* **STUDENT Controller**
```java
 @RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public String addStudent(@RequestBody Student std){
        return studentService.addStudent(std);
    }

    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudent(id);
    }

    @PutMapping("/id/{id}")
    public String updateStudent(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return studentService.updateStudent(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
```
* **ADDRESS Controller**
```java

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("/id/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddress(id);
    }

    @PutMapping("/id/{id}")
    public String updateAddress(@PathVariable Long id,@RequestParam String columnName,@RequestParam String val){
        return addressService.updateAddress(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
```
* **COURSE Controller**
```java
 @RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @PutMapping("/id/{id}")
    public String updateCourse(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return courseService.updateCourse(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteCourse(@PathVariable String id){
        return courseService.deleteCourse(id);
    }


}

```
* **BOOK Controller**
```java
 @RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable String id){
        return bookService.getBook(id);
    }

    @PutMapping("/id/{id}")
    public String updateBook(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return bookService.updateBook(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }
}
```
* **LAPTOP Controller**
```java
 @RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping
    public String addLaptop(@RequestBody Laptop laptop){
        return laptopService.addLaptop(laptop);
    }

    @GetMapping("/id/{id}")
    public Laptop getLaptopById(@PathVariable String id){
        return laptopService.getLaptop(id);
    }

    @PutMapping("/id/{id}")
    public String updateLaptop(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return laptopService.updateLaptop(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteLaptop(@PathVariable String id){
        return laptopService.deleteLaptop(id);
    }

}
```
### 2. Services
* **STUDENT Service**
```java
 @Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudent(Student std) {
        studentRepo.save(std);
        return "Added new Student...";
    }

    public Student getStudent(String id) {
        return studentRepo.findById(id).get();
    }

    @Transactional
    public String updateStudent(String id, String columnName, String val) {
        if(studentRepo.existsById(id)){
            if(columnName.equals("name")){
                studentRepo.updateName(id,val);
            }
            else if(columnName.equals("age")){
                studentRepo.updateAge(id,val);
            }
            else if(columnName.equals("phoneNumber")){
                studentRepo.updatePhoneNumber(id,val);
            }
            else if (columnName.equals("branch")) {
                studentRepo.updateBranch(id,val);
            }
            else if(columnName.equals("department")){
                studentRepo.updateDepartment(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteStudent(String id) {
        studentRepo.deleteById(id);
        return "Deleted...";
    }
}
```
* **ADDRESS Service**
```java
 @Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Added..";
    }

    public Address getAddress(Long id) {
        return addressRepo.findById(id).get();

    }

    @Transactional
    public String updateAddress(Long id, String columnName, String val) {

        if(addressRepo.existsById(id)){
            if(columnName.equals("landmark")){
                addressRepo.updateLandmark(id,val);
            }
            else if(columnName.equals("zipcode")){
                addressRepo.updateZipcode(id,val);
            }
            else if(columnName.equals("district")){
                addressRepo.updateDistrict(id,val);
            }
            else if (columnName.equals("state")) {
                addressRepo.updateState(id,val);
            }
            else if(columnName.equals("country")){
                addressRepo.updateCountry(id,val);
            }
            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteAddress(Long id) {
        addressRepo.deleteById(id);
        return "Deleted...";
    }
}
```
* **COURSE Service**
```java
 @Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public String addCourse(Course course) {
        courseRepo.save(course);
        return "Added...";
    }

    public Course getCourse(String id) {
        return  courseRepo.findById(id).get();
    }

    public String updateCourse(String id, String columnName, String val) {
        if(courseRepo.existsById(id)){
            if(columnName.equals("title")){
                courseRepo.updateTitle(id,val);
            }
            else if(columnName.equals("description")){
                courseRepo.updateDescription(id,val);
            }
            else if (columnName.equals("duration")) {
                courseRepo.updateDuration(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteCourse(String id) {
        courseRepo.deleteById(id);
        return "deleted...";
    }
}

```
* **BOOK Service**
```java
@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;

    public String addBook(Book book) {
        bookRepo.save(book);
        return "Added...";
    }

    public Book getBook(String id) {
        return bookRepo.findById(id).get();
    }

    @Transactional
    public String updateBook(String id, String columnName, String val) {
        if(bookRepo.existsById(id)){
            if(columnName.equals("title")){
                bookRepo.updateTitle(id,val);
            }
            else if(columnName.equals("author")){
                bookRepo.updateAuthor(id,val);
            }
            else if(columnName.equals("description")){
                bookRepo.updateDescription(id,val);
            }
            else if (columnName.equals("price")) {
                bookRepo.updatePrice(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";

    }

    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Deleted...";
    }
} 
```
* **LAPTOP Service**
```java
 @Service
public class LaptopService {
    @Autowired
    ILaptopRepo laptopRepo;

    public String addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
        return "Added...";
    }

    public Laptop getLaptop(String id) {
        return laptopRepo.findById(id).get();
    }

    @Transactional
    public String updateLaptop(String id, String columnName, String val) {
        if(laptopRepo.existsById(id)){
            if(columnName.equals("name")){
                laptopRepo.updateName(id,val);
            }
            else if(columnName.equals("brand")){
                laptopRepo.updateBrand(id,val);
            }
            else if (columnName.equals("price")) {
                laptopRepo.updatePrice(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteLaptop(String id) {
        laptopRepo.deleteById(id);
        return "Deleted...";
    }
}

```

### 3. Repository
* **STUDENT Repo**
```java
 public interface IStudentRepo extends JpaRepository<Student,String> {

    @Modifying
    @Query(value = "update student set name= :val where id= :id",nativeQuery = true)
    void updateName(String id, String val);

    @Modifying
    @Query(value = "update student set age= :val where id= :id",nativeQuery = true)
    void updateAge(String id, String val);

    @Modifying
    @Query(value = "update student set phoneNumber= :val where id= :id",nativeQuery = true)
    void updatePhoneNumber(String id, String val);

    @Modifying
    @Query(value = "update student set branch= :val where id= :id",nativeQuery = true)
    void updateBranch(String id, String val);

    @Modifying
    @Query(value = "update student set department= :val where id= :id",nativeQuery = true)
    void updateDepartment(String id, String val);
}
```
* **ADDRESS Repo**
```java
 public interface IAddressRepo extends JpaRepository<Address,Long> {

    @Modifying
    @Query(value = "update address set landmark= :val where address_id= :id",nativeQuery = true)
    void updateLandmark(Long id, String val);

    @Modifying
    @Query(value = "update address set zipcode= :val where address_id= :id",nativeQuery = true)
    void updateZipcode(Long id, String val);

    @Modifying
    @Query(value = "update address set district= :val where address_id= :id",nativeQuery = true)
    void updateDistrict(Long id, String val);

    @Modifying
    @Query(value = "update address set state= :val where address_id= :id",nativeQuery = true)
    void updateState(Long id, String val);

    @Modifying
    @Query(value = "update address set country= :val where address_id= :id",nativeQuery = true)
    void updateCountry(Long id, String val);
}
```
* **COURSE Repo**
```java
 public interface ICourseRepo extends JpaRepository<Course,String> {

    @Modifying
    @Query(value = "update course set title= :val where id= :id",nativeQuery = true)
    void updateTitle(String id, String val);

    @Modifying
    @Query(value = "update course set description= :val where id= :id",nativeQuery = true)
    void updateDescription(String id, String val);

    @Modifying
    @Query(value = "update book set duration= :val where id= :id",nativeQuery = true)
    void updateDuration(String id, String val);
}
```
* **BOOK Repo**
```java
 public interface IBookRepo extends JpaRepository<Book,String> {

    @Modifying
    @Query(value = "update book set title= :val where id= :id",nativeQuery = true)
    void updateTitle(String id, String val);

    @Modifying
    @Query(value = "update book set author= :val where id= :id",nativeQuery = true)
    void updateAuthor(String id, String val);

    @Modifying
    @Query(value = "update book set description= :val where id= :id",nativeQuery = true)
    void updateDescription(String id, String val);

    @Modifying
    @Query(value = "update book set price= :val where id= :id",nativeQuery = true)
    void updatePrice(String id, String val);
}
```
* **LAPTOP Repo**
```java
 public interface ILaptopRepo extends JpaRepository<Laptop,String> {

    @Modifying
    @Query(value = "update laptop set name= :val where id= :id",nativeQuery = true)
    void updateName(String id, String val);

    @Modifying
    @Query(value = "update laptop set brand= :val where id= :id",nativeQuery = true)
    void updateBrand(String id, String val);

    @Modifying
    @Query(value = "update laptop set price= :val where id= :id",nativeQuery = true)
    void updatePrice(String id, String val);
}
```

### 4. Data Base
```java
  spring.datasource.url=jdbc:mysql://localhost:3306/encompasses_handling
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=update

        spring.jpa.properties.hibernate.show_sql=true
        spring.jpa.properties.hibernate.use_sql_comments=true
        spring.jpa.properties.hibernate.format_sql=true
```

## Data Structure
*  Set


## Project Summary
This project we use a Bidirectional mapping between the entities and this entities are student, course, laptop, address and book.
