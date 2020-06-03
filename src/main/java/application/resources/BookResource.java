package application.resources;

import application.model.BookDetails;
import application.service.BookService;
import application.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource implements IBookResource {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private BookService bookService;

    @Autowired
    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "{bookId}", method = RequestMethod.GET)
    public List<BookDetails> getBooksByIds(@RequestHeader(Constants.MONGO_API_TYPE) String mongoApiType, @RequestParam List<Long> bookIds) {
        LOG.info("Getting book details of the supplied ID's.");

        List<BookDetails> bookDetails = new ArrayList<>();
        switch (mongoApiType) {
            case Constants.MONGO_REPOSITORY:
                bookDetails = bookService.getBooksByIdsUsingMongoRepo(bookIds);
                break;
            case Constants.MONGO_TEMPLATE:
                //bookDetailsList = itemService.getAllItemsUsingMongoRepo();
                break;
            default:
                break;
        }

        return bookDetails;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<BookDetails> getAllBooks(@RequestHeader(Constants.MONGO_API_TYPE) String mongoApiType) {
        LOG.info("Getting all the books available in the collection.");

        List<BookDetails> bookDetailsList = new ArrayList<>();
        switch (mongoApiType) {
            case Constants.MONGO_REPOSITORY:
                bookDetailsList = bookService.getAllBooksUsingMongoRepo();
                break;
            case Constants.MONGO_TEMPLATE:
                //bookDetailsList = itemService.getAllItemsUsingMongoRepo();
                break;
            default:
                break;
        }

        return bookDetailsList;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<String> addBooks(@RequestHeader(Constants.MONGO_API_TYPE) String mongoApiType, @RequestBody List<BookDetails> bookDetails) {
        LOG.info("Getting all the books available in the collection.");
        switch (mongoApiType) {
            case Constants.MONGO_REPOSITORY:
                bookService.addAllBooksUsingMongoRepo(bookDetails);
                break;
            case Constants.MONGO_TEMPLATE:
                //bookDetailsList = itemService.getAllItemsUsingMongoRepo();
                break;
            default:
                break;
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBooksByIds(@RequestHeader(Constants.MONGO_API_TYPE) String mongoApiType,
                                                   @RequestBody List<Long> bookIds) {
        switch (mongoApiType) {
            case Constants.MONGO_REPOSITORY:
                bookService.deleteBooksByIdsUsingMongoRepo(bookIds);
                break;
            case Constants.MONGO_TEMPLATE:
                //bookDetailsList = itemService.getAllItemsUsingMongoRepo();
                break;
            default:
                break;
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "all", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllBooks(@RequestHeader(Constants.MONGO_API_TYPE) String mongoApiType) {

        switch (mongoApiType) {
            case Constants.MONGO_REPOSITORY:
                bookService.deleteAllBooksUsingMongoRepo();
                break;
            case Constants.MONGO_TEMPLATE:
                //bookDetailsList = itemService.getAllItemsUsingMongoRepo();
                break;
            default:
                break;
        }

        return ResponseEntity.ok().build();
    }
}
