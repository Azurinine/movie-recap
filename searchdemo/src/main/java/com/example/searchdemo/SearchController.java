package com.example.searchdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search")
    public List<Episode> search(@RequestParam String query) {
        // Call your Java logic to get the episodes based on the query
        return SearchEngine.runSearch(query);  // Assuming this returns a List<Episode>
    }
}
