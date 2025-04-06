package searchdemo.src.main.java.com.example.searchdemo;

import org.springframewjaork.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search")
    public String search(@RequestParam String query) {
        // Call your Java logic here. For now, just return the query
        return SearchEngine.runSearch(query);
    }
}
