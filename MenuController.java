package com.resturant.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Controller
public class MenuController {

    @Autowired
    private ItemService itemService;

    private List<Item> itemList=null;

    @GetMapping
    public Menu getMenu() {

        Menu menu=new Menu();
        List<Item> item=itemService.getAllItems();
        menu.setItem(item);
        return menu;
    }

    @GetMapping("{id}")
    public Menu findMenuById(@PathVariable("id") int id){

        itemList=new ArrayList<Item>();
        Menu menu=new Menu();
        Item oneItem=itemService.findByItemId(id);
        itemList.add(oneItem);
        menu.setItem(itemList);
        return menu;
    }


}
