package application.service;

import application.core.SequenceGenerator;
import application.model.BookDetails;
import application.repo.IBookRepoMongoTemplate;
import application.repo.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private BookRepository bookRepository;
    private SequenceGenerator sequenceGenerator;
    private IBookRepoMongoTemplate iBookRepoMongoTemplate;

    @Autowired
    public void BookService(BookRepository bookRepository, SequenceGenerator sequenceGenerator,
                            IBookRepoMongoTemplate iBookRepoMongoTemplate) {
        this.bookRepository = bookRepository;
        this.sequenceGenerator = sequenceGenerator;
        this.iBookRepoMongoTemplate = iBookRepoMongoTemplate;
    }

    public List<BookDetails> getBooksByIdsUsingMongoRepo(List<Long> bookIds) {
        return (List<BookDetails>) bookRepository.findAllById(bookIds);
    }

    public List<BookDetails> getAllBooksUsingMongoRepo() {
        return bookRepository.findAll();
    }

    public void addAllBooksUsingMongoRepo(List<BookDetails> bookDetails) {
        bookDetails.forEach(book -> book.setBookId(sequenceGenerator.getNextSequence(BookDetails.SEQUENCE_NAME)));
        bookRepository.saveAll(bookDetails);
    }

    public void deleteBooksByIdsUsingMongoRepo(List<Long> bookIds) {
        bookIds.forEach(id -> bookRepository.deleteById(id));
    }

    public void deleteAllBooksUsingMongoRepo() {
        bookRepository.deleteAll();
    }

}
