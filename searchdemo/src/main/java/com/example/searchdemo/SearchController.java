package com.example.searchdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search")
    public List<Episode> search(@RequestParam String title, @RequestParam int season) {
        return SearchEngine.runSearch(title, season);
    }

}
