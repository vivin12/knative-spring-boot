package application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book_details")
public class BookDetails {

    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private long bookId;
    private String bookName;
    private String author;
    private Integer publishedYear;

    public long getBookId() { return bookId; }

    public void setBookId(long bookId) { this.bookId = bookId; }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}
