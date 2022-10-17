package com.example.reto_3.service;


import com.example.reto_3.entities.Category;
import com.example.reto_3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }

    public Category update(Category category){
        if (category.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(category.getId());
            if ((q.isPresent())){
                if(category.getName()!=null){
                    q.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    q.get().setDescription(category.getDescription());
                }
                if(category.getBikes()!=null){
                    q.get().setBikes(category.getBikes());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else {
                return category;
            }
        }else {
            return category;
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
