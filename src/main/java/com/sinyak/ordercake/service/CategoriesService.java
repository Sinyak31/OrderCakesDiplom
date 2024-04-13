package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Categories;
import com.sinyak.ordercake.repositories.CategoriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Transactional
    public List<Categories> findAll(){
        return categoriesRepository.findAll();
    }

    @Transactional
    public void saveCategories(Categories categories){
        categoriesRepository.save(categories);
    }

    @Transactional
    public void updateCategories(int id, Categories categoriesUpdate){
        Categories categories = categoriesRepository.findById(id).orElse(null);
        assert categories != null;
        categories.setNameCategories(categoriesUpdate.getNameCategories());
        if(categoriesUpdate.getImage() != null && !categoriesUpdate.getImage().equals("")){
            categories.setImage(categoriesUpdate.getImage());
        }
        categoriesRepository.save(categories);
    }


    public Optional<Categories> findCategoriesByID(int id){
        Optional<Categories> categories = categoriesRepository.findById(id);
        return categories;
    }

    public void deleteCategoriesById(int id){
        categoriesRepository.deleteById(id);
    }
}
