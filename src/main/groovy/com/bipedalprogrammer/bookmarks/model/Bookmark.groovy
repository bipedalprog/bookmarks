package com.bipedalprogrammer.bookmarks.model

import java.time.LocalDateTime

/**
 * Created by dennis on 10/16/14.
 */
class Bookmark {
  LocalDateTime created
  LocalDateTime updated
  String title
  String url
  List tags
  String notes

  Bookmark(String url, String title, List<String> tags, String notes) {
    this.url = url
    this.title = title
    this.tags = tags
    this.notes = notes
    this.created = LocalDateTime.now()
    this.updated = LocalDateTime.now()
  }

  String toString() {
    "title: $title url: $url tags: $tags notes: $notes"
  }

  void setTitle(String title) {
    this.title = title
    this.updated = LocalDateTime.now()
  }

  void setTags(List tags) {
    this.tags = tags
    this.updated = LocalDateTime.now()
  }

  void setNotes(String notes) {
    this.notes = notes
    this.updated = LocalDateTime.now()
  }

}
