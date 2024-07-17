package pickdomain.hackathon.domain.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pickdomain.hackathon.domain.feed.entity.Type;
import pickdomain.hackathon.domain.news.entity.News;

import java.time.LocalDate;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(
            value = "SELECT * " +
                    "FROM news " +
                    "WHERE news.pub_date LIKE :start% AND news.type = :type",
            nativeQuery = true
    )
    List<News> findAllByPubDateContainingAndType(
            @Param("start")
            String start,
            @Param("type")
            String type);


    @Query(
            value = "SELECT * " +
                    "FROM news " +
                    "WHERE news.pub_date LIKE :pubDateStart% " +
                    "AND news.type = :newsType " +
                    "AND news.description LIKE %:descriptionKeyword%",
            nativeQuery = true
    )
    List<News> findAllByPubDateAndTypeAndDescription(
            @Param("newsType") String type,
            @Param("pubDateStart") String startDate,
            @Param("descriptionKeyword") String keyword);

}
