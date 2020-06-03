package application.resources;

import application.model.BookDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookResource {

    List<BookDetails> getBooksByIds(String mongoApiType, List<Long> bookId);

    List<BookDetails> getAllBooks(String monogApiType);

    ResponseEntity<String> addBooks(String monogApiType, List<BookDetails> bookDetails);

    ResponseEntity<String> deleteBooksByIds(String monogApiType, List<Long> bookIds);

    ResponseEntity<String> deleteAllBooks(String monogApiType);

}
