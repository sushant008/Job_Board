package com.saga.Controller;

import com.saga.Dto.CategoryDto;
import com.saga.Dto.ResponseDto;
import com.saga.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Category is created Successfully!"));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAllcategories() {
        categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto("200", "All Categories are fetched successfully"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        categoryService.updateCategory(categoryDto, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto("200", "Category is updated Successfully!"));
    }

    @DeleteMapping("delete")
    public ResponseEntity<ResponseDto> deleteCategory(@RequestParam String categoryName) {
        boolean isDeleted = categoryService.deleteCategory(categoryName);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200","Category is Deleted Successfully!"));
        }
        else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("417","Delete Operation is Failed!"));
        }
    }
}

