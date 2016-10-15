package audi.com.popularmovies.model;

import java.util.List;

/**
 * Created by Audi on 15/10/16.
 */

public class ReviewsResponse {


    /**
     * id : 47933
     * page : 1
     * results : [{"id":"5769f7afc3a3683726001772","author":"Screen-Space","content":"\"Independence Day: Resurgence entertains like few Hollywood blockbusters have of late, largely by foregoing pretension on every level and drilling down on the basic tenets of popcorn moviemaking...\"\r\n\r\nRead the full review here: http://screen-space.squarespace.com/reviews/2016/6/22/independence-day-resurgence.html","url":"https://www.themoviedb.org/review/5769f7afc3a3683726001772"}]
     * total_pages : 1
     * total_results : 1
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    /**
     * id : 5769f7afc3a3683726001772
     * author : Screen-Space
     * content : "Independence Day: Resurgence entertains like few Hollywood blockbusters have of late, largely by foregoing pretension on every level and drilling down on the basic tenets of popcorn moviemaking..."
     * <p>
     * Read the full review here: http://screen-space.squarespace.com/reviews/2016/6/22/independence-day-resurgence.html
     * url : https://www.themoviedb.org/review/5769f7afc3a3683726001772
     */

    private List<Review> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
        this.results = results;
    }

    public static class Review {
        private String id;
        private String author;
        private String content;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
