# Employee Address

## Framework and Language
* ### Framework
    * Spring Boot
* ### Language
    * Java

## Data Flow
### 1. Controller


* **Employee Controller**
```java

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("employee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("employee/{id}/{columnName}={val}")
    public String updateEmployee(@PathVariable Long id, @PathVariable String columnName,@PathVariable String val){
        return employeeService.updateEmployee(id,columnName,val);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
```

* **Address Controller**
```java
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("addresses")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping("address/{id}")
    public Address getAddress(@PathVariable Long id){
        return addressService.getAddress(id);
    }

    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("addresses/{id}/{columnName}={val}")
    public String updateAddress(@PathVariable Long id, @PathVariable String columnName,@PathVariable String val){
        return addressService.updateAddress(id,columnName,val);
    }

    @DeleteMapping("address/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
```


### 2. Services
* **Employee Service**
```java
@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;

    public List<Employee> getEmployees() {
        return (List<Employee>)employeeRepo.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).get();
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Added...";
    }

    @Transactional
    public String updateEmployee(Long id, String columnName, String val) {
        if(employeeRepo.existsById(id)){
            if(columnName.equals("firstName")){
                employeeRepo.updateFirstName(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("lastName")){
                employeeRepo.updateLastName(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("addressId")){
                employeeRepo.updateAddressId(Long.parseLong(val),id);
                return columnName+" updated...";
            }
            else {
                return "Column name not found...";
            }

        }
        return "Invalid Id";
    }

    public String deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
        return "Deleted...";
    }
}
```

* **Address Service**
```java
@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getAddresses() {
        return (List<Address>)addressRepo.findAll();
    }

    public Address getAddress(Long id) {
        return addressRepo.findById(id).get();
    }

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Added...";
    }

    @Transactional
    public String updateAddress(Long id, String columnName, String val) {
        if(addressRepo.existsById(id)){
            if(columnName.equals("street")){
                addressRepo.updateStreet(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("city")){
                addressRepo.updateCity(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("state")){
                addressRepo.updateState(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("zipcode")){
                addressRepo.updateZipcode(val,id);
                return columnName+" updated...";
            }
            else {
                return "Column name not found...";
            }

        }
        return "Invalid Id";
    }

    public String deleteAddress(Long id) {
        addressRepo.deleteById(id);
        return "Deleted...";
    }
}
```


### 3. Repository
* **Employee Repo**
```java
 public interface IEmployeeRepo extends JpaRepository<Employee,Long> {

    @Modifying
    @Query(value = "UPDATE employee SET first_name = :val where emp_id= :id",nativeQuery = true)
    void updateFirstName(String val, Long id);

    @Modifying
    @Query(value = "UPDATE employee SET last_name = :val where emp_id= :id",nativeQuery = true)
    void updateLastName(String val, Long id);

    @Modifying
    @Query(value = "UPDATE employee SET fk_address_id = :val where emp_id= :id",nativeQuery = true)
    void updateAddressId(Long val, Long id);
}
```
* **Address Repo**
```java
public interface IAddressRepo extends JpaRepository<Address,Long> {

    @Modifying
    @Query(value = "UPDATE address SET street = :val where add_id = :id",nativeQuery = true)
    void updateStreet(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET city = :val where add_id = :id",nativeQuery = true)
    void updateCity(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET state = :val where add_id = :id",nativeQuery = true)
    void updateState(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET zipcode = :val where add_id = :id",nativeQuery = true)
    void updateZipcode(String val, Long id);
}
```



### 4. Data Source
```java
  spring.datasource.url=jdbc:mysql://localhost:3306/emp_add
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
  spring.jpa.hibernate.ddl-auto=update

  spring.jpa.properties.hibernate.show_sql=true
  spring.jpa.properties.hibernate.use_sql_comments=true
  spring.jpa.properties.hibernate.format_sql=true
```

## Data Sturcture
* List

## Project Summary
In a one-to-one mapping between "Employee" and "Address," each employee is associated with exactly one address, and vice versa. This relationship is typically established using a foreign key in one entity that references the primary key of the other entity.