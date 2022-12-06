package test;


import base.BaseTest;
import io.qameta.allure.*;
import base.listeners.TestListener;
import org.TestVagrantTechnologies.utils.datareader.DataMap;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("IMDB WIKI")
@Feature("Date and Region Check")
@Severity(SeverityLevel.CRITICAL)
public class MovieReleaseDateRegionTest extends BaseTest {
    DataMap dataMap = new DataMap("data");

    @Test(priority = 1)
    @Description("Test Description : Verifying the release date and region of the specified movie ")
    @Story("WIKI & IMDB Date+Region Validation")
    public void regionDateOfMovieTest() {
        homePage.redirectToImdbPage(dataMap.getString("imdb.url"))
                .verifySearchScreen()
                .searchMovie(dataMap.getString("imdb.movie_name"))
                .getMovieFromList(dataMap.getString("imdb.movie_name"))
                .getMovieRegion()
                .getMovieReleaseDate();
        homePage.redirectToWikiPage(dataMap.getString("wiki.url"))
                .searchMovieOnWiki(dataMap.getString("wiki.movie_name"))
                .getMovieRegion().getMovieReleaseDate()
                .dateValidate().regionValidate();


    }


    @Test(priority = 2)
    @Description("Test Description : Validating the date and release date of :\t movie_name2: Black Panther: Wakanda Forever ")
    @Story("WIKI & IMDB Date+Region Validation")
    public void regionDateOfMovieTest2() {
        homePage.redirectToImdbPage(dataMap.getString("imdb.url"))
                .verifySearchScreen()
                .searchMovie(dataMap.getString("imdb.movie_name2"))
                .getMovieFromList(dataMap.getString("imdb.movie_name2"))
                .getMovieRegion()
                .getMovieReleaseDate();
        homePage.redirectToWikiPage(dataMap.getString("wiki.url"))
                .searchMovieOnWiki(dataMap.getString("wiki.movie_name2"))
                .getMovieRegion().getMovieReleaseDate()
                .dateValidate().regionValidate();


    }
}
