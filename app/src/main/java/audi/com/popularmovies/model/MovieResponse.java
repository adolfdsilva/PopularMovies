package audi.com.popularmovies.model;


import java.util.List;

import audi.com.popularmovies.model.database.greenbot.Movie;

/**
 * Created by Audi on 15/09/16.
 */
public class MovieResponse {


    /**
     * page : 1
     * results : [{"poster_path":"/5N20rQURev5CNDcMjHVUZhpoCNC.jpg","adult":false,"overview":"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.","release_date":"2016-04-27","genre_ids":[28,53,878],"id":271110,"original_title":"Captain America: Civil War","original_language":"en","title":"Captain America: Civil War","backdrop_path":"/rqAHkvXldb9tHlnbQDwOzRi0yVD.jpg","popularity":45.789261,"vote_count":2845,"video":false,"vote_average":6.9},{"poster_path":"/zSouWWrySXshPCT4t3UKCQGayyo.jpg","adult":false,"overview":"After the re-emergence of the world's first mutant, world-destroyer Apocalypse, the X-Men must unite to defeat his extinction level plan.","release_date":"2016-05-18","genre_ids":[28,12,14,878],"id":246655,"original_title":"X-Men: Apocalypse","original_language":"en","title":"X-Men: Apocalypse","backdrop_path":"/oQWWth5AOtbWG9o8SCAviGcADed.jpg","popularity":28.055634,"vote_count":1756,"video":false,"vote_average":6.1},{"poster_path":"/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg","adult":false,"overview":"From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.","release_date":"2016-08-03","genre_ids":[28,80,14],"id":297761,"original_title":"Suicide Squad","original_language":"en","title":"Suicide Squad","backdrop_path":"/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg","popularity":23.356669,"vote_count":1830,"video":false,"vote_average":5.89},{"poster_path":"/tgfRDJs5PFW20Aoh1orEzuxW8cN.jpg","adult":false,"overview":"Arthur Bishop thought he had put his murderous past behind him when his most formidable foe kidnaps the love of his life. Now he is forced to travel the globe to complete three impossible assassinations, and do what he does best, make them look like accidents.","release_date":"2016-08-25","genre_ids":[80,28,53],"id":278924,"original_title":"Mechanic: Resurrection","original_language":"en","title":"Mechanic: Resurrection","backdrop_path":"/3oRHlbxMLBXHfMqUsx1emwqiuQ3.jpg","popularity":20.971617,"vote_count":261,"video":false,"vote_average":4.42},{"poster_path":"/lw0IqOSMsQcy1QnVIEIDppLmNwk.jpg","adult":false,"overview":"A group of teens break into a blind man's home thinking they'll get away with the perfect crime. They're wrong.","release_date":"2016-08-25","genre_ids":[27,53],"id":300669,"original_title":"Don't Breathe","original_language":"en","title":"Don't Breathe","backdrop_path":"/bCThHXQ3aLLDU3KFST0rC8mTan5.jpg","popularity":20.733922,"vote_count":141,"video":false,"vote_average":6.02},{"poster_path":"/h28t2JNNGrZx0fIuAw8aHQFhIxR.jpg","adult":false,"overview":"A recently cheated on married woman falls for a younger man who has moved in next door, but their torrid affair soon takes a dangerous turn.","release_date":"2015-01-23","genre_ids":[53],"id":241251,"original_title":"The Boy Next Door","original_language":"en","title":"The Boy Next Door","backdrop_path":"/vj4IhmH4HCMZYYjTMiYBybTWR5o.jpg","popularity":18.760561,"vote_count":716,"video":false,"vote_average":4.01},{"poster_path":"/ckrTPz6FZ35L5ybjqvkLWzzSLO7.jpg","adult":false,"overview":"The peaceful realm of Azeroth stands on the brink of war as its civilization faces a fearsome race of invaders: orc warriors fleeing their dying home to colonize another. As a portal opens to connect the two worlds, one army faces destruction and the other faces extinction. From opposing sides, two heroes are set on a collision course that will decide the fate of their family, their people, and their home.","release_date":"2016-05-25","genre_ids":[28,12,14],"id":68735,"original_title":"Warcraft","original_language":"en","title":"Warcraft","backdrop_path":"/5SX2rgKXZ7NVmAJR5z5LprqSXKa.jpg","popularity":17.558062,"vote_count":756,"video":false,"vote_average":6.13},{"poster_path":"/6vuxwCfBejPfUjMxrPgk0ANmVFq.jpg","adult":false,"overview":"An injured surfer stranded on a buoy needs to get back to shore, but the great white shark stalking her might have other ideas.","release_date":"2016-06-24","genre_ids":[27,18,53],"id":332567,"original_title":"The Shallows","original_language":"en","title":"The Shallows","backdrop_path":"/lEkHdk4g0nAKtMcHBtSmC1ON3O1.jpg","popularity":16.381379,"vote_count":299,"video":false,"vote_average":6.12},{"poster_path":"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg","adult":false,"overview":"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.","release_date":"2015-05-13","genre_ids":[28,12,878,53],"id":76341,"original_title":"Mad Max: Fury Road","original_language":"en","title":"Mad Max: Fury Road","backdrop_path":"/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg","popularity":15.260955,"vote_count":5318,"video":false,"vote_average":7.25},{"poster_path":"/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg","adult":false,"overview":"The most dangerous former operative of the CIA is drawn out of hiding to uncover hidden truths about his past.","release_date":"2016-07-27","genre_ids":[28,53],"id":324668,"original_title":"Jason Bourne","original_language":"en","title":"Jason Bourne","backdrop_path":"/AoT2YrJUJlg5vKE3iMOLvHlTd3m.jpg","popularity":14.873725,"vote_count":843,"video":false,"vote_average":5.4},{"poster_path":"/hU0E130tsGdsYa4K9lc3Xrn5Wyt.jpg","adult":false,"overview":"One year after outwitting the FBI and winning the public\u2019s adulation with their mind-bending spectacles, the Four Horsemen resurface only to find themselves face to face with a new enemy who enlists them to pull off their most dangerous heist yet.","release_date":"2016-06-02","genre_ids":[28,12,35,80,9648,53],"id":291805,"original_title":"Now You See Me 2","original_language":"en","title":"Now You See Me 2","backdrop_path":"/zrAO2OOa6s6dQMQ7zsUbDyIBrAP.jpg","popularity":14.389086,"vote_count":883,"video":false,"vote_average":6.63},{"poster_path":"/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg","adult":false,"overview":"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.","release_date":"2015-06-09","genre_ids":[28,12,878,53],"id":135397,"original_title":"Jurassic World","original_language":"en","title":"Jurassic World","backdrop_path":"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg","popularity":13.092658,"vote_count":4997,"video":false,"vote_average":6.59},{"poster_path":"/vOipe2myi26UDwP978hsYOrnUWC.jpg","adult":false,"overview":"After a threat from the tiger Shere Khan forces him to flee the jungle, a man-cub named Mowgli embarks on a journey of self discovery with the help of panther, Bagheera, and free spirited bear, Baloo.","release_date":"2016-04-07","genre_ids":[12,18,14],"id":278927,"original_title":"The Jungle Book","original_language":"en","title":"The Jungle Book","backdrop_path":"/eIOTsGg9FCVrBc4r2nXaV61JF4F.jpg","popularity":12.257102,"vote_count":1227,"video":false,"vote_average":6.34},{"poster_path":"/5BCpxPLyp4wGcTribpZ6WtNkVJ5.jpg","adult":false,"overview":"After supervillain Shredder escapes custody, he joins forces with mad scientist Baxter Stockman and two dimwitted henchmen, Bebop and Rocksteady, to unleash a diabolical plan to take over the world. As the Turtles prepare to take on Shredder and his new crew, they find themselves facing an even greater evil with similar intentions: the notorious Krang.","release_date":"2016-06-01","genre_ids":[28,12,35,878],"id":308531,"original_title":"Teenage Mutant Ninja Turtles: Out of the Shadows","original_language":"en","title":"Teenage Mutant Ninja Turtles: Out of the Shadows","backdrop_path":"/999RuhZvog8ocyvcccVV9yGmMjL.jpg","popularity":12.191103,"vote_count":297,"video":false,"vote_average":5.45},{"poster_path":"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg","adult":false,"overview":"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.","release_date":"2014-11-05","genre_ids":[12,18,878],"id":157336,"original_title":"Interstellar","original_language":"en","title":"Interstellar","backdrop_path":"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg","popularity":11.745613,"vote_count":5685,"video":false,"vote_average":8.11},{"poster_path":"/5TQ6YDmymBpnF005OyoB7ohZps9.jpg","adult":false,"overview":"After the cataclysmic events in New York with The Avengers, Steve Rogers, aka Captain America is living quietly in Washington, D.C. and trying to adjust to the modern world. But when a S.H.I.E.L.D. colleague comes under attack, Steve becomes embroiled in a web of intrigue that threatens to put the world at risk. Joining forces with the Black Widow, Captain America struggles to expose the ever-widening conspiracy while fighting off professional assassins sent to silence him at every turn. When the full scope of the villainous plot is revealed, Captain America and the Black Widow enlist the help of a new ally, the Falcon. However, they soon find themselves up against an unexpected and formidable enemy\u2014the Winter Soldier.","release_date":"2014-03-20","genre_ids":[28,12,878],"id":100402,"original_title":"Captain America: The Winter Soldier","original_language":"en","title":"Captain America: The Winter Soldier","backdrop_path":"/4qfXT9BtxeFuamR4F49m2mpKQI1.jpg","popularity":11.418299,"vote_count":3539,"video":false,"vote_average":7.58},{"poster_path":"/t2mZzQXjpQxmqtJOPpe8Dr2YpMl.jpg","adult":false,"overview":"An island populated entirely by happy, flightless birds or almost entirely. In this paradise, Red, a bird with a temper problem, speedy Chuck, and the volatile Bomb have always been outsiders. But when the island is visited by mysterious green piggies, it\u2019s up to these unlikely outcasts to figure out what the pigs are up to.","release_date":"2016-05-11","genre_ids":[28,16,35,10751],"id":153518,"original_title":"The Angry Birds Movie","original_language":"en","title":"The Angry Birds Movie","backdrop_path":"/3mJcfL2lPfRky16EPi95d2YrKqu.jpg","popularity":11.31525,"vote_count":412,"video":false,"vote_average":5.81},{"poster_path":"/cGOPbv9wA5gEejkUN892JrveARt.jpg","adult":false,"overview":"Fearing the actions of a god-like Super Hero left unchecked, Gotham City\u2019s own formidable, forceful vigilante takes on Metropolis\u2019s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it\u2019s ever known before.","release_date":"2016-03-23","genre_ids":[28,12,14],"id":209112,"original_title":"Batman v Superman: Dawn of Justice","original_language":"en","title":"Batman v Superman: Dawn of Justice","backdrop_path":"/vsjBeMPZtyB7yNsYY56XYxifaQZ.jpg","popularity":10.957255,"vote_count":3625,"video":false,"vote_average":5.52},{"poster_path":"/gj282Pniaa78ZJfbaixyLXnXEDI.jpg","adult":false,"overview":"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.","release_date":"2014-11-18","genre_ids":[878,12,53],"id":131631,"original_title":"The Hunger Games: Mockingjay - Part 1","original_language":"en","title":"The Hunger Games: Mockingjay - Part 1","backdrop_path":"/83nHcz2KcnEpPXY50Ky2VldewJJ.jpg","popularity":10.885962,"vote_count":3224,"video":false,"vote_average":6.69},{"poster_path":"/inVq3FRqcYIRl2la8iZikYYxFNR.jpg","adult":false,"overview":"Based upon Marvel Comics\u2019 most unconventional anti-hero, DEADPOOL tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.","release_date":"2016-02-09","genre_ids":[28,12,35,10749],"id":293660,"original_title":"Deadpool","original_language":"en","title":"Deadpool","backdrop_path":"/nbIrDhOtUpdD9HKDBRy02a8VhpV.jpg","popularity":10.498872,"vote_count":4979,"video":false,"vote_average":7.17}]
     * total_results : 19589
     * total_pages : 980
     */

    private int page;
    private int total_results;
    private int total_pages;
    /**
     * poster_path : /5N20rQURev5CNDcMjHVUZhpoCNC.jpg
     * adult : false
     * overview : Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.
     * release_date : 2016-04-27
     * genre_ids : [28,53,878]
     * id : 271110
     * original_title : Captain America: Civil War
     * original_language : en
     * title : Captain America: Civil War
     * backdrop_path : /rqAHkvXldb9tHlnbQDwOzRi0yVD.jpg
     * popularity : 45.789261
     * vote_count : 2845
     * video : false
     * vote_average : 6.9
     */

    private List<Movie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
