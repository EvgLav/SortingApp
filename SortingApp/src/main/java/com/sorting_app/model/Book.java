
package com.sorting_app.model;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private final String bookName;
    private final String author;
    private final int pages;

    private Book(BookBuilder builder) {
        this.bookName = builder.book;
        this.author = builder.author;
        this.pages = builder.pages;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book o) {
        return Comparator.nullsLast(
                            Comparator.comparing(Book::getBookName, Comparator.nullsLast(Comparator.naturalOrder()))
                                      .thenComparing(Book::getAuthor, Comparator.nullsLast(Comparator.naturalOrder())))
                                      .thenComparingInt(Book::getPages)
                                      .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Книга: %s; Автор: %s; Страницы: %d", bookName, author, pages);
    }

    public static class BookBuilder {
        private String book;
        private String author;
        private int pages;

        public BookBuilder() {}

        public BookBuilder setBook(String book) {
            this.book = book;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}