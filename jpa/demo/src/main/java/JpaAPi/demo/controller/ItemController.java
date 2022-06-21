package JpaAPi.demo.controller;

import JpaAPi.demo.entity.Item;
import JpaAPi.demo.repostiroy.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items/*")
public class ItemController {

    private final ItemRepository itemRepository;
    @GetMapping("all")
    public List<Item> allItem() {
        return itemRepository.findAll();
    }



}
