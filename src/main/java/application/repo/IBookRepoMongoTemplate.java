package application.repo;

import application.model.BookDetails;

import java.util.List;

public interface IBookRepoMongoTemplate {

    List<BookDetails> getAllBooks();
}
