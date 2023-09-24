# Readme file of URL Hit

## Framework and Language 
* ### Framework
  * Spring Boot
* ### Language
  * Java
 
## Data Flow
### 1. Controller
```JAVA
@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("jobs")
    public String addJobs(@RequestBody @Valid List<Job> jobList){
        return jobService.addJobs(jobList);
    }

    @GetMapping("jobs")
    public List<Job> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping("jobs/title/{title}")
    public List<Job> getJobByTitle(@PathVariable String title){
        return jobService.getJobByTitle(title);
    }

    @GetMapping("jobs/type/{jobType}")
    public List<Job> getJobByType(@PathVariable Type jobType){
        return jobService.getJobByType(jobType);
    }

    @GetMapping("jobs/title/{title}/salary/{salary}")
    public List<Job> getJobByTitleAndSalary(@PathVariable String title,@PathVariable Double salary){
        return jobService.getJobByTitleAndSalary(title,salary);
    }

    @GetMapping("jobs/salary/{salary}")
    public List<Job> getJobBySalary(@PathVariable Double salary){
        return jobService.getJobBySalary(salary);
    }

    @GetMapping("job/desc/{desc}")
    public List<Job> getJobByDescription(String desc){
        return jobService.getJobByDescription(desc);
    }

    @GetMapping("job/location/{location}")
    public List<Job> getJobByLocation(String location) {
        return jobService.getJobByLocation(location);
    }

    @PutMapping("job/id/{id}/salary/{salary}")
    public String updateSalaryById(@PathVariable Long id,@PathVariable Double salary){
        return jobService.updateSalaryById(id,salary);
    }

    @DeleteMapping("job/id/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }

    @DeleteMapping("job/type/{type}")
    public  String deleteByType(Type type){
        return jobService.deleteByType(type);
    }

}
  
```

### 2. Services
```JAVA
@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

//    Crud methods
    public String addJobs(List<Job> jobList) {
        jobRepo.saveAll(jobList);
        return "New "+jobList.size()+" jobs were added...";
    }

    public List<Job> getJobs() {
        return (List<Job>)jobRepo.findAll();
    }

    public String deleteJobById(Long id){
        jobRepo.deleteById(id);
        return "Deleted...";
    }



//    Custom finder
    public List<Job> getJobByLocation(String location) {
        return jobRepo.findByLocation(location);
    }

    public List<Job> getJobByType(Type jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<Job> getJobBySalary(Double salary) {
        return jobRepo.findBySalaryGreaterThanEqual(salary);
    }

    public List<Job> getJobByTitleAndSalary(String title, Double salary) {
        return jobRepo.findByTitleAndSalaryGreaterThanEqual(title,salary);
    }

//    Custom Query
    @Transactional
    public String updateSalaryById(Long id, Double salary) {
        jobRepo.updateSalaryById(id,salary);
        return "Salary updated...";
    }

    @Transactional
    public String deleteByType(Type jobType) {
        jobRepo.deleteJobByType(jobType);
        return "Deleted...";
    }

    @Transactional
    public List<Job> getJobByTitle(String title){
        return jobRepo.getJobByTitle(title);
    }

    @Transactional
    public List<Job> getJobByDescription(String desc){
        return jobRepo.getJobByDescription(desc);
    }

}
```
### 3. Repository
```JAVA
@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
    List<Job> findByLocation(String Location);

    List<Job> findByJobType(Type jobType);

    List<Job> findByTitleAndSalaryGreaterThanEqual(String title, Double salary);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

    @Modifying
    @Query(value = "update job set salary=(:salary) where id=(:id)" , nativeQuery = true)
    void updateSalaryById(Long id, Double salary);

    @Modifying
    @Query(value = "delete from job where jobType=(:jobType)" , nativeQuery = true)
    void deleteJobByType(Type jobType);

    @Modifying
    @Query(value = "select * from job where title= (:title) " , nativeQuery = true)
    List<Job> getJobByTitle(String title);

    @Modifying
    @Query(value = "select * from job where description=(:desc)" , nativeQuery = true)
    List<Job> getJobByDescription(String desc);
}
```


### 4. Data Source
```JAVA

spring.datasource.url=jdbc:h2:mem:h2db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=manjeet
spring.datasource.password=job
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


spring.h2.console.enabled=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```

## Data Structure And DataBase
*  List
*  H2 Database


## Project Summary
