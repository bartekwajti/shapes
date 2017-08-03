package com.vaytee.shapes.history;

import com.vaytee.shapes.security.AuthenticatedUser;
import com.vaytee.shapes.history.model.HistoryRecord;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 2017-07-22.
 */
@RestController
@RequestMapping("history")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE, onConstructor = @__(@Autowired))
public class HistoryController {

    @NonNull
    HistoryService historyService;

    @GetMapping
    public ResponseEntity<Page<HistoryRecord>> listFigures(
            @AuthenticatedUser User user,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {

        PageRequest pageRequest = new PageRequest(page, size);
        Page<HistoryRecord> result = historyService.findAllByUser(user.getUsername(), pageRequest);
        return ResponseEntity.ok(result);
    }
}
