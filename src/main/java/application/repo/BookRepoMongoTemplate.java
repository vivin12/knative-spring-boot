package application.repo;

import application.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepoMongoTemplate implements IBookRepoMongoTemplate {

    private MongoTemplate mongoTemplate;

    @Autowired
    public BookRepoMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<BookDetails> getAllBooks() {
        return mongoTemplate.findAll(BookDetails.class);
    }
}
