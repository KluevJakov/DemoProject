CREATE TABLE author (
    id UUID,
    fullname VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE category (
    id UUID,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE book (
    id UUID,
    title VARCHAR(255),
    publish_year INTEGER,
    category_id UUID,
    FOREIGN KEY (category_id) REFERENCES category(id),
    PRIMARY KEY (id)
);

CREATE TABLE books_authors (
    book_id UUID,
    author_id UUID,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);