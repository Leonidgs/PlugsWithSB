package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {

    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String createPet(@RequestBody Pet pet) {
        if(newId.get() == 1) {
            petModel.add(pet, newId.getAndIncrement());
            return "Поздравляем! Вы завели своё первое домашнее животное! Не забывайте вкусно кормить и гладить!";
        } else {
            petModel.add(pet, newId.getAndIncrement());
            return "Поздравляем с новым питомцем!";
        }
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {

        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {

        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/delete", consumes = "application/json")
    public String delete(@RequestBody Map<String, Integer> id) {
        petModel.deletePet(id.get("id"));
        return "Питомец с id " + id + " успешно удалён";
    }

    @PutMapping(value = "/change", consumes = "application/json")
    public Pet change(@RequestBody Map<String, Object> fakeObj) {

        Pet pet = new Pet(fakeObj.get("name").toString(), fakeObj.get("type").toString(),
                Integer.parseInt(fakeObj.get("age").toString()));

        petModel.changePet(pet, Integer.parseInt(fakeObj.get("id").toString()));

        return petModel.getFromList(Integer.parseInt(fakeObj.get("id").toString()));

    }
}
