package com.github.jiantailang.book.adapters;

import com.github.jiantailang.book.BookUseCase;
import com.github.jiantailang.book.adapters.models.HttpBook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookHttpControlAdapter {

    private final BookUseCase useCase;

    @GetMapping("/book/{id}")
    @ResponseBody
    public HttpBook get(@PathVariable("id") long id) {
        return HttpBook.of(useCase.take(id));
    }

    @PutMapping("/book/")
    public HttpBook put(@RequestBody HttpBook book) {
        useCase.put(book.toBook());
        return book;
    }
}
