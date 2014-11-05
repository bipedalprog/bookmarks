package com.bipedalprogrammer.bookmarks.services

import com.bipedalprogrammer.bookmarks.model.Bookmark

/**
 * Created by dennis on 10/16/14.
 */
class BookmarkServer {
  HashMap<String, Bookmark> bookmarksByURL = new HashMap<String, Bookmark>()
  HashMap<String, List> tagCloud = new HashMap<String, List>()

  BookmarkServer() {
    bookmarksByURL.clear()
    tagCloud.clear()
  }

  void addBookmark(Bookmark bookmark) {
    String url = bookmark.url
    if (url != null && bookmarksByURL[url] == null) {
      bookmarksByURL[url] = bookmark
      List<String> tags = bookmark.tags
      for (it in tags) {
        List tagList = tagCloud[it]
        if (tagList != null) {
          if (!tagList.contains(Bookmark)) {
            tagList << bookmark
          }
        } else {
          tagCloud[it] = [bookmark]
        }
      }
    }
  }

  List list() {
    List list = bookmarksByURL.collect { k, v -> v }
    return list
  }

  List listTags() {
    List list = tagCloud.collect { k, v -> k }
    return list
  }


}
