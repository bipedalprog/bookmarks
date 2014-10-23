package com.bipedalprogrammer.bookmarks.services

import com.bipedalprogrammer.bookmarks.model.Bookmark
import org.junit.Test

/**
 * Created by dennis on 10/17/14.
 */
class TestBookmarkServer {
    BookmarkServer server = new BookmarkServer();

    @Test
    void testSimpleAdd() {
        server.addBookmark(new Bookmark("http://localhost/", "Local Host", [], "Local bookmark with no tags."))
        assert server.list().size() == 1
    }

    @Test
    void testBookmarkAdd() {
        server.addBookmark(new Bookmark("http://localhost/bookmark", "Local Tags", ["tag1", "tag2"], "Local url with tags"))
        assert server.listTags().size() > 0
        assert server.listTags().contains("tag1")
    }
}
