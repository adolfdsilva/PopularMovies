package audi.com.popularmovies.model;

import java.util.List;

/**
 * Created by Audi on 15/10/16.
 */

public class TrailerResponse {


    /**
     * id : 47933
     * results : [{"id":"579758f19251413b180043cc","iso_639_1":"en","iso_3166_1":"US","key":"LbduDRH2m2M","name":"Official Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5797591bc3a368044f0016de","iso_639_1":"en","iso_3166_1":"US","key":"RfJgT89hEME","name":"Official Trailer 2","site":"YouTube","size":1080,"type":"Trailer"},{"id":"571beee692514115e2000a10","iso_639_1":"en","iso_3166_1":"US","key":"g5K0lKrebqg","name":"Super Bowl TV Commercial","site":"YouTube","size":1080,"type":"Teaser"}]
     */

    private int id;
    /**
     * id : 579758f19251413b180043cc
     * iso_639_1 : en
     * iso_3166_1 : US
     * key : LbduDRH2m2M
     * name : Official Trailer
     * site : YouTube
     * size : 1080
     * type : Trailer
     */

    private List<Trailer> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Trailer> getResults() {
        return results;
    }

    public void setResults(List<Trailer> results) {
        this.results = results;
    }

    public static class Trailer {
        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
