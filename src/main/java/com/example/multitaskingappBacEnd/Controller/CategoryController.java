package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.exam.Category;
import com.example.multitaskingappBacEnd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    //add karnege hum

    @Autowired
    private CategoryService categoryService;

    //add
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }
    @GetMapping("/{cid}")
    public Category getCategory(@PathVariable("cid") Long cid){
        return this.categoryService.getCategory(cid);
    }
    //get all the category
    @GetMapping("/")
    public ResponseEntity<?> getCategorys(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    //update
    @PutMapping("/")
    public  Category updateCaterory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("/{cid}")
    public void deleteCategory(@PathVariable("cid") Long cid){
         this.categoryService.deleteCategory(cid);
    }

//    "cid": 9,
//            "title": "Programing Language",
//            "description": "This Quiz Contains Quizz related to Programing Language"
//}

}
