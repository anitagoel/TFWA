package com.ishitwa.Analytics_Microservice.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable long id){
        try{
            Department d=departmentService.getDepartmentById(id);
            return ResponseEntity.ok().body(d);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cant get the Department");
        }
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<?> addDepartment(@RequestBody Department department){
        try{
            departmentService.saveDepartment(department);
            return new ResponseEntity<>(department, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Error in saving department!",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<?> getAllDepartments(){
        try{
            List<Department> departmentList=departmentService.getAllDepartments();
            return new ResponseEntity<>(departmentList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/teachers")
    public ResponseEntity<?> getAllTeachersFeedback(){
        try{
            List<Department> departments=departmentService.getAllDepartments();
            return new ResponseEntity<>(
                    departments,
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    "Some error occured!",
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
